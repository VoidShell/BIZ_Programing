package Chapter_07;

import java.io.UnsupportedEncodingException;
import java.text.DecimalFormat;

public class Biz_07_02_FieldExtract {
    public static int cuttingUnitItemPrice(byte[] bytes) throws UnsupportedEncodingException {
        byte[] unitItemPriceBytes = new byte[10];
        for (int i = 0; i < 10; i++) {
            unitItemPriceBytes[i] = bytes[i + 18];
        }
        String unitPriceString = new String(unitItemPriceBytes);
        String cutUnitPriceString = unitPriceString.replaceAll(",", "").replaceAll(" ", "");

        return Integer.parseInt(cutUnitPriceString);
    }

    public static int cuttingItemAmount(byte[] bytes) {
        byte[] itemAmountBytes = new byte[4];
        for (int i = 0; i < 4; i++) {
            itemAmountBytes[i] = bytes[i + 28];
        }
        String itemAmountString = new String(itemAmountBytes);
        String cutItemAmountBytes = itemAmountString.replaceAll(" ", "");

        return Integer.parseInt(cutItemAmountBytes);
    }

    public static int cuttingItemPrice(byte[] bytes) {
        byte[] itemPriceBytes = new byte[10];
        for (int i = 0; i < 10; i++) {
            itemPriceBytes[i] = bytes[i + 32];
        }
        String itemPriceString = new String(itemPriceBytes);
        String cutItemPriceBytes = itemPriceString.replaceAll(",", "").replaceAll(" ", "");

        return Integer.parseInt(cutItemPriceBytes);
    }

    public static String k27_cutByteString(String k27_str, int k27_sPoint, int k27_length) throws Exception {
        // 리턴문에서 스트링을 생성할때 인수로 넣어줄 인코딩 타입 스트링
        String k27_EncodingLang = "euc-kr";
        // 파리미터로 정의한 k27_str을 getBytes 메서드(타입 euc-kr)를 써서 byte 배열로 변환한다.
        byte[] k27_bytes = k27_str.getBytes("euc-kr");
        // k27_value 배열을 선언. k27_length는 파라미터에 정의한 해당 byte로 자를 기준.
        // 원하는 byte수로 value 배열을 다시 선언.
        byte[] k27_value = new byte[k27_length];

        // k27_bytes배열의 길이가 k27_sPoint + k27_length의 길이보다 작을 경우 예외처리
        if (k27_bytes.length < k27_sPoint + k27_length) {
            throw new Exception("Length of k27_bytes is less. k27_length : " + k27_bytes.length + " k27_sPoint : " + k27_sPoint + " k27_length : " + k27_length);
        }
        // k27_value 배열에 k27_bytes 배열을 복사. 원하는 지점부터 자를 수 있게. k27_sPoint 변수 이용.
        // 파라미터 k27_length 길이 만큼 루프를 반복하기 때문에 해당 길이로 k27_value 배열이 잘리면서 복사된다.
        // if (k27_length >= 0) System.arraycopy(k27_bytes, k27_sPoint + 0, k27_value, 0, k27_length)
        for (int i = 0; i < k27_length; i++) {
            k27_value[i] = k27_bytes[k27_sPoint + i];
        }
        // new String에 byte를 넣어서 String을 생성하고 리턴. trim()으로 뒷부분 공백 제거.
        return new String(k27_value, k27_EncodingLang).trim();
    }

    public static String k27_HanBlankForeword(String k27_str, int k27_length) throws UnsupportedEncodingException {
        StringBuilder stringBuilder = new StringBuilder();
        String outputString;

        int byteLength = k27_str.getBytes("euc-kr").length;

        if (byteLength < k27_length) {
            for (int i = 0; i < k27_length - byteLength; i++) {
                stringBuilder.append(" ");
            }
            outputString = stringBuilder.append(k27_str).toString();

        } else {
            outputString = k27_str;
        }
        return outputString;
    }

    public static void main(String[] args) throws Exception {
        String[] OneRec = {
                "01  초코에몽180ml*     3,780   1     3,780",
                "02  BE정장벨트15F     15,000   1    15,000",
                "03  (G)기본고무줄4     2,980   1     2,980",
                "04* 서울우유 2.3L      4,950   1     4,950",
                "05  그릭 베리믹스9     5,980   2    11,960",
                "06  하림 치킨너겟4     8,480   1     8,480",
                "07  하림 치킨너겟4    13,300   1    13,300",
                "08  로레알헤어오일     5,980   1    29,900",
                "09  바나나스페셜 2     2,980   1     2,980",
                "10  로투스비스킷31     4,700   3    14,100",
                "11  풀무원 치즈&치       990   1       990",
                "12  극세사화장실용     1,440   2     2,880",
                "13  바나나요구르트     4,250   1     4,250",
                "14  풀무원샘물250m     2,750 100   275,000",
                "15* 바른생각 휴지     12,400   1    12,400",
                "16  냉동블루베리1.     4,700   2     9,400",
                "17  소프트옥수수식     2,980   1     2,980",
                "18  허니씨솔트호두     4,980   1     4,980",
                "19  LH망사스펀지수     2,280   4     9,120",
                "20  베이비오갈아넣     2,980   1     2,980",
                "21  롯데몽쉘36입(      4,980   1     4,980",
                "22  스니커즈 미니      9,000   1     9,000",
                "23  미니 담라 소프     8,780   1     8,780",
                "24  키도 크리미버     14,680   2    29,360",
                "25  토마스멀티비타    11,980   2    35,940",
                "26  미니 멘토스 뉴    12,980   1    12,980",
                "27  엠바레 캐러멀     10,980   4    43,920",
                "28  하리보 골드베     14,980   2    29,960",
                "29  젤리스트로우       9,980   1     9,980",
                "30  사과스트로우       9,980   1     9,980"};

        DecimalFormat decimalFormat = new DecimalFormat("###,###,###,###,###,###");

        int[] unitItemPrice = new int[OneRec.length];
        int[] itemAmount = new int[OneRec.length];
        int[] itemPrice = new int[OneRec.length];

        for (int i = 0; i < OneRec.length; i++) {
            byte[] bytes = OneRec[i].getBytes("euc-kr");

            unitItemPrice[i] = cuttingUnitItemPrice(bytes);
            itemAmount[i] = cuttingItemAmount(bytes);
            itemPrice[i] = cuttingItemPrice(bytes);

            String cutString = k27_cutByteString(OneRec[i], 0, 32);
            StringBuilder stringBuilder = new StringBuilder(cutString);

            if (itemPrice[i] != unitItemPrice[i] * itemAmount[i]) {
                String correctItemPrice = k27_HanBlankForeword(decimalFormat.format(unitItemPrice[i] * itemAmount[i]), 10);
                String outputString = stringBuilder.append(correctItemPrice).toString();
                System.out.println("*************************");
                System.out.println("오류[" + OneRec[i] + "]");
                System.out.println("교정[" + outputString + "]");
                System.out.println("*************************");
            }
        }
    }
}