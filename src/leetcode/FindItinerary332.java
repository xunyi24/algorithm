package leetcode;

import java.util.*;

public class FindItinerary332 {
    public static void main(String[] args) {
        List<String> ticket1 = new ArrayList<>();
        ticket1.add("JFK");
        ticket1.add("SFO");
        List<String> ticket2 = new ArrayList<>();
        ticket2.add("JFK");
        ticket2.add("ATL");
        List<String> ticket3 = new ArrayList<>();
        ticket3.add("SFO");
        ticket3.add("ATL");
        List<String> ticket4 = new ArrayList<>();
        ticket4.add("ATL");
        ticket4.add("JFK");
        List<String> ticket5 = new ArrayList<>();
        ticket5.add("ATL");
        ticket5.add("SFO");

        List<List<String>> tickets = new ArrayList<>();
        tickets.add(ticket1);
        tickets.add(ticket2);
        tickets.add(ticket3);
        tickets.add(ticket4);
        tickets.add(ticket5);

        FindItinerary332 findItinerary332 = new FindItinerary332();
        List<String> res = findItinerary332.findItinerary(tickets);
        System.out.println(res);
    }


    List<String> res = new ArrayList<>();
    int ticketsSize;
    public List<String> findItinerary(List<List<String>> tickets) {
        ticketsSize = tickets.size();
        res.add("JFK");
        Map<String, TreeMap<String, Integer>> ticketsMap = new HashMap<>();
        for (List<String> ticket : tickets) {
            String from = ticket.get(0);
            String to = ticket.get(1);
            if (ticketsMap.containsKey(from)) {
                TreeMap<String, Integer> treeMap = ticketsMap.get(from);
                if (treeMap.containsKey(to)) {
                    treeMap.put(to, treeMap.get(to) + 1);
                } else {
                    treeMap.put(to, 1);
                }
            } else {
                TreeMap<String, Integer> ticketTo = new TreeMap<>();
                ticketTo.put(to, 1);
                ticketsMap.put(from, ticketTo);
            }
        }
        backtracking(ticketsMap);

        // 欧拉解法
        for (List<String> ticket : tickets) {
            String from = ticket.get(0);
            String to = ticket.get(1);
            if (!ticketMap.containsKey(from)) {
                ticketMap.put(from, new PriorityQueue<>());
            }
            ticketMap.get(from).add(to);
        }
        dfs("JFK");
        Collections.reverse(res);
        return res;
    }

    /**
     * 欧拉解法
     */
    static Map<String, PriorityQueue<String>> ticketMap = new HashMap<>();
    private void dfs(String ticket) {
        while (ticketMap.containsKey(ticket) && ticketMap.get(ticket).size() > 0) {
            String to = ticketMap.get(ticket).poll();
            dfs(to);
        }
        res.add(ticket);
    }

    /**
     * 输入：[["JFK","SFO"],["JFK","ATL"],["SFO","ATL"],["ATL","JFK"],["ATL","SFO"]]
     * 输出：["JFK","ATL","JFK","SFO","ATL","SFO"]
     * 解释：另一种有效的行程是["JFK","SFO","ATL","JFK","ATL","SFO"]。但是它自然排序更大更靠后。
     * @param ticketsMap
     */
    private boolean backtracking(Map<String, TreeMap<String, Integer>> ticketsMap) {
        if (res.size() == ticketsSize + 1) return true;

        String toFrom = res.get(res.size() - 1);
        TreeMap<String, Integer> to = ticketsMap.get(toFrom);
        if (to != null) {
            for (Map.Entry<String, Integer> ticketTo : to.entrySet()) {
                if (ticketTo.getValue() > 0) {
                    res.add(ticketTo.getKey());
                    ticketTo.setValue(ticketTo.getValue() - 1);
                    if (backtracking(ticketsMap)) return true;
                    res.remove(res.size() - 1);
                    ticketTo.setValue(ticketTo.getValue() + 1);
                }
            }
        }
        return false;
    }

    // 这种方式只能求所有的行程, 不符合题目要求, 是自己的一个尝试
    static List<List<String>> t = new ArrayList<>();
    private void backtracking1(List<List<String>> tickets, boolean[] used) {
        if (res.size() == tickets.size() + 1) {
            t.add(new ArrayList<>(res));
            return;
        }

        for (int i = 0; i < tickets.size(); i++) {
            if (used[i]) continue;
            String toFrom = res.get(res.size() - 1);
            String from = tickets.get(i).get(0);
            String to = tickets.get(i).get(1);
            if (from.equals(toFrom)) {
                res.add(to);
            } else {
                continue;
            }
            used[i] = true;
            backtracking1(tickets, used);
            used[i] = false;
            res.remove(res.size() - 1);

        }
    }
}
