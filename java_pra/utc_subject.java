import java.util.Scanner;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class utc_subject {
    public static void main(String[] args) {
        Weekday_checker weekday_changer = new Weekday_checker();
        weekday_changer.print_near_weekday();
    }
}

class Weekday_checker {
    public void print_near_weekday() {
        Scanner scan = new Scanner(System.in);
        System.out.println("日時を 'yyyy-MM-dd' 形式で入力してくださいjstで受け取ります（例: 2000-01-26）:");
        String get_data = scan.nextLine();
        ZonedDateTime changed_data = this.format_utc_changer(get_data);
        ZonedDateTime weekdate_near_changed = this.weekday_change(changed_data);
        DateTimeFormatter out_data = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        System.out.println("UTCに変換してさらに最も近い未来の平日は" + out_data.format(weekdate_near_changed));
        scan.close();
    }

    private ZonedDateTime format_utc_changer(String original_data) {
        DateTimeFormatter changing = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate format_changed = LocalDate.parse(original_data, changing);
        ZonedDateTime jst_time = format_changed.atStartOfDay(ZoneId.of("Asia/Tokyo"));
        ZonedDateTime utc_time = jst_time.withZoneSameInstant(ZoneId.of("UTC"));
        return utc_time;
    }

    private ZonedDateTime weekday_change(ZonedDateTime utc_formatted_date) {
        DayOfWeek week = utc_formatted_date.getDayOfWeek();
        if (week == DayOfWeek.SATURDAY) {
            utc_formatted_date = utc_formatted_date.plusDays(2);
        } else if (week == DayOfWeek.SUNDAY) {
            utc_formatted_date = utc_formatted_date.plusDays(1);
        }
        return utc_formatted_date;
    }
}
