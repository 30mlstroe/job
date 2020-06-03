<%@page import="job.model.joinus.dto.JoinUsDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@include file ="/WEB-INF/jsp/header.jsp" %>
     <script src="/js/axios.js"></script>
     <script src="/js/education.js"></script>
    <section class="page-header darken-2" style="background: url(../images/cover-2.jpg)">
        <div class="container">
            <header class="section-header text-white">
                <h2>채용 공고 확인</h2>
                <p>Find jobs that suit you</p>
            </header>
            <div class="row">
                <div class="col-md-4 col-sm-6">
                    <div class="form-group">
                        <div class="input-group input-group-lg">
                            <div class="input-group-addon">
                                <i class="md-tag"></i>
                            </div>
                            <form action="/facebook" method="get">
                            	<button type="submit" class="btn btn-primary btn-block btn-lg">FaceBook 채용공고 확인</button>
                            </form>
                            <!-- <input type="text" class="form-control" placeholder="키워드 검색 (회사명, 직무, etc...)"> -->
                        </div>
                    </div>
                </div>
                <div class="col-md-4 col-sm-6">
                    <div class="form-group">
                        <div class="input-group input-group-lg">
                            <div class="input-group-addon">
                                <i class="md-pin"></i>
                            </div>
                             <form action="/blog" method="get">
                            	<button type="submit" class="btn btn-primary btn-block btn-lg">블로그 채용공고 확인</button>
                            </form>
                            <!-- <input type="text" class="form-control" placeholder="지역 검색"> -->
                        </div>
                    </div>
                </div>
                <!-- <div class="col-md-4 col-sm-12">
                    <div class="form-group">
                        <button type="submit" onclick="search(); return false;" class="btn btn-primary btn-block btn-lg">Search</button>
                    </div>
                </div> -->
            </div>
        </div>
    </section>
    <section>
        <div class="container">
            <header class="section-header">
                <h3>신규 채용 공고</h3>
            </header>
            <div class="card">
                <div class="card-body">
                    <div class="item-jobpost">
                        <div class="row">
                            <div class="col-md-5">
                                <h5>
                                    <a href="../job-detail.html">Full Stack Web Developer</a>
                                </h5>
                                <ul class="list-inline">
                                    <li><a href="#"><img src="../images/logos/linkedin-logo.png" alt="">Linkedin</a></li>
                                    <li><label class="label bg-green lighten-1">Freelance</label></li>
                                </ul>
                            </div>
                            <div class="col-md-5 jobpost-location">
                                <span><i class="md-pin m-r-10"></i> Ankara - Turkey</span>
                            </div>
                            <div class="col-md-2 jobpost-apply-btn">
                                <a href="#" class="btn btn-primary btn-block btn-outline btn-sm">Apply Now <i class="md-long-arrow-right m-l-10"></i></a>
                            </div>
                        </div>
                    </div>
                    <div class="item-jobpost">
                        <div class="row">
                            <div class="col-md-5">
                                <h5>
                                    <a href="./job-detail.html">Senior front-end developer</a>
                                </h5>
                                <ul class="list-inline">
                                    <li><a href="#"><img src="../images/logos/envato-logo.png" alt="">Envato</a></li>
                                    <li><label class="label bg-purple lighten-1">Part Time</label></li>
                                </ul>
                            </div>
                            <div class="col-md-5 jobpost-location">
                                <span><i class="md-pin m-r-10"></i> Samsun - Turkey</span>
                            </div>
                            <div class="col-md-2 jobpost-apply-btn">
                                <a href="#" class="btn btn-success btn-block btn-sm"><i class="md-check m-r-10"></i>Applied</a>
                            </div>
                        </div>
                    </div>
                    <div class="item-jobpost">
                        <div class="row">
                            <div class="col-md-5">
                                <h5>
                                    <a href="../job-detail.html">Software Engineer (Entry or Senior)</a>
                                </h5>
                                <ul class="list-inline">
                                    <li><a href="#"><img src="../images/logos/twitter-logo.png" alt="">Twitter</a></li>
                                    <li><label class="label bg-blue lighten-1">Full Time</label></li>
                                </ul>
                            </div>
                            <div class="col-md-5 jobpost-location">
                                <span><i class="md-pin m-r-10"></i> Ordu - Turkey</span>
                            </div>
                            <div class="col-md-2 jobpost-apply-btn">
                                <a href="#" class="btn btn-primary btn-block btn-outline btn-sm">Apply Now <i class="md-long-arrow-right m-l-10"></i></a>
                            </div>
                        </div>
                    </div>
                    <div class="item-jobpost">
                        <div class="row">
                            <div class="col-md-5">
                                <h5>
                                    <a href="../job-detail.html">Web Applications Developer</a>
                                </h5>
                                <ul class="list-inline">
                                    <li><a href="#"><img src="../images/logos/google-logo.png" alt="">Google</a></li>
                                    <li><label class="label bg-green lighten-1">Freelance</label></li>
                                </ul>
                            </div>
                            <div class="col-md-5 jobpost-location">
                                <span><i class="md-pin m-r-10"></i> İstanbul - Turkey</span>
                            </div>
                            <div class="col-md-2 jobpost-apply-btn">
                                <a href="#" class="btn btn-primary btn-block btn-outline btn-sm">Apply Now <i class="md-long-arrow-right m-l-10"></i></a>
                            </div>
                        </div>
                    </div>
                    <div class="item-jobpost">
                        <div class="row">
                            <div class="col-md-5">
                                <h5>
                                    <a href="../job-detail.html">Software and technical support specialist</a>
                                </h5>
                                <ul class="list-inline">
                                    <li>
                                        <a href="#"><img src="../images/logos/github-logo.png" alt="">Github</a>
                                    </li>
                                    <li><label class="label bg-green lighten-1">Full Time</label></li>
                                </ul>
                            </div>
                            <div class="col-md-5 jobpost-location">
                                <span><i class="md-pin m-r-10"></i> İstanbul - Turkey</span>
                            </div>
                            <div class="col-md-2 jobpost-apply-btn">
                                <a href="#" class="btn btn-primary btn-block btn-outline btn-sm">Apply Now <i class="md-long-arrow-right m-l-10"></i></a>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
