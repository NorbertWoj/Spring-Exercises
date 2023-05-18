package app.utils;

import java.util.Comparator;
import java.util.Set;

public class Ids {

    public static int getNewId(Set<Integer> keysSoFar) {
        if(keysSoFar.isEmpty()) {
            return 0;
        }
        else {
//            Integer integer = knights.keySet().stream().max(Integer::max).get();
            Integer integer = keysSoFar.stream().max(Comparator.naturalOrder()).get();
            return ++integer;
        }
    }

    public static int generateNewId(Set<Integer> existingIds) {
        if(existingIds.isEmpty()) {
            return 0;
        }
        else {
            Integer integer = existingIds.stream().max((o1, o2) -> o1.compareTo(o2)).get();
            return integer+1;
        }
    }
}
