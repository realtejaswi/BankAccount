import java.util.ArrayList;
import java.util.Scanner;

interface CentralBank {
    long getBalance();

    void withdraw(long amount);

    void deposit(long amount);

    void showAccount();

    boolean search(String acc_no);
}

class unb implements CentralBank {

    String name;
    String accno;
    String acc_type;
    long balance;

    unb(String name, String accno, String acc_type, long balance) {
        this.name = name;
        this.accno = accno;
        this.acc_type = acc_type;
        this.balance = balance;
    }

    public long getBalance() {
        return balance;
    }

    public void withdraw(long amount) {
        if (balance >= amount) {
            balance = balance - amount;
            System.out.println("Balance after withdrawal: " + balance);
        } else {
            System.out.println("Your balance is less than " + amount + "\tTransaction failed...!!");
        }
    }

    public void deposit(long amount) {
        balance = balance + amount;
    }

    public void showAccount() {
        System.out.println("UNB Bank account");
        System.out.println("Name of account holder: " + name);
        System.out.println("Account no.: " + accno);
        System.out.println("Account type: " + acc_type);
        System.out.println("Balance: " + balance);
    }

    public boolean search(String ac_no) {
        if (accno.equals(ac_no)) {
            showAccount();
            return true;
        }
        return false;
    }
}

class nbd implements CentralBank {

    String name;
    String accno;
    String acc_type;
    long balance;

    nbd(String name, String accno, String acc_type, long balance) {
        this.name = name;
        this.accno = accno;
        this.acc_type = acc_type;
        this.balance = balance;
    }

    public long getBalance() {
        return balance;
    }

    public void withdraw(long amount) {
        if (balance >= amount) {
            balance = balance - amount;
            System.out.println("Balance after withdrawal: " + balance);
        } else {
            System.out.println("Your balance is less than " + amount + "\tTransaction failed...!!");
        }
    }

    public void deposit(long amount) {
        balance = balance + amount;
    }

    public void showAccount() {
        System.out.println("NBD Bank account");
        System.out.println("Name of account holder: " + name);
        System.out.println("Account no.: " + accno);
        System.out.println("Account type: " + acc_type);
        System.out.println("Balance: " + balance);
    }

    public boolean search(String ac_no) {
        if (accno.equals(ac_no)) {
            showAccount();
            return true;
        }
        return false;
    }
}

class fgb implements CentralBank {

    String name;
    String accno;
    String acc_type;
    long balance;

    fgb(String name, String accno, String acc_type, long balance) {
        this.name = name;
        this.accno = accno;
        this.acc_type = acc_type;
        this.balance = balance;
    }

    public long getBalance() {
        return balance;
    }

    public void withdraw(long amount) {
        if (balance >= amount) {
            balance = balance - amount;
            System.out.println("Balance after withdrawal: " + balance);
        } else {
            System.out.println("Your balance is less than " + amount + "\tTransaction failed...!!");
        }
    }

    public void deposit(long amount) {
        balance = balance + amount;
    }

    public void showAccount() {
        System.out.println("FGB Bank account");
        System.out.println("Name of account holder: " + name);
        System.out.println("Account no.: " + accno);
        System.out.println("Account type: " + acc_type);
        System.out.println("Balance: " + balance);
    }

    public boolean search(String ac_no) {
        if (accno.equals(ac_no)) {
            showAccount();
            return true;
        }
        return false;
    }
}

public class  Bank{

