import java.util.HashMap;
import java.util.Map;

public class LRU {
    public static void main(String[] args) {
        Map<String, Integer> map = new HashMap<>();
        map.put("322", 4);
        map.put("2", 4);
        map.put("23er", 4);
        map.put("scc23f", 4);
        map.put("0l-", 4);
        map.put("29", 0);
        map.put("dff", 4);

        System.out.println(map.keySet().toString());
    }
}


