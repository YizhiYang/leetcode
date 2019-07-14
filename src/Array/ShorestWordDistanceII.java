package Array;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 *
 * Design a class which receives a list of words in the constructor,
 * and implements a method that takes two words word1 and word2 and return the shortest distance between these two words in the list.
 * Your method will be called repeatedly many times with different parameters.
 *
 * Example:
 * Assume that words = ["practice", "makes", "perfect", "coding", "makes"].
 *
 * Input: word1 = “coding”, word2 = “practice”
 * Output: 3
 * Input: word1 = "makes", word2 = "coding"
 * Output: 1
 *
 */

public class ShorestWordDistanceII {

    HashMap<String, List<Integer>> map = new HashMap<>();

    public ShorestWordDistanceII(String[] words) {

        for (int i = 0; i < words.length; i++) {
            List<Integer> count = map.get(words[i]);
            if (count == null) {
                count = new ArrayList<>();
            }
            count.add(i);
            map.put(words[i], count);
        }
    }

    public int shorestWordDistance(String word1, String word2) {
        List<Integer> idx1 = map.get(word1);
        List<Integer> idx2 = map.get(word2);
        int distance = Integer.MAX_VALUE;
        int i = 0;
        int j = 0;
        while (i < idx1.size() && j < idx2.size()) {
            distance = Math.min(distance, Math.abs(idx1.get(i) - idx2.get(j)));
            if(idx1.get(i) > idx2.get(j)){
                j++;
            }
            else{
                i++;
            }
        }
        return distance;
    }
}
