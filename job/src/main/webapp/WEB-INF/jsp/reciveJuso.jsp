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

     
 
<%@include file ="/WEB-INF/jsp/footer.jsp" %>