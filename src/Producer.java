import java.util.Random;
import java.util.UUID;

public class Producer implements Runnable {
    Integer priority;
    Integer capacity;



    public Producer(Integer priority, Integer capacity) {
        this.priority = null != priority ? priority : -1;
        this.capacity = null != capacity ? capacity : -1;
    }

    @Override
    public  void run() {
        if(this.capacity < 0){
            while (true){

               Manager.push(createEvent());
            }
        } else{
            for(int i = 1; i < capacity; i++){
                Manager.push(createEvent());
            }

        }
    }

    public  synchronized Event createEvent() {

        Event e = this.priority != -1 ? new Event(this.priority): new Event();
        //e.priority
        e.id = UUID.randomUUID().toString();
        System.out.println(Thread.currentThread().getName() +" produced, "+"Create time: " +e.createTime);
        //System.out.println("created");
        //System.out.println("Producer "+ " created event with id and priority " +e.id + " "+e.priority  );

        return e;
    }

}
