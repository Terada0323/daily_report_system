package actions;

import java.io.IOException;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.WeekFields;
import java.util.List;

import javax.servlet.ServletException;

import actions.views.EmployeeView;
import actions.views.MemoView;
import actions.views.WeekReportView;
import constants.AttributeConst;
import constants.ForwardConst;
import constants.JpaConst;
import constants.MessageConst;
import lombok.val;
import services.MemoService;
import services.WeekReportService;

/**
 * 日報に関する処理を行うActionクラス
 *
 */
public class WeekReportAction extends ActionBase {

    private WeekReportService service;
    private MemoService service2;

    /**
     * メソッドを実行する
     */
    @Override
    public void process() throws ServletException, IOException {

        service = new WeekReportService();

        service2 = new MemoService(); //追記

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

        //指定されたページ数の一覧画面に表示する日報データを取得
        int page = getPage();
        List<WeekReportView> weekreports = service.getAllPerPage(page);

        //全日報データの件数を取得
        long weekreportsCount = service.countAll();

        putRequestScope(AttributeConst.WEEKREPORTS, weekreports); //取得した日報データ
        putRequestScope(AttributeConst.WEEKREP_COUNT, weekreportsCount); //全ての日報データの件数
        putRequestScope(AttributeConst.PAGE, page); //ページ数
        putRequestScope(AttributeConst.MAX_ROW, JpaConst.ROW_PER_PAGE); //1ページに表示するレコードの数

        //セッションにフラッシュメッセージが設定されている場合はリクエストスコープに移し替え、セッションからは削除する
        String flush = getSessionScope(AttributeConst.FLUSH);
        if (flush != null) {
            putRequestScope(AttributeConst.FLUSH, flush);
            removeSessionScope(AttributeConst.FLUSH);
        }

        //一覧画面を表示
        forward(ForwardConst.FW_WEEKREP_INDEX);



    }



    /**
     * 自分だけの一覧画面を表示する
     * @throws ServletException
     * @throws IOException
     */
    public void myIndex() throws ServletException, IOException {

     // 以下追記

        //セッションからログイン中の従業員情報を取得
        EmployeeView loginEmployee = (EmployeeView) getSessionScope(AttributeConst.LOGIN_EMP);

        //ログイン中の従業員が作成した日報データを、指定されたページ数の一覧画面に表示する分取得する
        int page = getPage();
        List<WeekReportView> weekreports = service.getMinePerPage(loginEmployee, page);

        //ログイン中の従業員が作成した日報データの件数を取得
        long myWeekReportsCount = service.countAllMine(loginEmployee);

        putRequestScope(AttributeConst.WEEKREPORTS, weekreports); //取得した日報データ
        putRequestScope(AttributeConst.WEEKREP_COUNT, myWeekReportsCount); //ログイン中の従業員が作成した日報の数
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
        forward(ForwardConst.FW_WEEKREP_INDEX);
    }


    /**
     * 今日の目標のために最新作成の一件だけ取ってくる
     * @throws ServletException
     * @throws IOException
     */
    public void myIndex1() throws ServletException, IOException {

     // 以下追記

        //セッションからログイン中の従業員情報を取得
        EmployeeView loginEmployee = (EmployeeView) getSessionScope(AttributeConst.LOGIN_EMP);

        //ログイン中の従業員が作成した日報データを、指定されたページ数の一覧画面に表示する分取得する
        int page = getPage();
        List<WeekReportView> weekreports = service.getMinePerPage(loginEmployee, page);

        //ログイン中の従業員が作成した日報データの件数を取得
        long myWeekReportsCount = service.countAllMine(loginEmployee);



        putRequestScope(AttributeConst.WEEKREPORTS, weekreports); //取得した日報データ
        putRequestScope(AttributeConst.WEEKREP_COUNT, myWeekReportsCount); //ログイン中の従業員が作成した日報の数
        putRequestScope(AttributeConst.PAGE, page); //ページ数
        putRequestScope(AttributeConst.MAX_ROW, 1); //1ページに表示するレコードの数

        //↑ここまで追記

        //セッションにフラッシュメッセージが設定されている場合はリクエストスコープに移し替え、セッションからは削除する
        String flush = getSessionScope(AttributeConst.FLUSH);
        if (flush != null) {
            putRequestScope(AttributeConst.FLUSH, flush);
            removeSessionScope(AttributeConst.FLUSH);
        }

        //一覧画面を表示
        forward(ForwardConst.FW_WEEKREP_INDEX);
    }








