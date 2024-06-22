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
 * メモデータのDTOモデル
 *
 */
@Table(name = JpaConst.TABLE_COMENT)
@NamedQueries({
    @NamedQuery(
            name = JpaConst.Q_COMENT_GET_ALL,
            query = JpaConst.Q_COMENT_GET_ALL_DEF),
    @NamedQuery(
            name = JpaConst.Q_COMENT_COUNT,
            query = JpaConst.Q_COMENT_COUNT_DEF),
    @NamedQuery(
            name = JpaConst.Q_COMENT_GET_ALL_MINE,
            query = JpaConst.Q_COMENT_GET_ALL_MINE_DEF),
    @NamedQuery(
            name = JpaConst.Q_COMENT_COUNT_ALL_MINE,
            query = JpaConst.Q_COMENT_COUNT_ALL_MINE_DEF)
})

@Getter //全てのクラスフィールドについてgetterを自動生成する(Lombok)
@Setter //全てのクラスフィールドについてsetterを自動生成する(Lombok)
@NoArgsConstructor //引数なしコンストラクタを自動生成する(Lombok)
@AllArgsConstructor //全てのクラスフィールドを引数にもつ引数ありコンストラクタを自動生成する(Lombok)
@Entity
public class Coment {

    /**
     * id
     */
    @Id
    @Column(name = JpaConst.COMENT_COL_ID)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * メモを登録した従業員
     */
    @ManyToOne
    @JoinColumn(name = JpaConst.COMENT_COL_EMP, nullable = false)
    private Employee employee;

    /**
     * いつのメモかを示す日付
     */
    @Column(name = JpaConst.COMENT_COL_COMENT_DATE, nullable = false)
    private LocalDate comentDate;

    /**
     * メモのタイトル
     */
    @Column(name = JpaConst.COMENT_COL_TITLE, length = 255, nullable = false)
    private String title;

    /**
     * メモの内容
     */
    @Lob
    @Column(name = JpaConst.COMENT_COL_CONTENT, nullable = false)
    private String content;



    /**
     * 登録日時
     */
    @Column(name = JpaConst.COMENT_COL_CREATED_AT, nullable = false)
    private LocalDateTime createdAt;

    /**
     * 更新日時
     */
    @Column(name = JpaConst.COMENT_COL_UPDATED_AT, nullable = false)
    private LocalDateTime updatedAt;




}