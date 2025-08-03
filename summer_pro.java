
//夏休みに作るコードのプロトタイプを作っとく
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import java.util.List;

public class summer_pro {

    public static void main(String[] args) {
        Cal_point cal = new Cal_point();
        Cal_point.deal();
    }
}

@Controller
class Cal_point {
    @PostMapping("/submit")
    @ResponseBody
    public Integer deal(
            @RequestParam Double attend_count,
            @RequestParam Double report_point,
            @RequestParam Double report_count,
            @RequestParam List<Double> exam) {

    }

    private Integer need_pointper_four(Double report, List exam, Double attend) {// パターンA出席8割レポート4割,期末テスト6割で,まだテスト受けてない
        Double pass_point = 60.0, four_per = 0.4, report_point;
        report_point = report * four_per;
        if (report_point < 0 || report_point > 40) {
            continue;
        }

        return;
    }

}

class Test_base {// オーバーライド用親クラス
    private Integer need_pointper_four(Double report, List exam, Double attend) {// パターンA出席8割レポート4割,期末テスト6割で,まだテスト受けてない
        Double pass_point = 60.0, four_per = 0.4, report_point;
        report_point = report * four_per;
        if (report_point < 0 || report_point > 40) {
            continue;
        }

        return;
    }

}