    /**
     * 新規登録画面を表示する
     * @throws ServletException
     * @throws IOException
     */
    public void entryNew() throws ServletException, IOException {

        putRequestScope(AttributeConst.TOKEN, getTokenId()); //CSRF対策用トークン

        //日報情報の空インスタンスに、日報の日付＝今日の日付を設定する
        WeekReportView wv = new WeekReportView();
        wv.setWeekreportDate(LocalDate.now());

        val weekField = WeekFields.SUNDAY_START.weekOfMonth();
        int weeknumber = LocalDate.now().get(weekField);
        putRequestScope(AttributeConst.WEEKREP_WEEK, weeknumber); //取得した日報データ


        putRequestScope(AttributeConst.WEEKREPORT, wv); //日付のみ設定済みの日報インスタンス




     // 以下追記

        //セッションからログイン中の従業員情報を取得
        EmployeeView loginEmployee = (EmployeeView) getSessionScope(AttributeConst.LOGIN_EMP);

        //ログイン中の従業員が作成した日報データを、指定されたページ数の一覧画面に表示する分取得する
        int page = getPage();

        List<MemoView> memos = service2.getMinePerPage(loginEmployee, page);

        //ログイン中の従業員が作成した日報データの件数を取得
        long myMemosCount = service2.countAllMine(loginEmployee);

        putRequestScope(AttributeConst.MEMOS, memos); //取得した日報データ
        putRequestScope(AttributeConst.MEMO_COUNT, myMemosCount); //ログイン中の従業員が作成した日報の数
        putRequestScope(AttributeConst.PAGE, page); //ページ数
        putRequestScope(AttributeConst.MAX_ROW, JpaConst.ROW_PER_PAGE); //1ページに表示するレコードの数

        //↑ここまで追記

        //セッションにフラッシュメッセージが設定されている場合はリクエストスコープに移し替え、セッションからは削除する
        String flush = getSessionScope(AttributeConst.FLUSH);
        if (flush != null) {
            putRequestScope(AttributeConst.FLUSH, flush);
            removeSessionScope(AttributeConst.FLUSH);
        }






        //新規登録画面を表示
        forward(ForwardConst.FW_WEEKREP_NEW);

    }

