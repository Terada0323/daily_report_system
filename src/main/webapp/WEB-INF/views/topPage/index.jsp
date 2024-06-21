<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page import="constants.ForwardConst"%>

<c:set var="actTop" value="${ForwardConst.ACT_TOP.getValue()}" />
<c:set var="actTop2" value="${ForwardConst.ACT_TOP2.getValue()}" />
<c:set var="actEmp" value="${ForwardConst.ACT_EMP.getValue()}" />
<c:set var="actRep" value="${ForwardConst.ACT_REP.getValue()}" />
<c:set var="actWeekRep" value="${ForwardConst.ACT_WEEKREP.getValue()}" />
<c:set var="actMemo" value="${ForwardConst.ACT_MEMO.getValue()}" />

<c:set var="commShow" value="${ForwardConst.CMD_SHOW.getValue()}" />
<c:set var="commIdx" value="${ForwardConst.CMD_INDEX.getValue()}" />

<c:set var="commNew" value="${ForwardConst.CMD_NEW.getValue()}" />

<c:import url="../layout/app.jsp">
    <c:param name="content">
        <c:if test="${flush != null}">
            <div id="flush_success">
                <c:out value="${flush}"></c:out>
            </div>
        </c:if>


        <h2>らくらく日報くんへようこそ</h2>



        <div class="buttoncon">
            <p id="topbutton">
                <a id="topbuttonlink"
                    href="<c:url value='?action=${actMemo}&command=${commIdx}' />">メモ管理</a>
            </p>
            <p id="topbutton">
                <a id="topbuttonlink"
                    href="<c:url value='?action=${actMemo}&command=${commNew}' />">メモ作成</a>
            </p>
            <p id="topbutton">
                <a id="topbuttonlink"
                    href="<c:url value='?action=${actRep}&command=${commNew}' />">日報作成</a>
            </p>
            <p id="topbutton">
                <a id="topbuttonlink"
                    href="<c:url value='?action=${actRep}&command=${commIdx}' />">日報管理</a>
            </p>
            <p id="topbutton">
                <a id="topbuttonlink"
                    href="<c:url value='?action=${actWeekRep}&command=${commIdx}' />">週報？？</a>
            </p>
        </div>



        <h3>【今日の目標】</h3>


        <c:forEach var="report" items="${reports}" varStatus="status">
            <h2>
                <c:out value="${report.tomorrowGoal}" />
            </h2>
        </c:forEach>

    </c:param>
</c:import>