import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class EventQueue {
    LinkedList<Event> list = new LinkedList<Event>();
    Map<Integer,LinkedList<Event>> pMap ;
    int priority;
    Event event;

    public EventQueue(int priority) {
        this.priority = priority;
    }

    public synchronized void push(Event event){
            list.add(event);
    }

    public synchronized Event pop(){
        if(list.isEmpty()){
            return null;
        }
        return list.removeFirst();


    }



}
