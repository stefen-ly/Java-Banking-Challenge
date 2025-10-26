import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class SavingAccount extends Account {
    protected float interestRate;

    public SavingAccount(String accountName, String accountNumber, double balance, LocalDate createDate, float interestRate) {
        super(accountName, accountNumber, BigDecimal.valueOf(balance), createDate);
        this.interestRate = interestRate;
    }


    Card card;

    public BigDecimal calculateInterest() {
        long days = ChronoUnit.DAYS.between(createDate, LocalDate.now());
        if (days > 365) {
            BigDecimal interestDivideBy100 = BigDecimal.valueOf(interestRate/100);
            return balance.multiply(interestDivideBy100).setScale(2, RoundingMode.FLOOR);
        } else {
            return BigDecimal.ZERO;
        }
    }

    @Override
    public void checkBalance() {
        super.checkBalance();
        BigDecimal interest = calculateInterest();
        System.out.println("Interest rate: " + interestRate);
        System.out.println("Current balance: " + interest);
    }

    @Override
    public BigDecimal deposit(double amount) {
        return super.deposit(amount);
    }

    @Override
    public BigDecimal withdraw(double amount) {
        return super.withdraw(amount);
    }
}