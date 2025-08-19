import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Map;

public class attend_check {
    public static void main(String[] args) {
        List<String[]> data = List.of(
                new String[] { "Alice", "2025-08-01 09:00", "1200" },
                new String[] { "Bob", "2025-08-02 09:15", "500" },
                new String[] { "Alice", "2025-08-03 08:50", "800" },
                new String[] { "Bob", "2025-07-31 09:10", "2000" },
                new String[] { "Charlie", "2025-08-02 10:00", "1500" });
        Date_last output = new Date_last();
        Map<String, LocalDateTime> get = output.return_lastdate(data);
        // output.print_date(get);
        Total_money money_sum = new Total_money();
        Map<String, Integer> sum = money_sum.sum_money(data);
        money_sum.print_sort(sum, get);
    }
}

class Total_money {
    int name = 0, figure = 2, sum_figure = 1;

    public Map<String, Integer> sum_money(List<String[]> money) {
        Map<String, Integer> total = new HashMap<>();
        for (String[] box : money) {
            Integer num = Integer.parseInt(box[figure]);
            if (total.containsKey(box[name])) {
                total.put(box[name], num + total.get(box[name]));// 初めての名前じゃないとき数字を足す
            } else if (!total.containsKey(box[name])) {
                total.put(box[name], num);// 初めての名前の時追加
            }
        }

        return total;
    }

    public void print_sort(Map<String, Integer> box, Map<String, LocalDateTime> shop_day) {
        List<Map.Entry<String, Integer>> list = new ArrayList<>(box.entrySet());
        list.sort((e1, e2) -> e2.getValue().compareTo(e1.getValue()));
        int i = 1;
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        for (Map.Entry<String, Integer> x : list) {
            for (Map.Entry<String, LocalDateTime> y : shop_day.entrySet()) {
                if (x.getKey().equals(y.getKey())) {
                    System.out.println(
                            i + "位: " + x.getKey() + " (合計" + x.getValue() + "円,最終購入" + y.getValue().format(fmt) + ")");
                    i++;
                }
            }
        }
    }
}

class Date_last {
    int name = 0, date = 1;

    public Map<String, LocalDateTime> return_lastdate(List<String[]> x) {
        Map<String, LocalDateTime> latest = new HashMap<>();
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");

        for (String[] num : x) {
            LocalDateTime time = LocalDateTime.parse(num[1], fmt);
            if (!latest.containsKey(num[name]) || time.isAfter(latest.get(num[name]))) {
                latest.put(num[name], time);
            }
        }
        return latest;
    }

    public void print_date(Map<String, LocalDateTime> y) {
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        for (Map.Entry<String, LocalDateTime> entry : y.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue().format(fmt));
        }
    }
}
