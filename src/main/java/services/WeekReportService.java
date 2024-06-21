package services;

import java.time.LocalDateTime;
import java.util.List;

import actions.views.EmployeeConverter;
import actions.views.EmployeeView;
import actions.views.WeekReportConverter;
import actions.views.WeekReportView;
import constants.JpaConst;
import models.WeekReport;
import models.validators.WeekReportValidator;

/**
 * 日報テーブルの操作に関わる処理を行うクラス
 */
public class WeekReportService extends ServiceBase {

    /**
     * 指定した従業員が作成した日報データを、指定されたページ数の一覧画面に表示する分取得しReportViewのリストで返却する
     * @param employee 従業員
     * @param page ページ数
     * @return 一覧画面に表示するデータのリスト
     */
    public List<WeekReportView> getMinePerPage(EmployeeView employee, int page) {

        List<WeekReport> weekreports = em.createNamedQuery(JpaConst.Q_WEEKREP_GET_ALL_MINE, WeekReport.class)
                .setParameter(JpaConst.JPQL_PARM_EMPLOYEE, EmployeeConverter.toModel(employee))
                .setFirstResult(JpaConst.ROW_PER_PAGE * (page - 1))
                .setMaxResults(JpaConst.ROW_PER_PAGE)
                .getResultList();
        return WeekReportConverter.toViewList(weekreports);
    }

    /**
     * 指定した従業員が作成した日報データの件数を取得し、返却する
     * @param employee
     * @return 日報データの件数
     */
    public long countAllMine(EmployeeView employee) {

        long count = (long) em.createNamedQuery(JpaConst.Q_REP_COUNT_ALL_MINE, Long.class)
                .setParameter(JpaConst.JPQL_PARM_EMPLOYEE, EmployeeConverter.toModel(employee))
                .getSingleResult();

        return count;
    }

    /**
     * 指定されたページ数の一覧画面に表示する日報データを取得し、ReportViewのリストで返却する
     * @param page ページ数
     * @return 一覧画面に表示するデータのリスト
     */
    public List<WeekReportView> getAllPerPage(int page) {

        List<WeekReport> weekreports = em.createNamedQuery(JpaConst.Q_WEEKREP_GET_ALL, WeekReport.class)
                .setFirstResult(JpaConst.ROW_PER_PAGE * (page - 1))
                .setMaxResults(JpaConst.ROW_PER_PAGE)
                .getResultList();
        return WeekReportConverter.toViewList(weekreports);
    }

    /**
     * 日報テーブルのデータの件数を取得し、返却する
     * @return データの件数
     */
    public long countAll() {
        long weekreports_count = (long) em.createNamedQuery(JpaConst.Q_WEEKREP_COUNT, Long.class)
                .getSingleResult();
        return weekreports_count;
    }

    /**
     * idを条件に取得したデータをReportViewのインスタンスで返却する
     * @param id
     * @return 取得データのインスタンス
     */
    public WeekReportView findOne(int id) {
        return WeekReportConverter.toView(findOneInternal(id));
    }

    /**
     * 画面から入力された日報の登録内容を元にデータを1件作成し、日報テーブルに登録する
     * @param rv 日報の登録内容
     * @return バリデーションで発生したエラーのリスト
     */
    public List<String> create(WeekReportView wv) {
        List<String> errors = WeekReportValidator.validate(wv);
        if (errors.size() == 0) {
            LocalDateTime ldt = LocalDateTime.now();
            wv.setWeekcreatedAt(ldt);
            wv.setWeekupdatedAt(ldt);
            createInternal(wv);
        }

        //バリデーションで発生したエラーを返却（エラーがなければ0件の空リスト）
        return errors;
    }

    /**
     * 画面から入力された日報の登録内容を元に、日報データを更新する
     * @param rv 日報の更新内容
     * @return バリデーションで発生したエラーのリスト
     */
    public List<String> update(WeekReportView wv) {

        //バリデーションを行う
        List<String> errors = WeekReportValidator.validate(wv);

        if (errors.size() == 0) {

            //更新日時を現在時刻に設定
            LocalDateTime ldt = LocalDateTime.now();
            wv.setWeekupdatedAt(ldt);

            updateInternal(wv);
        }

        //バリデーションで発生したエラーを返却（エラーがなければ0件の空リスト）
        return errors;
    }

    /**
     * idを条件にデータを1件取得する
     * @param id
     * @return 取得データのインスタンス
     */
    private WeekReport findOneInternal(int id) {
        return em.find(WeekReport.class, id);
    }

    /**
     * 日報データを1件登録する
     * @param rv 日報データ
     */
    private void createInternal(WeekReportView wv) {

        em.getTransaction().begin();
        em.persist(WeekReportConverter.toModel(wv));
        em.getTransaction().commit();

    }

    /**
     * 日報データを更新する
     * @param rv 日報データ
     */
    private void updateInternal(WeekReportView wv) {

        em.getTransaction().begin();
        WeekReport w = findOneInternal(wv.getId());
        WeekReportConverter.copyViewToModel(w, wv);
        em.getTransaction().commit();

    }

}