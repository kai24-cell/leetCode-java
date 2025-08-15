package com.example.demo.backend;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.function.Predicate;
import org.springframework.boot.SpringApplication;

@SpringBootApplication
public class Backend {

    public static void main(String[] args) {

        SpringApplication.run(Backend.class, args);
    }
}

@RestController
class Cal_point {
    @PostMapping("/submit")
    @ResponseBody
    public Double deal(
            @RequestParam Double get_attend_count,
            @RequestParam Double get_report_point,
            @RequestParam Double get_report_count,
            @RequestParam List<Double> get_exam) {
        Double least, need_test_point = 0.0;
        Report_check report = new Report_check();
        least = report.need_point(get_report_count, get_report_point);// 単位取得に必要な点数からレポート点を引いた点数
        Least_test_point need = new Least_test_point();
        need_test_point = need.change_test_pount(least, get_exam);
        return need_test_point;
    }

}

class Least_test_point {
    public Double change_test_pount(Double least, List<Double> test_point) {
        Double per_point = 0.0, need_point = 0.0;
        per_point = this.per_test_point(test_point);
        need_point = this.need_test_point(per_point, least);
        return need_point;

    }

    private Double need_test_point(Double per_point, Double least) {
        Double need = 0.0, non_need = 0.0;
        boolean check = false;
        need = least - per_point;
        Err_check if_pass = new Err_check();
        check = if_pass.pass_check(need);
        if (check == true) {
            return non_need;
        } else if (check == false) {
            return need;
        } else {
            throw new IllegalArgumentException("エラー:テスト点の入力が上手く行きませんでした");
        }

    }

    private Double per_test_point(List<Double> test_point) {
        Double total = 0.0, average_point = 0.0, six_per_point = 0.0, six_per = 0.6;
        for (Double point : test_point) {
            total += point;
        }
        average_point = total / test_point.size();
        six_per_point = average_point * six_per;
        Err_check err_check = new Err_check();
        err_check.six_per_point_check(six_per_point);
        return six_per_point;

    }
}

class Report_check {// レポート点から残りの必要点数を出力するクラス
    private Double cal_report_point(Double report, Double report_count) {
        Double four_per = 0.4, report_point = 0.0;
        report_point = report * four_per / report_count;// 400点が4回の場合は40点になる。【重要】100点満点想定でレポート点考えてる。
        Err_check check = new Err_check();
        check.report_point_check(report_point);
        return report_point;
    }

    public Double need_point(Double report_count, Double report) {// パターンAレポート4割,期末テスト6割
        Double pass_point = 60.0, report_point = 0.0, need_least_point = 0.0;
        report_point = this.cal_report_point(report, report_count);
        need_least_point = pass_point - report_point;
        Err_check need_check = new Err_check();
        need_check.need_point_check(need_least_point);
        return need_least_point;
    }
}

class Err_check {// エラー確認のクラス
    public void report_point_check(Double report_point) {// 0点以上40点以下で考えてる
        Double low_check = 0.0, high_check = 40.0;
        Predicate<Double> x = check -> check >= low_check && check <= high_check;
        if (x.test(report_point) == false) {
            throw new IllegalArgumentException("エラー:レポート点の入力が上手くいってません。100点満点で記入してください");
        }
    }

    public void need_point_check(Double need_least_point) {// 20点以上60点以下で考える
        Double low_check = 20.0, high_check = 60.0;
        Predicate<Double> x = check -> check >= low_check && check <= high_check;

        if (x.test(need_least_point) == false) {
            throw new IllegalArgumentException("エラー:必要点数の計算が失敗しました");
        }
    }

    public void six_per_point_check(Double six_per_point) {// 0点以上60点以下で考える
        Double low_check = 0.0, high_check = 60.0;
        Predicate<Double> x = check -> check >= low_check && check <= high_check;
        if (x.test(six_per_point) == false) {
            throw new IllegalArgumentException("エラー:テスト点が負の数または100点満点で入力されていません");
        }
    }

    public boolean pass_check(Double need_point) {
        Double need = 0.0;
        Predicate<Double> x = check -> check <= need;
        return x.test(need_point);
    }
}