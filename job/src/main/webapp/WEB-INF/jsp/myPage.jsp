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

     <section>
        <div class="container">
            <div class="row">
                <div class="col-md-6 col-md-offset-3">
                    <div class="card">
                        <div class="card-body">
                            <h4 class="card-title">회원 정보 수정</h4>
                            <form name="update" method="post" action="/updateUserInfo" id="update">
                                <div class="form-group">
                                    <div class="input-group">
                                        <div class="input-group-addon">
                                            <i class="md-face"></i>
                                        </div>
                                        <input type="text" id="userId" class="form-control" name="userId" value="<%=id%>" readonly>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <div class="input-group">
                                        <div class="input-group-addon">
                                            <i class="md-face"></i>
                                        </div>
                                        <input type="text" id="userName" class="form-control" name="userName" value="<%=name%>">
                                    </div>
                                </div>
                                <div class="form-group">
                                    <div class="input-group">
                                        <div class="input-group-addon">
                                            <i class="md-email"></i>
                                        </div>
                                        <input type="text" id="userEmail" class="form-control" name="userEmail" value="<%=email%>" required>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <div class="input-group">
                                        <div class="input-group-addon">
                                            <i class="md-face"></i>
                                        </div>
                                        <input type="text" id="userPhone" class="form-control" name="userPhone" value="<%=phone%>" required>
                                    </div>
                                </div>
                                <div class="row">
                                    <div class="col-md-6">
                                        <div class="input-group">
                                            <div class="input-group-addon">
                                                <i class="md-lock"></i>
                                            </div>
                                            <input type="password" id="password" class="form-control" name="password" value="<%=password%>" required>
                                        </div>
                                    </div>
                                    <div class="col-md-6">
                                        <div class="input-group">
                                            <div class="input-group-addon">
                                                <i class="md-lock"></i>
                                            </div>
                                            <input type="password" id="checkPassword" class="form-control" name="checkPassword" value="<%=password%>" required>
                                        </div>
                                    </div>
                                </div>
                              
                                <div class="form-group">
                                    <button type="submit" onclick="javascript:update(); return false;" class="btn btn-primary btn-block">나의 정보 수정하기</button>
                                </div>
                            </form>
                              <div class="form-group">
                                    <button type="submit" onClick="location.href='/createWeight';" class="btn btn-primary btn-block">채용점수 수정하기</button>
                                </div>
                            <ul class="list-inline">
                                <li><a href="login.html">로그인</a></li>
                                <li class="pull-right"><a href="forget.html">비밀번호 찾기</a></li>
                            </ul>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </section>
 
<%@include file ="/WEB-INF/jsp/footer.jsp" %>