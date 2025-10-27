import java.math.BigDecimal;
import java.time.LocalDate;

public class Card {
    private String pin = " ";
    private BigDecimal overLimit;
    private String cardType = "";
    LocalDate expirationDate;

    public Card(){
    }

    public Card(String pin, BigDecimal overLimit, String cardType, LocalDate expirationDate) {
        this.pin = pin;
        this.overLimit =  overLimit;
        this.cardType = cardType;
        this.expirationDate = expirationDate;
    }

    public String getPin() {
        return pin;
    }
    public void setPin(String pin) {
        this.pin = pin;
    }
    public BigDecimal getOverLimit() {
        return overLimit;
    }
    public void setOverLimit(BigDecimal overLimit) {
        this.overLimit = overLimit;
    }
    public String getCardType(String masterCard) {
        return cardType;
    }
    public void setCardType(String cardType) {
        this.cardType = cardType;
    }
    public LocalDate getExpirationDate(LocalDate localDate) {
        return expirationDate;
    }
    public void setExpirationDate(LocalDate expirationDate) {
        this.expirationDate = expirationDate;
    }


}