<!--             <div class="col-sm-4 col-sm-offset-4 col-xs-6 col-xs-offset-3">
                <a href="#" class="btn btn-primary btn-block m-t-20">Other Jobs</a>
            </div> -->
        </div>
    </section>
    
   <section>
        <div class="container">
            <header class="section-header">
                <h3>추천 교육 </h3>
            </header>
            <div class="card">
                <div class="card-body" id="test"></div>
                <div class='content-row' id='error'>
                <h5 id="error"></h5>
                </div>
            </div>
            <!-- <div class="col-sm-4 col-sm-offset-4 col-xs-6 col-xs-offset-3">
                <a href="#" class="btn btn-primary btn-block m-t-20">Other Jobs</a>
            </div> -->
        </div>
    </section>
    
    <!-- <section class="bg-white">
        <div class="container">
            <header class="section-header">
                <h3>Job Categories</h3>
                <p>We list popular business categories here</p>
            </header>
            <ul class="simple category-list">
                <li class="col-md-4 col-sm-6 col-xs-12">
                    <a href="#"><i class="md-chevron-right m-r-10"></i>Health (30)</a>
                </li>
                <li class="col-md-4 col-sm-6 col-xs-12">
                    <a href="#"><i class="md-chevron-right m-r-10"></i>Textile (30)</a>
                </li>
                <li class="col-md-4 col-sm-6 col-xs-12">
                    <a href="#"><i class="md-chevron-right m-r-10"></i>Secretary / Executive Assistant (2.042)</a>
                </li>
                <li class="col-md-4 col-sm-6 col-xs-12">
                    <a href="#"><i class="md-chevron-right m-r-10"></i>Store / Retail (11)</a>
                </li>
                <li class="col-md-4 col-sm-6 col-xs-12">
                    <a href="#"><i class="md-chevron-right m-r-10"></i>Marketing / Advertising (96)</a>
                </li>
                <li class="col-md-4 col-sm-6 col-xs-12">
                    <a href="#"><i class="md-chevron-right m-r-10"></i>Accounting / Finance (30)</a>
                </li>
                <li class="col-md-4 col-sm-6 col-xs-12">
                    <a href="#"><i class="md-chevron-right m-r-10"></i>Building / Architect / Construction (23)</a>
                </li>
                <li class="col-md-4 col-sm-6 col-xs-12">
                    <a href="#"><i class="md-chevron-right m-r-10"></i>Logistics / Transportation / Warehouse</a>
                </li>
                <li class="col-md-4 col-sm-6 col-xs-12">
                    <a href="#"><i class="md-chevron-right m-r-10"></i>Education</a>
                </li>
                <li class="col-md-4 col-sm-6 col-xs-12">
                    <a href="#"><i class="md-chevron-right m-r-10"></i>Information (64)</a>
                </li>
                <li class="col-md-4 col-sm-6 col-xs-12">
                    <a href="#"><i class="md-chevron-right m-r-10"></i>Tourism / Food / Service</a>
                </li>
                <li class="col-md-4 col-sm-6 col-xs-12">
                    <a href="#"><i class="md-chevron-right m-r-10"></i>Bank / Insurance (63)</a>
                </li>
                <li class="col-md-4 col-sm-6 col-xs-12">
                    <a href="#"><i class="md-chevron-right m-r-10"></i>Human Resources / Management (213)</a>
                </li>
                <li class="col-md-4 col-sm-6 col-xs-12">
                    <a href="#"><i class="md-chevron-right m-r-10"></i>Internship / New Graduate / Part-Time</a>
                </li>
                <li class="col-md-4 col-sm-6 col-xs-12">
                    <a href="#"><i class="md-chevron-right m-r-10"></i>Security (30)</a>
                </li>
                <li class="col-md-4 col-sm-6 col-xs-12">
                    <a href="#"><i class="md-chevron-right m-r-10"></i>Information (30)</a>
                </li>
                <li class="col-md-4 col-sm-6 col-xs-12">
                    <a href="#"><i class="md-chevron-right m-r-10"></i>Tourism / Food / Service</a>
                </li>
                <li class="col-md-4 col-sm-6 col-xs-12">
                    <a href="#"><i class="md-chevron-right m-r-10"></i>Bank / Insurance (31)</a>
                </li>
                <li class="col-md-4 col-sm-6 col-xs-12">
                    <a href="#"><i class="md-chevron-right m-r-10"></i>Human Resources / Management (56)</a>
                </li>
                <li class="col-md-4 col-sm-6 col-xs-12">
                    <a href="#"><i class="md-chevron-right m-r-10"></i>Internship / New Graduate (754)</a>
                </li>
                <li class="col-md-4 col-sm-6 col-xs-12">
                    <a href="#"><i class="md-chevron-right m-r-10"></i>Security (875)</a>
                </li>
            </ul>
        </div>
    </section>
    <section>
        <div class="container">
            <header class="section-header">
                <h3>Jobs You Applied</h3>
                <p>You applied for 3 job postings</p>
            </header>
            <div class="row">
                <div class="col-lg-4 col-sm-12">
                    <div class="card">
                        <div class="card-body">
                            <div class="row">
                                <div class="col-xs-2">
                                    <a href="#">
                                        <img src="../images/logos/facebook-logo.png" alt="...">
                                    </a>
                                </div>
                                <div class="col-xs-9">
                                    <h5>
                                        <a href="#">Full Stack JavaScript Architect</a>
                                    </h5>
                                    <ul class="simple list-inline">
                                        <li>Twitter</li>
                                        <li>
                                            <span class="label label-danger">Part Time</span>
                                        </li>
                                    </ul>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="col-lg-4 col-sm-12">
                    <div class="card">
                        <div class="card-body">
                            <div class="row">
                                <div class="col-xs-2">
                                    <a href="#">
                                        <img src="../images/logos/google-logo.png" alt="...">
                                    </a>
                                </div>
                                <div class="col-xs-9">
                                    <h5>
                                        <a href="#">Front End Javascript Engineer</a>
                                    </h5>
                                    <ul class="simple list-inline">
                                        <li>Google</li>
                                        <li>
                                            <span class="label label-info">Full Time</span>
                                        </li>
                                    </ul>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="col-lg-4 col-sm-12">
                    <div class="card">
                        <div class="card-body">
                            <div class="row">
                                <div class="col-xs-2">
                                    <a href="#">
                                        <img src="../images/logos/twitter-logo.png" alt="...">
                                    </a>
                                </div>
                                <div class="col-xs-9">
                                    <h5>
                                        <a href="#">Experienced Frontend Engineer</a>
                                    </h5>
                                    <ul class="simple list-inline">
                                        <li>Twitter</li>
                                        <li>
                                            <span class="label label-success">Freelance</span>
                                        </li>
                                    </ul>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </section>
    <section class="bg-white">
        <div class="container">
            <header class="section-header">
                <h3>Latest Posts</h3>
                <p>The most recent post is here</p>
            </header>
            <div class="row">
                <div class="col-md-4">
                    <a href="#">
                        <div class="card bg-grey lighten-4">
                            <img src="../images/post/post-1.jpg" alt="...">
                            <div class="card-body">
                                <h5 class="m-b-0">New developments in the business world</h5>
                            </div>
                        </div>
                    </a>
                </div>
                <div class="col-md-4">
                    <a href="#">
                        <div class="card bg-grey lighten-4">
                            <img src="../images/post/post-3.jpg" alt="...">
                            <div class="card-body">
                                <h5 class="m-b-0">How should the resume be? What should be considered?</h5>
                            </div>
                        </div>
                    </a>
                </div>
                <div class="col-md-4">
                    <a href="#">
                        <div class="card bg-grey lighten-4">
                            <img src="../images/post/post-4.jpg" alt="...">
                            <div class="card-body">
                                <h5 class="m-b-0">How should the advertising work be done?</h5>
                            </div>
                        </div>
                    </a>
                </div>
            </div>
        </div>
    </section>  -->


<%@include file ="/WEB-INF/jsp/footer.jsp" %>