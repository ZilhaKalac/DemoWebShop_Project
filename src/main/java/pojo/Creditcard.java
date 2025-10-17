package pojo;

public class Creditcard {

    private String cardholderName;
    private String cardNumber;
    private String cardCode;

    public Creditcard(){

    }

    public Creditcard(String cardholderName, String cardNumber, String cardCode) {
        this.cardholderName = cardholderName;
        this.cardNumber = cardNumber;
        this.cardCode = cardCode;
    }

    public String getCardholderName() {
        return cardholderName;
    }

    public void setCardholderName(String cardholderName) {
        this.cardholderName = cardholderName;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getCardCode() {
        return cardCode;
    }

    public void setCardCode(String cardCode) {
        this.cardCode = cardCode;
    }

    @Override
    public String toString() {
        return "creditcard{" +
                "cardholderName='" + cardholderName + '\'' +
                ", cardNumber='" + cardNumber + '\'' +
                ", cardCode='" + cardCode + '\'' +
                '}';
    }
}




