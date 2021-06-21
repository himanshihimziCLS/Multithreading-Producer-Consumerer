import java.time.Duration;
import java.util.Date;

public class Consumer implements Runnable {

    Integer priority;
   public static int count = 0;

    public Consumer(Integer priority) {
        this.priority = priority;
        //this.priority = null != priority ? priority : n;
    }


    @Override
    public synchronized void run() {
        while (true) {
            Event e = Manager.pop(priority);
            if (e == null) continue;

            e.consumeTime = System.currentTimeMillis();

            //e.consumeTime = new Date().getTime();
            if (e.consumeTime - e.createTime > Constants.TIMEOUT) {
                System.out.println("Event " + e.id + " Is starved");
                count++;

            }

            System.out.println(Thread.currentThread().getName() + " consumed ," + "consume time: " + e.consumeTime);
          //  System.out.println("Total starved : " +count);

            //
        }


    }

}
