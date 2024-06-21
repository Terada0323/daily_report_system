package models;

import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import constants.JpaConst;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * 日報データのDTOモデル
 *
 */
@Table(name = JpaConst.TABLE_WEEKREP)
@NamedQueries({
    @NamedQuery(
            name = JpaConst.Q_WEEKREP_GET_ALL,
            query = JpaConst.Q_WEEKREP_GET_ALL_DEF),
    @NamedQuery(
            name = JpaConst.Q_WEEKREP_COUNT,
            query = JpaConst.Q_WEEKREP_COUNT_DEF),
    @NamedQuery(
            name = JpaConst.Q_WEEKREP_GET_ALL_MINE,
            query = JpaConst.Q_WEEKREP_GET_ALL_MINE_DEF),
    @NamedQuery(
            name = JpaConst.Q_WEEKREP_COUNT_ALL_MINE,
            query = JpaConst.Q_WEEKREP_COUNT_ALL_MINE_DEF)
})

@Getter //全てのクラスフィールドについてgetterを自動生成する(Lombok)
@Setter //全てのクラスフィールドについてsetterを自動生成する(Lombok)
@NoArgsConstructor //引数なしコンストラクタを自動生成する(Lombok)
@AllArgsConstructor //全てのクラスフィールドを引数にもつ引数ありコンストラクタを自動生成する(Lombok)
@Entity
public class WeekReport {

    /**
     * id
     */
    @Id
    @Column(name = JpaConst.WEEKREP_COL_ID)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 日報を登録した従業員
     */
    @ManyToOne
    @JoinColumn(name = JpaConst.WEEKREP_COL_EMP, nullable = false)
    private Employee employee;

    /**
     * いつの日報かを示す日付
     */
    @Column(name = JpaConst.WEEKREP_COL_REP_DATE, nullable = false)
    private LocalDate weekreportDate;

    /**
     * 日報のタイトル
     */
    @Column(name = JpaConst.WEEKREP_COL_TITLE, length = 255, nullable = false)
    private String weektitle;

    /**
     * 日報の内容
     */
    @Lob
    @Column(name = JpaConst.WEEKREP_COL_CONTENT, nullable = false)
    private String weekcontent;

    /**
     * 日報の内容２
     */
    @Lob
    @Column(name = JpaConst.WEEKREP_COL_CONTENT2, nullable = true)
    private String weekcontent2;

    /**
     * 日報の明日の目標
     */
    @Lob
    @Column(name = JpaConst.WEEKREP_TOMORROW_GOAL, nullable = true)
    private String weektomorrowGoal;

    /**
     * 日報のOE内容１
     */
    @Lob
    @Column(name = JpaConst.WEEKREP_COL_CONTENT_OE1, nullable = true)
    private String weekcontentOe1;

    /**
     * 日報のOE内容２
     */
    @Lob
    @Column(name = JpaConst.WEEKREP_COL_CONTENT_OE2, nullable = true)
    private String weekcontentOe2;

    /**
     * OEのタグ１
     */
    @Column(name = JpaConst.WEEKREP_COL_OE_FLAG1, nullable = true)
    private Integer weekoeFlag1;


    /**
     * OEのタグ
     */
    @Column(name = JpaConst.WEEKREP_COL_OE_FLAG2, nullable = true)
    private Integer weekoeFlag2;


    /**
     * 登録日時
     */
    @Column(name = JpaConst.WEEKREP_COL_CREATED_AT, nullable = false)
    private LocalDateTime weekcreatedAt;

    /**
     * 更新日時
     */
    @Column(name = JpaConst.WEEKREP_COL_UPDATED_AT, nullable = false)
    private LocalDateTime weekupdatedAt;


    /**
     * OEのタグ１
     */
    @Column(name = JpaConst.WEEKREP_COL_REP_WEEK, nullable = true)
    private Integer weeknumber;


}