package constants;

/**
 * DB関連の項目値を定義するインターフェース
 * ※インターフェイスに定義した変数は public static final 修飾子がついているとみなされる
 */
public interface JpaConst {

    //persistence-unit名
    String PERSISTENCE_UNIT_NAME = "daily_report_system";

    //データ取得件数の最大値
    int ROW_PER_PAGE = 15; //1ページに表示するレコードの数

    //従業員テーブル
    String TABLE_EMP = "employees"; //テーブル名
    //従業員テーブルカラム
    String EMP_COL_ID = "id"; //id
    String EMP_COL_CODE = "code"; //社員番号
    String EMP_COL_NAME = "name"; //氏名
    String EMP_COL_PASS = "password"; //パスワード
    String EMP_COL_ADMIN_FLAG = "admin_flag"; //管理者権限
    String EMP_COL_CREATED_AT = "created_at"; //登録日時
    String EMP_COL_UPDATED_AT = "updated_at"; //更新日時
    String EMP_COL_DELETE_FLAG = "delete_flag"; //削除フラグ

    int ROLE_ADMIN = 1; //管理者権限ON(管理者)
    int ROLE_GENERAL = 0; //管理者権限OFF(一般)
    int EMP_DEL_TRUE = 1; //削除フラグON(削除済み)
    int EMP_DEL_FALSE = 0; //削除フラグOFF(現役)

    //日報テーブル
    String TABLE_REP = "reports"; //テーブル名
    //日報テーブルカラム
    String REP_COL_ID = "id"; //id
    String REP_COL_EMP = "employee_id"; //日報を作成した従業員のid
    String REP_COL_REP_DATE = "report_date"; //いつの日報かを示す日付
    String REP_COL_TITLE = "title"; //日報のタイトル
    String REP_COL_CONTENT = "content"; //日報の内容
    String REP_COL_CREATED_AT = "created_at"; //登録日時
    String REP_COL_UPDATED_AT = "updated_at"; //更新日時

    String REP_COL_CONTENT2 = "report_content2"; //日報の内容2
    String REP_TOMORROW_GOAL = "report_tomorrow_goal"; //明日の目標
    String REP_COL_CONTENT_OE1 = "report_content_oe1"; //OEメモの内容１
    String REP_COL_CONTENT_OE2 = "report_content_oe2"; //OEメモの内容２
    String REP_COL_OE_FLAG1 = "oe_flag1"; //OEのタグ１
    String REP_COL_OE_FLAG2 = "oe_flag2"; //OEのタグ２

    int OE_1 = 0; //目的
    int OE_2 = 1; //正しい
    int OE_3 = 2; //大胆
    int OE_4 = 3; //当事者
    int OE_5=  4; //相手軸
    int OE_6 = 5; //礼節
    int OE_7 = 6; //スピード
    int OE_8=  7; //学び続ける



    ///////テーブル追加編集開始位置///////

    //メモテーブル
    String TABLE_MEMO = "memos"; //テーブル名
    //メモテーブルカラム
    String MEMO_COL_ID = "id"; //id
    String MEMO_COL_EMP = "employee_id"; //メモを作成した従業員のid
    String MEMO_COL_MEMO_DATE = "memo_date"; //いつのメモかを示す日付
    String MEMO_COL_TITLE = "memo_title"; //メモのタイトル
    String MEMO_COL_CONTENT = "memo_content"; //メモの内容
    String MEMO_COL_CREATED_AT = "created_at"; //登録日時
    String MEMO_COL_UPDATED_AT = "updated_at"; //更新日時

    String MEMO_COL_CONTENT2 = "memo_content2"; //メモの内容
    String MEMO_COL_EMOTION_FLAG = "emotion_flag"; //管理者権限

    int FEEL_HAPPY = 0; //幸せ
    int FEEL_SAD = 1; //悲しい…