    /**
     * 新規登録を行う
     * @throws ServletException
     * @throws IOException
     */
    public void create() throws ServletException, IOException {

        //CSRF対策 tokenのチェック
        if (checkToken()) {

            //日報の日付が入力されていなければ、今日の日付を設定
            LocalDate day = null;
            if (getRequestParam(AttributeConst.WEEKREP_DATE) == null
                    || getRequestParam(AttributeConst.WEEKREP_DATE).equals("")) {
                day = LocalDate.now();
            } else {
                day = LocalDate.parse(getRequestParam(AttributeConst.WEEKREP_DATE));
            }

            //セッションからログイン中の従業員情報を取得
            EmployeeView ev = (EmployeeView) getSessionScope(AttributeConst.LOGIN_EMP);



            WeekFields weekFields = WeekFields.of(DayOfWeek.MONDAY, 1); // ISO-8601の定義
            int weekNumber = day.get(weekFields.weekOfMonth());








            //パラメータの値をもとに日報情報のインスタンスを作成する
            WeekReportView wv = new WeekReportView(
                    null,
                    ev, //ログインしている従業員を、日報作成者として登録する
                    day,
                    getRequestParam(AttributeConst.WEEKREP_TITLE),
                    getRequestParam(AttributeConst.WEEKREP_CONTENT),
                    getRequestParam(AttributeConst.WEEKREP_CONTENT2),
                    getRequestParam(AttributeConst.WEEKREP_TOMORROWGOAL),
                    getRequestParam(AttributeConst.WEEKREP_CONTENT_OE1),
                    getRequestParam(AttributeConst.WEEKREP_CONTENT_OE2),
                    toNumber(getRequestParam(AttributeConst.WEEKREP_OE1_FLG)),
                    toNumber(getRequestParam(AttributeConst.WEEKREP_OE2_FLG)),
                    null,
                    null,
                    weekNumber);








            //日報情報登録
            List<String> errors = service.create(wv);

            if (errors.size() > 0) {
                //登録中にエラーがあった場合

                putRequestScope(AttributeConst.TOKEN, getTokenId()); //CSRF対策用トークン
                putRequestScope(AttributeConst.WEEKREPORT, wv);//入力された日報情報
                putRequestScope(AttributeConst.ERR, errors);//エラーのリスト

                //新規登録画面を再表示
                forward(ForwardConst.FW_WEEKREP_NEW);

            } else {
                //登録中にエラーがなかった場合

                //セッションに登録完了のフラッシュメッセージを設定
                putSessionScope(AttributeConst.FLUSH, MessageConst.I_REGISTERED.getMessage());

                //一覧画面にリダイレクト
                redirect(ForwardConst.ACT_WEEKREP, ForwardConst.CMD_INDEX);
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
        WeekReportView wv = service.findOne(toNumber(getRequestParam(AttributeConst.WEEKREP_ID)));

        if (wv == null) {
            //該当の日報データが存在しない場合はエラー画面を表示
            forward(ForwardConst.FW_ERR_UNKNOWN);

        } else {

            putRequestScope(AttributeConst.WEEKREPORT, wv); //取得した日報データ

            //詳細画面を表示
            forward(ForwardConst.FW_WEEKREP_SHOW);
        }
    }

    /**
     * 編集画面を表示する
     * @throws ServletException
     * @throws IOException
     */
    public void edit() throws ServletException, IOException {

        //idを条件に日報データを取得する
        WeekReportView wv = service.findOne(toNumber(getRequestParam(AttributeConst.WEEKREP_ID)));

        //セッションからログイン中の従業員情報を取得
        EmployeeView ev = (EmployeeView) getSessionScope(AttributeConst.LOGIN_EMP);

        if (wv == null || ev.getId() != wv.getEmployee().getId()) {
            //該当の日報データが存在しない、または
            //ログインしている従業員が日報の作成者でない場合はエラー画面を表示
            forward(ForwardConst.FW_ERR_UNKNOWN);

        } else {

            putRequestScope(AttributeConst.TOKEN, getTokenId()); //CSRF対策用トークン
            putRequestScope(AttributeConst.WEEKREPORT, wv); //取得した日報データ


          //ログイン中の従業員が作成した日報データを、指定されたページ数の一覧画面に表示する分取得する
            int page = getPage();

            List<MemoView> memos = service2.getMinePerPage(ev, page);

            //ログイン中の従業員が作成した日報データの件数を取得
            long myMemosCount = service2.countAllMine(ev);

            putRequestScope(AttributeConst.MEMOS, memos); //取得した日報データ
            putRequestScope(AttributeConst.MEMO_COUNT, myMemosCount); //ログイン中の従業員が作成した日報の数
            putRequestScope(AttributeConst.PAGE, page); //ページ数
            putRequestScope(AttributeConst.MAX_ROW, JpaConst.ROW_PER_PAGE); //1ページに表示するレコードの数

            //↑ここまで追記

            //編集画面を表示
            forward(ForwardConst.FW_WEEKREP_EDIT);
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
            WeekReportView wv = service.findOne(toNumber(getRequestParam(AttributeConst.WEEKREP_ID)));

            WeekFields weekFields = WeekFields.of(DayOfWeek.MONDAY, 1); // ISO-8601の定義
            int weekNumber = toLocalDate(getRequestParam(AttributeConst.WEEKREP_DATE)).get(weekFields.weekOfMonth());



            //入力された日報内容を設定する
            wv.setWeekreportDate(toLocalDate(getRequestParam(AttributeConst.WEEKREP_DATE)));
            wv.setWeektitle(getRequestParam(AttributeConst.WEEKREP_TITLE));
            wv.setWeekcontent(getRequestParam(AttributeConst.WEEKREP_CONTENT));
            wv.setWeekcontent2(getRequestParam(AttributeConst.WEEKREP_CONTENT2));
            wv.setWeektomorrowGoal(getRequestParam(AttributeConst.WEEKREP_TOMORROWGOAL));
            wv.setWeekcontentOe1(getRequestParam(AttributeConst.WEEKREP_CONTENT_OE1));
            wv.setWeekcontentOe2(getRequestParam(AttributeConst.WEEKREP_CONTENT_OE2));
            wv.setWeekoeFlag1(toNumber(getRequestParam(AttributeConst.WEEKREP_OE1_FLG)));
            wv.setWeekoeFlag2(toNumber(getRequestParam(AttributeConst.WEEKREP_OE2_FLG)));
            wv.setWeeknumber(weekNumber);




            //日報データを更新する
            List<String> errors = service.update(wv);

            if (errors.size() > 0) {
                //更新中にエラーが発生した場合

                putRequestScope(AttributeConst.TOKEN, getTokenId()); //CSRF対策用トークン
                putRequestScope(AttributeConst.WEEKREPORT, wv); //入力された日報情報
                putRequestScope(AttributeConst.ERR, errors); //エラーのリスト

                //編集画面を再表示
                forward(ForwardConst.FW_WEEKREP_EDIT);
            } else {
                //更新中にエラーがなかった場合

                //セッションに更新完了のフラッシュメッセージを設定
                putSessionScope(AttributeConst.FLUSH, MessageConst.I_UPDATED.getMessage());

                //一覧画面にリダイレクト
                redirect(ForwardConst.ACT_WEEKREP, ForwardConst.CMD_INDEX);

            }
        }
    }


}