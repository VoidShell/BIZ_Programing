package Chapter_05_Receipt_01;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class k27_Biz_05_Receipt_01 {
    public static void main(String[] args) {
        // k27_iPrice 가격 21000 초기화
        int k27_iPrice = 210000000;
        // 날짜 표현을 위한 Calendar 객체 생성
        Calendar k27_calendar = Calendar.getInstance();
        // 날짜를 원하는 포맷으로 설정하기 위한 SimpleDateFromat 패턴 객체 생성
        SimpleDateFormat k27_sdfMin = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        SimpleDateFormat k27_sdfMinSec = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        // 금액에 컴마표기를 위한 DecimalForamt 패턴 객체 생성.
        DecimalFormat k27_dfWon = new DecimalFormat("###,###,###,###,###");

        // Store, Order, Class 생성자를 통해 영수증 데이터를 입력하고 해당 인스턴스를 생성한다.
        k27_Biz_05_Receipt_01_Store k27_store = new k27_Biz_05_Receipt_01_Store
                ("종로상회(분당서현점)", "129-17-77924", "이상철", "031 781 1596", "성남시 분당구 서현동 269-3");
        k27_Biz_05_Receipt_01_Order k27_order = new k27_Biz_05_Receipt_01_Order
                ("12", "20160425 01 00041", k27_iPrice, 0, 0, k27_iPrice, 0);
        k27_Biz_05_Receipt_01_Card k27_card = new k27_Biz_05_Receipt_01_Card("우리카드", k27_calendar.getTime(), "55222059****2021", "730461774", "00", k27_iPrice, "730461774", "비씨카드사", "129-17-77924", k27_calendar.getTime(), " ");
        // 각 인스턴스 부분이 담당하는 부분에서 getter로 해당 인스턴스의 필드 정보들을 불러온다.
        System.out.printf("                영  수  증                \n");
        System.out.printf("-----------------------------------------\n");
        System.out.printf("%s  %s\n", k27_store.getK27_storeName(), k27_store.getK27_storeNumber());
        System.out.printf("%s  %s\n", k27_store.getK27_ownerName(), k27_store.getK27_telNumber());
        System.out.printf("%s\n", k27_store.getK27_storeAddress());
        System.out.printf("테이블명 : %s\n", k27_order.getK27_tableName());
        System.out.printf("주문번호 : %s\n", k27_order.getK27_orderNumber());
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

    static class k27_Biz_05_Receipt_01_Card {
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
}


