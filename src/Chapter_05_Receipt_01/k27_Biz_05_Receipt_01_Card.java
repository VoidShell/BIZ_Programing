package Chapter_05_Receipt_01;

import java.util.Date;
public class k27_Biz_05_Receipt_01_Card {
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
