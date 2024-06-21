<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page import="constants.ForwardConst" %>
<%@ page import="java.time.LocalDate" %>
<%@ page import="java.time.temporal.WeekFields" %>
<%@ page import="java.time.DayOfWeek" %>

<c:set var="actWeekRep" value="${ForwardConst.ACT_WEEKREP.getValue()}" />
<c:set var="commIdx" value="${ForwardConst.CMD_INDEX.getValue()}" />
<c:set var="commEdt" value="${ForwardConst.CMD_EDIT.getValue()}" />

<c:import url="/WEB-INF/views/layout/app.jsp">
    <c:param name="content">

        <h2>週報 詳細ページ</h2>


        <% LocalDate date = LocalDate.of(2022, 1, 1);
           WeekFields weekFields = WeekFields.of(DayOfWeek.MONDAY, 1); // ISO-8601の定義
           int weekNumber = date.get(weekFields.weekOfMonth());
            out.println("第" + weekNumber + "週"); %>
             <c:out value="${weeknumber}"
             />
        <table>
            <tbody>
                <tr>
                    <th>氏名</th>
                    <td><c:out value="${weekreport.employee.name}" /></td>
                </tr>

                <tr>
                    <th>第何週</th>
                    <td><c:out value="${weekreport.weeknumber}" /></td>
                </tr>

                <tr>
                    <th>日付</th>
                    <fmt:parseDate value="${weekreport.weekreportDate}" pattern="yyyy-MM-dd" var="weekreportDay" type="date" />





                    <td><fmt:formatDate value='${weekreportDay}' pattern='yyyy-MM-dd' /></td>
                </tr>
                <tr>
                    <th>内容（事実）</th>
                    <td><pre><c:out value="${weekreport.weekcontent}" /></pre></td>
                </tr>
                 <tr>
                    <th>内容（気づき、学び）</th>
                    <td><pre><c:out value="${weekreport.weekcontent2}" /></pre></td>
                </tr>
                <tr>
                    <th>明日の目標</th>
                    <td><pre><c:out value="${weekreport.weektomorrowGoal}" /></pre></td>
                </tr>
                <tr>
                    <th>OEの内容１</th>
                    <td><pre><c:out value="${weekreport.weekcontentOe1}" /></pre></td>
                </tr>
                <tr>
                    <th>OEのタグ1</th>
                    <td><c:choose>
                            <c:when test="${weekreport.weekoeFlag1 == 0}">1.目的を考え行動する</c:when>
                            <c:when test="${weekreport.weekoeFlag1 == 1}">2.正しいことを正しく行う</c:when>
                            <c:when test="${weekreport.weekoeFlag1 == 2}">3.臆せず大胆に挑戦する</c:when>
                            <c:when test="${weekreport.weekoeFlag1 == 3}">4.当事者意識を持つ</c:when>
                            <c:when test="${weekreport.weekoeFlag1 == 4}">5.相手軸を意識する</c:when>
                            <c:when test="${weekreport.weekoeFlag1 == 5}">6.礼節をもって接する</c:when>
                            <c:when test="${weekreport.weekoeFlag1 == 6}">7.スピードと質に拘る</c:when>
                            <c:when test="${weekreport.weekoeFlag1 == 7}">8.プロとして学び続ける</c:when>

                        </c:choose>

                        </td>
                </tr>
                <tr>
                    <th>OEの内容２</th>
                    <td><pre><c:out value="${weekreport.weekcontentOe2}" /></pre></td>
                </tr>

                <tr>
                    <th>OEのタグ2</th>
                    <td><c:choose>
                            <c:when test="${weekreport.weekoeFlag2 == 0}">1.目的を考え行動する</c:when>
                            <c:when test="${weekreport.weekoeFlag2 == 1}">2.正しいことを正しく行う</c:when>
                            <c:when test="${weekreport.weekoeFlag2 == 2}">3.臆せず大胆に挑戦する</c:when>
                            <c:when test="${weekreport.weekoeFlag2 == 3}">4.当事者意識を持つ</c:when>
                            <c:when test="${weekreport.weekoeFlag2 == 4}">5.相手軸を意識する</c:when>
                            <c:when test="${weekreport.weekoeFlag2 == 5}">6.礼節をもって接する</c:when>
                            <c:when test="${weekreport.weekoeFlag2 == 6}">7.スピードと質に拘る</c:when>
                            <c:when test="${weekreport.weekoeFlag2 == 7}">8.プロとして学び続ける</c:when>

                        </c:choose>

                        </td>
                </tr>
                <tr>
                    <th>登録日時</th>
                    <fmt:parseDate value="${weekreport.weekcreatedAt}" pattern="yyyy-MM-dd'T'HH:mm:ss" var="weekcreateDay" type="date" />
                    <td><fmt:formatDate value="${weekcreateDay}" pattern="yyyy-MM-dd HH:mm:ss" /></td>
                </tr>
                <tr>
                    <th>更新日時</th>
                    <fmt:parseDate value="${weekreport.weekupdatedAt}" pattern="yyyy-MM-dd'T'HH:mm:ss" var="weekupdateDay" type="date" />
                    <td><fmt:formatDate value="${weekupdateDay}" pattern="yyyy-MM-dd HH:mm:ss" /></td>
                </tr>
            </tbody>
        </table>

        <c:if test="${sessionScope.login_employee.id == weekreport.employee.id}">
            <p>
                <a href="<c:url value='?action=${actWeekRep}&command=${commEdt}&id=${weekreport.id}' />">この週報を編集する</a>
            </p>
        </c:if>

        <p>
            <a href="<c:url value='?action=${actWeekRep}&command=${commIdx}' />">一覧に戻る</a>
        </p>
    </c:param>
</c:import>