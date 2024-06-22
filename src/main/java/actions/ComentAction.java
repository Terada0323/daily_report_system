package actions;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

import javax.servlet.ServletException;

import actions.views.ComentView;
import actions.views.EmployeeView;
import actions.views.ReportView;
import constants.AttributeConst;
import constants.ForwardConst;
import constants.JpaConst;
import constants.MessageConst;
import services.ComentService;
import services.ReportService;

/**
 * 日報に関する処理を行うActionクラス
 *
 */
public class ComentAction extends ActionBase {

    private ComentService service;
    private ReportService service2;

    /**
     * メソッドを実行する
     */
    @Override
    public void process() throws ServletException, IOException {

        service = new ComentService();
        service2 = new ReportService();

        //メソッドを実行
        invoke();
        service.close();
        service2.close();
    }

    /**
     * 一覧画面を表示する
     * @throws ServletException
     * @throws IOException
     */
    public void index() throws ServletException, IOException {

     // 以下追記

        //セッションからログイン中の従業員情報を取得
        EmployeeView loginEmployee = (EmployeeView) getSessionScope(AttributeConst.LOGIN_EMP);

        //ログイン中の従業員が作成した日報データを、指定されたページ数の一覧画面に表示する分取得する
        int page = getPage();
        List<ComentView> coments = service.getMinePerPage(loginEmployee, page);

        //ログイン中の従業員が作成した日報データの件数を取得
        long myComentsCount = service.countAllMine(loginEmployee);

        putRequestScope(AttributeConst.COMENTS, coments); //取得した日報データ
        putRequestScope(AttributeConst.COMENT_COUNT, myComentsCount); //ログイン中の従業員が作成した日報の数
        putRequestScope(AttributeConst.PAGE, page); //ページ数
        putRequestScope(AttributeConst.MAX_ROW, JpaConst.ROW_PER_PAGE); //1ページに表示するレコードの数

        //↑ここまで追記

        //セッションにフラッシュメッセージが設定されている場合はリクエストスコープに移し替え、セッションからは削除する
        String flush = getSessionScope(AttributeConst.FLUSH);
        if (flush != null) {
            putRequestScope(AttributeConst.FLUSH, flush);
            removeSessionScope(AttributeConst.FLUSH);
        }

        //一覧画面を表示
        forward(ForwardConst.FW_COMENT_INDEX);
    }


    /**
     * 新規登録画面を表示する
     * @throws ServletException
     * @throws IOException
     */
    public void entryNew() throws ServletException, IOException {

        putRequestScope(AttributeConst.TOKEN, getTokenId()); //CSRF対策用トークン

        //メモ情報の空インスタンスに、メモの日付＝今日の日付を設定する
        ComentView cv = new ComentView();
        cv.setComentDate(LocalDate.now());
        putRequestScope(AttributeConst.COMENT, cv); //日付のみ設定済みのメモインスタンス



     // 以下追記

        //セッションからログイン中の従業員情報を取得
        EmployeeView loginEmployee = (EmployeeView) getSessionScope(AttributeConst.LOGIN_EMP);

        //ログイン中の従業員が作成した日報データを、指定されたページ数の一覧画面に表示する分取得する
        int page = getPage();

        List<ReportView> reports = service2.getMinePerPage(loginEmployee, page);

        //ログイン中の従業員が作成した日報データの件数を取得
        long myReportsCount = service2.countAllMine(loginEmployee);

        reports.subList(1, Math.toIntExact(myReportsCount)).clear();

        putRequestScope(AttributeConst.REPORTS, reports); //取得した日報データ
        putRequestScope(AttributeConst.REP_COUNT, myReportsCount); //ログイン中の従業員が作成した日報の数
        putRequestScope(AttributeConst.PAGE, page); //ページ数
        putRequestScope(AttributeConst.MAX_ROW, JpaConst.ROW_PER_PAGE); //1ページに表示するレコードの数

        //↑ここまで追記



        //新規登録画面を表示
        forward(ForwardConst.FW_COMENT_NEW);

    }

    /**
     * 新規登録を行う
     * @throws ServletException
     * @throws IOException
     */
    public void create() throws ServletException, IOException {

        //CSRF対策 tokenのチェック
        if (checkToken()) {

            //メモの日付が入力されていなければ、今日の日付を設定
            LocalDate day = null;
            if (getRequestParam(AttributeConst.COMENT_DATE) == null
                    || getRequestParam(AttributeConst.COMENT_DATE).equals("")) {
                day = LocalDate.now();
            } else {
                day = LocalDate.parse(getRequestParam(AttributeConst.COMENT_DATE));
            }

            //セッションからログイン中の従業員情報を取得
            EmployeeView ev = (EmployeeView) getSessionScope(AttributeConst.LOGIN_EMP);

            //パラメータの値をもとにメモ情報のインスタンスを作成する
            ComentView cv = new ComentView(
                    null,
                    ev, //ログインしている従業員を、日報作成者として登録する
                    day,
                    getRequestParam(AttributeConst.COMENT_TITLE),
                    getRequestParam(AttributeConst.COMENT_CONTENT),
                    null,
                    null);

            //メモ情報登録
            List<String> errors = service.create(cv);

            if (errors.size() > 0) {
                //登録中にエラーがあった場合

                putRequestScope(AttributeConst.TOKEN, getTokenId()); //CSRF対策用トークン
                putRequestScope(AttributeConst.COMENT, cv);//入力された日報情報
                putRequestScope(AttributeConst.ERR, errors);//エラーのリスト

                //新規登録画面を再表示
                forward(ForwardConst.FW_COMENT_NEW);

            } else {
                //登録中にエラーがなかった場合

                //セッションに登録完了のフラッシュメッセージを設定
                putSessionScope(AttributeConst.FLUSH, MessageConst.I_REGISTERED.getMessage());

                //一覧画面にリダイレクト
                redirect(ForwardConst.ACT_COMENT, ForwardConst.CMD_INDEX);
            }
        }
    }

