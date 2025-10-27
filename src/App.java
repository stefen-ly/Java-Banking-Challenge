import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.Month;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

//        Card card = new Card(
//                "1234",
//                BigDecimal.valueOf(3000.00),
//                "Mastercard",
//                LocalDate.of(2026, 3, 2)
//        );

        Card card = new Card();
        card.setCardType("Master card");
        card.setPin("1234");
        card.setExpirationDate(LocalDate.of(2023, Month.JANUARY, 1));
        card.setOverLimit(BigDecimal.valueOf(3000));

        SavingAccount mySavingAccount = new SavingAccount(
                "Stefen Ly",
                "SA001",
                BigDecimal.valueOf(5000.00),
                LocalDate.of(2023, 1, 1),
                7,
                card
        );


        int choice;

        do {
            System.out.println("Welcome");
            System.out.println("-------------[Menu]---------------");
            System.out.println("1. Check Balance");
            System.out.println("2. Withdraw");
            System.out.println("3. Deposit");
            System.out.println("0. Exit");
            System.out.println("----------------------------------");
            System.out.print("Enter your choice: ");
            choice = input.nextInt();
            System.out.println("----------------------------------");

            input.nextLine();

            switch (choice) {
                case 1 -> {
                    mySavingAccount.checkBalance();
                }
                case 2 -> {
                    System.out.print("Enter amount to withdraw: ");
                    BigDecimal amount = new BigDecimal(input.nextLine());
                    mySavingAccount.withdraw(amount);
                }
                case 3 -> {
                    System.out.print("Enter amount to deposit: ");
                    BigDecimal amount = new BigDecimal(input.nextLine());
                    mySavingAccount.deposit(amount);
                }
                case 0 -> {
                    System.out.println("Thank you for using our account");
                }
                default -> {
                    System.out.println("Invalid choice");
                }
            }
        } while (choice != 0);
    }
}