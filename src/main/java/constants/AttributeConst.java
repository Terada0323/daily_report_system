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
    PAGE2("page2"),
    MEMOPAGE("memopage"),

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
    REP_TOMORROWGOAL("tomorrow_goal"),
    REP_CONTENT_OE1("content_oe1"),
    REP_CONTENT_OE2("content_oe2"),
    REP_OE1_FLG("oe1_flag"),
    REP_OE2_FLG("oe2_flag"),

    OE_1(0),
    OE_2(1),
    OE_3(2),
    OE_4(3),
    OE_5(4),
    OE_6(5),
    OE_7(6),
    OE_8(7),


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
    FEEL_JOY(0),
    FEEL_ANTICIPATION(1),
    FEEL_ANGER(2),
    FEEL_DISGUST(3),
    FEEL_SADNESS(4),
    FEEL_SURPRISE(5),
    FEEL_FEAR(6),
    FEEL_TRUST(7),



    //週報の管理
    WEEKREPORT("weekreport"),
    WEEKREPORTS("weekreports"),
    WEEKREP_COUNT("weekreports_count"),
    WEEKREP_ID("id"),
    WEEKREP_DATE("weekreport_date"),
    WEEKREP_WEEK("weekreport_week"),
    WEEKREP_TITLE("weektitle"),
    WEEKREP_CONTENT("weekcontent_msg"),
    WEEKREP_CONTENT2("weekcontent_msg2"),
    WEEKREP_TOMORROWGOAL("weektomorrow_goal"),
    WEEKREP_CONTENT_OE1("weekcontent_oe1"),
    WEEKREP_CONTENT_OE2("weekcontent_oe2"),
    WEEKREP_OE1_FLG("weekoe1_flag"),
    WEEKREP_OE2_FLG("weekoe2_flag"),

    WEEKOE_1(0),
    WEEKOE_2(1),
    WEEKOE_3(2),
    WEEKOE_4(3),
    WEEKOE_5(4),
    WEEKOE_6(5),
    WEEKOE_7(6),
    WEEKOE_8(7),




  //コメントの管理
    COMENT("coment"),
    COMENTS("coments"),
    COMENT_COUNT("coments_count"),
    COMENT_ID("id"),
    COMENT_DATE("coment_date"),
    COMENT_TITLE("title"),
    COMENT_CONTENT("content_msg");

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