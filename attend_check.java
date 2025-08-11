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
        output.print_date(get);
        Total_money money_sum = new Total_money();
        Map<String, Integer> sum = money_sum.sum_money(data);
    }
}

class Total_money {
    public Map<String, Integer> sum_money(List<String[]> money) {

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
