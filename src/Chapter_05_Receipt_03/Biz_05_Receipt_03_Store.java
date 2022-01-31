package Chapter_05_Receipt_03;

public class Biz_05_Receipt_03_Store {
    private String storeLogo;
    private String storeName;
    private String telNumber;
    private String storeCode;
    private String ownerName;
    private String storeAddress;
    private String informMsg1;
    private String informMsg2;
    private String informMsg3;
    private String informMsg4;
    private String posNumber;


    public Biz_05_Receipt_03_Store(String storeLogo, String storeName, String telNumber, String storeCode, String ownerName, String storeAddress, String informMsg1, String informMsg2, String informMsg3, String informMsg4, String posNumber) {
        this.storeLogo = storeLogo;
        this.storeName = storeName;
        this.telNumber = telNumber;
        this.storeCode = storeCode;
        this.ownerName = ownerName;
        this.storeAddress = storeAddress;
        this.informMsg1 = informMsg1;
        this.informMsg2 = informMsg2;
        this.informMsg3 = informMsg3;
        this.informMsg4 = informMsg4;
        this.posNumber = posNumber;
    }

    public String getStoreLogo() {
        return storeLogo;
    }

    public void setStoreLogo(String storeLogo) {
        this.storeLogo = storeLogo;
    }

    public String getStoreName() {
        return storeName;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }

    public String getTelNumber() {
        return telNumber;
    }

    public void setTelNumber(String telNumber) {
        this.telNumber = telNumber;
    }

    public String getStoreCode() {
        return storeCode;
    }

    public void setStoreCode(String storeCode) {
        this.storeCode = storeCode;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public String getStoreAddress() {
        return storeAddress;
    }

    public void setStoreAddress(String storeAddress) {
        this.storeAddress = storeAddress;
    }

    public String getInformMsg1() {
        return informMsg1;
    }

    public void setInformMsg1(String informMsg1) {
        this.informMsg1 = informMsg1;
    }

    public String getInformMsg2() {
        return informMsg2;
    }

    public void setInformMsg2(String informMsg2) {
        this.informMsg2 = informMsg2;
    }

    public String getInformMsg3() {
        return informMsg3;
    }

    public void setInformMsg3(String informMsg3) {
        this.informMsg3 = informMsg3;
    }

    public String getInformMsg4() {
        return informMsg4;
    }

    public void setInformMsg4(String informMsg4) {
        this.informMsg4 = informMsg4;
    }

    public String getPosNumber() {
        return posNumber;
    }

    public void setPosNumber(String posNumber) {
        this.posNumber = posNumber;
    }
}