    /**
     * 詳細画面を表示する
     * @throws ServletException
     * @throws IOException
     */
    public void show() throws ServletException, IOException {

        //idを条件に日報データを取得する
        ComentView cv = service.findOne(toNumber(getRequestParam(AttributeConst.COMENT_ID)));

        if (cv == null) {
            //該当のメモデータが存在しない場合はエラー画面を表示
            System.out.println("a");
            forward(ForwardConst.FW_ERR_UNKNOWN);

        } else {

            ///ここからエラーです
            putRequestScope(AttributeConst.COMENT, cv); //取得した日報データ

            //詳細画面を表示
            forward(ForwardConst.FW_COMENT_SHOW);
        }
    }

    /**
     * 編集画面を表示する
     * @throws ServletException
     * @throws IOException
     */
    public void edit() throws ServletException, IOException {

        //idを条件に日報データを取得する
        ComentView cv = service.findOne(toNumber(getRequestParam(AttributeConst.COMENT_ID)));

        //セッションからログイン中の従業員情報を取得
        EmployeeView ev = (EmployeeView) getSessionScope(AttributeConst.LOGIN_EMP);

        if (cv == null || ev.getId() != cv.getEmployee().getId()) {
            //該当の日報データが存在しない、または
            //ログインしている従業員が日報の作成者でない場合はエラー画面を表示
            forward(ForwardConst.FW_ERR_UNKNOWN);

        } else {

            putRequestScope(AttributeConst.TOKEN, getTokenId()); //CSRF対策用トークン
            putRequestScope(AttributeConst.COMENT, cv); //取得したメモデータ


            //ログイン中の従業員が作成した日報データを、指定されたページ数の一覧画面に表示する分取得する
            int page = getPage();

            List<ReportView> reports = service2.getMinePerPage(ev, page);

            //ログイン中の従業員が作成した日報データの件数を取得
            long myReportsCount = service2.countAllMine(ev);

            reports.subList(1, Math.toIntExact(myReportsCount)).clear();

            putRequestScope(AttributeConst.REPORTS, reports); //取得した日報データ
            putRequestScope(AttributeConst.REP_COUNT, myReportsCount); //ログイン中の従業員が作成した日報の数
            putRequestScope(AttributeConst.PAGE, page); //ページ数
            putRequestScope(AttributeConst.MAX_ROW, JpaConst.ROW_PER_PAGE); //1ページに表示するレコードの数

            //↑ここまで追記




            //編集画面を表示
            forward(ForwardConst.FW_COMENT_EDIT);
        }

    }

    /**
     * 更新を行う
     * @throws ServletException
     * @throws IOException
     */
    public void update() throws ServletException, IOException {

        //CSRF対策 tokenのチェック
        if (checkToken()) {

            //idを条件に日報データを取得する
            ComentView cv = service.findOne(toNumber(getRequestParam(AttributeConst.COMENT_ID)));

            //入力された日報内容を設定する
            cv.setComentDate(toLocalDate(getRequestParam(AttributeConst.COMENT_DATE)));
            cv.setTitle(getRequestParam(AttributeConst.COMENT_TITLE));
            cv.setContent(getRequestParam(AttributeConst.COMENT_CONTENT));


            //日報データを更新する
            List<String> errors = service.update(cv);

            if (errors.size() > 0) {
                //更新中にエラーが発生した場合

                putRequestScope(AttributeConst.TOKEN, getTokenId()); //CSRF対策用トークン
                putRequestScope(AttributeConst.COMENT, cv); //入力された日報情報
                putRequestScope(AttributeConst.ERR, errors); //エラーのリスト

                //編集画面を再表示
                forward(ForwardConst.FW_COMENT_EDIT);
            } else {
                //更新中にエラーがなかった場合

                //セッションに更新完了のフラッシュメッセージを設定
                putSessionScope(AttributeConst.FLUSH, MessageConst.I_UPDATED.getMessage());

                //一覧画面にリダイレクト
                redirect(ForwardConst.ACT_COMENT, ForwardConst.CMD_INDEX);

            }
        }
    }

}