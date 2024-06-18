<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page import="constants.ForwardConst" %>

<c:set var="actRep" value="${ForwardConst.ACT_REP.getValue()}" />
<c:set var="commIdx" value="${ForwardConst.CMD_INDEX.getValue()}" />
<c:set var="commEdt" value="${ForwardConst.CMD_EDIT.getValue()}" />

<c:import url="/WEB-INF/views/layout/app.jsp">
    <c:param name="content">

        <h2>日報 詳細ページ</h2>

        <table>
            <tbody>
                <tr>
                    <th>氏名</th>
                    <td><c:out value="${report.employee.name}" /></td>
                </tr>
                <tr>
                    <th>日付</th>
                    <fmt:parseDate value="${report.reportDate}" pattern="yyyy-MM-dd" var="reportDay" type="date" />
                    <td><fmt:formatDate value='${reportDay}' pattern='yyyy-MM-dd' /></td>
                </tr>
                <tr>
                    <th>内容（事実）</th>
                    <td><pre><c:out value="${report.content}" /></pre></td>
                </tr>
                 <tr>
                    <th>内容（気づき、学び）</th>
                    <td><pre><c:out value="${report.content2}" /></pre></td>
                </tr>
                <tr>
                    <th>明日の目標</th>
                    <td><pre><c:out value="${report.tomorrowGoal}" /></pre></td>
                </tr>
                <tr>
                    <th>OEの内容１</th>
                    <td><pre><c:out value="${report.contentOe1}" /></pre></td>
                </tr>
                <tr>
                    <th>OEの内容２</th>
                    <td><pre><c:out value="${report.contentOe2}" /></pre></td>
                </tr>
                <tr>
                    <th>OEのタグ1</th>
                    <td><c:choose>
                            <c:when test="${report.oeFlag1 == 0}">1</c:when>
                            <c:when test="${report.oeFlag1 == 1}">2</c:when>
                            <c:when test="${report.oeFlag1 == 2}">3</c:when>
                            <c:when test="${report.oeFlag1 == 3}">4</c:when>
                            <c:when test="${report.oeFlag1 == 4}">5</c:when>
                            <c:when test="${report.oeFlag1 == 5}">6</c:when>
                            <c:when test="${report.oeFlag1 == 6}">7</c:when>
                            <c:when test="${report.oeFlag1 == 7}">8</c:when>

                        </c:choose>

                        </td>
                </tr>
                <tr>
                    <th>OEのタグ2</th>
                    <td><c:choose>
                            <c:when test="${report.oeFlag2 == 0}">1</c:when>
                            <c:when test="${report.oeFlag2 == 1}">2</c:when>
                            <c:when test="${report.oeFlag2 == 2}">3</c:when>
                            <c:when test="${report.oeFlag2 == 3}">4</c:when>
                            <c:when test="${report.oeFlag2 == 4}">5</c:when>
                            <c:when test="${report.oeFlag2 == 5}">6</c:when>
                            <c:when test="${report.oeFlag2 == 6}">7</c:when>
                            <c:when test="${report.oeFlag2 == 7}">8</c:when>

                        </c:choose>

                        </td>
                </tr>
                <tr>
                    <th>登録日時</th>
                    <fmt:parseDate value="${report.createdAt}" pattern="yyyy-MM-dd'T'HH:mm:ss" var="createDay" type="date" />
                    <td><fmt:formatDate value="${createDay}" pattern="yyyy-MM-dd HH:mm:ss" /></td>
                </tr>
                <tr>
                    <th>更新日時</th>
                    <fmt:parseDate value="${report.updatedAt}" pattern="yyyy-MM-dd'T'HH:mm:ss" var="updateDay" type="date" />
                    <td><fmt:formatDate value="${updateDay}" pattern="yyyy-MM-dd HH:mm:ss" /></td>
                </tr>
            </tbody>
        </table>

        <c:if test="${sessionScope.login_employee.id == report.employee.id}">
            <p>
                <a href="<c:url value='?action=${actRep}&command=${commEdt}&id=${report.id}' />">この日報を編集する</a>
            </p>
        </c:if>

        <p>
            <a href="<c:url value='?action=${actRep}&command=${commIdx}' />">一覧に戻る</a>
        </p>
    </c:param>
</c:import>