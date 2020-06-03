<%@page import="job.model.joinus.dto.JoinUsDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/jsp/header.jsp"%>
<%
	JoinUsDTO user = (JoinUsDTO) session.getAttribute("user");
	String id = user.getUser_id();
	String name = user.getUser_name();
	String email = user.getUser_email();
	String phone = user.getUser_phone();
	String password = user.getUser_pw();
%>
<section class="page-header lighten-4"
	style="background: url(../images/cover-1.jpg)">
	<div class="container">
		<h2>Create Weight</h2>
	</div>
</section>

<section>
	<div class="container">
		<form name="saveResume" method="post" action="/updateWeight" id="updateWeight">
			<div class="card">
				<div class="card-body">
					<div class="row">
						<div class="title">
							<h5>직업 성향 선택</h5>
						</div>
						<div class="row">
							<div class="col-md-6">
								<div class="form-group">
									<div class="column" title=""><strong>♣ 희망임금</strong><br />
										<select id="salLevel" name="salLevel" class="form-control" required>
											<option value="">점수를 선택하여 주세요</option>
											<option value=10>10점</option>
											<option value=9>9점</option>
											<option value=8>8점</option>
											<option value=7>7점</option>
											<option value=6>6점</option>
											<option value=5>5점</option>
											<option value=4>4점</option>
											<option value=3>3점</option>
											<option value=2>2점</option>
											<option value=1>1점</option>
											<option value=0>0점</option>
										</select>
									</div>
								</div>
							</div>
						</div>
						<div class="row">
							<div class="col-md-6">
								<div class="form-group">
									<div class="column" title=""><strong>♣ 일의양과 시간대</strong><br />
										<select id="workTime" name="workTime" class="form-control" required>
											<option value="">점수를 선택하여 주세요</option>
											<option value=10>10점</option>
											<option value=9>9점</option>
											<option value=8>8점</option>
											<option value=7>7점</option>
											<option value=6>6점</option>
											<option value=5>5점</option>
											<option value=4>4점</option>
											<option value=3>3점</option>
											<option value=2>2점</option>
											<option value=1>1점</option>
											<option value=0>0점</option>
										</select>
									</div>
								</div>
							</div>
						</div>
						<div class="row">
							<div class="col-md-6">
								<div class="form-group">
									<div class="column" title=""><strong>♣ 일의내용</strong><br />
										<select id="workInfo" name="workInfo" class="form-control" required>
											<option value="">점수를 선택하여 주세요</option>
											<option value=10>10점</option>
											<option value=9>9점</option>
											<option value=8>8점</option>
											<option value=7>7점</option>
											<option value=6>6점</option>
											<option value=5>5점</option>
											<option value=4>4점</option>
											<option value=3>3점</option>
											<option value=2>2점</option>
											<option value=1>1점</option>
											<option value=0>0점</option>
										</select>
									</div>
								</div>
							</div>
						</div>
						<div class="row">
							<div class="col-md-6">
								<div class="form-group">
									<div class="column" title=""><strong>♣ 출퇴근거리 등 편리</strong><br />
										<select id="distance" name="distance" class="form-control" required>
											<option value="">점수를 선택하여 주세요</option>
											<option value=10>10점</option>
											<option value=9>9점</option>
											<option value=8>8점</option>
											<option value=7>7점</option>
											<option value=6>6점</option>
											<option value=5>5점</option>
											<option value=4>4점</option>
											<option value=3>3점</option>
											<option value=2>2점</option>
											<option value=1>1점</option>
											<option value=0>0점</option>
										</select>
									</div>
								</div>
							</div>
						</div>
						<div class="row">
							<div class="col-md-6">
								<div class="form-group">
									<div class="column" title=""><strong>♣ 계속 근로 가능성</strong><br />
										<select id="workability" name="workability" class="form-control" required>
											<option value="">점수를 선택하여 주세요</option>
											<option value=10>10점</option>
											<option value=9>9점</option>
											<option value=8>8점</option>
											<option value=7>7점</option>
											<option value=6>6점</option>
											<option value=5>5점</option>
											<option value=4>4점</option>
											<option value=3>3점</option>
											<option value=2>2점</option>
											<option value=1>1점</option>
											<option value=0>0점</option>
										</select>
									</div>
								</div>
							</div>
						</div>
						<div class="row">
							<div class="col-md-6">
								<div class="form-group">
									<div class="column" title=""><strong>♣ 과거취업경험연관성</strong><br />
										<select id="careers" name="careers" class="form-control" required>
											<option value="">점수를 선택하여 주세요</option>
											<option value=10>10점</option>
											<option value=9>9점</option>
											<option value=8>8점</option>
											<option value=7>7점</option>
											<option value=6>6점</option>
											<option value=5>5점</option>
											<option value=4>4점</option>
											<option value=3>3점</option>
											<option value=2>2점</option>
											<option value=1>1점</option>
											<option value=0>0점</option>
										</select>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
			<!-- Skills finish -->
			<div class="col-sm-4 col-sm-offset-4 col-xs-6 col-xs-offset-3">
				<button type="submit" onclick="/updateWeight" class="btn btn-primary btn-block btn-lg m-t-20">저장</button>
			</div>
		</form>
	</div>
</section>
<script src="../js/readWeight.js"></script>
<!-- <script src="../js/createResume.js"></script> -->
<%@include file="/WEB-INF/jsp/footer.jsp"%>