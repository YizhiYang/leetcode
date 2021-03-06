package Array.NestedListWeightSum;

import Tree.DFS.NestedInteger;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Similar to level order traversal
 *
 * Given a nested list of integers, return the sum of all integers in the list weighted by their depth.
 *
 * Each element is either an integer, or a list -- whose elements may also be integers or other lists.
 *
 * Example 1:
 *
 * Input: [[1,1],2,[1,1]]
 * Output: 10
 * Explanation: Four 1's at depth 2, one 2 at depth 1.
 * Example 2:
 *
 * Input: [1,[4,[6]]]
 * Output: 27
 * Explanation: One 1 at depth 1, one 4 at depth 2, and one 6 at depth 3; 1 + 4*2 + 6*3 = 27.
 *
 */


// 思路是用类似level order的queue去做，如果是integer的话就加 不然的话就把list里面的东西加到queue里面。
public class NestedListWeightSum {
    public int depthSum(List<NestedInteger> nestedList) {

        if (nestedList == null) {
            return 0;
        }
        int sum = 0;
        int level = 1;

        Queue<NestedInteger> queue = new LinkedList<>(nestedList);

        while (queue.size() > 0) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                NestedInteger ni = queue.poll();
                if (ni.isInteger()) {
                    sum += ni.getInteger() * level;
                } else {
                    queue.addAll(ni.getList());
                }
            }
            level++;
        }
        return sum;
    }

}
