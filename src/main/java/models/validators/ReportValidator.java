package models.validators;

import java.util.ArrayList;
import java.util.List;

import actions.views.ReportView;
import constants.MessageConst;

/**
 * 日報インスタンスに設定されている値のバリデーションを行うクラス
 */
public class ReportValidator {

    /**
     * 日報インスタンスの各項目についてバリデーションを行う
     * @param rv 日報インスタンス
     * @return エラーのリスト
     */
    public static List<String> validate(ReportView rv) {
        List<String> errors = new ArrayList<String>();

        //タイトルのチェック
        String titleError = validateTitle(rv.getTitle());
        if (!titleError.equals("")) {
            errors.add(titleError);
        }

        //内容のチェック
        String contentError = validateContent(rv.getContent());
        if (!contentError.equals("")) {
            errors.add(contentError);
        }

      //内容2のチェック
        String content2Error = validateContent2(rv.getContent2());
        if (!content2Error.equals("")) {
            errors.add(content2Error);
        }

         //明日の目標のチェック
        String tomorrowGoalError = validateTomorrowGoal(rv.getTomorrowGoal());
        if (!tomorrowGoalError.equals("")) {
            errors.add(tomorrowGoalError);
        }

        //OE1のチェック
        String contentOe1Error = validateContentOe1(rv.getContentOe1());
        if (!contentOe1Error.equals("")) {
            errors.add(contentOe1Error);
        }

      //OE2のチェック
        String contentOe2Error = validateContentOe2(rv.getContentOe2());
        if (!contentOe2Error.equals("")) {
            errors.add(contentOe2Error);
        }

        return errors;
    }

    /**
     * タイトルに入力値があるかをチェックし、入力値がなければエラーメッセージを返却
     * @param title タイトル
     * @return エラーメッセージ
     */
    private static String validateTitle(String title) {
        if (title == null || title.equals("")) {
            return MessageConst.E_NOTITLE.getMessage();
        }

        //入力値がある場合は空文字を返却
        return "";
    }

    /**
     * 内容に入力値があるかをチェックし、入力値がなければエラーメッセージを返却
     * @param content 内容
     * @return エラーメッセージ
     */
    private static String validateContent(String content) {
        if (content == null || content.equals("")) {
            return MessageConst.E_NOCONTENT.getMessage();
        }

        //入力値がある場合は空文字を返却
        return "";
    }

    /**
     * 内容に入力値があるかをチェックし、入力値がなければエラーメッセージを返却
     * @param content 内容
     * @return エラーメッセージ
     */
    private static String validateContent2(String content2) {
        if (content2 == null || content2.equals("")) {
            return MessageConst.E_NOCONTENT.getMessage();
        }

        //入力値がある場合は空文字を返却
        return "";
    }

    /**
     * 内容に入力値があるかをチェックし、入力値がなければエラーメッセージを返却
     * @param content 内容
     * @return エラーメッセージ
     * 明日の目標
     */
    private static String validateTomorrowGoal(String tomorrowGoal) {
        if (tomorrowGoal == null || tomorrowGoal.equals("")) {
            return MessageConst.E_NOTOMORROWGOAL.getMessage();
        }

        //入力値がある場合は空文字を返却
        return "";
    }

    /**
     * 内容に入力値があるかをチェックし、入力値がなければエラーメッセージを返却
     * @param content 内容
     * @return エラーメッセージ
     * OE内容１
     */
    private static String validateContentOe1(String contentOe1) {
        if (contentOe1 == null || contentOe1.equals("")) {
            return MessageConst.E_NOCONTENTOE1.getMessage();
        }

        //入力値がある場合は空文字を返却
        return "";
    }

    /**
     * 内容に入力値があるかをチェックし、入力値がなければエラーメッセージを返却
     * @param content 内容
     * @return エラーメッセージ
     * OE内容2
     */
    private static String validateContentOe2(String contentOe2) {
        if (contentOe2 == null || contentOe2.equals("")) {
            return MessageConst.E_NOCONTENTOE2.getMessage();
        }

        //入力値がある場合は空文字を返却
        return "";
    }
}