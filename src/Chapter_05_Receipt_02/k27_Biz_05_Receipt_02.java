package Chapter_05_Receipt_02;

import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

public class k27_Biz_05_Receipt_02 {
    public static void main(String[] args) {
        // 아이템이름과 아이템코드, 가격, 수량을 설정하는 변수 선언
        String k27_itemname1, k27_itemname2;
        String k27_itemcode1, k27_itemcode2;
        int k27_price1, k27_price2;
        int k27_num1, k27_num2;

        // itemname1, itemcode1, price1, num1 초기화
        k27_itemname1 = "풀무원샘물";
        k27_itemcode1 = "8809169718205";
        k27_price1 = 30000000;
        k27_num1 = 1;
        // itemname2, itemcode2, price2, num2 초기화
        k27_itemname2 = "바나나요구르트";
        k27_itemcode2 = "8809169213444";
        k27_price2 = 10000000;
        k27_num2 = 1;
        // 날짜 표현을 위한 Calendar 객체 생성
        Calendar k27_calendar = Calendar.getInstance();
        // 날짜를 원하는 포맷으로 설정하기 위한 SimpleDateFromat 패턴 객체 생성
        SimpleDateFormat k27_sdfYMD2 = new SimpleDateFormat("yyyy/MM/dd");
        SimpleDateFormat k27_sdfYMD3 = new SimpleDateFormat("yyyyMMdd HHmmss");
        SimpleDateFormat k27_sdfYMD4 = new SimpleDateFormat("yyyyMMddHHmmss");
        // 금액에 컴마표기를 위한 DecimalForamt 패턴 객체 생성.
        DecimalFormat k27_dfWon = new DecimalFormat("###,###,###,###,###");

        // Store, Order, Class 생성자를 통해 영수증 데이터를 입력하고 해당 인스턴스를 생성한다.
        k27_Biz_05_Receipt_02_Store k27_store = new k27_Biz_05_Receipt_02_Store
                ("충주(양평)휴게소", "충북충주시가금면용전리380-4", "최병권", "677-85-00239", "043-857-9229", "0002");
        // 계산 부분 메소드와 변수 활용을 위한 Order 클래스형 k27_orderCal 인스턴스 생성
        k27_Biz_05_Receipt_02_Order k27_orderCal = new k27_Biz_05_Receipt_02_Order();
        // ArrayList를 Order 클래스형으로 선언하고 k27_orderList를 만든다.
        // 이곳에 상품들이 인스턴스 단위로 정보가 orderList에 저장된다.
        ArrayList<k27_Biz_05_Receipt_02_Order> k27_orderList = new ArrayList<>();
        // 위에서 선언한 제품 정보 변수들을 k27_orderList에 Order 클래스의 생성자를 통해 넣는다.
        k27_orderList.add(new k27_Biz_05_Receipt_02_Order(k27_itemname1, k27_itemcode1, k27_price1, k27_num1));
        k27_orderList.add(new k27_Biz_05_Receipt_02_Order(k27_itemname2, k27_itemcode2, k27_price2, k27_num2));
        // 생성자자를 통해 Card 정보를 담고있는 k27_card 인스턴스에 데이터 설정.
        k27_Biz_05_Receipt_02_Card k27_card = new k27_Biz_05_Receipt_02_Card
                ("026-비씨카드사", "00/00A", "5522-20**-****-BADD", "일시불", "04-KICC", "75549250", " ", "0920", "000002 편의점2", k27_calendar.getTime(), "00138705");
        // 영수증 부분에 맞는 인스턴스에서 getter를 이용해 정보를 불러온다.
        System.out.printf("%s\n", k27_store.getK27_storeName());
        System.out.printf("%s\n", k27_store.getK27_storeAddress());
        System.out.printf("%s %s TEL:%s\n", k27_store.getK27_ownerName(), k27_store.getK27_storeNumber(), k27_store.getK27_telNumber());
        System.out.printf("\n");
        System.out.printf("\n");
        System.out.printf("[정상등록]%-19sPOS번호:%-10s\n", k27_sdfYMD3.format(k27_card.getK27_paymentDate()), k27_store.getK27_posNumber());
        System.out.printf("-----------------------------------------\n");
        System.out.printf("%-10s%10s%3s%8s\n", "품목코드", "단가", "수량", "금액");
        // 상품 리스트가 출력되는 부분은 orderList를 for문으로 돌리며 목록을 출력한다.
        for (int k27_i = 0; k27_i < k27_orderList.size(); k27_i++) {
            System.out.printf("%s\n", k27_orderList.get(k27_i).getK27_itemName());
            // 상품 목록 리스트에 형식에 맞춰 orderList에 담긴 상품 정보 출력한다.
            System.out.printf("%-14s%12.10s%3s %11.10s\n",
                    k27_orderList.get(k27_i).getK27_itemCode(), k27_dfWon.format(k27_orderList.get(k27_i).getK27_itemUnitPrice()), k27_orderList.get(k27_i).getK27_itemAmount(), k27_dfWon.format(k27_orderList.get(k27_i).getK27_itemPrice()));
        }
        // orderList에 담긴 각 인스턴스의 k27_itemPrice의 총합을 구한다.
        // 이를 통해 주문 총합을 알 수 있다.
        k27_orderCal.setK27_totalPrice(k27_orderList.stream().mapToInt(k27_Biz_05_Receipt_02_Order::getK27_itemPrice).sum());
        k27_card.setK27_amountReceived(k27_orderCal.getK27_totalPrice());
        k27_card.setK27_cardSale(k27_orderCal.getK27_totalPrice());
        // Card 부분 인스턴스 정보 출력.
        System.out.printf("\n");
        System.out.printf("과세 물품 합계%27s\n", k27_dfWon.format(k27_orderCal.getK27_preTaxPrice()));
        System.out.printf("부    가    세%27s\n", k27_dfWon.format(k27_orderCal.getK27_taxAmount()));
        System.out.printf("합          계%27s\n", k27_dfWon.format(k27_orderCal.getK27_totalPrice()));
        System.out.printf("%-21s%15s\n", k27_card.getK27_cardCompany(), k27_card.getK27_cardCode());
        System.out.printf("카  드  번  호 : %24s\n", k27_card.getK27_cardNumber());
        System.out.printf("카  드  매  출 : %24s\n", k27_dfWon.format(k27_card.getK27_cardSale()));
        System.out.printf("거  래  구  분 : %21s\n", k27_card.getK27_transMethod());
        System.out.printf("승  인  번  호 : %-10s%14s\n", k27_card.getK27_approvalCode(), k27_card.getK27_approvalNumber());
        System.out.printf("가 맹 점 번 호 : %s\n", k27_card.getK27_memberNumber());
        System.out.printf("받  은  금  액 : %24s\n", k27_dfWon.format(k27_card.getK27_amountReceived()));
        System.out.printf("거    스    름 : %24s\n", k27_dfWon.format(k27_card.getK27_amountChange()));
        System.out.printf("-----------------------------------------\n");
        System.out.printf("주문번호: %10s\n", k27_card.getK27_orderNumber());
        System.out.printf("-----------------------------------------\n");
        System.out.printf("판매원 : %s\n", k27_card.getK27_salesmanName());
        System.out.printf("%s-%s-%s\n", k27_sdfYMD2.format(k27_card.getK27_paymentDate()), "0002", "0922");
        System.out.printf("연동모듈:[%s  %s]\n", k27_card.getK27_interlockingModule(), k27_sdfYMD4.format(k27_card.getK27_paymentDate()));
    }
}
