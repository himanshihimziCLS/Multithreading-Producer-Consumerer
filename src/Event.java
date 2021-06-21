import java.util.Date;
import java.util.Objects;

public class Event {
    String id;
    int priority;
   static long createTime;
    static long consumeTime;

    public Event(int priority) {
        this.priority = priority;
        this.createTime = System.currentTimeMillis();
        //this.createTime = new Date().getTime();
    }
    public Event(){
        int max = 5;
        int min = 1;
        this.priority = (int) Math.floor(Math.random()*(max-min+1)+min);
        this.createTime = System.currentTimeMillis();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Event event = (Event) o;
        return priority == event.priority && createTime == event.createTime && id.equals(event.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, priority, createTime);
    }


    public boolean isStarved(){
        if(consumeTime - createTime > 200){
            return true;
        }
        return false;
    }
    public boolean aboutToStarve(){
        if(Event.consumeTime - Event.createTime == Constants.TIMEOUT){
            return true;
        }
        return false;
    }

}
