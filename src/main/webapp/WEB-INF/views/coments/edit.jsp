<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="constants.ForwardConst"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<c:set var="actComent" value="${ForwardConst.ACT_COMENT.getValue()}" />
<c:set var="commUpd" value="${ForwardConst.CMD_UPDATE.getValue()}" />
<c:set var="commIdx" value="${ForwardConst.CMD_INDEX.getValue()}" />
<c:set var="actTop" value="${ForwardConst.ACT_TOP.getValue()}" />

<c:import url="/WEB-INF/views/layout/app.jsp">
    <c:param name="content">

        <h2>コメント 編集ページ</h2>


        <h3>【今日の目標】</h3>


        <c:forEach var="report" items="${reports}" varStatus="status">
            <h2>
                <c:out value="${report.tomorrowGoal}" />
            </h2>
        </c:forEach>




        <form method="POST"
            action="<c:url value='?action=${actComent}&command=${commUpd}' />">
            <c:import url="_form.jsp" />
        </form>

        <p>
            <a href="<c:url value='?action=Coment&command=index' />">一覧に戻る</a></p>
            <p><a href="<c:url value='/?action=${actTop}&command=${commIdx}' />">Topページに戻る</p>

    </c:param>
</c:import>