import java.util.function.Predicate;

public class ramuda_pra {
    public static void main(String[] args) {
        // int x = (a,b) -> a+b;
        // BiFunction<Integer, Integer, Integer> x = (a, b) -> a + b;
        // System.out.println(x.apply(1, 2));
        Predicate<String> ant = s -> s.isEmpty();
        System.out.println(ant.test("")); // true

    }
}
