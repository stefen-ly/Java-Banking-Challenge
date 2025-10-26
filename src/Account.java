
import java.math.BigDecimal;
import java.time.LocalDate;

public class Account {
    protected String accountName = "";
    protected String accountNumber = "";
    protected BigDecimal balance;
    LocalDate createDate;

    public Account(String accountName, String accountNumber, BigDecimal balance, LocalDate createDate) {
        this.accountName = accountName;
        this.accountNumber = accountNumber;
        this.balance = balance;
        this.createDate = createDate;
    }

    // Deposit money
    public BigDecimal deposit(double amount) {
        if (amount < 0) {
            System.out.println("Invalid deposit amount!");
        } else {
            balance = balance.add(BigDecimal.valueOf(amount));
        }
        return balance;
    }

    // Withdraw money
    public BigDecimal withdraw(double amount) {
        if (amount < 0) {
            System.out.println("Invalid withdraw amount!");
            return balance;
        } else if (balance.compareTo(BigDecimal.valueOf(amount)) < 0) {
            System.out.println("Insufficient balance!");
            return balance;
        } else {
            balance = balance.subtract(BigDecimal.valueOf(amount));
            return balance;
        }
    }

    public void checkBalance() {
        System.out.println("Account Name: " + accountName);
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Balance: " + balance);
        System.out.println("Create Date: " + createDate);
    }

}
