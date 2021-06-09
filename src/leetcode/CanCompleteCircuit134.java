package leetcode;

public class CanCompleteCircuit134 {
    public static void main(String[] args) {
        CanCompleteCircuit134 ccc = new CanCompleteCircuit134();
        int[] gas = {3, 3, 4};
        int[] cost = {3, 4, 4};
        System.out.println(ccc.canCompleteCircuit(gas, cost));
    }
    /**
     * gas  = [1,2,3,4,5]
     * cost = [3,4,5,1,2]
     * 输出 3
     *
     * gas  = [2,3,4]
     * cost = [3,4,3]
     *
     * 输出: -1
     */
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int start = 0, length = gas.length;
        while (start < length) {
            if (gas[start] >= cost[start]) break;
            start++;
        }

        int index = (start + length) % length, sum = 0, preStart = start;
        boolean first = true;
        while (index != start || first) {
            first = false;
            sum += gas[index];
            if (sum - cost[index] < 0) {
                for (int i = start + 1; i < length; i++) {
                    if (gas[i] >= cost[i]) {
                        start = i;
                        break;
                    }
                }
                if (start == preStart) {
                    return -1;
                } else {
                    preStart = start;
                    index = (start + length) % length;
                    first = true;
                    sum = 0;
                    continue;
                }
            } else {
                sum -= cost[index];
            }
            index = (++index + length) % length;
        }

        return index;
    }
}
