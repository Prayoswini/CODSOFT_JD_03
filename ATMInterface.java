import java.util.*;
class BankAccount{
    private double balance;

    public BankAccount(double initialBalance){
        balance=initialBalance;
    }
    public double getBalance(){
        return balance;
    }
    public void deposit(double amount){
        if(amount > 0){
            balance +=amount;
            System.out.println("Deposit of " + amount + " successful.");
        }else{
            System.out.println("Deposit failed. Amount must be greater than zero.");
        }
    }
    public void withdraw(double amount){
        if(amount >0 && amount <=balance){
            balance -=amount;
            System.out.println("Withdrawal of " + amount + " successful.");
        }
        else{
            System.out.println("Withdrawal failed. Either insufficient balance or invalid amount.");
        }
    }
}
class ATM{
    private BankAccount account;
    private Scanner scanner;

    public ATM(BankAccount account){
        this.account = account;
        this.scanner = new Scanner(System.in);
    }
    public void showMenu(){
        System.out.println("\n================= WELCOME TO ATM ==================");
        System.out.println("**************        ATM MENU      *************");
        System.out.println("1. Check Balance");
        System.out.println("2. Deposit Cash");
        System.out.println("3. Withdraw Cash");
        System.out.println("4. EXIT");
        System.out.println("==================================================");
        System.out.println("Choose an option (1-4)");
    }

    public void start(){
        int choice;
        do{
            showMenu();
            System.out.println("Enter your choice:");
            choice=scanner.nextInt();
            switch(choice){
                case 1:
                      checkBalance();
                      break;
                case 2:   
                      deposit();
                      break;
                case 3:
                     withdraw();
                     break;
                case 4:
                    System.out.println("Thank you for using the ATM. Session ended.");
                    break;
                default:
                    System.out.println("Invalid Choice. PLease enter a valid option");  
            }
        }while(choice!=4);
    }

    private void checkBalance(){
        System.out.println("Current Balance:"+account.getBalance());  
    }
    private void deposit(){
        System.out.println("Enter amount to deposit: ");
        double amount = scanner.nextDouble();
        account.deposit(amount);
    }
    private void withdraw(){
        System.out.println("Enter amount to withdraw: ");
        double amount= scanner.nextDouble();
        account.withdraw(amount);
    }

public class ATMInterface {
    public static void main(String[] args) {
        BankAccount userAccount = new BankAccount(1000);
        ATM atm= new ATM(userAccount);
        atm.start();
        
    }
    
}
}