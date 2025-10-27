
import java.math.BigDecimal;
import java.time.LocalDate;

public class Account {
    private String accountName = "";
    private String accountNumber = "";
    private BigDecimal balance;
    LocalDate createDate;

    public Account(){
        balance = BigDecimal.valueOf(10000);
    }


    public Account(String accountName, String accountNumber, BigDecimal balance, LocalDate createDate) {
        this.accountName = accountName;
        this.accountNumber = accountNumber;
        this.balance = balance;
        this.createDate = createDate;
    }

    public String getAccountName() {
        return accountName;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public LocalDate getCreateDate() {
        return createDate;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public void setCreateDate(LocalDate createDate) {
        this.createDate = createDate;
    }

    // Deposit money
    public void deposit(BigDecimal amount) {
        if (amount.compareTo(BigDecimal.ZERO) < 0) {
            System.out.println("Invalid deposit amount!");
            return;
        }
        balance = balance.add(amount);
    }

    // Withdraw money
    public void withdraw(BigDecimal amount) {
        if (amount.compareTo(BigDecimal.ZERO) < 0) {
            System.out.println("Invalid withdraw amount!");
            return;
        }
        if (balance.compareTo(amount) < 0) {
            System.out.println("Insufficient balance!");
            return ;
        }
            balance = balance.subtract(amount);
    }

    public void checkBalance() {
        System.out.println("Account Name: " + accountName);
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Balance: " + balance);
        System.out.println("Create Date: " + createDate);
    }

}
