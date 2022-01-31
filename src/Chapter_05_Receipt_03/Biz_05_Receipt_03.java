/*
package Chapter_05_Receipt_03;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

public class Biz_05_Receipt_03 {

    public static String getString(String str, int sPoint, int length) throws Exception {
        String EncodingLang = "euc-kr";
        byte[] bytes = str.getBytes("euc-kr");
        byte[] value = new byte[length];

        if (bytes.length < sPoint + length) {
            throw new Exception("Length of bytes is less. length : " + bytes.length + " sPoint : " + sPoint + " length : " + length);
        }
        for (int i = 0; i < length; i++) {
            value[i] = bytes[sPoint + i];
        }

        //String a = new String(value, EncodingLang).trim();


        return new String(value, EncodingLang).trim();
    }

    public String subStringBytes(String str, int byteLength, int sizePerLetter) {
        int retLength = 0;
        int tempSize = 0;
        int asc;
        if (str == null || "".equals(str) || "null".equals(str)) {
            str = "";
        }

        int length = str.length();

        for (int i = 1; i <= length; i++) {
            asc = (int) str.charAt(i - 1);
            if (asc > 127) {
                if (byteLength >= tempSize + sizePerLetter) {
                    tempSize += sizePerLetter;
                    retLength++;
                }
            } else {
                if (byteLength > tempSize) {
                    tempSize++;
                    retLength++;
                }
            }
        }

        return str.substring(0, retLength);
    }

    public static void main(String[] args) throws Exception {
        Calendar calendar = Calendar.getInstance();
        DecimalFormat dfWon = new DecimalFormat("###,###,###,###,###,###");
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");

        Biz_05_Receipt_03_Store store = new Biz_05_Receipt_03_Store("emart", "이마트 죽전점", "(031)888-1234", "206-86-50913", "이갑수", "용인시 수지구 포은대로",
                "영수증 미지참시 교환/환불 불가(30일내)", "교환/환불 구매점에서 가능(결제카드지참)", "체크카드/신용카드 청구취소 반영은", "최대 3~5일 소요 (주말, 공휴일제외)", "0009-2418");
        Biz_05_Receipt_03_Card card = new Biz_05_Receipt_03_Card(calendar.getTime(), "0009-2418", "0024 하나", "5417**8890/07850246", "카드결제", "일시불 / ");
        Biz_05_Receipt_03_Order orderCal = new Biz_05_Receipt_03_Order();

        ArrayList<Biz_05_Receipt_03_Order> orderList = new ArrayList<>();

      */
/*  orderList.add(new Biz_05_Receipt_03_Order(false, "초코에몽180ml*4", 3780, 1));
        orderList.add(new Biz_05_Receipt_03_Order(false, "BE정장벨트15F", 15000, 1));
        orderList.add(new Biz_05_Receipt_03_Order(false, "(G)기본고무줄4-7", 2980, 1));
        orderList.add(new Biz_05_Receipt_03_Order(true, "서울우유 2.3L", 4950, 1));
        orderList.add(new Biz_05_Receipt_03_Order(false, "그릭 베리믹스95g*8", 5980, 1));
        orderList.add(new Biz_05_Receipt_03_Order(false, "하림 치킨너겟480+1", 8480, 1));
        orderList.add(new Biz_05_Receipt_03_Order(false, "로레알헤어오일브라", 13300, 1));
        orderList.add(new Biz_05_Receipt_03_Order(false, "바나나스페셜 240ml123", 5980, 1));*//*

        orderList.add(new Biz_05_Receipt_03_Order(false, "이탈리안샐ggg러                                                                       gggggg러드", 4700, 1));


        System.out.printf("%14s%-5s %-2s\n", " ", store.getStoreName(), store.getTelNumber());
        System.out.printf("%10s%4s%-5s %-2s\n", store.getStoreLogo(), " ", store.getStoreCode(), store.getOwnerName());
        System.out.printf("%14s%-5s\n", " ", store.getStoreAddress());
        System.out.printf("[구 매]%-21sPOS:%s\n", sdf.format(calendar.getTime()), card.getPosNumber());
        System.out.printf("-----------------------------------------\n");
        System.out.printf("%5s%17s%4s%7s", "상품명", "단 가", "수량", "금 액\n");
        System.out.printf("-----------------------------------------\n");

        for (int i = 0; i < orderList.size(); i++) {
            StringBuilder sb = new StringBuilder(orderList.get(i).getItemName());
            int byteLength = orderList.get(i).getItemName().getBytes("euc-kr").length;
            if (byteLength >= 14) {
                sb.setLength(0);
                String OutPUttest = getString(orderList.get(i).getItemName(), 0, 14);
                sb.append(test);


            } else {
                for (int j = 0; j < 14 - byteLength; j++) {
                    sb.append(" ");
                }
            }
            orderList.get(i).setItemName(sb.toString());

            StringBuilder zeroSb = new StringBuilder(i);



            String test = orderList.get(i).getItemName();
            System.out.println(test);

            System.out.println(test.substring(test.length() - 1));

            if (!test.substring(test.length() - 1).matches("^[a-zA-Z0-9가-힣 `~!@#$%^&*()\\-_=+\\[{\\]}\\\\|;:'\",<.>/?//s]{0,100}$")) {
                System.out.println("ok");
            }





            if (!orderList.get(i).isTaxFree()) {
                System.out.printf("%02d%s%5s%11.11s%4.2s%9.13s\n", i + 1, " ", orderList.get(i).getItemName(), dfWon.format(orderList.get(i).getItemUnitPrice()), orderList.get(i).getItemAmount(), dfWon.format(orderList.get(i).getItemPrice()));
                orderCal.setTaxItemTotalPrice(orderCal.getTaxItemTotalPrice() + orderList.get(i).getItemPrice());
            } else {
                System.out.printf("%02d%s%5s%11.11s%4.2s%9.13s\n", i + 1, "*", orderList.get(i).getItemName(), dfWon.format(orderList.get(i).getItemUnitPrice()), orderList.get(i).getItemAmount(), dfWon.format(orderList.get(i).getItemPrice()));
                orderCal.setTaxFreeItemTotalPrice(orderCal.getTaxFreeItemTotalPrice() + orderList.get(i).getItemPrice());
            }
            orderCal.setItemTotalPrice(orderCal.getItemTotalPrice() + orderList.get(i).getItemPrice());
        }

        System.out.printf("%20s%17.13s\n", "(*)면 세  물 품", dfWon.format(orderCal.getTaxFreeItemTotalPrice()));
        System.out.printf("%20s%17.13s\n", "과 세  물 품", dfWon.format(orderCal.getPreTaxItemTotalPrice()));
        System.out.printf("%21s%17.13s\n", "부   가   세", dfWon.format(orderCal.getItemTotalVat()));
        System.out.printf("%22s%17.13s\n", "합        계", dfWon.format(orderCal.getItemTotalPrice()));
        System.out.printf("%s%24.13s\n", "결 제 대 상 금 액", dfWon.format(orderCal.getItemTotalPrice()));
        System.out.printf("-----------------------------------------\n");
        System.out.printf("%s%32s\n", card.getCardCompany(), card.getCardNumber());
        System.out.printf("%s%30s\n", card.getPaymentMethod(), card.getCardPaymentMethod() + dfWon.format(orderCal.getItemTotalPrice()));
        System.out.printf("-----------------------------------------\n");
    }
}
*/
