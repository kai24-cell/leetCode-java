
//夏休みに作るコードのプロトタイプを作っとく
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import java.util.List;

// public class summer_pro {

//     public static void main(String[] args) {
//         Cal_point cal = new Cal_point();
//         Cal_point.deal();
//     }
// }

@Controller
class Cal_point {
    @PostMapping("/submit")
    @ResponseBody
    public Integer deal(
            @RequestParam Double get_attend_count,
            @RequestParam Double get_report_point,
            @RequestParam Double get_report_count,
            @RequestParam List<Double> get_exam) {

    }

    private Double cal_report_point(Double report, Double report_count) {
        Double four_per = 0.4, report_point;
        boolean result;
        report_point = report * four_per / report_count;
        Err_check check = new Err_check();
        result = check.report_point_check(report_point);
        if (result == true) {
            return report_point;
        } else {
            throw new IllegalArgumentException("エラー:レポート点の入力が上手くいってません。");
        }
    }

    private Double need_point(Double report_count, Double report, List<Double> exam, Double attend) {// パターンA出席8割レポート4割,期末テスト6割で,まだテスト受けてない
        Double pass_point = 60.0, four_per = 0.4, report_point, need_least_point, low_check = 0.0, high_check = 40.0;
        report_point = this.cal_report_point(report, report_count);
        need_least_point = pass_point - report_point;

        return need_least_point;
    }

}

class Err_check {
    public boolean report_point_check(Double report_point) {
        Double low_check = 0.0, high_check = 40.0;
        if (report_point < low_check || report_point > high_check) {
            return false;
        } else {
            return true;
        }
    }
}