<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Myjob - Login</title>
    <!-- Custom css -->
    <link rel="stylesheet" href="../css/app.css">
    <!-- Favicon -->
    <link rel="Shortcut Icon"  href="../images/favicon.png"  type="image/x-icon">
    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
    <script src="../js/html5shiv.min.js"></script>
    <script src="../js/respond.min.js"></script>
    <![endif]-->
</head>
<body>
    <!-- Page loader start -->
    <div class="page-loader"></div>
    <!-- Page loader end -->
    <!-- Header start -->
    <header class="main-header">
        <!-- Navbar start -->
        <nav class="navbar">
            <div class="container">
                <!-- Logo start -->
                <a href="../sharple.html" class="navbar-brand">
                    <img src="../images/sharple-logo.png" alt="...">
                </a>
                <!-- Logo end -->
                <!-- Navs start -->
                <div class="navs">
                    <!-- Account nav start -->
                    <ul class="nav navbar-nav account">
                        <li><a href="../login.html"><i class="md-lock-open m-r-10"></i>Login</a></li>
                        <li><a href="../register.html"><i class="md-face m-r-10"></i>Register</a></li>
                    </ul>
                    <!-- Account nav end -->
                    <!-- Main nav start -->
                    <!-- Main nav end -->
                </div>
                <!-- Navs end -->
                <!-- Responsive nav button start -->
                <ul class="nav navbar-nav responsive-btn">
                    <li><a href="#"><i class="md-menu m-r-10"></i></a></li>
                </ul>
                <!-- Responsive nav button end -->
            </div>
        </nav>
        <!-- Navbar end -->
    </header>
    <!-- Header end -->
 
     <section>
        <div class="container">
            <div class="row">
                <div class="col-md-6 col-md-offset-3">
                    <div class="card">
                        <div class="card-body">
                            <h4 class="card-title">회원가입</h4>
                            <form name="regist" id="regist">
                                <div class="form-group">
                                    <div class="input-group">
                                        <div class="input-group-addon">
                                            <i class="md-face"></i>
                                        </div>
                                        <input type="text" id="userId" class="form-control" name="userId" maxlength="12" placeholder="아이디">
                                    </div>
                                </div>
                                <div class="form-group">
                                    <div class="input-group">
                                        <div class="input-group-addon">
                                            <i class="md-face"></i>
                                        </div>
                                        <input type="text" id="userName" class="form-control" name="userName" maxlength="5" placeholder="이름" required>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <div class="input-group">
                                        <div class="input-group-addon">
                                            <i class="md-email"></i>
                                        </div>
                                        <input type="text" id="userEmail" class="form-control" name="userEmail" placeholder="이메일" required>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <div class="input-group">
                                        <div class="input-group-addon">
                                            <i class="md-face"></i>
                                        </div>
                                        <input type="text" id="userPhone" class="form-control" name="userPhone" maxlength="11" placeholder="전화번호" required>
                                    </div>
                                </div>
                                <div class="row">
                                    <div class="col-md-6">
                                        <div class="input-group">
                                            <div class="input-group-addon">
                                                <i class="md-lock"></i>
                                            </div>
                                            <input type="password" id="userPassword" class="form-control" name="userPassword"  maxlength="12" placeholder="비밀번호" required>
                                        </div>
                                    </div>
                                    <div class="col-md-6">
                                        <div class="input-group">
                                            <div class="input-group-addon">
                                                <i class="md-lock"></i>
                                            </div>
                                            <input type="password" id="checkPassword" class="form-control" name="checkPassword" maxlength="12" placeholder="비밀번호 확인" required>
                                        </div>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <button type="button" id="save" name="save" class="btn btn-primary btn-block">회원가입</button>
                                </div>
                            </form>
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
    <script src="../assets/js/jquery/jquery.min.js"></script>
    <script src="../assets/js/jquery/jquery-ui.min.js"></script>
<script src="../js/registValid.js"></script>
<%@include file ="/WEB-INF/jsp/footer.jsp" %>