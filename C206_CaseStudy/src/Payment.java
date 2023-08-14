public class Payment {
    private String name;
    private String cardNumber;
    private String cvv;

    public Payment(String name, String cardNumber, String cvv) {
        this.name = name;
        this.cardNumber = cardNumber;
        this.cvv = cvv;
    }

    public String getName() {
        return name;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public String getCvv() {
        return cvv;
    }
}