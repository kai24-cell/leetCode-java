import java.util.function.BiPredicate;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.HashMap;
import java.util.Map;

public class ramuda_pra {
    public static void main(String[] args) {
        Map<String, Integer> a = new HashMap<>();
        a.put("あ", 3);
        a.put("い", 3);
        System.out.println(a.get("あ") + a.get("い"));
    }
}
