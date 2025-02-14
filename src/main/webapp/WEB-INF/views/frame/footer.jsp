<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="footer">
    <div class="footer_top_wrap">
      <div class="footer_top">
        <div class="footer_top_notice">
          <div id="notice_text">공지사항</div>
          <div id="notice_detail"><a href="#">[공식] 아무노래나일단틀어</a></div>
        </div>
        <div class="footer_list">
          <ul>
            <li><a href="index.do">홈</a></li>
            <li><a href="/accounts/list.do">계좌관리</a></li>
            <li><a href="/products/list.do">상품관리</a></li>
          </ul>
        </div>
      </div>
    </div>
    <div class="footer_bottom">
      <div class="footer_bottom_list">
      <ul>
        <c:if test="${empty user}">
          	<ul>
            <li><a id="log" href="/users/login.do">로그인</a></li>
            </ul>
          	</c:if>

          	<c:if test="${not empty user}">
          	<ul>
			<li><a id="log" href ="/users/logout.do">로그아웃</a></li>
          	</ul>
			</c:if>
        <li><a href="#">전체서비스</a></li>
        <li><a href="#">고객센터</a></li>
        <li><a href="#">문제신고</a></li>
        <li style = "font-weight: bold;"><a href="#">개인정보처리방침</a></li>
        <!-- <li><a href="#">기사배열 책임자</a></li> -->
        <li>청소년보호 책임자</li>
      </ul>
      <div class = "footer_bottom_notice">
        본 콘텐츠의 저작권은 제공처 또는 나에게 있으며, 이를 무단 이용하는 경우 저작권법 등에 따라 법적 책임을 질 수 있습니다.
      </div>
      <div class = "footer_bottom_logo">
        © Bank Corp.
      </div>
    </div>
    
    </div>
    </div>