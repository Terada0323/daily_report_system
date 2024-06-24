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
<c:set var="actComent" value="${ForwardConst.ACT_COMENT.getValue()}" />

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

<h3>【今日の目標】</h3>


        <c:forEach var="report" items="${reports}" varStatus="status">
            <h2>
                <c:out value="${report.tomorrowGoal}" />
            </h2>
        </c:forEach>

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
                    href="<c:url value='?action=${actWeekRep}&command=${commIdx}' />">週報管理</a>
            </p>

        </div>






<%-- <h2>コメント　一覧</h2>
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
--%>



        <h2>コメント一覧</h2>
        <ul>
            <c:forEach var="coment" items="${coments}" varStatus="status">
                <li>
                        <c:out value="${coment.id}"/>

                        <c:out value="${coment.employee.name}"/>
                    ：<c:out value="${coment.title}"></c:out> &gt; <c:out value="${coment.content}" />
                </li>
            </c:forEach>
        </ul>















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

<p id="topbutton">
                <a id="topbuttonlink"
                    href="javascript:newWindow();">メモ管理</a>
        <script>
            function newWindow() {
                window.open("http://localhost:8080/daily_report_system/?action=Memo&command=index", "newWindow", "left=700, top=300, width=500, height=500, scrollbars=1");
            }
        </script>
            </p>



               <p><a href="<c:url value='?action=${actComent}&command=${commNew}' />">コメント作成</a></p>

    </c:param>
</c:import>