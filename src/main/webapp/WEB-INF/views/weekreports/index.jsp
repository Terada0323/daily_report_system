<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page import="constants.ForwardConst" %>







<c:set var="actWeekRep" value="${ForwardConst.ACT_WEEKREP.getValue()}" />
<c:set var="commIdx" value="${ForwardConst.CMD_INDEX.getValue()}" />
<c:set var="commShow" value="${ForwardConst.CMD_SHOW.getValue()}" />
<c:set var="commNew" value="${ForwardConst.CMD_NEW.getValue()}" />

<c:import url="/WEB-INF/views/layout/app.jsp">
    <c:param name="content">
        <c:if test="${flush != null}">
            <div id="flush_success">
                <c:out value="${flush}"></c:out>
            </div>
        </c:if>
        <h2>週報　一覧</h2>
        <table id="report_list">
            <tbody>
                <tr>
                    <th class="weekreport_name">氏名</th>
                    <th class="weekreport_date">日付</th>
                    <th class="weekreport_week">第何週？</th>
                    <th class="weekreport_title">タイトル</th>
                    <th class="weekreport_action">操作</th>
                </tr>
                <c:forEach var="weekreport" items="${weekreports}" varStatus="status">
                    <fmt:parseDate value="${weekreport.weekreportDate}" pattern="yyyy-MM-dd" var="weekreportDay" type="date" />

                    <tr class="row${status.count % 2}">
                        <td class="weekreport_name"><c:out value="${weekreport.employee.name}" /></td>
                        <td class="weekreport_date"><fmt:formatDate value='${weekreportDay}' pattern='yyyy-MM-dd' /></td>
                        <td class="weekreport_week">${weekreport.weeknumber}</td>
                        <td class="weekreport_title">${weekreport.weektitle}</td>
                        <td class="weekreport_action"><a href="<c:url value='?action=${actWeekRep}&command=${commShow}&id=${weekreport.id}' />">詳細を見る</a></td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>

        <div id="pagination">
            （全 ${weekreports_count} 件）<br />
            <c:forEach var="i" begin="1" end="${((weekreports_count - 1) / maxRow) + 1}" step="1">
                <c:choose>
                    <c:when test="${i == page}">
                        <c:out value="${i}" />&nbsp;
                    </c:when>
                    <c:otherwise>
                        <a href="<c:url value='?action=${actWeekRep}&command=${commIdx}&page=${i}' />"><c:out value="${i}" /></a>&nbsp;
                    </c:otherwise>
                </c:choose>
            </c:forEach>
        </div>
        <p><a href="<c:url value='?action=${actWeekRep}&command=${commNew}' />">新規週報の登録</a></p>

    </c:param>
</c:import>