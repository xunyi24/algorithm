package leetcode;

import java.util.*;

public class TopKFrequent347 {
    public static void main(String[] args) {
        int[] nums = {1,1,1,2,2,3};
        TopKFrequent347 topKFrequent347 = new TopKFrequent347();
        System.out.println(Arrays.toString(topKFrequent347.topKFrequent(nums, 2)));
    }

    /**
     * 给定一个非空的整数数组，返回其中出现频率前k高的元素。
     **
     * 示例 1:
     *
     * 输入: nums = [1,1,1,2,2,3], k = 2
     * 输出: [1,2]
     * 示例 2:
     *
     * 输入: nums = [1], k = 1
     * 输出: [1]
     */
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> integerHashMap = new HashMap<>();
        for (int num : nums) {
            if (integerHashMap.containsKey(num)) {
                integerHashMap.put(num, integerHashMap.get(num) + 1);
            } else {
                integerHashMap.put(num, 1);

            }
        }

        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        List<Integer>[] lists = new List[nums.length + 1];
        for(Map.Entry<Integer, Integer> entry: integerHashMap.entrySet()) {
            int value = entry.getKey();
            int times = entry.getValue();
            if (lists[times] == null) {
                lists[times] = new ArrayList<>();
            }
            lists[times].add(value);
        }

        List<Integer> list = new ArrayList<>();
        for (int i = lists.length - 1; i >= 0; i--) {
            if (lists[i] != null) {
                list.addAll(lists[i]);
            }
            if (list.size() >= k) {
                break;
            }
        }

        int[] res = new int[list.size()];
        for (int i = 0; i < res.length; i++) {
            res[i] = list.get(i);
        }
        return res;
    }
}
