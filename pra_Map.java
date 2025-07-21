import java.util.HashMap;
import java.util.TreeMap;
import java.util.Map;

public class pra_Map {
    public static void main(String arg[]) {
        Map<String, Integer> map = new HashMap<>();
        map.put("apple", 3);
        map = new TreeMap<>(map);// 型変更
    }

}
