import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class thr implements Runnable{
    static int num=10;
    static volatile boolean done1=false;
    static volatile boolean done2=false;
    static volatile boolean done3=false;
    static volatile boolean done4=false;
    static Lock lock=new ReentrantLock();
    @Override
    public void run() {
        runner();
    }
    public static void runner(){
        lock.lock();
         if(!done1){
            num+=num;
            done1=true;
             lock.unlock();
            return;
        }
         if (!done2){
             num*=num;
             done2=true;
             lock.unlock();
             return;
         }
         if (!done3){
             num/=2;
             done3=true;
             lock.unlock();
             return;
         }
         if (!done4){
             num-=1;
             done4=true;
             lock.unlock();
             return;
         }
        lock.unlock();
    }
    public static void main(String[] args) {
        thr t=new thr();
        List<Thread> threads=new ArrayList<>();
        for (int i = 1; i <= 4; i++) {
            Thread thread = new Thread(t);
            threads.add(thread);
        }
        for (var l : threads) {
            l.start();
        }
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            System.out.println(t.num+" done");
        }


    }
}

