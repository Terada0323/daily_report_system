package constants;

/**
 * 画面の項目値等を定義するEnumクラス
 *
 */
public enum AttributeConst {

    //フラッシュメッセージ
    FLUSH("flush"),

    //一覧画面共通
    MAX_ROW("maxRow"),
    PAGE("page"),

    //入力フォーム共通
    TOKEN("_token"),
    ERR("errors"),

    //ログイン中の従業員
    LOGIN_EMP("login_employee"),

    //ログイン画面
    LOGIN_ERR("loginError"),

    //従業員管理
    EMPLOYEE("employee"),
    EMPLOYEES("employees"),
    EMP_COUNT("employees_count"),
    EMP_ID("id"),
    EMP_CODE("code"),
    EMP_PASS("password"),
    EMP_NAME("name"),
    EMP_ADMIN_FLG("admin_flag"),

    //管理者フラグ
    ROLE_ADMIN(1),
    ROLE_GENERAL(0),

    //削除フラグ
    DEL_FLAG_TRUE(1),
    DEL_FLAG_FALSE(0),

    //日報管理
    REPORT("report"),
    REPORTS("reports"),
    REP_COUNT("reports_count"),
    REP_ID("id"),
    REP_DATE("report_date"),
    REP_TITLE("title"),
    REP_CONTENT("content_msg"),
    REP_CONTENT2("content_msg2"),


    //lesson17から変数の編集と追加開始位置
    //従業員管理

    //メモの管理
    MEMO("memo"),
    MEMOS("memos"),
    MEMO_COUNT("memos_count"),
    MEMO_ID("id"),
    MEMO_DATE("memo_date"),
    MEMO_TITLE("title"),
    MEMO_CONTENT("content_msg"),
    MEMO_CONTENT2("content_msg2"),
    MEMO_EMOTION_FLG("emotion_flag"),

    //感情のタグ
    FEEL_HAPPY(0),
    FEEL_SAD(1);

    //日報の管理
    //DAY_REPORT("daily_report"),
    //DAY_REPORTS("daily_reports"),
    //DAY_REP_COUNT("daily_reports_count"),
    //DAY_REP_ID("id"),
    //DAY_REP_DATE("daily_report_date"),
    //DAY_REP_OE_CONTENT(""),
    //DAY_REP_OE_TAG(""),
    //DAY_REP_CONTENT("daily_report_content_msg");

    //週報の管理


    //lesson17から変数の編集と追加終了位置



    private final String text;
    private final Integer i;

    private AttributeConst(final String text) {
        this.text = text;
        this.i = null;
    }

    private AttributeConst(final Integer i) {
        this.text = null;
        this.i = i;
    }

    public String getValue() {
        return this.text;
    }

    public Integer getIntegerValue() {
        return this.i;
    }

}