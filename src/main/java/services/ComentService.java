package services;

import java.time.LocalDateTime;
import java.util.List;

import actions.views.ComentConverter;
import actions.views.ComentView;
import actions.views.EmployeeConverter;
import actions.views.EmployeeView;
import constants.JpaConst;
import models.Coment;
import models.validators.ComentValidator;

/**
 * メモテーブルの操作に関わる処理を行うクラス
 */
public class ComentService extends ServiceBase {

    /**
     * 指定した従業員が作成したメモデータを、指定されたページ数の一覧画面に表示する分取得しComentViewのリストで返却する
     * @param employee 従業員
     * @param page ページ数
     * @return 一覧画面に表示するデータのリスト
     */
    public List<ComentView> getMinePerPage(EmployeeView employee, int page) {

        List<Coment> coments = em.createNamedQuery(JpaConst.Q_COMENT_GET_ALL_MINE, Coment.class)
                .setParameter(JpaConst.JPQL_PARM_EMPLOYEE, EmployeeConverter.toModel(employee))
                .setFirstResult(JpaConst.ROW_PER_PAGE * (page - 1))
                .setMaxResults(JpaConst.ROW_PER_PAGE)
                .getResultList();





        return ComentConverter.toViewList(coments);
    }

    /**
     * 指定した従業員が作成したメモデータの件数を取得し、返却する
     * @param employee
     * @return メモデータの件数
     */
    public long countAllMine(EmployeeView employee) {

        long count = (long) em.createNamedQuery(JpaConst.Q_COMENT_COUNT_ALL_MINE, Long.class)
                .setParameter(JpaConst.JPQL_PARM_EMPLOYEE, EmployeeConverter.toModel(employee))
                .getSingleResult();

        return count;
    }

    /**
     * 指定されたページ数の一覧画面に表示するメモデータを取得し、ComentViewのリストで返却する
     * @param page ページ数
     * @return 一覧画面に表示するデータのリスト
     */
    public List<ComentView> getAllPerPage(int page) {

        List<Coment> coments = em.createNamedQuery(JpaConst.Q_COMENT_GET_ALL, Coment.class)
                .setFirstResult(JpaConst.ROW_PER_PAGE * (page - 1))
                .setMaxResults(JpaConst.ROW_PER_PAGE)
                .getResultList();
        return ComentConverter.toViewList(coments);
    }

    /**
     * メモテーブルのデータの件数を取得し、返却する
     * @return データの件数
     */
    public long countAll() {
        long coments_count = (long) em.createNamedQuery(JpaConst.Q_COMENT_COUNT, Long.class)
                .getSingleResult();
        return coments_count;
    }

    /**
     * idを条件に取得したデータをComentViewのインスタンスで返却する
     * @param id
     * @return 取得データのインスタンス
     */
    public ComentView findOne(int id) {
        return ComentConverter.toView(findOneInternal(id));
    }

    /**
     * 画面から入力された日報の登録内容を元にデータを1件作成し、メモテーブルに登録する
     * @param mv メモの登録内容
     * @return バリデーションで発生したエラーのリスト
     */
    public List<String> create(ComentView mv) {
        List<String> errors = ComentValidator.validate(mv);
        if (errors.size() == 0) {
            LocalDateTime ldt = LocalDateTime.now();
            mv.setCreatedAt(ldt);
            mv.setUpdatedAt(ldt);
            createInternal(mv);
        }

        //バリデーションで発生したエラーを返却（エラーがなければ0件の空リスト）
        return errors;
    }

    /**
     * 画面から入力されたメモの登録内容を元に、メモデータを更新する
     * @param rv メモの更新内容
     * @return バリデーションで発生したエラーのリスト
     */
    public List<String> update(ComentView cv) {

        //バリデーションを行う
        List<String> errors = ComentValidator.validate(cv);

        if (errors.size() == 0) {

            //更新日時を現在時刻に設定
            LocalDateTime ldt = LocalDateTime.now();
            cv.setUpdatedAt(ldt);

            updateInternal(cv);
        }

        //バリデーションで発生したエラーを返却（エラーがなければ0件の空リスト）
        return errors;
    }

    /**
     * idを条件にデータを1件取得する
     * @param id
     * @return 取得データのインスタンス
     */
    private Coment findOneInternal(int id) {
        return em.find(Coment.class, id);
    }

    /**
     * メモデータを1件登録する
     * @param mv メモデータ
     */
    private void createInternal(ComentView cv) {

        em.getTransaction().begin();
        em.persist(ComentConverter.toModel(cv));
        em.getTransaction().commit();

    }

    /**
     * メモデータを更新する
     * @param mv メモデータ
     */
    private void updateInternal(ComentView cv) {

        em.getTransaction().begin();
        Coment m = findOneInternal(cv.getId());
        ComentConverter.copyViewToModel(m, cv);
        em.getTransaction().commit();

    }

}