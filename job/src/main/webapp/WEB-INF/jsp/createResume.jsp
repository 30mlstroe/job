<%@page import="job.model.joinus.dto.JoinUsDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file ="/WEB-INF/jsp/header.jsp" %>
<%
   JoinUsDTO user = (JoinUsDTO)session.getAttribute("user");
   String id = user.getUser_id();
   String name = user.getUser_name();
   String email = user.getUser_email();
   String phone = user.getUser_phone();
   String password = user.getUser_pw();
   
%>
    <section class="page-header lighten-4" style="background: url(../images/cover-1.jpg)">
        <div class="container">
            <h2>새 이력서 쓰기</h2>
        </div>
    </section>
    <section>
        <div class="container">
            <form name="saveResume" method="post" action="/saveResume" id="saveResume">
                <div class="card">
                    <div class="card-body">
                        <div class="row">
                            <!-- <div class="col-md-3">
                                <div class="content-row">
                                    <div class="img-preview h300" style="background: url(http://localhost/themeforest/personal/assets/images/user/user-2.jpg) 50% 0">
                                        <i class="icon md-plus"></i>
                                        <input type="file">
                                    </div>
                                </div>
                            </div> -->
                            <div class="col-md-9">
                                <div class="content-row">
                                    <h5 class="m-b-15">기본 정보</h5>
                                    <div class="form-group">
                                        <input type="text" id="name" class="form-control" name="name" value="<%=name%>">
                                    </div>
                                    <div class="form-group">
                                        <input type="text" id="previousCareer" class="form-control" name="previousCareer" placeholder="최근 경력 회사 규모" required>
                                    </div>
                                    
                                    <div class="form-group">
                                        <input type="text" id="title" class="form-control" name="title" placeholder="이력서 제목" required>
                                    </div>
                                    <div class="row">
                                        <div class="col-md-6">
                                            <div class="input-group">
                                        <span class="input-group-addon">
                                            <i class="md-cake"></i>
                                        </span>
                                                <input type="text" onKeyup="this.value=this.value.replace(/[^0-9]/g,'');" id="age" class="form-control" name="age" placeholder="나이" required>
                                            </div>
                                        </div>
                                        <div class="col-md-6">
                                            <div class="input-group">
                                        <span class="input-group-addon">
                                            <i class="md-cake"></i>
                                        </span>
                                                <select id="sex" class="form-control" name="sex" required>
                                                       <option value="">성별</option>
                                                       <option value="남자">남자</option>
                                                       <option value="여자">여자</option>
                                                </select>
                                            </div>
                                        </div>
                                        <div class="row">
                                           <div class="col-md-6">
                                              <div class="form-group">
                                                  <select id="marry" name="marry" class="form-control" required>
                                                      <option value="">혼인 여부</option>
                                                       <option value="미혼">미혼</option>
                                                       <option value="기혼">기혼</option>
                                                       <option value="사별">사별</option>
                                                   </select>
                                               </div>
                                           </div>
                                           <div class="col-md-6">
                                              <div class="form-group">
                                                  <select id="army" name="army" class="form-control" required>
                                                      <option value="">병역 의무 이행 선택</option>
                                                       <option value="육군 만기 전역">육군 만기 전역</option>
                                                       <option value="해군 만기 전역">해군 만기 전역</option>
                                                       <option value="공군 만기 전역">공군 만기 전역</option>
                                                       <option value="의경 만기 전역">의경 만기 전역</option>
                                                       <option value="사회복무요원 만기 전역">사회복무요원 만기 전역</option>
                                                       <option value="의가사 전역">의가사 전역</option>
                                                       <option value="군 면제">군 면제</option>
                                                   </select>
                                               </div>
                                           </div>
                                        </div>
                                        
                                        <div class="row">
                                           <div class="col-md-6">
                                              <div class="form-group">
                                                  <select id="finalGraduation" name="finalGraduation" class="form-control" required>
                                                      <option value="">최종 학력</option>
                                                       <option value="고졸">고졸</option>
                                                       <option value="학사">학사</option>
                                                       <option value="석사">석사</option>
                                                       <option value="박사">박사</option>
                                                   </select>
                                               </div>
                                           </div>
                                           <div class="col-md-6">
                                              <div class="form-group">
                                                  <select id="graduatedYear" name="graduatedYear" class="form-control" required>
                                                      <option value="">졸업 연도</option>
                                                       <option value="1990">1990</option>
                                                       <option value="1991">1991</option>
                                                       <option value="1992">1992</option>
                                                       <option value="1993">1993</option>
                                                       <option value="1994">1994</option>
                                                       <option value="1995">1995</option>
                                                       <option value="1996">1996</option>
                                                       <option value="1997">1997</option>
                                                       <option value="1999">1998</option>
                                                       <option value="2000">2000</option>
                                                       <option value="2001">2001</option>
                                                       <option value="2002">2002</option>
                                                       <option value="2003">2003</option>
                                                       <option value="2004">2004</option>
                                                       <option value="2005">2005</option>
                                                       <option value="2006">2006</option>
                                                       <option value="2007">2007</option>
                                                       <option value="2008">2008</option>
                                                       <option value="2009">2009</option>
                                                       <option value="2010">2010</option>
                                                       <option value="2011">2011</option>
                                                       <option value="2012">2012</option>
                                                       <option value="2013">2013</option>
                                                       <option value="2014">2014</option>
                                                       <option value="2015">2015</option>
                                                       <option value="2016">2016</option>
                                                       <option value="2017">2017</option>
                                                       <option value="2018">2018</option>
                                                       <option value="2019">2019</option>
                                                       <option value="2020">2020</option>
                                                   </select>
                                               </div>
                                           </div>
                                        </div>
                                    </div>
                                    <div class="row">
                                        <div class="col-md-6">
                                            <div class="input-group">
                                                <input type="text" id="schoolName" class="form-control" name="schoolName" placeholder="최종 졸업 학교 이름" required>
                                            </div>
                                        </div>
                                        <div class="col-md-6">
                                            <div class="input-group">
                                                <input type="text" id="schoolRegion" class="form-control" name="schoolRegion" placeholder="학교 소재 지역" required>
                                            </div>
                                        </div>
                                        <div class="col-md-6">
                                           <div class="form-group">
                                               <select id="whetherGraduated" name="whetherGraduated" class="form-control" required>
                                                   <option value="">졸업 여부</option>
                                                    <option value="졸업 예정">졸업 예정</option>
                                                      <option value="졸업">졸업</option>
                                                      <option value="휴학">휴학</option>
                                                    <option value="재학">재학</option>
                                                </select>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                                <div class="content-row">
                                    <h5 class="m-b-15">연락처 정보</h5>
                                    <div class="row">
                                        <div class="col-md-6">
                                            <div class="input-group">
                                        <span class="input-group-addon">
                                            <i class="md-pin"></i>
                                        </span>
                                                <input type="text" id="zipcode" class="form-control" name="zipcode" placeholder="우편 변호" readonly>
                                            </div>
                                        </div>
                                         <div class="col-md-6">
                                            <div class="input-group">
                                           	 <button type="button" onclick="goPopup();">주소 검색</button>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="row">
                                        <div class="col-md-6">
                                            <div class="input-group">
                                        <span class="input-group-addon">
                                            <i class="md-pin"></i>
                                        </span>
                                                <input type="text" id="address1" class="form-control" name="address1" placeholder="주소" required>
                                            </div>
                                        </div>
                                        <div class="col-md-6">
                                            <div class="input-group">
                                        <span class="input-group-addon">
                                            <i class="md-link"></i>
                                        </span>
                                                <input type="text" id="address2" class="form-control" name="address2" placeholder="상세 주소" required>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="row">
                                        <div class="col-md-6">
                                            <div class="input-group">
                                        <span class="input-group-addon">
                                            <i class="md-email"></i>
                                        </span>
                                                <input type="text"  id="email" class="form-control" name="email" value="<%=email%>">
                                            </div>
                                        </div>
                                        <div class="col-md-6">
                                            <div class="input-group">
                                        <span class="input-group-addon">
                                            <i class="md-phone"></i>
                                        </span>
                                                <input type="text" id="phone" class="form-control" name="phone" value="<%=phone%>">
                                            </div>
                                        </div>
                                    </div>
                                </div>
                                <div class="content-row">
                                    <h5 class="m-b-15">희망 직무 정보</h5>
                                    <div class="row">
                                        <div class="col-md-6">
                                           <div class="form-group">
                                               <select id="jobName1" name="jobName1" class="form-control" required>
                                                   <option value="">1지망 직업명</option>
                                                    <option value="시스템 소프트웨어 개발자">시스템 소프트웨어 개발자</option>
                                                      <option value="시스템 소프트웨어 개발자(프로그래머)">시스템 소프트웨어 개발자(프로그래머)</option>
                                                      <option value="펌웨어 및 임베디드 소프트웨어 프로그래머">펌웨어 및 임베디드 소프트웨어 프로그래머</option>
                                                    <option value="응용 소프트웨어 개발자">응용 소프트웨어 개발자</option>
                                                    <option value="JAVA 프로그래밍 언어 전문가">JAVA 프로그래밍 언어 전문가</option>
                                                    <option value="C언어 및 그 외 프로그래밍 언어 전문가">C언어 및 그 외 프로그래밍 언어 전문가</option>
                                                    <option value="범용 응용 소프트웨어 프로그래머(ERP,정보처리,재무관리 등)">범용 응용 소프트웨어 프로그래머(ERP,정보처리,재무관리 등)</option>
                                                    <option value="산업특화 응용 소프트웨어 프로그래머(국방,항공,교통,에너지,금융,자동차 등)">산업특화 응용 소프트웨어 프로그래머(국방,항공,교통,에너지,금융,자동차 등)</option>
                                                    <option value="네트워크 프로그래머">네트워크 프로그래머</option>
                                                    <option value="게임 프로그래머">게임 프로그래머</option>
                                                    <option value="모바일 애플리케이션 프로그래머(앱·어플 개발)">모바일 애플리케이션 프로그래머(앱·어플 개발)</option>
                                                    <option value="웹 개발자">웹 개발자</option>
                                                    <option value="웹 개발자(웹 엔지니어·웹 프로그래머)">웹 개발자(웹 엔지니어·웹 프로그래머)</option>
                                                    <option value="웹 기획자">웹 기획자</option>
                                                    <option value="IT 테스터 및 IT QA 전문가">IT 테스터 및 IT QA 전문가</option>
                                                    <option value="데이터 전문가">데이터 전문가</option>
                                                    <option value="데이터 설계 및 프로그래머">데이터 설계 및 프로그래머</option>
                                                    <option value="데이터 분석가(빅데이터 분석가)">데이터 분석가(빅데이터 분석가)</option>
                                                    <option value="데이터베이스 운영·관리자">데이터베이스 운영·관리자</option>
                                                    <option value="네트워크 시스템 개발자">네트워크 시스템 개발자</option>
                                                    <option value="정보시스템 운영자">정보시스템 운영자</option>
                                                    <option value="네트워크 관리자(클라우딩컴퓨터운영관리자)">네트워크 관리자(클라우딩컴퓨터운영관리자)</option>
                                                    <option value="IT 기술지원 전문가">IT 기술지원 전문가</option>
                                                    <option value="웹 운영자(홈페이지 관리자)">웹 운영자(홈페이지 관리자)</option>
                                                    <option value="디지털 포렌식 전문가 및 기타 데이터·네트워크 전문가">디지털 포렌식 전문가 및 기타 데이터·네트워크 전문가</option>
                                                    <option value="정보보안 전문가">정보보안 전문가</option>
                                                    <option value="침해사고 대응 전문가">침해사고 대응 전문가</option>
                                                    <option value="통신·방송송출 장비 기사">통신·방송송출 장비 기사</option>
                                                </select>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="row">
                                        <div class="col-md-6">
                                           <div class="form-group">
                                               <select id="jobName2" name="jobName2" class="form-control" required>
                                                   <option value="">2지망 직업명</option>
                                                    <option value="시스템 소프트웨어 개발자">시스템 소프트웨어 개발자</option>
                                                      <option value="시스템 소프트웨어 개발자(프로그래머)">시스템 소프트웨어 개발자(프로그래머)</option>
                                                      <option value="펌웨어 및 임베디드 소프트웨어 프로그래머">펌웨어 및 임베디드 소프트웨어 프로그래머</option>
                                                    <option value="응용 소프트웨어 개발자">응용 소프트웨어 개발자</option>
                                                    <option value="JAVA 프로그래밍 언어 전문가">JAVA 프로그래밍 언어 전문가</option>
                                                    <option value="C언어 및 그 외 프로그래밍 언어 전문가">C언어 및 그 외 프로그래밍 언어 전문가</option>
                                                    <option value="범용 응용 소프트웨어 프로그래머(ERP,정보처리,재무관리 등)">범용 응용 소프트웨어 프로그래머(ERP,정보처리,재무관리 등)</option>
                                                    <option value="산업특화 응용 소프트웨어 프로그래머(국방,항공,교통,에너지,금융,자동차 등)">산업특화 응용 소프트웨어 프로그래머(국방,항공,교통,에너지,금융,자동차 등)</option>
                                                    <option value="네트워크 프로그래머">네트워크 프로그래머</option>
                                                    <option value="게임 프로그래머">게임 프로그래머</option>
                                                    <option value="모바일 애플리케이션 프로그래머(앱·어플 개발)">모바일 애플리케이션 프로그래머(앱·어플 개발)</option>
                                                    <option value="웹 개발자">웹 개발자</option>
                                                    <option value="웹 개발자(웹 엔지니어·웹 프로그래머)">웹 개발자(웹 엔지니어·웹 프로그래머)</option>
                                                    <option value="웹 기획자">웹 기획자</option>
                                                    <option value="IT 테스터 및 IT QA 전문가">IT 테스터 및 IT QA 전문가</option>
                                                    <option value="데이터 전문가">데이터 전문가</option>
                                                    <option value="데이터 설계 및 프로그래머">데이터 설계 및 프로그래머</option>
                                                    <option value="데이터 분석가(빅데이터 분석가)">데이터 분석가(빅데이터 분석가)</option>
                                                    <option value="데이터베이스 운영·관리자">데이터베이스 운영·관리자</option>
                                                    <option value="네트워크 시스템 개발자">네트워크 시스템 개발자</option>
                                                    <option value="정보시스템 운영자">정보시스템 운영자</option>
                                                    <option value="네트워크 관리자(클라우딩컴퓨터운영관리자)">네트워크 관리자(클라우딩컴퓨터운영관리자)</option>
                                                    <option value="IT 기술지원 전문가">IT 기술지원 전문가</option>
                                                    <option value="웹 운영자(홈페이지 관리자)">웹 운영자(홈페이지 관리자)</option>
                                                    <option value="디지털 포렌식 전문가 및 기타 데이터·네트워크 전문가">디지털 포렌식 전문가 및 기타 데이터·네트워크 전문가</option>
                                                    <option value="정보보안 전문가">정보보안 전문가</option>
                                                    <option value="침해사고 대응 전문가">침해사고 대응 전문가</option>
                                                    <option value="통신·방송송출 장비 기사">통신·방송송출 장비 기사</option>
                                                </select>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="row">
                                        <div class="col-md-6">
                                           <div class="form-group">
                                               <select id="jobName3" name="jobName3" class="form-control" required>
                                                   <option value="">3지망 직업명</option>
                                                    <option value="시스템 소프트웨어 개발자">시스템 소프트웨어 개발자</option>
                                                      <option value="시스템 소프트웨어 개발자(프로그래머)">시스템 소프트웨어 개발자(프로그래머)</option>
                                                      <option value="펌웨어 및 임베디드 소프트웨어 프로그래머">펌웨어 및 임베디드 소프트웨어 프로그래머</option>
                                                    <option value="응용 소프트웨어 개발자">응용 소프트웨어 개발자</option>
                                                    <option value="JAVA 프로그래밍 언어 전문가">JAVA 프로그래밍 언어 전문가</option>
                                                    <option value="C언어 및 그 외 프로그래밍 언어 전문가">C언어 및 그 외 프로그래밍 언어 전문가</option>
                                                    <option value="범용 응용 소프트웨어 프로그래머(ERP,정보처리,재무관리 등)">범용 응용 소프트웨어 프로그래머(ERP,정보처리,재무관리 등)</option>
                                                    <option value="산업특화 응용 소프트웨어 프로그래머(국방,항공,교통,에너지,금융,자동차 등)">산업특화 응용 소프트웨어 프로그래머(국방,항공,교통,에너지,금융,자동차 등)</option>
                                                    <option value="네트워크 프로그래머">네트워크 프로그래머</option>
                                                    <option value="게임 프로그래머">게임 프로그래머</option>
                                                    <option value="모바일 애플리케이션 프로그래머(앱·어플 개발)">모바일 애플리케이션 프로그래머(앱·어플 개발)</option>
                                                    <option value="웹 개발자">웹 개발자</option>
                                                    <option value="웹 개발자(웹 엔지니어·웹 프로그래머)">웹 개발자(웹 엔지니어·웹 프로그래머)</option>
                                                    <option value="웹 기획자">웹 기획자</option>
                                                    <option value="IT 테스터 및 IT QA 전문가">IT 테스터 및 IT QA 전문가</option>
                                                    <option value="데이터 전문가">데이터 전문가</option>
                                                    <option value="데이터 설계 및 프로그래머">데이터 설계 및 프로그래머</option>
                                                    <option value="데이터 분석가(빅데이터 분석가)">데이터 분석가(빅데이터 분석가)</option>
                                                    <option value="데이터베이스 운영·관리자">데이터베이스 운영·관리자</option>
                                                    <option value="네트워크 시스템 개발자">네트워크 시스템 개발자</option>
                                                    <option value="정보시스템 운영자">정보시스템 운영자</option>
                                                    <option value="네트워크 관리자(클라우딩컴퓨터운영관리자)">네트워크 관리자(클라우딩컴퓨터운영관리자)</option>
                                                    <option value="IT 기술지원 전문가">IT 기술지원 전문가</option>
                                                    <option value="웹 운영자(홈페이지 관리자)">웹 운영자(홈페이지 관리자)</option>
                                                    <option value="디지털 포렌식 전문가 및 기타 데이터·네트워크 전문가">디지털 포렌식 전문가 및 기타 데이터·네트워크 전문가</option>
                                                    <option value="정보보안 전문가">정보보안 전문가</option>
                                                    <option value="침해사고 대응 전문가">침해사고 대응 전문가</option>
                                                    <option value="통신·방송송출 장비 기사">통신·방송송출 장비 기사</option>
                                                </select>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="row">
                                        <div class="col-md-6">
                                           <div class="form-group">
                                               <select id="employmentType" name="employmentType" class="form-control" required>
                                                   <option value="">희망 고용 형태</option>
                                                    <option value="정규직">정규직</option>
                                                      <option value="계약직">계약직</option>
                                                      <option value="프리랜서">프리랜서</option>
                                                      <option value="채용연계형 인턴">채용연계형 인턴</option>
                                                      <option value="체험형 인턴">체험형 인턴</option>
                                                </select>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="row">
                                       <div class="col-md-6">
                                            <div class="input-group">
                                           		 연봉(단위 만원) :
                                                <input type="text" id="hopeSalary" maxlength="4" onKeyup="this.value=this.value.replace(/[^0-9]/g,'');" class="form-control" name="hopeSalary" placeholder="희망 급여">
                                            </div>
                                        </div>
                                        <!-- <div class="col-md-6">
                                           <div class="form-group">
                                               <select id="salaryType" name="salaryType" class="form-control" required>
                                                   <option value="">급여 종류</option>
                                                    <option value="연봉">연봉(단위 만원)</option>
                                                </select>
                                            </div>
                                        </div> -->
                                    </div>
                                    <div class="row">
                                       <div class="col-md-6">
                                           <div class="form-group">
                                               <select id="hopeCompanySize" name="hopeCompanySize" class="form-control" required>
                                                   <option value="">희망 회사 규모</option>
                                                    <option value="대기업">대기업</option>
                                                      <option value="중소기업">중소기업</option>
                                                      <option value="공기업">공기업</option>
                                                </select>
                                            </div>
                                        </div>
                                        <!-- <div class="col-md-6">
                                           <div class="form-group">
                                               <select id="guinType" name="guinType" class="form-control" required>
                                                   <option value="">구인 등급 책정</option>
                                                    <option value="정규직">정규직</option>
                                                      <option value="계약직">계약직</option>
                                                      <option value="프리랜서">프리랜서</option>
                                                      <option value="인턴">인턴</option>
                                                </select>
                                            </div>
                                        </div> -->
                                    </div>
                                    <div class="row">
                                       <div class="col-md-6">
                                           <div class="form-group">
                                               <select id="enterType" name="enterType" class="form-control" required>
                                                   <option value="">희망 직급</option>
                                                    <option value="사원">사원</option>
                                                      <option value="대리">대리</option>
                                                      <option value="선임">선임</option>
                                                      <option value="과장">과장</option>
                                                      <option value="책임">책임</option>
                                                      <option value="차장">차장</option>
                                                      <option value="부장">부장</option>
                                                      <option value="수석">수석</option>
                                                      <option value="상무">상무</option>
                                                </select>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <!-- Works Experience start -->
                <div class="card">
                    <div class="card-body">
                        <h4 class="card-title">경력 사항</h4>
                        <div id="career_1"></div>
                        <div id="career_2"></div>
                        <div id="career_3"></div>
                        <div id="career_4"></div>
                        <div id="btnAddCareer"></div>
                    </div>
                </div>
                <!-- Works Experience finish -->
                <!-- Skills start -->
                <div class="card">
                    <div class="card-body">
                        <h4 class="card-title">취득 자격</h4>
                        <div class="card bg-grey lighten-4">
                            <div class="card-body">
                                <div class="row">
                                        입력 형태 ex) : 컴퓨터활용능력 2급, 정보처리산업기사, 정보처리기사 
                                    <div class="col-md-6">
                                        <div class="form-group">
                                            <input type="text" id="certificationList" name="certificationList" class="form-control" placeholder="보유 자격증 목록을 적어주세요.">
                                        </div>
                                    </div>
                                </div>
                                <div class="row">
                                    <div class="col-md-6">
                                        <div class="form-group">
                                        Word level
                                            <select id="wordSkill" name="wordSkill" class="form-control" required>
                                                   <option value="">워드 숙련도</option>
                                                    <option value="상">상</option>
                                                      <option value="중">중</option>
                                                      <option value="하">하</option>
                                            </select>
                                        </div>
                                    </div>
                                    <div class="col-md-6">
                                        <div class="form-group">
                                            PowerPoint level
                                            <select id="pptSkill" name="pptSkill" class="form-control" required>
                                                   <option value="">파워포인트 숙련도</option>
                                                    <option value="상">상</option>
                                                      <option value="중">중</option>
                                                      <option value="하">하</option>
                                            </select>
                                        </div>
                                    </div>
                                </div>
                                <div class="row">
                                    <div class="col-md-6">
                                        <div class="form-group">
                                        Excel level
                                            <select id="excelSkill" name="excelSkill" class="form-control" required>
                                                   <option value="">엑셀 숙련도</option>
                                                    <option value="상">상</option>
                                                      <option value="중">중</option>
                                                      <option value="하">하</option>
                                            </select>
                                        </div>
                                    </div>
                                    <div class="col-md-6">
                                        <div class="form-group">
                                            Searching level
                                            <select id="searchingSkill" name="searchingSkill" class="form-control" required>
                                                   <option value="">검색 능력</option>
                                                    <option value="상">상</option>
                                                      <option value="중">중</option>
                                                      <option value="하">하</option>
                                            </select>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="card">
                    <div class="card-body">
                        <h4 class="card-title">자기 소개서</h4>
                        <div class="card bg-grey lighten-4">
                            <div class="card-body">
                                <div class="row">
                                            <textarea id="profile" name="profile" style="width:100%;height:100;border:50;overflow:visible;text-overflow:ellipsis;"></textarea>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <!-- Skills finish -->                
                <div class="col-sm-4 col-sm-offset-4 col-xs-6 col-xs-offset-3">
                    <button type="submit" onclick="/saveResume" class="btn btn-primary btn-block btn-lg m-t-20">다음</button>
                </div>
            </form>
        </div>
    </section>
 <script src="../js/addCareer.js"></script>
 <script src="https://code.jquery.com/jquery-3.5.0.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
 <!-- <script src="../js/createResume.js"></script> -->
<%@include file ="/WEB-INF/jsp/footer.jsp" %>