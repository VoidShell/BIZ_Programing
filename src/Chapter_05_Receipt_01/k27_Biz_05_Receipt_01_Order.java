package Chapter_05_Receipt_01;

public class k27_Biz_05_Receipt_01_Order {
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