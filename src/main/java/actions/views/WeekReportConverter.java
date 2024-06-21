package actions.views;

import java.util.ArrayList;
import java.util.List;

import models.WeekReport;

/**
 * 日報データのDTOモデル⇔Viewモデルの変換を行うクラス
 *
 */
public class WeekReportConverter {

    /**
     * ViewモデルのインスタンスからDTOモデルのインスタンスを作成する
     * @param rv ReportViewのインスタンス
     * @return Reportのインスタンス
     */
    public static WeekReport toModel(WeekReportView wv) {
        return new WeekReport(
                wv.getId(),
                EmployeeConverter.toModel(wv.getEmployee()),
                wv.getWeekreportDate(),
                wv.getWeektitle(),
                wv.getWeekcontent(),
                wv.getWeekcontent2(),
                wv.getWeektomorrowGoal(),
                wv.getWeekcontentOe1(),
                wv.getWeekcontentOe2(),
                wv.getWeekoeFlag1(),
                wv.getWeekoeFlag2(),
                wv.getWeekcreatedAt(),
                wv.getWeekcreatedAt(),
                wv.getWeeknumber());
    }

    /**
     * DTOモデルのインスタンスからViewモデルのインスタンスを作成する
     * @param r Reportのインスタンス
     * @return ReportViewのインスタンス
     */
    public static WeekReportView toView(WeekReport w) {

        if (w == null) {
            return null;
        }

        return new WeekReportView(
                w.getId(),
                EmployeeConverter.toView(w.getEmployee()),
                w.getWeekreportDate(),
                w.getWeektitle(),
                w.getWeekcontent(),
                w.getWeekcontent2(),
                w.getWeektomorrowGoal(),
                w.getWeekcontentOe1(),
                w.getWeekcontentOe2(),
                w.getWeekoeFlag1(),
                w.getWeekoeFlag2(),
                w.getWeekcreatedAt(),
                w.getWeekcreatedAt(),
                w.getWeeknumber());

    }

    /**
     * DTOモデルのリストからViewモデルのリストを作成する
     * @param list DTOモデルのリスト
     * @return Viewモデルのリスト
     */
    public static List<WeekReportView> toViewList(List<WeekReport> list) {
        List<WeekReportView> evs = new ArrayList<>();

        for (WeekReport w : list) {
            evs.add(toView(w));
        }

        return evs;
    }

    /**
     * Viewモデルの全フィールドの内容をDTOモデルのフィールドにコピーする
     * @param r DTOモデル(コピー先)
     * @param rv Viewモデル(コピー元)
     */
    public static void copyViewToModel(WeekReport w, WeekReportView wv) {
        w.setId(wv.getId());
        w.setEmployee(EmployeeConverter.toModel(wv.getEmployee()));
        w.setWeekreportDate(wv.getWeekreportDate());
        w.setWeektitle(wv.getWeektitle());
        w.setWeekcontent(wv.getWeekcontent());
        w.setWeekcontent2(wv.getWeekcontent2());
        w.setWeektomorrowGoal(wv.getWeektomorrowGoal());
        w.setWeekcontentOe1(wv.getWeekcontentOe1());
        w.setWeekcontentOe2(wv.getWeekcontentOe2());
        w.setWeekoeFlag1(wv.getWeekoeFlag1());
        w.setWeekoeFlag2(wv.getWeekoeFlag2());
        w.setWeekcreatedAt(wv.getWeekcreatedAt());
        w.setWeekupdatedAt(wv.getWeekcreatedAt());


    }

}