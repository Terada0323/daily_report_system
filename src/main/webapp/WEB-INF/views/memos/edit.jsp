<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="constants.ForwardConst"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<c:set var="actMemo" value="${ForwardConst.ACT_MEMO.getValue()}" />
<c:set var="commUpd" value="${ForwardConst.CMD_UPDATE.getValue()}" />

<c:import url="/WEB-INF/views/layout/app.jsp">
    <c:param name="content">

        <h2>メモ 編集ページ</h2>


        <h3>【今日の目標】</h3>


        <c:forEach var="report" items="${reports}" varStatus="status">
            <h2>
                <c:out value="${report.tomorrowGoal}" />
            </h2>
        </c:forEach>




        <form method="POST"
            action="<c:url value='?action=${actMemo}&command=${commUpd}' />">
            <c:import url="_form.jsp" />
        </form>

        <p>
            <a href="<c:url value='?action=Memo&command=index' />">一覧に戻る</a>
        </p>
    </c:param>
</c:import>