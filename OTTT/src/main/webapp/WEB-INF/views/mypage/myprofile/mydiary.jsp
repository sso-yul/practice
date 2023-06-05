<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="path" value="${pageContext.request.contextPath}"/>
<!doctype html>
<html lang="ko">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>게시판</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-aFq/bzH65dt+w6FI2ooMVUpc+21e0SRygnTpmBvdBgSdnuTN7QbdgL+OapgHtvPp" crossorigin="anonymous">
    <link rel="stylesheet" href="${path}/resources/css/mypage/mydiary.css" >
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha2/dist/js/bootstrap.bundle.min.js" integrity="sha384-qKXV1j0HvMUeCBQ+QVp7JcfGl760yU08IQ+GpUo5hlbpg51QRiuqHAJz8+BrxE/N" crossorigin="anonymous"></script>
</head>
<body>
	<div class="wrap">
		<header>
			<div class="logo">
				<a href="<c:url value="/" />">
				  <img src="${path}/resources/images/logo/OTTT.png" alt="로고">
				</a>
			</div>
			<nav class="gnb">
				<ul>
            <li>
              <a href="<c:url value="/genre/movie" />">영화</a>
            </li>
            <li>
              <a href="<c:url value="/genre/drama" />">드라마</a>
            </li>
            <li>
              <a href="<c:url value="/genre/interest" />">예능</a>
            </li>
            <li>
              <a href="<c:url value="/genre/animation" />">애니</a>
            </li>
            <li>
              <a href="<c:url value="/community" />">게시판</a>
            </li>
          </ul>
        </nav>
        <div class="h-icon">
          <ul>
            <li>
              <a href="<c:url value='/search' />">
                <!-- <img src="./images/icon/search02.png" alt="검색"> -->
              </a>
            </li>
            <li>
              <a href="<c:url value='/mypage' />">
                <!-- <img src="./images/icon/user01.png" alt="내 정보"> -->
              </a>
            </li>
          </ul>
        	</div>
		</header>

		<section class="sec01">
			<nav class="mnb">
				<ul>
					<li>
						<a href="<c:url value="/mypage/myreview" />" class="mreview">기록</a>
					</li>
					<li>
					    <a href="<c:url value="/mypage/wishlist" />">찜목록</a>
					</li>
					<li>
					    <a href="<c:url value="/mypage/watched" />">봤어요</a>
					</li>
					<li>
					  	<a href="<c:url value="/mypage/alarm" />">알림함</a>
					</li>
					<li>
					  	<a href="<c:url value="/mypage/message" />">쪽지함</a>
					</li>
				</ul>
            </nav>
		</section>

      	<section class="sec02">
      		<div class="Lcontent">
      			<div class="Lmenu">
      				<ul>
      					<li id="Ldiary">
      						<img class="mimg" src="${path}/resources/images/img/free-icon-diary-6393039.png" alt="다이어리">
      						<a href="<c:url value="/mypage/mydiary" />">나만의 다이어리</a>
   						</li>
   						<li id="Lrivew">
		                	<img class="mimg" src="${path}/resources/images/img/free-icon-review-3501894.png" alt="리뷰">
		                	<a href="<c:url value="/mypage/myreview" />">나의 리뷰</a>
		              	</li>
		              	<li id="Lwrite">
		                	<img class="mimg" src="${path}/resources/images/img/KakaoTalk_20230411_161709664.png" alt="게시글">
		                	<a href="<c:url value="/mycommynity/postcommu" />">내가 쓴 게시글</a>
		              	</li>
		              	<li id="Llike">
			                <img class="mimg" src="${path}/resources/images/img/free-icon-heart-6063477 2.png" alt="좋아요">
			                <a href="<c:url value="/mycommynity/likecommunity" />">좋아요 누른 게시글</a>
			            </li>
		    	        <li id="Lcomments">
		                	<img class="mimg" src="${path}/resources/images/img/comment.png" alt="댓글">
		                	<a href="<c:url value="/mycommynity/comment" />">나의 댓글</a>
		              	</li>
	              	</ul>
              	</div>
           	</div>     

	        <div class="main">
	        	<div class="main-head">
	        		<a href="<c:url value="/mypage/mydiary/create" />" class="write">글쓰기</a>
	          	</div>
	          	<div class="post">
	            	<a href="<c:url value="/mypage/mydiary/poster" />" class="review">
	            	<div class="Lside">
	            		<img class="poster" src="${path}/resources/images/poster/lala.jfif" alt="라라랜드">
	              	</div>
	              	<div class="Rside">
	              		<div class="rv-head">
		                  <span class="title">라라랜드</span>
		                  <img class="star" src="./images/icon/point.png" alt="별점">
		                </div>
	
		                <div class="rv-main">
		                  <span>내용</span>
		                </div>
	                </div>
	                </a>
                </div>

				<div class="post">
		            <a href="#" class="review">
		            <div class="Lside">
						<img class="poster" src="./images/poster/killing.jpg" alt="킬링디어">
		            </div>
		            <div class="Rside">
		            	<div class="rv-head">
		            		<span class="title">킬링디어</span>
		                  	<img class="star" src="./images/icon/point.png" alt="별점">
		                </div>
		
		                <div class="rv-main">
		                  <span>내용</span>
		                </div>
	                </div>
		            </a>
				</div>

	          	<div class="post">
	            	<a href="#" class="review">
					<div class="Lside">
	                	<img class="poster" src="./images/poster/thgolry.jpg" alt="더글로리">
	                </div>
	              	<div class="Rside">
	                	<div class="rv-head">
	                		<span class="title">더글로리</span>
	                  		<img class="star" src="./images/icon/point.png" alt="별점">
                  		</div>
	               		<div class="rv-main">
	               			<span>내용</span>
		                </div>
                	</div>
	            	</a>
	          	</div>
          	</div>
       	</section>
   	</div>

</body>
</html>