    //日報テーブル
    String TABLE_DAY_REP = "dailyReports"; //テーブル名
    //日報テーブルカラム
    String DAY_REP_COL_ID = "id"; //id
    String DAY_REP_COL_EMP = "employee_id"; //日報を作成した従業員のid
    String DAY_REP_COL_DAY_DATE = "report_date"; //いつの日報かを示す日付
    String DAY_REP_COL_CONTENT = "content"; //日報の内容
    String DAY_REP_COL_CREATED_AT = "created_at"; //登録日時
    String DAY_REP_COL_UPDATED_AT = "updated_at"; //更新日時

    //週報テーブル（まったく同じやったのでコメントアウトします：岡田）
//    String TABLE_WEEK_REP = "weeklyReports"; //テーブル名
//    //日報テーブルカラム
//    String WEEK_REP_COL_ID = "id"; //id
//    String WEEkREP_COL_EMP = "employee_id"; //週報を作成した従業員のid
//    String WEEK_REP_COL_WEEK_DATE = "report_date"; //いつの週報かを示す日付
//    String WEEK_REP_COL_CONTENT = "content"; //週報の内容
//    String WEEK_REP_COL_CREATED_AT = "created_at"; //登録日時
//    String WEEK_REP_COL_UPDATED_AT = "updated_at"; //更新日時

    //週報テーブル（0617_2135追加）
    String TABLE_WEEKREP = "weeklyreports"; //テーブル名
    //週報テーブルカラム
    String WEEKREP_COL_ID = "id"; //id
    String WEEKREP_COL_EMP = "employee_id"; //週報を作成した従業員のid
    String WEEKREP_COL_WEEKREP_DATE = "report_date"; //いつの週報かを示す日付
    String WEEKREP_COL_TITLE = "title"; //週報のタイトル
    String WEEKREP_COL_CONTENT = "content"; //週報の内容
    String WEEKREP_COL_CREATED_AT = "created_at"; //登録日時
    String WEEKREP_COL_UPDATED_AT = "updated_at"; //更新日時
    String WEEKREP_COL_TARGET = "target"; //目標（0617_2150追加）
    ///////テーブル追加編集終了位置///////


    //Entity名
    String ENTITY_EMP = "employee"; //従業員
    String ENTITY_REP = "report"; //日報

    //Entity名追加編集開始位置
    String ENTITY_MEMO = "memo"; //メモ
    String ENTITY_DAY_REP = "dailyReport"; //日報
    String ENTITY_WEEK_REP = "weeklyreport"; //日報

    //JPQL内パラメータ
    String JPQL_PARM_CODE = "code"; //社員番号
    String JPQL_PARM_PASSWORD = "password"; //パスワード
    String JPQL_PARM_EMPLOYEE = "employee"; //従業員

    //NamedQueryの nameとquery
    //全ての従業員をidの降順に取得する
    String Q_EMP_GET_ALL = ENTITY_EMP + ".getAll"; //name
    String Q_EMP_GET_ALL_DEF = "SELECT e FROM Employee AS e ORDER BY e.id DESC"; //query
    //全ての従業員の件数を取得する
    String Q_EMP_COUNT = ENTITY_EMP + ".count";
    String Q_EMP_COUNT_DEF = "SELECT COUNT(e) FROM Employee AS e";
    //社員番号とハッシュ化済パスワードを条件に未削除の従業員を取得する
    String Q_EMP_GET_BY_CODE_AND_PASS = ENTITY_EMP + ".getByCodeAndPass";
    String Q_EMP_GET_BY_CODE_AND_PASS_DEF = "SELECT e FROM Employee AS e WHERE e.deleteFlag = 0 AND e.code = :" + JPQL_PARM_CODE + " AND e.password = :" + JPQL_PARM_PASSWORD;
    //指定した社員番号を保持する従業員の件数を取得する
    String Q_EMP_COUNT_REGISTERED_BY_CODE = ENTITY_EMP + ".countRegisteredByCode";
    String Q_EMP_COUNT_REGISTERED_BY_CODE_DEF = "SELECT COUNT(e) FROM Employee AS e WHERE e.code = :" + JPQL_PARM_CODE;

