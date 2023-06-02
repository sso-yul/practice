<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="path" value="${pageContext.request.contextPath}"/>
<!doctype html>
<html lang="ko">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Netflix</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-aFq/bzH65dt+w6FI2ooMVUpc+21e0SRygnTpmBvdBgSdnuTN7QbdgL+OapgHtvPp" crossorigin="anonymous">
    <link rel="stylesheet" href="${path}/resources/css/community/priceInfo/priceNetflix.css" >
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha2/dist/js/bootstrap.bundle.min.js" integrity="sha384-qKXV1j0HvMUeCBQ+QVp7JcfGl760yU08IQ+GpUo5hlbpg51QRiuqHAJz8+BrxE/N" crossorigin="anonymous"></script>
  </head>

<!--  body  --------------------->
  <body style="background-color: #202020;">
     <div class="wrap">
      <header >
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
              <a href="<c:url value="/community/freecommunity" />" style="color: #33ff33;">게시판</a>
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
      <div id="line-1" >
        <nav class="nav">
          <a class="nav-link1" href="<c:url value='/community/freecommunity' />">자유게시판</a>
          <a class="nav-link1" href="<c:url value='/community/endmovie/tving' />">종료예정작</a>
          <a class="nav-link1" href="<c:url value='/community/priceInfoTving' />" style="color: #33ff33;">가격정보</a>
          <a class="nav-link1" href="<c:url value='/community/QnA' />">Q&A</a>
          <a class="nav-link1" href="<c:url value='/community/notice' />">공지사항</a>
        </nav>
      </div>
      <div id="line-2" >
        <nav class="nav2">
          <a class="nav-link2" href="<c:url value='/community/priceInfoTving' />"><img class="ott_icon" src="${path}/resources/images/icon/티빙.png" alt="tving"></a>
          <a class="nav-link2" href="<c:url value='/community/priceInfoNetflix' />"><img class="ott_icon" src="${path}/resources/images/icon/netplix.png" alt="netflix" style="border: 3px solid #33ff33;border-radius: 15px;"></a>
          <a class="nav-link2" href="<c:url value='/community//priceInfoWavve' />"><img class="ott_icon" src="${path}/resources/images/icon/웨이브.png" alt="wavve"></a>
          <a class="nav-link2" href="<c:url value='/community/priceInfoCoupang' />"><img class="ott_icon" src="${path}/resources/images/icon/쿠팡플레이.png" alt="coupang"></a>
          <a class="nav-link2" href="<c:url value='/community/priceInfoWatcha' />"><img class="ott_icon" src="${path}/resources/images/icon/왓챠.png" alt="watcha" ></a>
          <a class="nav-link2" href="<c:url value='/community/priceInfoDisney' />"><img class="ott_icon" src="${path}/resources/images/icon/디즈니플러스.png" alt="disney"></a>
        </nav>
      </div>
      <div class="voucher-inner-wrap">
        <section>
          <table class="vouchar-table">
              <tr>
                <th></th>
                  <td style="text-align: center;">기능</td>
                </tr>
              <tr>
                <th>광고형 베이식<br>월 5,500원</th>
                <td>
                <ul>
                  <li>• 광고지원, 일부 영화 및 시리즈 이용불가, 모바일 게임 무제한 이용</li>
                  <li>• 지원되는 디바이스에서 동시접속 1명까지 시청가능</li>
                  <li>• HD로 시청 가능</li>
                </ul>
                </td>
              </tr>
              <tr>
                <th>베이식<br>월 9,500원</th>
                <td>
                <ul>
                  <li>• 광고 없이 영화, 시리즈, 모바일 게임 무제한 이용</li>
                  <li>• 지원되는 디바이스에서 동시접속 1명까지 시청 가능</li>
                  <li>• HD로 시청 가능</li>
                  <li>• 한 번에 1대의 지원되는 디바이스에서 콘텐츠 저장 가능</li>
                </ul>
                </td>
              </tr>
              <tr>
                <th>스탠다드<br>월 13,500원</th>
                <td>
                  <ul>
                    <li>• 광고 없이 영화, 시리즈, 모바일 게임 무제한 이용</li>
                    <li>• 지원되는 디바이스에서 동시접속 2명까지 시청 가능</li>
                    <li>• 풀 HD로 시청 가능</li>
                    <li>• 한 번에 2대의 지원되는 디바이스에서 콘텐츠 저장 가능</li>
                  </ul>
                  </td>
              </tr>
              <tr>
                <th>프리미엄<br>월 17,000원</th>
                <td>
                <ul>
                  <li>• 광고 없이 영화, 시리즈, 모바일 게임 무제한 이용</li>
                  <li>• 지원되는 디바이스에서 동시접속 4명까지 시청 가능</li>
                  <li>• UHD로 시청 가능</li>
                  <li>• 한 번에 6대의 지원되는 디바이스에서 콘텐츠 저장 가능</li>
                  <li>• 넷플릭스 공간 음향</li>
                </ul>
                </td>
              </tr>
          </table>
        </section>
        <section>
          <h4>*광고형 멤버십</h4>
          <ul>
            <li>넷플릭스 광고형 멤버십을 사용하여 저렴한 요금으로 영화와 시리즈를 즐길 수 있습니다.</li>
            <li>넷플릭스의 다른 광고 없는 멤버십과는 달리, 대부분의 시리즈 및 영화 재생 전 또는 재생 중에 광고가 표시됩니다.<br>
              일부 영화 및 시리즈는 라이선스가 제한되어 시청할 수 없으며, 콘텐츠를 저장할 수는 없습니다.</li>
            <li> 참고)넷플릭스의 광고 없는 멤버십을 지원하는 디바이스 중 일부 소수의 디바이스에서는 넷플릭스 광고형 멤버십을 지원하지 않습니다.<br>
              이는 해당 디바이스의 넷플릭스 앱 또는 소프트웨어가 광고를 지원하는 버전으로 업데이트될 수 없는 경우입니다.</li>
            <a href="https://help.netflix.com/ko/node/126831">자세히 알아보기</a>
          </ul>
        </section>
      </div>
    </div>
  </body>

</html>
