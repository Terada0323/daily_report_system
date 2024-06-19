package actions;

import java.io.IOException;
import java.util.List; //追記

import javax.servlet.ServletException;

import actions.views.EmployeeView; //追記
import actions.views.MemoView;
import constants.AttributeConst;
import constants.ForwardConst;
import constants.JpaConst;  //追記
import services.MemoService;  //追記

/**
 * トップページに関する処理を行うActionクラス
 *
 */
public class TopAction2 extends ActionBase {

    private MemoService service; //追記

    /**
     * indexメソッドを実行する
     */
    @Override
    public void process() throws ServletException, IOException {

        service = new MemoService(); //追記

        //メソッドを実行
        invoke();

        service.close(); //追記

    }

    /**
     * 一覧画面を表示する
     * @param myMemosCount
     */
    public void index() throws ServletException, IOException {

        // 以下追記

        //セッションからログイン中の従業員情報を取得
        EmployeeView loginEmployee = (EmployeeView) getSessionScope(AttributeConst.LOGIN_EMP);

        //ログイン中の従業員が作成した日報データを、指定されたページ数の一覧画面に表示する分取得する
        int memopage = getPage();
        List<MemoView> memos = service.getMinePerPage(loginEmployee, memopage);

        //ログイン中の従業員が作成した日報データの件数を取得
//        long myMemosCount = service.countAllMine(loginEmployee);
        long myMemosCount = 5;

        putRequestScope(AttributeConst.MEMOS, memos); //取得した日報データ
        putRequestScope(AttributeConst.MEMO_COUNT, myMemosCount); //ログイン中の従業員が作成した日報の数
        putRequestScope(AttributeConst.MEMOPAGE, memopage); //ページ数
        putRequestScope(AttributeConst.MAX_ROW, JpaConst.ROW_PER_PAGE); //1ページに表示するレコードの数

        //↑ここまで追記

        //セッションにフラッシュメッセージが設定されている場合はリクエストスコープに移し替え、セッションからは削除する
        String flush = getSessionScope(AttributeConst.FLUSH);
        if (flush != null) {
            putRequestScope(AttributeConst.FLUSH, flush);
            removeSessionScope(AttributeConst.FLUSH);
        }

        //一覧画面を表示
        forward(ForwardConst.FW_TOP2_INDEX);
    }

}