package q3ex11;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

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


    Map<String, ArrayList<CompletableFuture<EventWrapper>>> subscriberList;
     
    public CompletableFuture<EventWrapper> subscribe(String event_name) {
        var promise = new CompletableFuture<EventWrapper>();

        if (subscriberList.containsKey(event_name)) {
            this.subscriberList.get(event_name).add(promise);
        } else {
            this.subscriberList.put(event_name, new ArrayList<>(Arrays.asList(promise)));
        }

        return promise;
    }

    public void alert(String event_name, EventWrapper event) throws ObjectNotFoundException {
        if (!subscriberList.containsKey(event_name)){
            throw new ObjectNotFoundException(String.format("No such event %s", event_name));
        }

        for (CompletableFuture<EventWrapper> i : subscriberList.get(event_name)) {
            i.complete(event);
        }
    }
}
