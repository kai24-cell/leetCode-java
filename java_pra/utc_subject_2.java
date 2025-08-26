import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;
import java.text.Format;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class utc_subject_2 {
    public static void main(String[] args) {
        Return_utctime call = new Return_utctime();
        call.mesod();
    }
}

class Return_utctime {
    List<String> data = new ArrayList<>();

    public void mesod() {
        Scanner scan = new Scanner(System.in);
        while (scan.hasNext()) {
            data.add(scan.next());
        }
    }

    private List<String> utc_change(List<String> data) {
        DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        return data;
    }
}