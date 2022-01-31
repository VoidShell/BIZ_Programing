package Chapter_05_Receipt_01;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class k27_Biz_05_Receipt_01_All {
    public static void main(String[] args) {
        // k27_iPrice 가격 21000 초기화
        int k27_iPrice = 14000;
        // 날짜 표현을 위한 Calendar 객체 생성
        Calendar k27_calendar = Calendar.getInstance();
        // 날짜를 원하는 포맷으로 설정하기 위한 SimpleDateFromat 패턴 객체 생성
        SimpleDateFormat k27_sdfMin = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        SimpleDateFormat k27_sdfMinSec = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        SimpleDateFormat k27_sdfMinSec2 = new SimpleDateFormat("yyyyMMdd");
        // 금액에 컴마표기를 위한 DecimalForamt 패턴 객체 생성.
        DecimalFormat k27_dfWon = new DecimalFormat("###,###,###,###,###");

        // Store, Order, Class 생성자를 통해 영수증 데이터를 입력하고 해당 인스턴스를 생성한다.
        k27_Biz_05_Receipt_01_Store k27_store = new k27_Biz_05_Receipt_01_Store
                ("종로상회(분당서현점)", "129-17-77924", "이상철", "031 781 1596", "성남시 분당구 서현동 269-3");
        k27_Biz_05_Receipt_01_Order k27_order = new k27_Biz_05_Receipt_01_Order("12", " 01 00041", k27_iPrice, 0, 0, k27_iPrice, 0);
        k27_Biz_05_Receipt_01_Card k27_card = new k27_Biz_05_Receipt_01_Card("우리카드", k27_calendar.getTime(), "55222059****2021", "730461774", "00", k27_iPrice, "730461774", "비씨카드사", "129-17-77924", k27_calendar.getTime(), " ");
        // 각 인스턴스 부분이 담당하는 부분에서 getter로 해당 인스턴스의 필드 정보들을 불러온다.
        System.out.printf("                영  수  증                \n");
        System.out.printf("-----------------------------------------\n");
        System.out.printf("%s  %s\n", k27_store.getK27_storeName(), k27_store.getK27_storeNumber());
        System.out.printf("%s  %s\n", k27_store.getK27_ownerName(), k27_store.getK27_telNumber());
        System.out.printf("%s\n", k27_store.getK27_storeAddress());
        System.out.printf("테이블명 : %s\n", k27_order.getK27_tableName());
        System.out.printf("주문번호 : %s\n", k27_sdfMinSec2.format(k27_card.getK27_paymentDate()) + k27_order.getK27_orderNumber());
        System.out.printf("-----------------------------------------\n");
        System.out.printf("주문합계%33s\n", k27_dfWon.format(k27_order.getK27_totalPrice()));
        System.out.printf("할인금액%33s\n", k27_dfWon.format(k27_order.getK27_discountAmount()));
        System.out.printf("받을금액%33s\n", k27_dfWon.format(k27_order.getK27_amountToReceive()));
        System.out.printf("-----------------------------------------\n");
        System.out.printf("현  금%13s 과  세%15s\n", k27_dfWon.format(k27_order.getK27_cash()), k27_dfWon.format(k27_order.getK27_preTaxPrice()));
        System.out.printf("카  드%13s 세  액%15s\n", k27_dfWon.format(k27_order.getK27_card()), k27_dfWon.format(k27_order.getK27_taxAmount()));
        System.out.printf("포인트%13s 면  세%15s\n", k27_dfWon.format(k27_order.getK27_point()), k27_dfWon.format(k27_order.getK27_taxFree()));
        System.out.printf("%24s%13s\n", "영수금액", k27_dfWon.format(k27_order.getK27_receiptPrice()));
        System.out.printf("-----------------------------------------\n");
        System.out.printf("%10s[%s 신용 승인]%10s\n", "", k27_card.getK27_cardCompany1(), "");
        System.out.printf("승 인 일 시 : %s\n", k27_sdfMinSec.format(k27_card.getK27_approvalDate()));
        System.out.printf("카 드 번 호 : %s\n", k27_card.getK27_cardNumber());
        System.out.printf("승 인 번 호 : %s  할부개월 : %s\n", k27_card.getK27_approvalNumber(), k27_card.getK27_installmentMonth());
        System.out.printf("승 인 금 액 : %s\n", k27_dfWon.format(k27_card.getK27_approvalPrice()));
        System.out.printf("가 맹 번 호 : %s  /  %s\n", k27_card.getK27_memberNumber(), k27_card.getK27_cardCompany2());
        System.out.printf("사업자 번호 : %s\n", k27_card.getK27_businessNumber());
        System.out.printf("-----------------------------------------\n");
        System.out.printf("%-18sCASHIER : %8s 직원\n", k27_sdfMin.format(k27_card.getK27_paymentDate()), k27_card.getK27_cashierName());
        System.out.printf("감사 합니다.\n");
    }

    public static class k27_Biz_05_Receipt_01_Order {
        // 영수증에서 Order 부분의 각 정보들의 필드
        // private 형으로 캡슐화
        private String k27_tableName;
        private String k27_orderNumber;
        private int k27_totalPrice;
        private int k27_discountAmount;
        private int k27_amountToReceive;
        private int k27_cash;
        private int k27_card;
        private int k27_point;
        private int k27_preTaxPrice;
        private int k27_taxAmount;
        private int k27_taxFree;
        private int k27_receiptPrice;

        // 해당 클래스에 대한 생성자 정의
        // 직접적으로 정보들이 입력되는 부분들은 생성자로 정의한다.
        public k27_Biz_05_Receipt_01_Order(String tableName, String orderNumber, int orderTotalPrice, int discountAmount, int cash, int card, int point) {
            this.k27_tableName = tableName;
            this.k27_orderNumber = orderNumber;
            this.k27_totalPrice = orderTotalPrice;
            this.k27_discountAmount = discountAmount;
            this.k27_cash = cash;
            this.k27_card = card;
            this.k27_point = point;
        }

        // 멤버 변수들에 대하여 getter/setter 설정
        public String getK27_tableName() {
            return k27_tableName;
        }

        public void setK27_tableName(String k27_tableName) {
            this.k27_tableName = k27_tableName;
        }

        public String getK27_orderNumber() {
            return k27_orderNumber;
        }

        public void setK27_orderNumber(String k27_orderNumber) {
            this.k27_orderNumber = k27_orderNumber;
        }

        public int getK27_totalPrice() {
            return k27_totalPrice;
        }

        public void setK27_totalPrice(int k27_totalPrice) {
            this.k27_totalPrice = k27_totalPrice;
        }

        public int getK27_discountAmount() {
            return k27_discountAmount;
        }

        public void setK27_discountAmount(int k27_discountAmount) {
            this.k27_discountAmount = k27_discountAmount;
        }

        //총 가격에서 할인금액을 뺀것이 지불 금액.
        public int getK27_amountToReceive() {
            this.k27_amountToReceive = this.k27_totalPrice - this.k27_discountAmount;
            return this.k27_amountToReceive;
        }

        public void setK27_amountToReceive(int k27_amountToReceive) {
            this.k27_amountToReceive = k27_amountToReceive;
        }

        public int getK27_cash() {
            return k27_cash;
        }

        public void setK27_cash(int k27_cash) {
            this.k27_cash = k27_cash;
        }

        public int getK27_card() {
            return k27_card;
        }

        public void setK27_card(int k27_card) {
            this.k27_card = k27_card;
        }

        public int getK27_point() {
            return k27_point;
        }

        public void setK27_point(int k27_point) {
            this.k27_point = k27_point;
        }

        // getter에 세전 가격 설정
        // k27_calFreeTaxPrice 메서드 사용한다.
        public int getK27_preTaxPrice() {
            this.k27_preTaxPrice = k27_calFreeTaxPrice(this.k27_amountToReceive, 10.0);
            return k27_preTaxPrice;
        }

        public void setK27_preTaxPrice(int k27_preTaxPrice) {
            this.k27_preTaxPrice = k27_preTaxPrice;
        }

        public int getK27_taxAmount() {
            return this.k27_amountToReceive - k27_calFreeTaxPrice(this.k27_totalPrice, 10);
        }

        public void setK27_taxAmount(int k27_taxAmount) {
            this.k27_taxAmount = k27_taxAmount;
        }

        public int getK27_taxFree() {
            return k27_taxFree;
        }

        public void setK27_taxFree(int k27_taxFree) {
            this.k27_taxFree = k27_taxFree;
        }

        public int getK27_receiptPrice() {
            return k27_amountToReceive - k27_taxFree;
        }

        public void setK27_receiptPrice(int k27_receiptPrice) {
            this.k27_receiptPrice = k27_receiptPrice;
        }

        // 세전 금액을 계산해주는 메서드
        // 기존 공식의 경우 나눗셈 뒤에 나눗셈이 존재해서 부동소수점 연산 때문에 정확하지 않은 값이 나온다.
        // 나눠지는 항에서 나눗셈이 존재하는 걸 피하기 위해 수식을 조작하여 순차적으로 처리하도록 만든다.
        public int k27_calFreeTaxPrice(int k27_totalPrice, double k27_taxRate) {
            return (int) (k27_totalPrice / (100.0 + k27_taxRate) * 100.0);
        }
    }

    public static class k27_Biz_05_Receipt_01_Card {
        // 영수증에서 Card 부분의 각 정보들의 필드
        // private 형으로 캡슐화
        private String k27_cardCompany1;
        private Date k27_approvalDate;
        private String k27_cardNumber;
        private String k27_approvalNumber;
        private String k27_installmentMonth;
        private int k27_approvalPrice;
        private String k27_memberNumber;
        private String k27_cardCompany2;
        private String k27_businessNumber;
        private Date k27_paymentDate;
        private String k27_cashierName;

        // 해당 클래스에 대한 생성자 정의
        // 직접적으로 정보들이 입력되는 부분들은 생성자로 정의한다.
        public k27_Biz_05_Receipt_01_Card(String cardCompany1, Date approvalDate, String cardNumber, String approvalNumber, String installmentMonth, int approvalPrice, String memberNumber, String cardCompany2, String businessNumber, Date paymentDate, String cashierName) {
            this.k27_cardCompany1 = cardCompany1;
            this.k27_approvalDate = approvalDate;
            this.k27_cardNumber = cardNumber;
            this.k27_approvalNumber = approvalNumber;
            this.k27_installmentMonth = installmentMonth;
            this.k27_approvalPrice = approvalPrice;
            this.k27_memberNumber = memberNumber;
            this.k27_cardCompany2 = cardCompany2;
            this.k27_businessNumber = businessNumber;
            this.k27_paymentDate = paymentDate;
            this.k27_cashierName = cashierName;
        }

        // 멤버 변수들에 대하여 getter/setter 설정
        public String getK27_cardCompany1() {
            return k27_cardCompany1;
        }

        public void setK27_cardCompany1(String k27_cardCompany1) {
            this.k27_cardCompany1 = k27_cardCompany1;
        }

        public Date getK27_approvalDate() {
            return k27_approvalDate;
        }

        public void setK27_approvalDate(Date k27_approvalDate) {
            this.k27_approvalDate = k27_approvalDate;
        }

        public String getK27_cardNumber() {
            return k27_cardNumber;
        }

        public void setK27_cardNumber(String k27_cardNumber) {
            this.k27_cardNumber = k27_cardNumber;
        }

        public String getK27_approvalNumber() {
            return k27_approvalNumber;
        }

        public void setK27_approvalNumber(String k27_approvalNumber) {
            this.k27_approvalNumber = k27_approvalNumber;
        }

        public String getK27_installmentMonth() {
            return k27_installmentMonth;
        }

        public void setK27_installmentMonth(String k27_installmentMonth) {
            this.k27_installmentMonth = k27_installmentMonth;
        }

        public int getK27_approvalPrice() {
            return k27_approvalPrice;
        }

        public void setK27_approvalPrice(int k27_approvalPrice) {
            this.k27_approvalPrice = k27_approvalPrice;
        }

        public String getK27_memberNumber() {
            return k27_memberNumber;
        }

        public void setK27_memberNumber(String k27_memberNumber) {
            this.k27_memberNumber = k27_memberNumber;
        }

        public String getK27_cardCompany2() {
            return k27_cardCompany2;
        }

        public void setK27_cardCompany2(String k27_cardCompany2) {
            this.k27_cardCompany2 = k27_cardCompany2;
        }

        public String getK27_businessNumber() {
            return k27_businessNumber;
        }

        public void setK27_businessNumber(String k27_businessNumber) {
            this.k27_businessNumber = k27_businessNumber;
        }

        public Date getK27_paymentDate() {
            return k27_paymentDate;
        }

        public void setK27_paymentDate(Date k27_paymentDate) {
            this.k27_paymentDate = k27_paymentDate;
        }

        public String getK27_cashierName() {
            return k27_cashierName;
        }

        public void setK27_cashierName(String k27_cashierName) {
            this.k27_cashierName = k27_cashierName;
        }
    }

    public static class k27_Biz_05_Receipt_01_Store {
        // 영수증에서 Store 부분의 각 정보들의 필드
        // private 형으로 캡슐화
        private String k27_storeName;
        private String k27_storeNumber;
        private String k27_ownerName;
        private String k27_telNumber;
        private String k27_storeAddress;

        // 해당 클래스에 대한 생성자 정의
        // 직접적으로 정보들이 입력되는 부분들은 생성자로 정의한다.
        public k27_Biz_05_Receipt_01_Store(String storeName, String storeNumber, String ownerName, String telNumber, String storeAddress) {
            this.k27_storeName = storeName;
            this.k27_storeNumber = storeNumber;
            this.k27_ownerName = ownerName;
            this.k27_telNumber = telNumber;
            this.k27_storeAddress = storeAddress;
        }

        // 멤버 변수들에 대하여 getter/setter 설정
        public String getK27_storeName() {
            return k27_storeName;
        }

        public void setK27_storeName(String k27_storeName) {
            this.k27_storeName = k27_storeName;
        }

        public String getK27_storeNumber() {
            return k27_storeNumber;
        }

        public void setK27_storeNumber(String k27_storeNumber) {
            this.k27_storeNumber = k27_storeNumber;
        }

        public String getK27_ownerName() {
            return k27_ownerName;
        }

        public void setK27_ownerName(String k27_ownerName) {
            this.k27_ownerName = k27_ownerName;
        }

        public String getK27_telNumber() {
            return k27_telNumber;
        }

        public void setK27_telNumber(String k27_telNumber) {
            this.k27_telNumber = k27_telNumber;
        }

        public String getK27_storeAddress() {
            return k27_storeAddress;
        }

        public void setK27_storeAddress(String k27_storeAddress) {
            this.k27_storeAddress = k27_storeAddress;
        }
    }
}
