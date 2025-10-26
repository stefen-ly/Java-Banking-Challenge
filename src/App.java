import java.time.LocalDate;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class App {
    public static void main(String[] args) {
        SavingAccount mySavingAccount = new SavingAccount(
                "Stefen Ly",
                "SA001",
                5000.0,
                LocalDate.of(2023, 1, 1),
                7
        );
        mySavingAccount.checkBalance();

        System.out.println();
        mySavingAccount.deposit(2000);
        mySavingAccount.checkBalance();

        System.out.println();
        mySavingAccount.withdraw(500);
        mySavingAccount.checkBalance();

    }
}