    public static CentralBank createAccount(ArrayList<CentralBank> C) {
        int choice;
        String name, accNo, acc_type;
        long balance;
        boolean found;

        CentralBank cus1;

        System.out.println("Enter your Bank");
        System.out.println("1.UNB 2.NBD 3.FGB");
        Scanner sc = new Scanner(System.in);
        choice = sc.nextInt();

        System.out.print("Enter Name: ");
        name = sc.next();
        System.out.print("Enter Account No: ");
        accNo = sc.next();
        System.out.print("Enter Account type: ");
        acc_type = sc.next();
        System.out.print("Enter Password: ");
        balance = sc.nextLong();

        found = false;
        for (CentralBank bank : C) {
            found = bank.search(accNo);
            if (found) {
                System.out.println("Account with entered accNo already exists.");
                break;
            }
        }
        if (!found) {
            switch (choice) {
                case 1:
                    if (balance < 1000) {
                        System.out.println("Minimum balance is 1000. Please make sure your minimum balance is 1000");
                    } else {
                        cus1 = new unb(name, accNo, acc_type, balance);
                        System.out.println("Account created");
                        return cus1;
                    }
                    break;
                case 2:
                    if (balance < 2000) {
                        System.out.println("Minimum balance is 2000. Please make sure your minimum balance is 2000");
                    } else {
                        cus1 = new nbd(name, accNo, acc_type, balance);
                        System.out.println("Account created in NBD");
                        return cus1;
                    }
                    break;

                case 3:
                    if (balance < 3000) {
                        System.out.println("Minimum balance is 3000. Please make sure your minimum balance is 3000");
                    } else {
                        cus1 = new fgb(name, accNo, acc_type, balance);
                        System.out.println("Account created");
                        return cus1;
                    }
                    break;

                default:
                    System.out.println("Wrong Choice");
                    break;

            }
        }
        return null;
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        ArrayList<CentralBank> C = new ArrayList<>();
        System.out.println("No accounts found. Please Create one");
        CentralBank cus1 = createAccount(C);
        if (cus1 != null) {
            C.add(cus1);
        }

        int ch;
        do {
            System.out.println("\n #Banking System Application#");
            System.out.println(" 1.Create an account \n2. Display all account details \n 3. Search by Account number\n 4. Deposit the amount \n 5. Withdraw the amount \n 6. Remove account\n 7.Exit ");
            System.out.println("Enter your choice: ");
            ch = sc.nextInt();

            switch (ch) {
                case 1:
                    CentralBank cus = createAccount(C);
                    if (cus != null) {
                        C.add(cus);
                    }
                    break;
                case 2:
                    if (C.isEmpty()) {
                        System.out.println("No accounts found");
                    }
                    for (CentralBank bank : C) {
                        bank.showAccount();
                    }
                    break;
                case 3:
                    System.out.print("Enter account no. you want to search: ");
                    String ac_no = sc.next();
                    boolean found = false;
                    for (CentralBank bank : C) {
                        found = bank.search(ac_no);
                        if (found) {
                            break;
                        }
                    }
                    if (!found) {
                        System.out.println("Search failed! Account doesn't exist..!!");
                    }
                    break;
                case 4:
                    System.out.print("Enter Account no. : ");
                    ac_no = sc.next();
                    found = false;
                    for (CentralBank bank : C) {
                        found = bank.search(ac_no);
                        if (found) {
                            System.out.println("Enter the amount to deposit");
                            long amount = sc.nextLong();
                            bank.deposit(amount);
                            break;
                        }
                    }
                    if (!found) {
                        System.out.println("Search failed! Account doesn't exist..!!");
                    }
                    break;
                case 5:
                    System.out.print("Enter Account No : ");
                    ac_no = sc.next();
                    found = false;
                    for (CentralBank bank : C) {
                        found = bank.search(ac_no);
                        if (found) {
                            System.out.println("Enter the amount to withdraw");
                            long amount = sc.nextLong();
                            bank.withdraw(amount);
                            break;
                        }
                    }
                    if (!found) {
                        System.out.println("Search failed! Account doesn't exist.!");
                    }
                    break;
                case 6:
                    System.out.println("Enter your acc no: ");
                    String temp = sc.next();
                    found = false;
                    for (CentralBank bank : C) {
                        found = bank.search(temp);
                        if (found) {
                            C.remove(bank);
                            System.out.println("Account deleted successfully");
                            break;
                        }
                    }
                    if (!found) {
                        System.out.println("Search failed! Account doesn't exist.!");
                    }
                    break;
                case 7:
                    break;
                default:
                    System.out.println("Enter the correct Choice");
                    break;
            }
        } while (ch != 7);
    }
}
