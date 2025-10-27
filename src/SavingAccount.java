import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class SavingAccount extends Account {
    private float interestRate;
    Card card;

    public SavingAccount() {
        super();
    }

    public SavingAccount(String accountName, String accountNumber, BigDecimal balance, LocalDate createDate, float interestRate, Card card) {
        super(accountName, accountNumber, balance, createDate);
        this.interestRate = interestRate;
        this.card = card;
    }

    public Card getCard() {
        return card;
    }

    public float getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(float interestRate) {
        this.interestRate = interestRate;
    }

    public void setCard(Card card) {
        this.card = card;
    }

    public BigDecimal calculateInterest() {
        long days = ChronoUnit.DAYS.between(createDate, LocalDate.now());
        if (days > 365) {
            BigDecimal interestDivideBy100 = BigDecimal.valueOf(interestRate / 100);
            return getBalance().multiply(interestDivideBy100).setScale(2, RoundingMode.FLOOR);
        } else {
            return BigDecimal.ZERO;
        }
    }

    @Override
    public void checkBalance() {
        super.checkBalance();
        BigDecimal interest = calculateInterest();
        System.out.println("Interest rate: " + interestRate);
        System.out.println("Interest: " + interest);
    }

    @Override
    public void deposit(BigDecimal amount) {
        if (card == null) {
            if (LocalDate.now().isAfter(card.expirationDate)) {
                System.out.println("Card is expired");
                return;
            }

            if (!card.getPin().equals("1234")) {
                System.out.println("Incorrect pin");
                return;
            }
        }
        super.deposit(amount);
        System.out.println("Deposit is successfully");
    }
    @Override
    public void withdraw(BigDecimal amount) {
        if (card != null) {
            if (LocalDate.now().isAfter(card.expirationDate)) {
                System.out.println("Card is expired");
                return;
            }
            if (!card.getPin().equals("1234")) {
                System.out.println("Incorrect pin");
                return;
            }
            if (amount.compareTo(card.getOverLimit()) > 0) {
                System.out.println("Amount is over limit " + card.getOverLimit() + "$");
                return;
            }
            super.withdraw(amount);
            System.out.println("Withdraw is successfully");
        } else {
            System.out.println("Card is not initialized.");
        }
    }
}