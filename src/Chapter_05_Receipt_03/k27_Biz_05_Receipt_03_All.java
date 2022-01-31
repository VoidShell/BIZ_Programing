package Chapter_05_Receipt_03;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class k27_Biz_05_Receipt_03_All {
    // String을 Byte 길이로 자르는 메서드 k27_getStirng 정의
    public static String k27_getString(String k27_str, int k27_sPoint, int k27_length) throws Exception {
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

    public static void main(String[] args) throws Exception {
        // 각 상품 정보에 해당하는 배열 선언하고 초기화
        // itemname: 항목명, price: 단가, num: 수량, taxfree: 면세유무
       /* String[] itemname = {"초코에몽180ml*4", "BE정장벨트15F", "(G)기본고무줄4-7", "서울우유 2.3L", "그릭 베리믹스95g*8", "하림 치킨너겟480+1",
                "하림 치킨너겟480+1", "로레알헤어오일브라", "바나나스페셜 240ml", "로투스비스킷312.5G", "풀무원 치즈&치즈", "극세사화장실용 수세미", "바나나요구르트 순한맛",
                "풀무원샘물250ml*4", "바른생각 휴지한박스", "냉동블루베리1.13kg", "소프트옥수수식빵", "허니씨솔트호두150g", "LH망사스펀지수세미2p", "베이비오갈아넣은체리",
                "롯데몽쉘36입(크+카)", "스니커즈 미니어쳐 1", "미니 담라 소프트캔디", "키도 크리미버터 13입", "토마스멀티비타민500", "미니 멘토스 뉴레인", "엠바레 캐러멀", "하리보 골드베렌 젤리", "젤리스트로우 대용량", "이탈리안샐ggg러gggggg러드", "이탈리안샐ggg러gggggg러드"};
        int[] price = {3780, 15000, 2980, 4950, 5980, 8480, 13300, 5980, 2980, 4700, 990, 1440, 4250, 2750, 12400, 4700, 2980, 4980, 2280, 2980, 4980, 9000, 8780, 14680, 11980, 12980, 10980, 14980, 9980, 10000000, 100000000};
        int[] num = {1, 1, 1, 1, 2, 1, 1, 5, 1, 3, 1, 2, 1, 100, 1, 2, 1, 1, 4, 1, 1, 1, 1, 2, 3, 1, 4, 2, 1, 1, 1};
        boolean[] taxfree = {false, false, false, true, false, false, false, false, false, false, false, false, false, false, true, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false};*/

        // 인덱스 100 이상을 위한 테스트 배열. 항목 120개
/*       String[] itemname = {"초코에몽180ml*4", "BE정장벨트15F", "(G)기본고무줄4-7", "서울우유 2.3L", "그릭 베리믹스95g*8", "하림 치킨너겟480+1",
                "하림 치킨너겟480+1", "로레알헤어오일브라", "바나나스페셜 240ml", "로투스비스킷312.5G", "풀무원 치즈&치즈", "극세사화장실용 수세미", "바나나요구르트 순한맛",
                "풀무원샘물250ml*4", "바른생각 휴지한박스", "냉동블루베리1.13kg", "소프트옥수수식빵", "허니씨솔트호두150g", "LH망사스펀지수세미2p", "베이비오갈아넣은체리",
                "롯데몽쉘36입(크+카)", "스니커즈 미니어쳐 1", "미니 담라 소프트캔디", "키도 크리미버터 13입", "토마스멀티비타민500", "미니 멘토스 뉴레인", "엠바레 캐러멀", "하리보 골드베렌 젤리", "젤리스트로우 대용량", "이탈리안샐ggg러gggggg러드", "이탈리안샐ggg러gggggg러드",
                "초코에몽180ml*4", "BE정장벨트15F", "(G)기본고무줄4-7", "서울우유 2.3L", "그릭 베리믹스95g*8", "하림 치킨너겟480+1",
                "하림 치킨너겟480+1", "로레알헤어오일브라", "바나나스페셜 240ml", "로투스비스킷312.5G", "풀무원 치즈&치즈", "극세사화장실용 수세미", "바나나요구르트 순한맛",
                "풀무원샘물250ml*4", "바른생각 휴지한박스", "냉동블루베리1.13kg", "소프트옥수수식빵", "허니씨솔트호두150g", "LH망사스펀지수세미2p", "베이비오갈아넣은체리",
                "롯데몽쉘36입(크+카)", "스니커즈 미니어쳐 1", "미니 담라 소프트캔디", "키도 크리미버터 13입", "토마스멀티비타민500", "미니 멘토스 뉴레인", "엠바레 캐러멀", "하리보 골드베렌 젤리", "젤리스트로우 대용량", "이탈리안샐ggg러gggggg러드", "이탈리안샐ggg러gggggg러드",
                "초코에몽180ml*4", "BE정장벨트15F", "(G)기본고무줄4-7", "서울우유 2.3L", "그릭 베리믹스95g*8", "하림 치킨너겟480+1",
                "하림 치킨너겟480+1", "로레알헤어오일브라", "바나나스페셜 240ml", "로투스비스킷312.5G", "풀무원 치즈&치즈", "극세사화장실용 수세미", "바나나요구르트 순한맛",
                "풀무원샘물250ml*4", "바른생각 휴지한박스", "냉동블루베리1.13kg", "소프트옥수수식빵", "허니씨솔트호두150g", "LH망사스펀지수세미2p", "베이비오갈아넣은체리",
                "롯데몽쉘36입(크+카)", "스니커즈 미니어쳐 1", "미니 담라 소프트캔디", "키도 크리미버터 13입", "토마스멀티비타민500", "미니 멘토스 뉴레인", "엠바레 캐러멀", "하리보 골드베렌 젤리", "젤리스트로우 대용량", "이탈리안샐ggg러gggggg러드", "이탈리안샐ggg러gggggg러드",
                "초코에몽180ml*4", "BE정장벨트15F", "(G)기본고무줄4-7", "서울우유 2.3L", "그릭 베리믹스95g*8", "하림 치킨너겟480+1",
                "하림 치킨너겟480+1", "로레알헤어오일브라", "바나나스페셜 240ml", "로투스비스킷312.5G", "풀무원 치즈&치즈", "극세사화장실용 수세미", "바나나요구르트 순한맛",
                "풀무원샘물250ml*4", "바른생각 휴지한박스", "냉동블루베리1.13kg", "소프트옥수수식빵", "허니씨솔트호두150g", "LH망사스펀지수세미2p", "베이비오갈아넣은체리",
                "롯데몽쉘36입(크+카)", "스니커즈 미니어쳐 1", "미니 담라 소프트캔디", "키도 크리미버터 13입", "토마스멀티비타민500", "미니 멘토스 뉴레인", "엠바레 캐러멀", "하리보 골드베렌 젤리", "젤리스트로우 대용량", "이탈리안샐ggg러gggggg러드", "이탈리안샐ggg러gggggg러드"};
        int[] price = {3780, 15000, 2980, 4950, 5980, 8480, 13300, 5980, 2980, 4700, 990, 1440, 4250, 2750, 12400, 4700, 2980, 4980, 2280, 2980, 4980, 9000, 8780, 14680, 11980, 12980, 10980, 14980, 9980, 10000000, 100000000,
                3780, 15000, 2980, 4950, 5980, 8480, 13300, 5980, 2980, 4700, 990, 1440, 4250, 2750, 12400, 4700, 2980, 4980, 2280, 2980, 4980, 9000, 8780, 14680, 11980, 12980, 10980, 14980, 9980, 10000000, 100000000,
                3780, 15000, 2980, 4950, 5980, 8480, 13300, 5980, 2980, 4700, 990, 1440, 4250, 2750, 12400, 4700, 2980, 4980, 2280, 2980, 4980, 9000, 8780, 14680, 11980, 12980, 10980, 14980, 9980, 10000000, 100000000,
                3780, 15000, 2980, 4950, 5980, 8480, 13300, 5980, 2980, 4700, 990, 1440, 4250, 2750, 12400, 4700, 2980, 4980, 2280, 2980, 4980, 9000, 8780, 14680, 11980, 12980, 10980, 14980, 9980, 10000000, 100000000};
        int[] num = {1, 1, 1, 1, 2, 1, 1, 5, 1, 3, 1, 2, 1, 100, 1, 2, 1, 1, 4, 1, 1, 1, 1, 2, 3, 1, 4, 2, 1, 1, 1,
                1, 1, 1, 1, 2, 1, 1, 5, 1, 3, 1, 2, 1, 100, 1, 2, 1, 1, 4, 1, 1, 1, 1, 2, 3, 1, 4, 2, 1, 1, 1,
                1, 1, 1, 1, 2, 1, 1, 5, 1, 3, 1, 2, 1, 100, 1, 2, 1, 1, 4, 1, 1, 1, 1, 2, 3, 1, 4, 2, 1, 1, 1,
                1, 1, 1, 1, 2, 1, 1, 5, 1, 3, 1, 2, 1, 100, 1, 2, 1, 1, 4, 1, 1, 1, 1, 2, 3, 1, 4, 2, 1, 1, 1};
        boolean[] taxfree = {false, false, false, true, false, false, false, false, false, false, false, false, false, false, true, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false,
                false, false, false, true, false, false, false, false, false, false, false, false, false, false, true, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false,
                false, false, false, true, false, false, false, false, false, false, false, false, false, false, true, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false,
                false, false, false, true, false, false, false, false, false, false, false, false, false, false, true, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false};*/

        // 인덱스 1을 위한 테스트 배열.
        String[] itemname = {"초코에몽180ml*4"};
        int[] price = {3780};
        int[] num = {1};
        boolean[] taxfree = {false};

        // 날짜 표현을 위한 Calendar 객체 생성
        Calendar k27_calendar = Calendar.getInstance();
        // 금액에 컴마표기를 위한 DecimalForamt 패턴 객체 생성.
        DecimalFormat k27_dfWon = new DecimalFormat("###,###,###,###,###,###");
        // 날짜를 원하는 포맷으로 설정하기 위한 SimpleDateFromat 패턴 객체 생성
        SimpleDateFormat k27_sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");

        // 영수증의 store, card 부분 클래스화 시키고 해당 정보들 생성자를 통해 인스턴스 생성.
        k27_Biz_05_Receipt_03_Store k27_store = new k27_Biz_05_Receipt_03_Store("emart", "이마트 죽전점", "(031)888-1234", "206-86-50913", "이갑수", "용인시 수지구 포은대로",
                "영수증 미지참시 교환/환불 불가(30일내)", "교환/환불 구매점에서 가능(결제카드지참)", "체크카드/신용카드 청구취소 반영은", "최대 3~5일 소요 (주말,공휴일제외)", "0009-2418");
        k27_Biz_05_Receipt_03_Card k27_card = new k27_Biz_05_Receipt_03_Card(k27_calendar.getTime(), "0009-2418", "0024 하나", "5417**8890/07850246", "카드결제", "일시불 / ", "조*근");
        // 주문 관련 금액 정보 필드 사용을 위한 Order 형 k27_orderCal 인스턴스 생성.
        k27_Biz_05_Receipt_03_Order k27_orderCal = new k27_Biz_05_Receipt_03_Order();

        // 주문 목록을 ArrayList<Order> 형으로 선언해서 k27_orderList 인스턴스(리스트)를 생성한다.
        //ArrayList<k27_Biz_05_Receipt_03_Order> k27_orderList = new ArrayList<>(Array.asList(itemname));
        ArrayList<k27_Biz_05_Receipt_03_Order> k27_orderList = new ArrayList<>();
        // k27_orderList에 add 메서드로 Order형 인스턴스들을 각각 생성하면서 삽입한다.

        System.out.printf("%15s%-8s%-2s\n", " ", k27_store.getK27_storeName(), k27_store.getK27_telNumber());
        System.out.printf("%10s%5s%-8s %-2s\n", k27_store.getK27_storeLogo(), " ", k27_store.getK27_storeCode(), k27_store.getK27_ownerName());
        System.out.printf("%15s%-8s\n", " ", k27_store.getK27_storeAddress());
        System.out.printf("\n");
        System.out.printf("%s\n", k27_store.getK27_informMsg1());
        System.out.printf("%s\n", k27_store.getK27_informMsg2());
        System.out.printf("%s\n", k27_store.getK27_informMsg3());
        System.out.printf("%s\n", k27_store.getK27_informMsg4());
        System.out.printf("\n");
        System.out.printf("[구 매]%-22sPOS:%s\n", k27_sdf.format(k27_calendar.getTime()), k27_card.getK27_posNumber());
        System.out.printf("------------------------------------------\n");
        System.out.printf("%5s%18s%3s%8s", "상품명", "단 가", "수량", "금 액\n");
        System.out.printf("------------------------------------------\n");
        // 상품 목록 출력을 위한 for문
        for (int k27_i = 0; k27_i < itemname.length; k27_i++) {
            // 배열에 저장된 상품 정보들을 Order형 ArrayList에 삽입한다.
            // 각 상품정보들은 인스턴스화 되어 저장된다.
            k27_orderList.add(new k27_Biz_05_Receipt_03_Order(taxfree[k27_i], itemname[k27_i], price[k27_i], num[k27_i]));
            // 14byte 길이를 만들어주기 위해 StringBuilder 인스턴스서 k27_sb 생성.
            // 해당 StringBuilder 인스턴스 k27_sb는 itemName을 포함한채로 생성된다.
            StringBuilder k27_sb = new StringBuilder(k27_orderList.get(k27_i).getK27_itemName());
            // 각 인스턴스의 아이템 이름 itemName을 getBytes.length를 사용해 길이를 측정한다.
            int k27_byteLength = k27_orderList.get(k27_i).getK27_itemName().getBytes("euc-kr").length;
            // 길이가 14byte이상이면
            if (k27_byteLength >= 14) {
                // k27_sb 내용을 초기화. k27_getString 메서드로 자른 내용을 그대로 붙여야 하기 때문이다.
                k27_sb.setLength(0);
                // getString 메서드로 itemName의 String을 14byte로 자른다.
                String k27_outputString = k27_getString(k27_orderList.get(k27_i).getK27_itemName(), 0, 14);
                // k27_sb에 완성된 String을 outputStirng 변수에 대입
                k27_sb.append(k27_outputString);
                // 완성된 내용이 14바이트에 한글이 걸쳐서 한글이 깨져서 출력될 때
                // k27_sb.toString 완성 된 문자에서 마지막 문자를 Substring하여 추출하고 이를 판별한다.
                // [영문, 숫자, 특수문자, 한글] 판별 정규표현식을 작성하고 이것이 아닌 것을 검출한다.
                // 즉, 해당 조건문에 걸리면 깨진 문자로 판별되고 해당 꺠진 문자를 제거하는 과정 진행.
                if (!k27_sb.toString().substring(k27_sb.toString().length() - 1).matches(
                        "^[a-zA-Z0-9가-힣 `~!@#$%^&*()\\-_=+\\[{\\]}\\\\|;:'\",<.>/?//s]{0,100}$")) {
                    // 마지막 문자를 자른 k27_outputString2 변수를 append하고 잘랐으니 마지막에 빈 공백 String을 넣는다.
                    String outputString = k27_sb.toString().substring(0, k27_sb.toString().length() - 1);
                    // 기존 k27_sb StringBuilder 인스턴스의 내용을 제거한다.
                    k27_sb.setLength(0);
                    // 마지막 문자를 자른 k27_outputString2 변수를 append하고 잘랐으니 마지막에 빈 공백 String을 넣는다.
                    k27_sb.append(outputString).append(" ");
                }
                // 길이가 14byte 이상이 아니면
            } else {
                // 14에서 부족한 부분만큼 공백 String을 append로 채워넣는다.
                for (int j = 0; j < 14 - k27_byteLength; j++) {
                    k27_sb.append(" ");
                }
            }

            // 위의 조건문에서 생성된 k27_sb.toString()을 orderList의 각 itemName setter를 이용해 대입한다.
            // 수정 된 이름 값을 대입
            k27_orderList.get(k27_i).setK27_itemName(k27_sb.toString());

            // taxFree 아이템을 판별하는 구문
            // 인스턴스의 taxFree 필드가 true가 아니면 모든 정보를 taxItem~ 필드들에 저장한다.
            if (!k27_orderList.get(k27_i).isK27_taxFree()) {
                // tax 아이템이면 별표 없는 공백으로 출력
                // k27_i이 100 미만이면 인덱스를 02d%에 별표 %-2s 서식지정자 출력
                if (k27_i + 1 < 100) {
                    System.out.printf("%02d%-2s%4s%10.10s%4.3s%10.10s\n", k27_i + 1, " ", k27_orderList.get(k27_i).getK27_itemName(), k27_dfWon.format(k27_orderList.get(k27_i).getK27_itemUnitPrice()), k27_orderList.get(k27_i).getK27_itemAmount(), k27_dfWon.format(k27_orderList.get(k27_i).getK27_itemPrice()));
                    // k27_i이 100 이상이면 인덱스를 3d%에 별표 %-s 서식지정자 출력
                } else {
                    System.out.printf("%3d%s%4s%10.10s%4.3s%10.10s\n", k27_i + 1, " ", k27_orderList.get(k27_i).getK27_itemName(), k27_dfWon.format(k27_orderList.get(k27_i).getK27_itemUnitPrice()), k27_orderList.get(k27_i).getK27_itemAmount(), k27_dfWon.format(k27_orderList.get(k27_i).getK27_itemPrice()));
                }
                // tax 아이템의 총합은 taxItemTotalPrice에 저장.
                k27_orderCal.setK27_taxItemTotalPrice(k27_orderCal.getK27_taxItemTotalPrice() + k27_orderList.get(k27_i).getK27_itemPrice());
                // 인스턴스의 taxFree 필드가 false이면 모든 정보를 taxFreeItem~ 필드들에 저장한다.
                // taxFree 아이템이면 별표를 출력
            } else {
                // k27_i이 100 미만이면 인덱스를 02d%에 별표 %-2s 서식지정자 출력
                if (k27_i + 1 < 100) {
                    System.out.printf("%02d%-2s%4s%10.10s%4.3s%10.10s\n", k27_i + 1, "*", k27_orderList.get(k27_i).getK27_itemName(), k27_dfWon.format(k27_orderList.get(k27_i).getK27_itemUnitPrice()), k27_orderList.get(k27_i).getK27_itemAmount(), k27_dfWon.format(k27_orderList.get(k27_i).getK27_itemPrice()));
                    // k27_i이 100 이상이면 인덱스를 3d%에 별표 %-s 서식지정자 출력
                } else {
                    System.out.printf("%3d%s%4s%10.10s%4.3s%10.10s\n", k27_i + 1, "*", k27_orderList.get(k27_i).getK27_itemName(), k27_dfWon.format(k27_orderList.get(k27_i).getK27_itemUnitPrice()), k27_orderList.get(k27_i).getK27_itemAmount(), k27_dfWon.format(k27_orderList.get(k27_i).getK27_itemPrice()));
                }
                // taxFree 아이템의 총합은 taxFreeItemTotalPrice에 저장.
                k27_orderCal.setK27_taxFreeItemTotalPrice(k27_orderCal.getK27_taxFreeItemTotalPrice() + k27_orderList.get(k27_i).getK27_itemPrice());
            }
            // 전체 itemTotalPrice를 구하기 위해 if뭍 바깥에서 종류상관없이 itemPrice 모두 입력
            k27_orderCal.setK27_itemTotalPrice(k27_orderCal.getK27_itemTotalPrice() + k27_orderList.get(k27_i).getK27_itemPrice());
        }

        System.out.printf("%23s%15.13s\n", "(*)면 세  물 품", k27_dfWon.format(k27_orderCal.getK27_taxFreeItemTotalPrice()));
        System.out.printf("%23s%15.13s\n", "과 세  물 품", k27_dfWon.format(k27_orderCal.getK27_preTaxItemTotalPrice()));
        System.out.printf("%24s%15.13s\n", "부   가   세", k27_dfWon.format(k27_orderCal.getK27_itemTotalVat()));
        System.out.printf("%25s%15.13s\n", "합        계", k27_dfWon.format(k27_orderCal.getK27_itemTotalPrice()));
        System.out.printf("%s%25.13s\n", "결 제 대 상 금 액", k27_dfWon.format(k27_orderCal.getK27_itemTotalPrice()));
        System.out.printf("------------------------------------------\n");
        System.out.printf("%s%33s\n", k27_card.getK27_cardCompany(), k27_card.getK27_cardNumber());
        System.out.printf("%s%31s\n", k27_card.getK27_paymentMethod(),
                k27_card.getK27_cardPaymentMethod() + k27_dfWon.format(k27_orderCal.getK27_itemTotalPrice()));
        System.out.printf("------------------------------------------\n");
        System.out.printf("%s %s", k27_card.getK27_cardHolder(), "고객님의 포인트 현황입니다.");
    }

    public static class k27_Biz_05_Receipt_03_Order {
        // 영수증에서 Order 부분의 각 정보들의 필드
        // private 형으로 캡슐화
        private boolean k27_taxFree;
        private String k27_itemName;
        private int k27_itemUnitPrice;
        private int k27_itemAmount;
        private int k27_itemPrice;
        private int k27_taxFreeItemTotalPrice;
        private int k27_taxItemTotalPrice;
        private int k27_preTaxItemTotalPrice;
        private int k27_itemTotalVat;
        private int k27_itemTotalPrice;

        // 해당 클래스에 대한 생성자 정의
        // 직접적으로 정보들이 입력되는 부분들은 생성자로 정의한다.
        public k27_Biz_05_Receipt_03_Order(boolean taxFree, String itemName, int itemUnitPrice, int itemAmount) {
            this.k27_taxFree = taxFree;
            this.k27_itemName = itemName;
            this.k27_itemUnitPrice = itemUnitPrice;
            this.k27_itemAmount = itemAmount;
        }

        public k27_Biz_05_Receipt_03_Order() {
        }

        public boolean isK27_taxFree() {
            return k27_taxFree;
        }

        public void setK27_taxFree(boolean k27_taxFree) {
            this.k27_taxFree = k27_taxFree;
        }

        public String getK27_itemName() {
            return k27_itemName;
        }

        public void setK27_itemName(String k27_itemName) {
            this.k27_itemName = k27_itemName;
        }

        public int getK27_itemUnitPrice() {
            return k27_itemUnitPrice;
        }

        public void setK27_itemUnitPrice(int k27_itemUnitPrice) {
            this.k27_itemUnitPrice = k27_itemUnitPrice;
        }

        public int getK27_itemAmount() {
            return k27_itemAmount;
        }

        public void setK27_itemAmount(int k27_itemAmount) {
            this.k27_itemAmount = k27_itemAmount;
        }

        public int getK27_itemPrice() {
            return this.k27_itemUnitPrice * this.k27_itemAmount;
        }

        public void setK27_itemPrice(int k27_itemPrice) {
            this.k27_itemPrice = k27_itemPrice;
        }

        public int getK27_taxFreeItemTotalPrice() {
            return k27_taxFreeItemTotalPrice;
        }

        public void setK27_taxFreeItemTotalPrice(int k27_taxFreeItemTotalPrice) {
            this.k27_taxFreeItemTotalPrice = k27_taxFreeItemTotalPrice;
        }

        public int getK27_taxItemTotalPrice() {
            return k27_taxItemTotalPrice;
        }

        public void setK27_taxItemTotalPrice(int k27_taxItemTotalPrice) {
            this.k27_taxItemTotalPrice = k27_taxItemTotalPrice;
        }

        // 세전 금액은 k27_taxItemTotalPrice를 calPreTaxPrice 메서드를 사용해서 출력한다.
        public int getK27_preTaxItemTotalPrice() {
            this.k27_preTaxItemTotalPrice = calPreTaxPrice(this.k27_taxItemTotalPrice, 10.0);
            return k27_preTaxItemTotalPrice;
        }

        public void setK27_preTaxItemTotalPrice(int k27_preTaxItemTotalPrice) {
            this.k27_preTaxItemTotalPrice = k27_preTaxItemTotalPrice;
        }

        // 세금은 k27_taxItemTotalPrice(전체 금액) - k27_preTaxItemTotalPrice(세전 금액)으로 계산
        public int getK27_itemTotalVat() {
            this.k27_itemTotalVat = this.k27_taxItemTotalPrice - k27_preTaxItemTotalPrice;
            return k27_itemTotalVat;
        }

        public void setK27_itemTotalVat(int k27_itemTotalVat) {
            this.k27_itemTotalVat = k27_itemTotalVat;
        }

        public int getK27_itemTotalPrice() {
            return k27_itemTotalPrice;
        }

        public void setK27_itemTotalPrice(int k27_itemTotalPrice) {
            this.k27_itemTotalPrice = k27_itemTotalPrice;
        }

        // 세전 금액을 계산해주는 메서드
        // 기존 공식의 경우 나눗셈 뒤에 나눗셈이 존재해서 부동소수점 연산 때문에 정확하지 않은 값이 나온다.
        // 나눠지는 항에서 나눗셈이 존재하는 걸 피하기 위해 수식을 조작하여 순차적으로 처리하도록 만든다.
        public int calPreTaxPrice(int totalPrice, double taxRate) {
            return (int) (totalPrice / (100.0 + taxRate) * 100.0);
        }
    }

    public static class k27_Biz_05_Receipt_03_Card {
        // 영수증에서 Card 부분의 각 정보들의 필드
        // private 형으로 캡슐화
        private Date k27_paymentDate;
        private String k27_posNumber;
        private String k27_cardCompany;
        private String k27_cardNumber;
        private String k27_paymentMethod;
        private String k27_cardPaymentMethod;
        private String k27_cardHolder;

        // 해당 클래스에 대한 생성자 정의
        // 직접적으로 정보들이 입력되는 부분들은 생성자로 정의한다.
        public k27_Biz_05_Receipt_03_Card(Date k27_paymentDate, String k27_posNumber, String k27_cardCompany, String k27_cardNumber, String k27_paymentMethod, String k27_cardPaymentMethod, String k27_cardHolder) {
            this.k27_paymentDate = k27_paymentDate;
            this.k27_posNumber = k27_posNumber;
            this.k27_cardCompany = k27_cardCompany;
            this.k27_cardNumber = k27_cardNumber;
            this.k27_paymentMethod = k27_paymentMethod;
            this.k27_cardPaymentMethod = k27_cardPaymentMethod;
            this.k27_cardHolder = k27_cardHolder;
        }

        public Date getK27_paymentDate() {
            return k27_paymentDate;
        }

        public void setK27_paymentDate(Date k27_paymentDate) {
            this.k27_paymentDate = k27_paymentDate;
        }

        public String getK27_posNumber() {
            return k27_posNumber;
        }

        public void setK27_posNumber(String k27_posNumber) {
            this.k27_posNumber = k27_posNumber;
        }

        public String getK27_cardCompany() {
            return k27_cardCompany;
        }

        public void setK27_cardCompany(String k27_cardCompany) {
            this.k27_cardCompany = k27_cardCompany;
        }

        public String getK27_cardNumber() {
            return k27_cardNumber;
        }

        public void setK27_cardNumber(String k27_cardNumber) {
            this.k27_cardNumber = k27_cardNumber;
        }

        public String getK27_paymentMethod() {
            return k27_paymentMethod;
        }

        public void setK27_paymentMethod(String k27_paymentMethod) {
            this.k27_paymentMethod = k27_paymentMethod;
        }

        public String getK27_cardPaymentMethod() {
            return k27_cardPaymentMethod;
        }

        public void setK27_cardPaymentMethod(String k27_cardPaymentMethod) {
            this.k27_cardPaymentMethod = k27_cardPaymentMethod;
        }

        public String getK27_cardHolder() {
            return k27_cardHolder;
        }

        public void setK27_cardHolder(String k27_cardHolder) {
            this.k27_cardHolder = k27_cardHolder;
        }
    }

    public static class k27_Biz_05_Receipt_03_Store {
        // 영수증에서 Card 부분의 각 정보들의 필드
        // private 형으로 캡슐화
        private String k27_storeLogo;
        private String k27_storeName;
        private String k27_telNumber;
        private String k27_storeCode;
        private String k27_ownerName;
        private String k27_storeAddress;
        private String k27_informMsg1;
        private String k27_informMsg2;
        private String k27_informMsg3;
        private String k27_informMsg4;
        private String k27_posNumber;

        // 해당 클래스에 대한 생성자 정의
        // 직접적으로 정보들이 입력되는 부분들은 생성자로 정의한다.
        public k27_Biz_05_Receipt_03_Store(String storeLogo, String storeName, String telNumber, String storeCode, String ownerName, String storeAddress, String informMsg1, String informMsg2, String informMsg3, String informMsg4, String posNumber) {
            this.k27_storeLogo = storeLogo;
            this.k27_storeName = storeName;
            this.k27_telNumber = telNumber;
            this.k27_storeCode = storeCode;
            this.k27_ownerName = ownerName;
            this.k27_storeAddress = storeAddress;
            this.k27_informMsg1 = informMsg1;
            this.k27_informMsg2 = informMsg2;
            this.k27_informMsg3 = informMsg3;
            this.k27_informMsg4 = informMsg4;
            this.k27_posNumber = posNumber;
        }

        public String getK27_storeLogo() {
            return k27_storeLogo;
        }

        public void setK27_storeLogo(String k27_storeLogo) {
            this.k27_storeLogo = k27_storeLogo;
        }

        public String getK27_storeName() {
            return k27_storeName;
        }

        public void setK27_storeName(String k27_storeName) {
            this.k27_storeName = k27_storeName;
        }

        public String getK27_telNumber() {
            return k27_telNumber;
        }

        public void setK27_telNumber(String k27_telNumber) {
            this.k27_telNumber = k27_telNumber;
        }

        public String getK27_storeCode() {
            return k27_storeCode;
        }

        public void setK27_storeCode(String k27_storeCode) {
            this.k27_storeCode = k27_storeCode;
        }

        public String getK27_ownerName() {
            return k27_ownerName;
        }

        public void setK27_ownerName(String k27_ownerName) {
            this.k27_ownerName = k27_ownerName;
        }

        public String getK27_storeAddress() {
            return k27_storeAddress;
        }

        public void setK27_storeAddress(String k27_storeAddress) {
            this.k27_storeAddress = k27_storeAddress;
        }

        public String getK27_informMsg1() {
            return k27_informMsg1;
        }

        public void setK27_informMsg1(String k27_informMsg1) {
            this.k27_informMsg1 = k27_informMsg1;
        }

        public String getK27_informMsg2() {
            return k27_informMsg2;
        }

        public void setK27_informMsg2(String k27_informMsg2) {
            this.k27_informMsg2 = k27_informMsg2;
        }

        public String getK27_informMsg3() {
            return k27_informMsg3;
        }

        public void setK27_informMsg3(String k27_informMsg3) {
            this.k27_informMsg3 = k27_informMsg3;
        }

        public String getK27_informMsg4() {
            return k27_informMsg4;
        }

        public void setK27_informMsg4(String k27_informMsg4) {
            this.k27_informMsg4 = k27_informMsg4;
        }

        public String getK27_posNumber() {
            return k27_posNumber;
        }

        public void setK27_posNumber(String k27_posNumber) {
            this.k27_posNumber = k27_posNumber;
        }
    }
}
