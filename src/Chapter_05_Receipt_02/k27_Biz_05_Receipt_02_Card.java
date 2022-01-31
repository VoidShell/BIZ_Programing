package Chapter_05_Receipt_02;

import java.util.Date;

public class k27_Biz_05_Receipt_02_Card {
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
