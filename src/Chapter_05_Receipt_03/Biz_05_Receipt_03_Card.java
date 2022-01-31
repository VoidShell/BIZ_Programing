package Chapter_05_Receipt_03;

import java.util.Date;

public class Biz_05_Receipt_03_Card {
    private Date paymentDate;
    private String posNumber;
    private String cardCompany;
    private String cardNumber;
    private String paymentMethod;
    private String cardPaymentMethod;
    private String cardHolder;

    public Biz_05_Receipt_03_Card(Date paymentDate, String posNumber, String cardCompany, String cardNumber, String paymentMethod, String cardPaymentMethod, String cardHolder) {
        this.paymentDate = paymentDate;
        this.posNumber = posNumber;
        this.cardCompany = cardCompany;
        this.cardNumber = cardNumber;
        this.paymentMethod = paymentMethod;
        this.cardPaymentMethod = cardPaymentMethod;
        this.cardHolder = cardHolder;
    }

    public Date getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(Date paymentDate) {
        this.paymentDate = paymentDate;
    }

    public String getPosNumber() {
        return posNumber;
    }

    public void setPosNumber(String posNumber) {
        this.posNumber = posNumber;
    }

    public String getCardCompany() {
        return cardCompany;
    }

    public void setCardCompany(String cardCompany) {
        this.cardCompany = cardCompany;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public String getCardPaymentMethod() {
        return cardPaymentMethod;
    }

    public void setCardPaymentMethod(String cardPaymentMethod) {
        this.cardPaymentMethod = cardPaymentMethod;
    }

    public String getCardHolder() {
        return cardHolder;
    }

    public void setCardHolder(String cardHolder) {
        this.cardHolder = cardHolder;
    }
}
