package Chapter_05_Receipt_01;

public class k27_Biz_05_Receipt_01_Store {
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
