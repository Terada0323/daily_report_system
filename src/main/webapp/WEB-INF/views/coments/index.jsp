<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page import="constants.ForwardConst" %>

<c:set var="actComent" value="${ForwardConst.ACT_COMENT.getValue()}" />
<c:set var="commIdx" value="${ForwardConst.CMD_INDEX.getValue()}" />
<c:set var="commShow" value="${ForwardConst.CMD_SHOW.getValue()}" />
<c:set var="commNew" value="${ForwardConst.CMD_NEW.getValue()}" />
<c:set var="actTop" value="${ForwardConst.ACT_TOP.getValue()}" />
<c:set var="actTop2" value="${ForwardConst.ACT_TOP2.getValue()}" />
<c:set var="actEmp" value="${ForwardConst.ACT_EMP.getValue()}" />
<c:set var="actRep" value="${ForwardConst.ACT_REP.getValue()}" />

<c:import url="/WEB-INF/views/layout/app.jsp">
    <c:param name="content">
        <c:if test="${flush != null}">
            <div id="flush_success">
                <c:out value="${flush}"></c:out>
            </div>
        </c:if>
        <h2>コメント　一覧</h2>
        <table id="coment_list">
            <tbody>
                <tr>

                    <th class="coment_date">日付</th>
                    <th class="coment_title">タイトル</th>
                    <th class="coment_action"></th>
                </tr>
                <c:forEach var="coment" items="${coments}" varStatus="status">
                    <fmt:parseDate value="${coment.comentDate}" pattern="yyyy-MM-dd" var="comentDay" type="date" />

                    <tr class="row${status.count % 2}">

                        <td class="coment_date"><fmt:formatDate value='${comentDay}' pattern='yyyy-MM-dd' /></td>
                        <td class="coment_title">${coment.title}</td>

                        <td class="coment_action"><a href="<c:url value='?action=${actComent}&command=${commShow}&id=${coment.id}' />">詳細を見る</a></td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>

        <div id="pagination">
            （全 ${coments_count} 件）<br />
            <c:forEach var="i" begin="1" end="${((coments_count - 1) / maxRow) + 1}" step="1">
                <c:choose>
                    <c:when test="${i == page}">
                        <c:out value="${i}" />&nbsp;
                    </c:when>
                    <c:otherwise>
                        <a href="<c:url value='?action=${actComent}&command=${commIdx}&page=${i}' />"><c:out value="${i}" /></a>&nbsp;
                    </c:otherwise>
                </c:choose>
            </c:forEach>
        </div>
        <p><a href="<c:url value='?action=${actComent}&command=${commNew}' />">新規コメントの登録</a></p>

    </c:param>
</c:import>