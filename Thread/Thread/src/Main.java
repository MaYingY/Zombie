/**
 * Created by dell on 17-6-18.
 */
public class Main {
    public static void main(String[] args) {
        Bank bank = new Bank();
        bank.setMoney(300);
        Thread threadone, threadtwo;
        threadone = new Thread(bank);
        threadone.setName("One");
        threadtwo = new Thread(bank);
        threadtwo.setName("Two");
        threadone.start();
        threadtwo.start();
    }
}
