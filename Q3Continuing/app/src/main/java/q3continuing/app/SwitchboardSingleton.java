package q3continuing.app;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;


public class SwitchboardSingleton {
    private static SwitchboardSingleton single_instance = null;
    private SwitchboardSingleton() {}
    public static SwitchboardSingleton get_instance() {
        if (single_instance == null) {
            single_instance = new SwitchboardSingleton();
            return single_instance;
        }
        return single_instance;
    }


    Map<String, ArrayList<EventReceiverInterface>> subscriberList = new HashMap<String, ArrayList<EventReceiverInterface>>();
     
    public void subscribe(String event_name, EventReceiverInterface receiver) {
        if (subscriberList.containsKey(event_name)) {
            this.subscriberList.get(event_name).add(receiver);
        } else {
            this.subscriberList.put(event_name, new ArrayList<>(Arrays.asList(receiver)));
        }
    }

    public void alert(String event_name, EventWrapper event) throws ObjectNotFoundException {
        if (!subscriberList.containsKey(event_name)){
            throw new ObjectNotFoundException(String.format("No such event %s", event_name));
        }

        for (EventReceiverInterface i : subscriberList.get(event_name)) {
            i.receiveEvent(event_name, event);
        }
    }
}
