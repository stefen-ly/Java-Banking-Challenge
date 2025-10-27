import java.math.BigDecimal;
import java.time.LocalDate;

public class PayrollAccount extends Account {
    private float tax = 0;

    Card card;

    public PayrollAccount(String accountName, String accountNumber, BigDecimal balance, LocalDate createDate, float tax,  Card card) {
        super(accountName, accountNumber, balance, createDate);
        this.tax = tax;
        this.card = card;
    }

    @Override
    public void checkBalance() {
        super.checkBalance();
        System.out.println("Tax: " + tax);
    }
}
