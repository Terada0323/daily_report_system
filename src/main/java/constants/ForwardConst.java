package constants;

/**
 * リクエストパラメーターの変数名、変数値、jspファイルの名前等画面遷移に関わる値を定義するEnumクラス
 *
 */
public enum ForwardConst {

    //action
    ACT("action"),
    ACT_TOP("Top"),
    ACT_TOP2("Top2"),
    ACT_EMP("Employee"),
    ACT_REP("Report"),
    ACT_AUTH("Auth"),

    //追加編集開始
    ACT_DAY_REP("DayReport"),
    ACT_WEEK_REP("WeekReport"),
    ACT_MEMO("Memo"),
    //追加編集終了

    //command
    CMD("command"),
    CMD_NONE(""),
    CMD_INDEX("index"),
    CMD_SHOW("show"),
    CMD_SHOW_LOGIN("showLogin"),
    CMD_LOGIN("login"),
    CMD_LOGOUT("logout"),
    CMD_NEW("entryNew"),
    CMD_CREATE("create"),
    CMD_EDIT("edit"),
    CMD_UPDATE("update"),
    CMD_DESTROY("destroy"),

    //jsp
    FW_ERR_UNKNOWN("error/unknown"),
    FW_TOP_INDEX("topPage/index"),
    FW_TOP2_INDEX("topPage2/index"),
    FW_LOGIN("login/login"),

    FW_EMP_INDEX("employees/index"),
    FW_EMP_SHOW("employees/show"),
    FW_EMP_NEW("employees/new"),
    FW_EMP_EDIT("employees/edit"),

    FW_REP_INDEX("reports/index"),
    FW_REP_SHOW("reports/show"),
    FW_REP_NEW("reports/new"),
    FW_REP_EDIT("reports/edit"),

    //追加開始位置
    FW_MEMO_INDEX("memos/index"),
    FW_MEMO_SHOW("memos/show"),
    FW_MEMO_NEW("memos/new"),
    FW_MEMO_EDIT("memos/edit");
    //追加終了位置

    /**
     * 文字列
     */
    private final String text;

    /**
     * コンストラクタ
     */
    private ForwardConst(final String text) {
        this.text = text;
    }

    /**
     * 値(文字列)取得
     */
    public String getValue() {
        return this.text;
    }

}