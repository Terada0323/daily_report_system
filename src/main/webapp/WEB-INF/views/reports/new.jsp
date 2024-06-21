<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="constants.ForwardConst" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<c:set var="action" value="${ForwardConst.ACT_REP.getValue()}" />
<c:set var="commIdx" value="${ForwardConst.CMD_INDEX.getValue()}" />
<c:set var="commCrt" value="${ForwardConst.CMD_CREATE.getValue()}" />

<c:set var="actMemo" value="${ForwardConst.ACT_MEMO.getValue()}" />
<c:set var="commShow" value="${ForwardConst.CMD_SHOW.getValue()}" />
<c:set var="commNew" value="${ForwardConst.CMD_NEW.getValue()}" />

<c:set var="actTop" value="${ForwardConst.ACT_TOP.getValue()}" />
<c:set var="actTop2" value="${ForwardConst.ACT_TOP2.getValue()}" />
<c:set var="actEmp" value="${ForwardConst.ACT_EMP.getValue()}" />
<c:set var="actRep" value="${ForwardConst.ACT_REP.getValue()}" />
<c:set var="actMemo" value="${ForwardConst.ACT_MEMO.getValue()}" />

<c:import url="/WEB-INF/views/layout/app.jsp">
    <c:param name="content">
        <h2>日報　新規登録ページ</h2>


<h3>【自分のメモ　一覧】</h3>
        <table id="memo_list">
            <tbody>
                <tr>

                    <th class="memo_date">日付</th>
                    <th class="memo_title">タイトル</th>
                    <th class="memo_content">内容（事実）</th>
                    <th class="memo_content2">内容（気づき、感情）</th>
                    <th class="memo_emotionFlag">感情のタグ</th>

                </tr>
                <c:forEach var="memo" items="${memos}" varStatus="status">
                    <fmt:parseDate value="${memo.memoDate}" pattern="yyyy-MM-dd" var="memoDay" type="date" />
                    <tr class="row${status.count % 2}">
                        <td class="memo_date"><fmt:formatDate value='${memoDay}' pattern='yyyy-MM-dd' /></td>
                        <td class="memo_title">${memo.title}</td>
                        <td class="memo_content">${memo.content}</td>
                        <td class="memo_content2">${memo.content2}</td>
                        <td><c:choose>
                            <c:when test="${memo.emotionFlag == 0}">喜び</c:when>
                            <c:when test="${memo.emotionFlag == 1}">期待</c:when>
                            <c:when test="${memo.emotionFlag == 2}">怒り</c:when>
                            <c:when test="${memo.emotionFlag == 3}">嫌悪</c:when>
                            <c:when test="${memo.emotionFlag == 4}">悲しみ</c:when>
                            <c:when test="${memo.emotionFlag == 5}">驚き</c:when>
                            <c:when test="${memo.emotionFlag == 6}">恐れ</c:when>
                            <c:when test="${memo.emotionFlag == 7}">信頼</c:when>

                        </c:choose>

                        </td>

                    </tr>
                </c:forEach>
            </tbody>
        </table>

        <div id="pagination">
            （全 ${memos_count} 件）<br />
            <c:forEach var="i" begin="1" end="${((memos_count - 1) / maxRow) + 1}" step="1">
                <c:choose>
                    <c:when test="${i == page}">
                        <c:out value="${i}" />&nbsp;
                    </c:when>
                    <c:otherwise>
                        <a href="<c:url value='?action=${actTop}&command=${commIdx}&page=${i}' />"><c:out value="${i}" /></a>&nbsp;
                    </c:otherwise>
                </c:choose>
            </c:forEach>
        </div>


        <form method="POST" action="<c:url value='?action=${action}&command=${commCrt}' />">
            <c:import url="_form.jsp" />
        </form>

        <p><a href="<c:url value='?action=${action}&command=${commIdx}' />">一覧に戻る</a></p>





    </c:param>
</c:import>