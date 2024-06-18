<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page import="constants.AttributeConst" %>

<c:if test="${errors != null}">
    <div id="flush_error">
        入力内容にエラーがあります。<br />
        <c:forEach var="error" items="${errors}">
            ・<c:out value="${error}" /><br />
        </c:forEach>

    </div>
</c:if>
<fmt:parseDate value="${memo.memoDate}" pattern="yyyy-MM-dd" var="memoDay" type="date" />
<label for="${AttributeConst.MEMO_DATE.getValue()}">日付</label><br />
<input type="date" name="${AttributeConst.REP_DATE.getValue()}" id="${AttributeConst.REP_DATE.getValue()}" value="<fmt:formatDate value='${memoDay}' pattern='yyyy-MM-dd' />" />
<br /><br />

<label>氏名</label><br />
<c:out value="${sessionScope.login_employee.name}" />
<br /><br />

<label for="${AttributeConst.MEMO_TITLE.getValue()}">タイトル</label><br />
<input type="text" name="${AttributeConst.MEMO_TITLE.getValue()}" id="${AttributeConst.MEMO_TITLE.getValue()}" value="${memo.title}" />
<br /><br />

<label for="${AttributeConst.MEMO_CONTENT.getValue()}">内容（事実）</label><br />
<textarea  name="${AttributeConst.MEMO_CONTENT.getValue()}" id="${AttributeConst.MEMO_CONTENT.getValue()}" rows="10" cols="50">${memo.content}</textarea>
<br /><br />

<label for="${AttributeConst.MEMO_CONTENT2.getValue()}">内容（気づき、感情）</label><br />
<textarea  name="${AttributeConst.MEMO_CONTENT2.getValue()}" id="${AttributeConst.MEMO_CONTENT2.getValue()}" rows="10" cols="50">${memo.content2}</textarea>
<br /><br />

<label for="${AttributeConst.MEMO_EMOTION_FLG.getValue()}">感情のタグ</label><br />
<select name="${AttributeConst.MEMO_EMOTION_FLG.getValue()}" id="${AttributeConst.MEMO_EMOTION_FLG.getValue()}">
    <option value="${AttributeConst.FEEL_HAPPY.getIntegerValue()}"<c:if test="${memo.emotionFlag == AttributeConst.FEEL_HAPPY.getIntegerValue()}"> selected</c:if>>幸せ</option>
    <option value="${AttributeConst.FEEL_SAD.getIntegerValue()}"<c:if test="${memo.emotionFlag == AttributeConst.FEEL_SAD.getIntegerValue()}"> selected</c:if>>悲しい</option>
</select>
<br /><br />


<input type="hidden" name="${AttributeConst.MEMO_ID.getValue()}" value="${memo.id}" />
<input type="hidden" name="${AttributeConst.TOKEN.getValue()}" value="${_token}" />
<button type="submit">投稿</button>