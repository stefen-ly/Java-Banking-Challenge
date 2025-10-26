import java.math.BigDecimal;
import java.time.LocalDate;

public class PayrollAccount extends Account {
    protected float tax = 0;

    Card card;

    public PayrollAccount(String accountName, String accountNumber, BigDecimal balance, LocalDate createDate, float tax) {
        super(accountName, accountNumber, balance, createDate);
        this.tax = tax;
    }

    @Override
    public void checkBalance() {
        super.checkBalance();
        System.out.println("Tax: " + tax);
    }
}
