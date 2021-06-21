import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;

public class StarvationHandle implements Runnable {
    static Map<Integer, EventQueue> pMap ;

    public StarvationHandle(Map<Integer, EventQueue> pMap) {
        this.pMap = pMap;
    }

    @Override
    public void run() {
        getStarveEvents();

    }


   static Event getStarveEvents() {
        synchronized (pMap) {
            for (int priority : pMap.keySet()) {
                EventQueue ev = pMap.get(priority);

               for (Event event : ev.list) {
                    if (event.aboutToStarve()) {
                        return event;
                    }
                }

            }

        }
        return null;
    }



}


