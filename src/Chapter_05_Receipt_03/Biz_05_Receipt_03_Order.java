package Chapter_05_Receipt_03;

public class Biz_05_Receipt_03_Order {
    private boolean taxFree;
    private String itemName;
    private int itemUnitPrice;
    private int itemAmount;
    private int itemPrice;
    private int taxFreeItemTotalPrice;
    private int taxItemTotalPrice;
    private int preTaxItemTotalPrice;
    private int itemTotalVat;
    private int itemTotalPrice;

    public Biz_05_Receipt_03_Order(boolean taxFree, String itemName, int itemUnitPrice, int itemAmount) {
        this.taxFree = taxFree;
        this.itemName = itemName;
        this.itemUnitPrice = itemUnitPrice;
        this.itemAmount = itemAmount;
    }

    public Biz_05_Receipt_03_Order() {
    }

    public boolean isTaxFree() {
        return taxFree;
    }

    public void setTaxFree(boolean taxFree) {
        this.taxFree = taxFree;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public int getItemUnitPrice() {
        return itemUnitPrice;
    }

    public void setItemUnitPrice(int itemUnitPrice) {
        this.itemUnitPrice = itemUnitPrice;
    }

    public int getItemAmount() {
        return itemAmount;
    }

    public void setItemAmount(int itemAmount) {
        this.itemAmount = itemAmount;
    }

    public int getItemPrice() {
        return this.itemUnitPrice * this.itemAmount;
    }

    public void setItemPrice(int itemPrice) {
        this.itemPrice = itemPrice;
    }

    public int getTaxFreeItemTotalPrice() {
        return taxFreeItemTotalPrice;
    }

    public void setTaxFreeItemTotalPrice(int taxFreeItemTotalPrice) {
        this.taxFreeItemTotalPrice = taxFreeItemTotalPrice;
    }

    public int getTaxItemTotalPrice() {
        return taxItemTotalPrice;
    }

    public void setTaxItemTotalPrice(int taxItemTotalPrice) {
        this.taxItemTotalPrice = taxItemTotalPrice;
    }

    public int getPreTaxItemTotalPrice() {
        this.preTaxItemTotalPrice = calPreTaxPrice(this.taxItemTotalPrice, 10.0);
        return preTaxItemTotalPrice;
    }

    public void setPreTaxItemTotalPrice(int preTaxItemTotalPrice) {
        this.preTaxItemTotalPrice = preTaxItemTotalPrice;
    }

    public int getItemTotalVat() {
        this.itemTotalVat = this.taxItemTotalPrice - preTaxItemTotalPrice;
        return itemTotalVat;
    }

    public void setItemTotalVat(int itemTotalVat) {
        this.itemTotalVat = itemTotalVat;
    }

    public int getItemTotalPrice() {
        return itemTotalPrice;
    }

    public void setItemTotalPrice(int itemTotalPrice) {
        this.itemTotalPrice = itemTotalPrice;
    }

    public int calPreTaxPrice (int totalPrice, double taxRate) {
        return (int) (totalPrice / (100 + taxRate) * 100);
    }
}
