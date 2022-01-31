package Chapter_05_Receipt_02;

public class k27_Biz_05_Receipt_02_Order {
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