package actions.views;

import java.time.LocalDate;
import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * 日報情報について画面の入力値・出力値を扱うViewモデル
 *
 */
@Getter //全てのクラスフィールドについてgetterを自動生成する(Lombok)
@Setter //全てのクラスフィールドについてsetterを自動生成する(Lombok)
@NoArgsConstructor //引数なしコンストラクタを自動生成する(Lombok)
@AllArgsConstructor //全てのクラスフィールドを引数にもつ引数ありコンストラクタを自動生成する(Lombok)
public class WeekReportView {

    /**
     * id
     */
    private Integer id;

    /**
     * 日報を登録した従業員
     */
    private EmployeeView employee;

    /**
     * いつの日報かを示す日付
     */
    private LocalDate weekreportDate;

    /**
     * 日報のタイトル
     */
    private String weektitle;

    /**
     * 日報の内容
     */
    private String weekcontent;

    /**
     * 日報の内容2
     */
    private String weekcontent2;

    /**
     * 日報の明日の目標
     */
    private String weektomorrowGoal;

    /**
     * 日報のOEの内容1
     */
    private String weekcontentOe1;

    /**
     * 日報のOEの内容2
     */
    private String weekcontentOe2;

    /**
     * OEのタグ1
     */
    private Integer weekoeFlag1;

    /**
     * OEのタグ2
     */
    private Integer weekoeFlag2;

    /**
     * 登録日時
     */
    private LocalDateTime weekcreatedAt;

    /**
     * 更新日時
     */
    private LocalDateTime weekupdatedAt;

    /**
     * OEのタグ2
     */
    private Integer weeknumber;


}