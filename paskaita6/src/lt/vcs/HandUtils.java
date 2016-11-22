package lt.vcs;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 *
 * @author Cukrus
 */
public class HandUtils {
    
    public static Combination findCombination(Map<Integer, Integer> mapas) {
        if (mapas.values().contains(5)) {
            return Combination.KIND5;
        } else if (mapas.values().contains(4)) {
            return Combination.KIND4;
        } else if (mapas.values().contains(3)) {
            if (mapas.values().contains(2)) {
                return Combination.FULL_HOUSE;
            }
            return Combination.KIND3;
        } else {
            Set<Integer> valSet = new HashSet<>(mapas.values());
            if (valSet.size() == 2 && (mapas.get(1) == 0 || mapas.get(6) == 0)) {
                return Combination.STRAIGHT;
            }
            int pairCount = 0;
            for (Integer val : mapas.values()) {
                if (val.equals(2)) {
                    pairCount++;
                }
            }
            if (pairCount == 2) {
                return Combination.PAIR2;
            }
            if (pairCount == 1) {
                return Combination.PAIR;
            }
            return Combination.NONE;
        }
    }
    
}
