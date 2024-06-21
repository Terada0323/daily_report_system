<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page import="constants.ForwardConst" %>

<c:set var="actMemo" value="${ForwardConst.ACT_MEMO.getValue()}" />
<c:set var="commIdx" value="${ForwardConst.CMD_INDEX.getValue()}" />
<c:set var="commEdt" value="${ForwardConst.CMD_EDIT.getValue()}" />

<c:import url="/WEB-INF/views/layout/app.jsp">
    <c:param name="content">

        <h2>メモ 詳細ページ</h2>

        <table>
            <tbody>
                <tr>
                    <th>氏名</th>
                    <td><c:out value="${memo.employee.name}" /></td>
                </tr>
                <tr>
                    <th>日付</th>
                    <fmt:parseDate value="${memo.memoDate}" pattern="yyyy-MM-dd" var="memoDay" type="date" />
                    <td><fmt:formatDate value='${memoDay}' pattern='yyyy-MM-dd' /></td>
                </tr>
                <tr>
                    <th>内容（事実）</th>
                    <td><pre><c:out value="${memo.content}" /></pre></td>
                </tr>
                <tr>
                    <th>内容（気づき、感情）</th>
                    <td><pre><c:out value="${memo.content2}" /></pre></td>
                </tr>
                <tr>
                    <th>感情のタグ</th>
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
                <tr>
                    <th>登録日時</th>
                    <fmt:parseDate value="${memo.createdAt}" pattern="yyyy-MM-dd'T'HH:mm:ss" var="createDay" type="date" />
                    <td><fmt:formatDate value="${createDay}" pattern="yyyy-MM-dd HH:mm:ss" /></td>
                </tr>
                <tr>
                    <th>更新日時</th>
                    <fmt:parseDate value="${memo.updatedAt}" pattern="yyyy-MM-dd'T'HH:mm:ss" var="updateDay" type="date" />
                    <td><fmt:formatDate value="${updateDay}" pattern="yyyy-MM-dd HH:mm:ss" /></td>
                </tr>
            </tbody>
        </table>

        <c:if test="${sessionScope.login_employee.id == memo.employee.id}">
            <p>
                <a href="<c:url value='?action=${actMemo}&command=${commEdt}&id=${memo.id}' />">このメモを編集する</a>
            </p>
        </c:if>

        <p>
            <a href="<c:url value='?action=${actMemo}&command=${commIdx}' />">一覧に戻る</a>
        </p>
    </c:param>
</c:import>