package Chapter_05_Receipt_02;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class k27_Biz_05_Receipt_02_All {
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

    public static class k27_Biz_05_Receipt_02_Order {
        // 영수증에서 Order 부분의 각 정보들의 필드
        // private 형으로 캡슐화
        private String k27_itemName;
        private String k27_itemCode;
        private int k27_itemUnitPrice;
        private int k27_itemAmount;
        private int k27_itemPrice;
        private int k27_preTaxPrice;
        private int k27_taxAmount;
        private int k27_totalPrice;

        // 해당 클래스에 대한 생성자 정의
        // 직접적으로 정보들이 입력되는 부분들은 생성자로 정의한다.
        public k27_Biz_05_Receipt_02_Order(String itemName, String itemCode, int itemUnitPrice, int itemAmount) {
            this.k27_itemName = itemName;
            this.k27_itemCode = itemCode;
            this.k27_itemUnitPrice = itemUnitPrice;
            this.k27_itemAmount = itemAmount;
        }

        // calulate 인스턴스 생성을 위한 기본 생성자 정의
        public k27_Biz_05_Receipt_02_Order() {
        }

        // 멤버 변수들에 대하여 getter/setter 설정
        public String getK27_itemName() {
            return k27_itemName;
        }

        public void setK27_itemName(String k27_itemName) {
            this.k27_itemName = k27_itemName;
        }

        public String getK27_itemCode() {
            return k27_itemCode;
        }

        public void setK27_itemCode(String k27_itemCode) {
            this.k27_itemCode = k27_itemCode;
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
            this.k27_itemPrice = this.k27_itemUnitPrice * this.k27_itemAmount;
            return k27_itemPrice;
        }

        public void setK27_itemPrice(int k27_itemPrice) {
            this.k27_itemPrice = k27_itemPrice;
        }

        // getter에 세전 가격 설정
        // k27_calFreeTaxPrice 메서드 사용한다.
        public int getK27_preTaxPrice() {
            this.k27_preTaxPrice = k27_calPreTaxPrice(this.k27_totalPrice, 10);
            return k27_preTaxPrice;
        }

        public void setK27_preTaxPrice(int k27_preTaxPrice) {
            this.k27_preTaxPrice = k27_preTaxPrice;
        }

        public int getK27_taxAmount() {
            this.k27_taxAmount = this.k27_totalPrice - k27_preTaxPrice;
            return k27_taxAmount;
        }

        public void setK27_taxAmount(int k27_taxAmount) {
            this.k27_taxAmount = k27_taxAmount;
        }

        public int getK27_totalPrice() {
            return k27_totalPrice;
        }

        public void setK27_totalPrice(int k27_totalPrice) {
            this.k27_totalPrice = k27_totalPrice;
        }

        // 세전 금액을 계산해주는 메서드
        // 기존 공식의 경우 나눗셈 뒤에 나눗셈이 존재해서 부동소수점 연산 때문에 정확하지 않은 값이 나온다.
        // 나눠지는 항에서 나눗셈이 존재하는 걸 피하기 위해 수식을 조작하여 순차적으로 처리하도록 만든다.
        public int k27_calPreTaxPrice(int k27_totalPrice, double k27_taxRate) {
            return (int) (k27_totalPrice / (100.0 + k27_taxRate) * 100.0);
        }
    }

    public static class k27_Biz_05_Receipt_02_Card {
        // 영수증에서 Card 부분의 각 정보들의 필드
        // private 형으로 캡슐화
        private String k27_cardCompany;
        private String k27_cardCode;
        private String k27_cardNumber;
        private int k27_cardSale;
        private String k27_transMethod;
        private String k27_approvalCode;
        private String k27_approvalNumber;
        private String k27_memberNumber;
        private int k27_amountReceived;
        private int k27_amountChange;
        private String k27_orderNumber;
        private String k27_salesmanName;
        private Date k27_paymentDate;
        private String k27_interlockingModule;
        // 해당 클래스에 대한 생성자 정의
        // 직접적으로 정보들이 입력되는 부분들은 생성자로 정의한다.
        public k27_Biz_05_Receipt_02_Card(String cardCompany, String cardCode, String cardNumber, String transMethod, String approvalCode, String approvalNumber, String memberNumber, String orderNumber, String salesmanName, Date paymentDate, String interlockingModule) {
            this.k27_cardCompany = cardCompany;
            this.k27_cardCode = cardCode;
            this.k27_cardNumber = cardNumber;
            this.k27_transMethod = transMethod;
            this.k27_approvalCode = approvalCode;
            this.k27_approvalNumber = approvalNumber;
            this.k27_memberNumber = memberNumber;
            this.k27_orderNumber = orderNumber;
            this.k27_salesmanName = salesmanName;
            this.k27_paymentDate = paymentDate;
            this.k27_interlockingModule = interlockingModule;
        }

        public String getK27_cardCompany() {
            return k27_cardCompany;
        }

        public void setK27_cardCompany(String k27_cardCompany) {
            this.k27_cardCompany = k27_cardCompany;
        }

        public String getK27_cardCode() {
            return k27_cardCode;
        }

        public void setK27_cardCode(String k27_cardCode) {
            this.k27_cardCode = k27_cardCode;
        }

        public String getK27_cardNumber() {
            return k27_cardNumber;
        }

        public void setK27_cardNumber(String k27_cardNumber) {
            this.k27_cardNumber = k27_cardNumber;
        }

        public int getK27_cardSale() {
            return k27_cardSale;
        }

        public void setK27_cardSale(int k27_cardSale) {
            this.k27_cardSale = k27_cardSale;
        }

        public String getK27_transMethod() {
            return k27_transMethod;
        }

        public void setK27_transMethod(String k27_transMethod) {
            this.k27_transMethod = k27_transMethod;
        }

        public String getK27_approvalCode() {
            return k27_approvalCode;
        }

        public void setK27_approvalCode(String k27_approvalCode) {
            this.k27_approvalCode = k27_approvalCode;
        }

        public String getK27_approvalNumber() {
            return k27_approvalNumber;
        }

        public void setK27_approvalNumber(String k27_approvalNumber) {
            this.k27_approvalNumber = k27_approvalNumber;
        }

        public String getK27_memberNumber() {
            return k27_memberNumber;
        }

        public void setK27_memberNumber(String k27_memberNumber) {
            this.k27_memberNumber = k27_memberNumber;
        }

        public int getK27_amountReceived() {
            return k27_amountReceived;
        }

        public void setK27_amountReceived(int k27_amountReceived) {
            this.k27_amountReceived = k27_amountReceived;
        }

        public int getK27_amountChange() {
            return k27_amountChange;
        }

        public void setK27_amountChange(int k27_amountChange) {
            this.k27_amountChange = k27_amountChange;
        }

        public String getK27_orderNumber() {
            return k27_orderNumber;
        }

        public void setK27_orderNumber(String k27_orderNumber) {
            this.k27_orderNumber = k27_orderNumber;
        }

        public String getK27_salesmanName() {
            return k27_salesmanName;
        }

        public void setK27_salesmanName(String k27_salesmanName) {
            this.k27_salesmanName = k27_salesmanName;
        }

        public Date getK27_paymentDate() {
            return k27_paymentDate;
        }

        public void setK27_paymentDate(Date k27_paymentDate) {
            this.k27_paymentDate = k27_paymentDate;
        }

        public String getK27_interlockingModule() {
            return k27_interlockingModule;
        }

        public void setK27_interlockingModule(String k27_interlockingModule) {
            this.k27_interlockingModule = k27_interlockingModule;
        }
    }

    public static class k27_Biz_05_Receipt_02_Store {
        // 영수증에서 Store 부분의 각 정보들의 필드
        // private 형으로 캡슐화
        private String k27_storeName;
        private String k27_storeAddress;
        private String k27_ownerName;
        private String k27_storeNumber;
        private String k27_telNumber;
        private String k27_posNumber;

        // 해당 클래스에 대한 생성자 정의
        // 직접적으로 정보들이 입력되는 부분들은 생성자로 정의한다.
        public k27_Biz_05_Receipt_02_Store(String storeName, String storeAddress, String ownerName, String storeNumber, String telNumber, String posNumber) {
            this.k27_storeName = storeName;
            this.k27_storeAddress = storeAddress;
            this.k27_ownerName = ownerName;
            this.k27_storeNumber = storeNumber;
            this.k27_telNumber = telNumber;
            this.k27_posNumber = posNumber;
        }

        // 멤버 변수들에 대하여 getter/setter 설정
        public String getK27_storeName() {
            return k27_storeName;
        }

        public void setK27_storeName(String k27_storeName) {
            this.k27_storeName = k27_storeName;
        }

        public String getK27_storeAddress() {
            return k27_storeAddress;
        }

        public void setK27_storeAddress(String k27_storeAddress) {
            this.k27_storeAddress = k27_storeAddress;
        }

        public String getK27_ownerName() {
            return k27_ownerName;
        }

        public void setK27_ownerName(String k27_ownerName) {
            this.k27_ownerName = k27_ownerName;
        }

        public String getK27_storeNumber() {
            return k27_storeNumber;
        }

        public void setK27_storeNumber(String k27_storeNumber) {
            this.k27_storeNumber = k27_storeNumber;
        }

        public String getK27_telNumber() {
            return k27_telNumber;
        }

        public void setK27_telNumber(String k27_telNumber) {
            this.k27_telNumber = k27_telNumber;
        }

        public String getK27_posNumber() {
            return k27_posNumber;
        }

        public void setK27_posNumber(String k27_posNumber) {
            this.k27_posNumber = k27_posNumber;
        }
    }
}
