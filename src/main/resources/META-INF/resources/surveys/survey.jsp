<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.util.HashMap, java.util.ArrayList" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css">
    <title> 설문 조사 </title>
</head>
<body>
    <div class="container bg-info p-0 row mx-auto">
        <div class="fs-4 py-3 d-flex justify-content-start col-6">
            <button type="submit" formaction="" class=" btn btn-info text-light">회원관리</button>
            <button type="submit" formaction="" class=" btn btn-info text-light">설문하기</button>
            <button type="submit" formaction="" class=" btn btn-info text-light">설문통계</button>
        </div>
        <div class="fs-4 py-3 d-flex justify-content-end col-6">
            <button type="submit" formaction="" class="btn btn-info text-light">로그인</button>
        </div>
    </div>
    <br>
    <form method="get" action="survey.html"> 
    <div class=" container mx-auto">
        <%
        ArrayList surveyList = (ArrayList)request.getAttribute("surveyList");
        String compare = "";
        for (int i = 0; i < surveyList.size(); i = i + 1) {
            HashMap survey = (HashMap) surveyList.get(i);
            String questions = (String) survey.get("QUESTIONS");
            String questionsId = (String) survey.get("QUESTIONS_ID");
            String choice = (String) survey.get("CHOICE");
            if (!compare.equals(questionsId)) {
        %>
                <p> <%= questions %></p>
                <label><input type="radio" name="1번 문항" value="1"> <%= choice %></label> <br>
        <%
                compare = questionsId;
            } else {
        %>
                <label><input type="radio" name="1번 문항" value="1"> <%= choice %></label> <br>
        <%
            }
        }
        %>
    </div>
    </form>
</body>
</html>