    //全ての日報をidの降順に取得する
    String Q_REP_GET_ALL = ENTITY_REP + ".getAll";
    String Q_REP_GET_ALL_DEF = "SELECT r FROM Report AS r ORDER BY r.id DESC";
    //全ての日報の件数を取得する
    String Q_REP_COUNT = ENTITY_REP + ".count";
    String Q_REP_COUNT_DEF = "SELECT COUNT(r) FROM Report AS r";
    //指定した従業員が作成した日報を全件idの降順で取得する
    String Q_REP_GET_ALL_MINE = ENTITY_REP + ".getAllMine";
    String Q_REP_GET_ALL_MINE_DEF = "SELECT r FROM Report AS r WHERE r.employee = :" + JPQL_PARM_EMPLOYEE + " ORDER BY r.id DESC";
    //指定した従業員が作成した日報の件数を取得する
    String Q_REP_COUNT_ALL_MINE = ENTITY_REP + ".countAllMine";
    String Q_REP_COUNT_ALL_MINE_DEF = "SELECT COUNT(r) FROM Report AS r WHERE r.employee = :" + JPQL_PARM_EMPLOYEE;

    //新規追加開始位置
  //全てのメモをidの降順に取得する
    String Q_MEMO_GET_ALL = ENTITY_MEMO + ".getAll";
    String Q_MEMO_GET_ALL_DEF = "SELECT m FROM Memo AS m ORDER BY m.id DESC";
    //全てのメモの件数を取得する
    String Q_MEMO_COUNT = ENTITY_MEMO + ".count";
    String Q_MEMO_COUNT_DEF = "SELECT COUNT(m) FROM Memo AS m";
    //指定した従業員が作成したメモを全件idの降順で取得する
    String Q_MEMO_GET_ALL_MINE = ENTITY_MEMO + ".getAllMine";
    String Q_MEMO_GET_ALL_MINE_DEF = "SELECT m FROM Memo AS m WHERE m.employee = :" + JPQL_PARM_EMPLOYEE + " ORDER BY m.id DESC";
    //指定した従業員が作成したメモの件数を取得する
    String Q_MEMO_COUNT_ALL_MINE = ENTITY_MEMO + ".countAllMine";
    String Q_MEMO_COUNT_ALL_MINE_DEF = "SELECT COUNT(m) FROM Memo AS m WHERE m.employee = :" + JPQL_PARM_EMPLOYEE;

    //週報DBからデータ取得（0617_2135追加）
    //全ての週報をidの降順に取得する
    String Q_WEEKREP_GET_ALL = ENTITY_WEEK_REP + ".getAll";
    String Q_WEEKREP_GET_ALL_DEF = "SELECT r FROM weeklyreports AS r ORDER BY r.id DESC";
    //全ての週報の件数を取得する
    String Q_WEEKREP_COUNT = ENTITY_WEEK_REP + ".count";
    String Q_WEEKREP_COUNT_DEF = "SELECT COUNT(r) FROM weeklyreports AS r";
    //指定した従業員が作成した週報を全件idの降順で取得する
    String Q_WEEKREP_GET_ALL_MINE = ENTITY_WEEK_REP + ".getAllMine";
    String Q_WEEKREP_GET_ALL_MINE_DEF = "SELECT r FROM weeklyreports AS r WHERE r.employee = :" + JPQL_PARM_EMPLOYEE + " ORDER BY r.id DESC";
    //指定した従業員が作成した週報の件数を取得する
    String Q_WEEKREP_COUNT_ALL_MINE = ENTITY_WEEK_REP + ".countAllMine";
    String Q_WEEKREP_COUNT_ALL_MINE_DEF = "SELECT COUNT(r) FROM weeklyreports AS r WHERE r.employee = :" + JPQL_PARM_EMPLOYEE;

    //新規追加終了位置

}