import com.sun.org.apache.xpath.internal.SourceTree;

/**
 * Created by dell on 17-6-18.
 */
public class Bank implements Runnable {
    private int number = 0;
    public void setMoney(int m) {
        number = m;
    }
    @Override
    public void run() {
        while(true) {
            String name = Thread.currentThread().getName();
            if(name.equals("One")) {
                if(number <= 160) {
                    System.out.println(name + "进入死亡状态");
                    return;
                }
                number = number + 10;
                System.out.println("我是"+name+"现在 number =" + number);
            }
            if(Thread.currentThread().getName().equals("Two")) {
                if(number <= 0) {
                    System.out.println(name + "进入死亡状态");
                    return;
                }
                number = number - 100;
                System.out.println("我是"+name+"现在 number =" + number);
            }
            try {
                Thread.sleep(800);
            } catch(InterruptedException e){
            }
        }
    }
}
