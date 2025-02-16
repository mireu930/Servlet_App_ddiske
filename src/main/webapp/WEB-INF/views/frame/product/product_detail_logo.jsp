<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 <div class="header">
    <div class="header_logo_wrap">
      <div class="header_logo">
        <img src="../resources/images/은행.png" height="25">
        <div class="header_logo_title">
          <ul>
            <li><a id="sports1" href="#">은행</a></li>
          </ul>
        </div>
        <div class="header_logo_in">
          <c:if test="${empty user}">
          	<ul>
            <li><a id="log" href="/users/login.do">로그인</a></li>
            <li><a id="menu" href="/users/join.do">회원가입</a></li>
            </ul>
          	</c:if>

          	<c:if test="${not empty user}">
          	<ul>
			<li><a id="log" href ="/users/logout.do">로그아웃</a></li>
			 <li><a id="menu" href ="/users/mypage.do">마이페이지</a></li>
          	</ul>
			</c:if>
        </div>
      </div>
    </div>

    <div class="sport_list_wrap">
      <div class="sport_list">
        <ul>
          <li><a href="../index.do">홈</a></li>
          <li>|</li>
          <li><a href="/accounts/list.do">계좌관리</a></li>
          <li>|</li>
          <li><a href="/products/list.do">상품관리</a></li>

        </ul>
      </div>
    </div>

    <div class="soccer_detail_wrap_wrap">
      <div class="soccer_detail_wrap">
        <div class="soccer_detail">
          <ul>
            <li><a href="./add.do">상품추가</a></li>
            <li>|</li>
            <li><a href="./update.do?productNum=${dto.productNum}">상품수정</a></li>
            <li>|</li>
            <c:if test="${not empty user.user_name and user.user_name == 'sss' }">
            <li><a href="./delete.do?productNum=${dto.productNum}" onclick = "if(!confirm('삭제하시겠습니까?')) return false" class="btn btn-outline-danger btn-sm">상품삭제</a></li>
			</c:if>
          </ul>
        </div>
      </div>
    </div>
  </div>