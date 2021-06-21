import java.io.*;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.Properties;


public class Manager {

    static Map<Integer, EventQueue> mp = new ConcurrentHashMap<>();


    static synchronized void push(Event event) {
        if (mp.containsKey(event.priority)) {
            mp.get(event.priority).push(event);
            //System.out.println("Pushed");
        } else {
            EventQueue e = new EventQueue(event.priority);
            e.push(event);
            mp.put(event.priority, e);
        }

       /*
        1. check the priority of event
        2. check if mp has a key of that priority
        3. if yes retrieve the value for priority and call push
        4. if not create a new instance of eventqueue with the event priority
        5. push the event to the eventqueue
        6. put the priority and the event queue in the map
        */


    }
    static synchronized  Event pop(Integer priority) {
        if(priority == null){
            int p = Collections.min(mp.keySet());
        return mp.get(p).pop();
    } else {
        if (mp.containsKey(priority)) {
            return mp.get(priority).pop();
        } else {
            return null;
        }
    }
    }

   /* static Event pop(Integer priority) {
        StarvationHandle s = new StarvationHandle(mp);
        Event e1 = StarvationHandle.getStarveEvents();
        {
            if (e1 == null) {
                if (priority == null) {
                    int p = Collections.min(mp.keySet());
                    return mp.get(p).pop();
                } else {
                    if (mp.containsKey(priority)) {
                        return mp.get(priority).pop();
                    } else {
                        return null;
                    }
                }


        1. if priority is null pick the eventQueue from mp with highest priority
        2. else pick the eventqueue with specified priority
        3. call pop from the eventqueue


            } else {
                return e1;
            }
        }
    }*/

    static void addEventQueue(LinkedList<Event> event) {
        //eventQueues.add(ev);
    }


    public static void main(String[] args) throws IOException {
        //System.out.println(System.currentTimeMillis());
        Properties p = new Properties();
        InputStream in = Manager.class.getResourceAsStream("config.properties");
        p.load(in);
       // System.out.println(p.getProperty("Producer"));
        int pro = Integer.parseInt(p.getProperty("Producer"));
        System.out.println("Producers are :" +pro);

        int con = Integer.parseInt(p.getProperty("Consumer"));
        System.out.println("Consumers are: "+con);
        int max = 5;
        int min =1;

        for(int i = 0; i < pro; i++){
            new Thread(new Producer((int) Math.floor(Math.random()*(max-min+1)+min),6), "Producer" +i).start();
        }
        for(int i = 0; i < con; i++){
            new Thread(new Consumer((int) Math.floor(Math.random()*(max-min+1)+min)) ,"Consumer" +i).start();
        }



    }
}




