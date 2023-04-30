package az.company.hotelreservation.model;

import java.util.Date;

public class CreditCard extends Entity{
    private String cardNumber;
    private int expMonth;
    private int expYear;
    private CreditCardType creditCardType;

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public int getExpMonth() {
        return expMonth;
    }

    public void setExpMonth(int expMonth) {
        this.expMonth = expMonth;
    }

    public int getExpYear() {
        return expYear;
    }

    public void setExpYear(int expYear) {
        this.expYear = expYear;
    }

    public CreditCardType getCreditCardType() {
        return creditCardType;
    }

    public void setCreditCardType(CreditCardType creditCardType) {
        this.creditCardType = creditCardType;
    }

    @Override
    public String toString() {
        return "CreditCard{" +
                "creditCardNumber='" + cardNumber + '\'' +
                ", expMonth=" + expMonth +
                ", expYear=" + expYear +
                ", creditCardType=" + creditCardType +
                '}';
    }
}
