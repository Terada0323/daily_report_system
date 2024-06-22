package actions.views;

import java.util.ArrayList;
import java.util.List;

import models.Coment;

/**
 * 日報データのDTOモデル⇔Viewモデルの変換を行うクラス
 *
 */
public class ComentConverter {

    /**
     * ViewモデルのインスタンスからDTOモデルのインスタンスを作成する
     * @param mv ComentViewのインスタンス
     * @return Comentのインスタンス
     */
    public static Coment toModel(ComentView cv) {
        return new Coment(
                cv.getId(),
                EmployeeConverter.toModel(cv.getEmployee()),
                cv.getComentDate(),
                cv.getTitle(),
                cv.getContent(),
                cv.getCreatedAt(),
                cv.getUpdatedAt());

    }

    /**
     * DTOモデルのインスタンスからViewモデルのインスタンスを作成する
     * @param m Comentのインスタンス
     * @return ComenttViewのインスタンス
     */
    public static ComentView toView(Coment c) {

        if (c == null) {
            return null;
        }

        return new ComentView(
                c.getId(),
                EmployeeConverter.toView(c.getEmployee()),
                c.getComentDate(),
                c.getTitle(),
                c.getContent(),
                c.getCreatedAt(),
                c.getUpdatedAt());

    }

    /**
     * DTOモデルのリストからViewモデルのリストを作成する
     * @param list DTOモデルのリスト
     * @return Viewモデルのリスト
     */
    public static List<ComentView> toViewList(List<Coment> list) {
        List<ComentView> evs = new ArrayList<>();

        for (Coment c : list) {
            evs.add(toView(c));
        }

        return evs;
    }

    /**
     * Viewモデルの全フィールドの内容をDTOモデルのフィールドにコピーする
     * @param m DTOモデル(コピー先)
     * @param mv Viewモデル(コピー元)
     */
    public static void copyViewToModel(Coment c, ComentView cv) {
        c.setId(cv.getId());
        c.setEmployee(EmployeeConverter.toModel(cv.getEmployee()));
        c.setComentDate(cv.getComentDate());
        c.setTitle(cv.getTitle());
        c.setContent(cv.getContent());
        c.setCreatedAt(cv.getCreatedAt());
        c.setUpdatedAt(cv.getUpdatedAt());

    }

}