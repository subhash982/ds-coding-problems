package leetcode.medium;

import java.util.HashMap;
import java.util.Random;

/**
 * 380. Insert Delete GetRandom O(1)
 * Design a data structure that supports all following operations in average O(1) time.
 * insert(val): Inserts an item val to the set if not already present.
 * remove(val): Removes an item val from the set if present.
 * getRandom: Returns a random element from current set of elements. Each element must have the same probability of being returned.
 * Example:
 * // Init an empty set.
 * RandomizedSet randomSet = new RandomizedSet();
 * // Inserts 1 to the set. Returns true as 1 was inserted successfully.
 * randomSet.insert(1);
 * // Returns false as 2 does not exist in the set.
 * randomSet.remove(2);
 * // Inserts 2 to the set, returns true. Set now contains [1,2].
 * randomSet.insert(2);
 * // getRandom should return either 1 or 2 randomly.
 * randomSet.getRandom();
 * // Removes 1 from the set, returns true. Set now contains [2].
 * randomSet.remove(1);
 * // 2 was already in the set, so return false.
 * randomSet.insert(2);
 * // Since 2 is the only number in the set, getRandom always return 2.
 * randomSet.getRandom();
 */
public class InsertDeleteGetRandom {
    HashMap <Integer, Integer> valueMap;
    HashMap <Integer, Integer> idxMap;

    /**
     * Initialize your data structure here.
     */
    public InsertDeleteGetRandom() {
        valueMap = new HashMap <>();
        idxMap = new HashMap <>();
    }

    /**
     * Inserts a value to the set. Returns true if the set did not already contain the specified element.
     */
    public boolean insert(int val) {
        if (valueMap.containsKey(val)) {
            return false;
        }

        valueMap.put(val, valueMap.size());
        idxMap.put(idxMap.size(), val);

        return true;
    }

    /**
     * Removes a value from the set. Returns true if the set contained the specified element.
     */
    public boolean remove(int val) {
        if (valueMap.containsKey(val)) {
            int idx = valueMap.get(val);
            valueMap.remove(val);
            idxMap.remove(idx);

            Integer tailElem = idxMap.get(idxMap.size());
            if (tailElem != null) {
                idxMap.put(idx, tailElem);
                valueMap.put(tailElem, idx);
            }

            return true;
        }

        return false;
    }

    /**
     * Get a random element from the set.
     */
    public int getRandom() {
        if (valueMap.size() == 0) {
            return -1;
        }

        if (valueMap.size() == 1) {
            return idxMap.get(0);
        }

        Random r = new Random();
        int idx = r.nextInt(valueMap.size());

        return idxMap.get(idx);
    }
}
