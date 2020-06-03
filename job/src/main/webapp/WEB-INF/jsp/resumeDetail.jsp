<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file ="/WEB-INF/jsp/header.jsp" %>
 <div class="page-loader"></div>
    <section class="page-header lighten-4" style="background: url(../assets/images/cover-1.jpg)">
        <div class="container">
            <!-- <img class="page-header-logo" src="../assets/images/user/user-2.jpg" alt="user-2"> -->
            <h2 id="title">
            </h2>
            <h6></h6>

        </div>
    </section>
    <section class="bg-white">
        <div class="container">
            <header class="section-header">
                <h3 id="user_name"></h3>
            </header>
        </div>
    </section>
    <section>
        <div class="container" id="career">
            <header class="section-header">
                <h3>경력 사항</h3>
                <p><i class="md-card-travel m-r-10" id="enter_type"></i></p>
            </header>
        </div>
    </section>
    <section class="bg-white">
        <div class="container">
            <header class="section-header">
                <h3>Skills</h3>
                <p><i class="md-equalizer m-r-10"></i>My best areas</p>
            </header>
            <div class="row">
                <div class="col-md-6">
                    <div class="skill-group">
                        <h6>WordPress<span>30%</span></h6>
                        <div class="skill">
                            <div class="skill-bar" style="width:30%"></div>
                        </div>
                        <h6>Adobe Illustrator<span>80%</span></h6>
                        <div class="skill">
                            <div class="skill-bar" style="width:80%"></div>
                        </div>
                        <h6>Adobe Photoshop<span>50%</span></h6>
                        <div class="skill">
                            <div class="skill-bar" style="width:50%"></div>
                        </div>
                        <h6>Photography<span>39%</span></h6>
                        <div class="skill">
                            <div class="skill-bar" style="width:90%"></div>
                        </div>
                    </div>
                </div>
                <div class="col-md-6">
                    <div class="skill-group">
                        <h6>Laravel<span>30%</span></h6>
                        <div class="skill">
                            <div class="skill-bar" style="width:30%"></div>
                        </div>
                        <h6>Html5<span>80%</span></h6>
                        <div class="skill">
                            <div class="skill-bar" style="width:80%"></div>
                        </div>
                        <h6>Css3<span>50%</span></h6>
                        <div class="skill">
                            <div class="skill-bar" style="width:50%"></div>
                        </div>
                        <h6>Javascript<span>90%</span></h6>
                        <div class="skill">
                            <div class="skill-bar" style="width:90%"></div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </section>
    <section>
        <div class="container">
            <header class="section-header">
                <h3>학력</h3>
                <p><i class="md-graduation-cap m-r-10"></i>최종 학력</p>
            </header>
            <div class='content-row'>
            	<h5 id="grade1_schoolName"></h5>
	            <ul>
	                <li id="grade1_schoolCity"></li>
	                <li id="grade1_schoolEnd"></li>
	                <li id="grade_lastgrade"></li>
	                <li id="grade1_endYear"></li>
	            </ul>
            </div>
        </div>
    </section>
    <section class="bg-white">
        <div class="container">
            <header class="section-header">
                <h3>References</h3>
                <p><i class="md-accounts-outline m-r-10"></i>Check out what I've done</p>
            </header>
            <div class="row">
                <div class="col-md-6">
                    <div class="media">
                        <div class="media-left">
                            <a href="#">
                                <img class="media-object" src="../assets/images/user/user-1.jpg" alt="...">
                            </a>
                        </div>
                        <div class="media-body">
                            <h5 class="media-heading">
                                <a href="#">Carolina Keegan</a>
                            </h5>
                            <ul class="list-inline simple">
                                <li><i class="md-star text-orange"></i></li>
                                <li><i class="md-star text-orange"></i></li>
                                <li><i class="md-star text-orange"></i></li>
                                <li><i class="md-star-outline"></i></li>
                                <li><i class="md-star-outline"></i></li>
                            </ul>
                            <p>Nemore nusquam vix eu, te quo veri expetenda persecuti, ex vix meis veritus sensibus. Vitae corpora scribentur ut vim, quo iudico cetero expetenda cu, vim eruditi probatus persecuti ne. Ex quaeque omnesque tacimates sit, sit te simul consul torquatos. Eos solum posse intellegam ei, meis soleat an pri. Adhuc mandamus postulant vix eu.</p>
                        </div>
                    </div>
                    <div class="media">
                        <div class="media-left">
                            <a href="#">
                                <img class="media-object" src="../assets/images/user/user-2.jpg" alt="...">
                            </a>
                        </div>
                        <div class="media-body">
                            <h5 class="media-heading">
                                <a href="resume-detail.html">Sarah Luizgarden</a>
                            </h5>
                            <ul class="list-inline simple">
                                <li><i class="md-star text-orange"></i></li>
                                <li><i class="md-star text-orange"></i></li>
                                <li><i class="md-star text-orange"></i></li>
                                <li><i class="md-star text-orange"></i></li>
                                <li><i class="md-star text-orange"></i></li>
                            </ul>
                            <p>Lorem ipsum dolor sit amet, vix no nemore nostro mnesarchum. Sea fuisset denique dissentias ei, cum ullum suscipiantur reprehendunt ne. Et idque tempor regione eum. Blandit urbanitas philosophia sea ea. Est nisl platonem adversarium eu, quo in zril nonumy causae. At his magna detracto, dicat movet facilisis ex duo.</p>
                        </div>
                    </div>
                    <div class="media">
                        <div class="media-left">
                            <a href="#">
                                <img class="media-object" src="../assets/images/user/user-3.jpg" alt="...">
                            </a>
                        </div>
                        <div class="media-body">
                            <h5 class="media-heading">
                                <a href="resume-detail.html">Mary Amiri</a>
                            </h5>
                            <ul class="list-inline simple">
                                <li><i class="md-star text-orange"></i></li>
                                <li><i class="md-star text-orange"></i></li>
                                <li><i class="md-star text-orange"></i></li>
                                <li><i class="md-star text-orange"></i></li>
                                <li><i class="md-star text-orange"></i></li>
                            </ul>
                            <p>Vis eruditi cotidieque in. No ius agam deserunt percipitur, offendit praesent constituto ne eos. Quodsi minimum ocurreret in his, solum postea epicurei qui ut. An salutandi prodesset pri.</p>
                        </div>
                    </div>
                </div>
                <div class="col-md-6">
                    <div class="media">
                        <div class="media-left">
                            <a href="#">
                                <img class="media-object" src="../assets/images/user/user-4.jpg" alt="...">
                            </a>
                        </div>
                        <div class="media-body">
                            <h5 class="media-heading">
                                <a href="resume-detail.html">John Doe</a>
                            </h5>
                            <ul class="list-inline simple">
                                <li><i class="md-star text-orange"></i></li>
                                <li><i class="md-star text-orange"></i></li>
                                <li><i class="md-star"></i></li>
                                <li><i class="md-star"></i></li>
                                <li><i class="md-star"></i></li>
                            </ul>
                            <p>Ex ornatus scaevola pro. Pro ei oportere consetetur, sale aperiam fabellas mel ad. Ad odio justo vis. Appareat voluptaria quo ea, doming impetus fuisset cum in.</p>
                        </div>
                    </div>
                    <div class="media">
                        <div class="media-left">
                            <a href="#">
                                <img class="media-object" src="../assets/images/user/user-5.jpg" alt="...">
                            </a>
                        </div>
                        <div class="media-body">
                            <h5 class="media-heading">
                                <a href="resume-detail.html">Chris Hernandeziyan</a>
                            </h5>
                            <ul class="list-inline simple">
                                <li><i class="md-star text-orange"></i></li>
                                <li><i class="md-star text-orange"></i></li>
                                <li><i class="md-star text-orange"></i></li>
                                <li><i class="md-star"></i></li>
                                <li><i class="md-star-outline"></i></li>
                            </ul>
                            <p>At lorem velit decore eum.</p>
                        </div>
                    </div>
                </div>
            </div>
            <hr>
            <div class="col-sm-4 col-sm-offset-4 col-xs-6 col-xs-offset-3">
                <a href="#" class="btn btn-primary btn-block">More References</a>
            </div>
        </div>
    </section>
    <section>
        <div class="container">
            <header class="section-header">
                <h3>Works</h3>
                <p><i class="md-cloud-outline m-r-10"></i>My working examples.</p>
            </header>
            <div class="tab">
                <ul class="nav nav-tabs" role="tablist">
                    <li role="presentation" class="active"><a href="#web-design" aria-controls="web-design" role="tab" data-toggle="tab">Web design<span class="label bg-grey m-l-10">2</span></a></li>
                    <li role="presentation"><a href="#mobile-app" aria-controls="mobile-app" role="tab" data-toggle="tab">Mobile App<span class="label bg-grey m-l-10">3</span></a></li>
                    <li role="presentation"><a href="#photography" aria-controls="photography" role="tab" data-toggle="tab">Photography<span class="label bg-grey m-l-10">1</span></a></li>
                </ul>
                <div class="tab-content">
                    <div role="tabpanel" class="tab-pane active" id="web-design">
                        <div class="row">
                            <div class="col-sm-3 col-xs-6">
                                <div class="m-b-30">
                                    <a href="#">
                                        <img src="../assets/images/post/post-1.jpg" alt="...">
                                    </a>
                                </div>
                            </div>
                            <div class="col-sm-3 col-xs-6">
                                <div class="m-b-30">
                                    <a href="#">
                                        <img src="../assets/images/post/post-2.jpg" alt="...">
                                    </a>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div role="tabpanel" class="tab-pane" id="mobile-app">
                        <div class="row">
                            <div class="col-sm-3 col-xs-6">
                                <div class="m-b-30">
                                    <a href="#">
                                        <img src="../assets/images/post/post-3.jpg" alt="...">
                                    </a>
                                </div>
                            </div>
                            <div class="col-sm-3 col-xs-6">
                                <div class="m-b-30">
                                    <a href="#">
                                        <img src="../assets/images/post/post-4.jpg" alt="...">
                                    </a>
                                </div>
                            </div>
                            <div class="col-sm-3 col-xs-6">
                                <div class="m-b-30">
                                    <a href="#">
                                        <img src="../assets/images/post/post-2.jpg" alt="...">
                                    </a>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div role="tabpanel" class="tab-pane" id="photography">
                        <div class="row">
                            <div class="col-sm-3 col-xs-6">
                                <div class="m-b-30">
                                    <a href="#">
                                        <img src="../assets/images/post/post-1.jpg" alt="...">
                                    </a>
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
                <h3>Location</h3>
                <p><i class="md-globe m-r-10"></i>You can contact me.</p>
            </header>
            <div class="row">
                <div class="col-md-4">
                    <div class="card bg-grey lighten-4 h-400">
                        <div class="card-body">
                            <ul class="simple">
                                <li><i class="md-pin left m-r-15"></i><strong>Address</strong></li>
                                <li>
                                    <p class="text-muted">R/13 Creative Town, Bangladesh</p>
                                </li>
                                <li><i class="md-phone left m-r-15"></i><strong>Phone</strong></li>
                                <li>
                                    <p class="text-muted">+00 (123) 456 789 , +88 (444) 456 789</p>
                                </li>
                                <li><i class="md-email left m-r-15"></i><strong>Email</strong></li>
                                <li>
                                    <p class="text-muted">name@yourdomain.com</p>
                                </li>
                            </ul>
                        </div>
                    </div>
                </div>
                <div class="col-md-8">
                    <div id="map"></div>
                </div>
            </div>
        </div>
    </section>
    <section>
        <div class="container">
            <header class="section-header">
                <h3>Contact Form</h3>
                <p>Send me a message now</p>
            </header>
            <form>
                <div class="row">
                    <div class="col-md-6">
                        <div class="form-group with-icon">
                            <div class="input-group">
                                <div class="input-group-addon">
                                    <i class="md-face"></i>
                                </div>
                                <input type="text" class="form-control" placeholder="Name">
                            </div>
                        </div>
                        <div class="form-group with-icon">
                            <div class="input-group">
                                <div class="input-group-addon">
                                    <i class="md-email"></i>
                                </div>
                                <input type="text" class="form-control" placeholder="Email">
                            </div>
                        </div>
                        <div class="form-group with-icon">
                            <div class="input-group">
                                <div class="input-group-addon">
                                    <i class="md-phone"></i>
                                </div>
                                <input type="text" class="form-control" placeholder="Phone">
                            </div>
                        </div>
                    </div>
                    <div class="col-md-6">
                        <div class="form-group">
                            <textarea class="form-control" rows="8" placeholder="We write your message here."></textarea>
                        </div>
                    </div>
                </div>
                <button class="btn btn-primary">Submit Form</button>
            </form>
        </div>
    </section>
    <!-- Footer start -->
    <footer>
        <div class="container">
            <div class="row">
                <div class="col-md-6">
                    <h5>Company</h5>
                    <p>Lorem ipsum dolor sit amet, eam verear dignissim ne, legere altera ex sit. Magna rationibus efficiantur vel at, cum cu iudico atomorum. Tale habemus molestie an sea, ne virtute dissentiet his, at sea ipsum insolens. Vitae doctus discere qui ne, enim iudico at pro, no sed modus omnes dolorem. Assum ubique equidem in eos. Putent maiestatis in ius.</p>
                    <p>Vitae doctus discere qui ne, enim iudico at pro, no sed modus omnes dolorem. Assum ubique equidem in eos. Putent maiestatis in ius.</p>
                </div>
                <div class="col-md-3">
                    <h5>Contact with us</h5>
                    <p>Manchester Road 123-78B, <br> Silictown</p>
                    <p>+46 123 456 789</p>
                    <p>info@sitename.com</p>
                    <p>http://www.sitename.com</p>
                </div>
                <div class="col-md-3">
                    <h5>Popular jobs</h5>
                    <ul>
                        <li>
                            <a href="#">
                                <i class="md-caret-right m-r-10"></i>Experienced Frontend Engineer
                            </a>
                        </li>
                        <li>
                            <a href="#">
                                <i class="md-caret-right m-r-10"></i>React.js Developer
                            </a>
                        </li>
                        <li>
                            <a href="#">
                                <i class="md-caret-right m-r-10"></i>Front End Javascript Engineer
                            </a>
                        </li>
                        <li>
                            <a href="#">
                                <i class="md-caret-right m-r-10"></i>PHP/Drupal developer for legacy ecommerce site
                            </a>
                        </li>
                    </ul>
                </div>
            </div>
            <hr class="sm">
            <div class="row">
                <div class="col-md-6 col-xs-12">
                    <ul class="social-icons social-icons-sm">
                        <li><a href="#" class="facebook"><i class="md-facebook"></i></a></li>
                        <li><a href="#" class="twitter"><i class="md-twitter"></i></a></li>
                        <li><a href="#" class="google"><i class="md-google"></i></a></li>
                        <li><a href="#" class="linkedin"><i class="md-linkedin"></i></a></li>
                        <li><a href="#" class="flickr"><i class="md-flickr"></i></a></li>
                    </ul>
                </div>
                <div class="col-md-6 col-xs-12">
                    <p class="copyright">Copyrights © 2017 All Rights Reserved by</p>
                </div>
            </div>
        </div>
    </footer>
    <!-- Footer end -->
    <!-- ================= Script files ================= -->
    <script src="js/axios.js"></script>
    <script src="js/readResume.js"></script>
    <!-- Jquery -->
    <script src="../assets/js/jquery/jquery.min.js"></script>
    <!-- Jquery ui -->
    <script src="../assets/js/jquery/jquery-ui.min.js"></script>
    <!-- Bootstrap -->
    <script src="../assets/js/bootstrap/bootstrap.min.js"></script>
    <!-- Bootstrap slider -->
    <script src="../assets/js/bootstrap-slider/bootstrap-slider.min.js"></script>
    <!-- Waves effect -->
    <script src="../assets/js/waves/waves.min.js"></script>
    <!-- Scroll animate effect -->
    <script src="../assets/js/scroll.js"></script>
    <!-- Owl carousel -->
    <script src="../assets/js/owl-carousel/owl.carousel.min.js"></script>
    <!-- Summernote editor -->
    <script src="../assets/js/summernote/summernote.min.js"></script>
    <!-- Typed.js -->
    <script src="../assets/js/typed.min.js"></script>
    <!-- Custom -->
    <script src="../assets/js/app.js"></script>
    <script async defer src="https://maps.googleapis.com/maps/api/js?key=AIzaSyAcTG7a4aldXxnHWNehzq2RQW92cy3opIA&callback=initMap"></script>
 
<%@include file ="/WEB-INF/jsp/footer.jsp" %>