package actions.views;

import java.util.ArrayList;
import java.util.List;

import models.Memo;

/**
 * 日報データのDTOモデル⇔Viewモデルの変換を行うクラス
 *
 */
public class MemoConverter {

    /**
     * ViewモデルのインスタンスからDTOモデルのインスタンスを作成する
     * @param mv MemoViewのインスタンス
     * @return Memoのインスタンス
     */
    public static Memo toModel(MemoView mv) {
        return new Memo(
                mv.getId(),
                EmployeeConverter.toModel(mv.getEmployee()),
                mv.getMemoDate(),
                mv.getTitle(),
                mv.getContent(),
                mv.getContent2(),
                mv.getCreatedAt(),
                mv.getUpdatedAt(),
                mv.getEmotionFlag());

    }

    /**
     * DTOモデルのインスタンスからViewモデルのインスタンスを作成する
     * @param m Memoのインスタンス
     * @return MemotViewのインスタンス
     */
    public static MemoView toView(Memo m) {

        if (m == null) {
            return null;
        }

        return new MemoView(
                m.getId(),
                EmployeeConverter.toView(m.getEmployee()),
                m.getMemoDate(),
                m.getTitle(),
                m.getContent(),
                m.getContent2(),
                m.getCreatedAt(),
                m.getUpdatedAt(),
                m.getEmotionFlag());

    }

    /**
     * DTOモデルのリストからViewモデルのリストを作成する
     * @param list DTOモデルのリスト
     * @return Viewモデルのリスト
     */
    public static List<MemoView> toViewList(List<Memo> list) {
        List<MemoView> evs = new ArrayList<>();

        for (Memo m : list) {
            evs.add(toView(m));
        }

        return evs;
    }

    /**
     * Viewモデルの全フィールドの内容をDTOモデルのフィールドにコピーする
     * @param m DTOモデル(コピー先)
     * @param mv Viewモデル(コピー元)
     */
    public static void copyViewToModel(Memo m, MemoView mv) {
        m.setId(mv.getId());
        m.setEmployee(EmployeeConverter.toModel(mv.getEmployee()));
        m.setMemoDate(mv.getMemoDate());
        m.setTitle(mv.getTitle());
        m.setContent(mv.getContent());
        m.setContent2(mv.getContent2());
        m.setCreatedAt(mv.getCreatedAt());
        m.setUpdatedAt(mv.getUpdatedAt());
        m.setEmotionFlag(mv.getEmotionFlag());

    }

}