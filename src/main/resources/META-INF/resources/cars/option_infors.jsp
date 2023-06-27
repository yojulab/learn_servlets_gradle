<!-- from /optionInforsJSPServlet -->
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.util.HashMap, java.util.ArrayList" %>

<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css">
    <title>Document</title>
</head>

<body>
    <div class="container">
        <%
        String search = (String)request.getAttribute("search");
        %>
        <form action="/optionInforsServlet">
            <label>검색
                <input type="text" name="search" value="<%= search %>">
            </label>
            <button>검색 하기</button>
        </form>
    </div>
    <div class="container">
        <table class="table table-bordered table-hover">
            <thead>
                <tr>
                    <th>OPTION_INFOR_ID</th>
                    <th>OPTION_NAME</th>
                    <th>Delete</th>
                </tr>
            </thead>
            <%
            ArrayList optionInforList = new ArrayList<>();
            optionInforList = (ArrayList)request.getAttribute("optionInforList");
            %>
            <tbody>
                <% for(int i=0; i< optionInforList.size(); i=i+1) { %>
                    <%
                    HashMap optionInforRecord = new HashMap<>();
                    optionInforRecord = (HashMap) optionInforList.get(i);
                    %>
                <tr>
                    <form action="">
                    <input type="hidden" name="unique_id" value="<%= optionInforRecord.get("OPTION_INFOR_ID") %>">
                    <td><%= optionInforRecord.get("OPTION_INFOR_ID") %></td>
                    <td><%= optionInforRecord.get("OPTION_NAME") %></td>
                    <td>
                        <button type="submit" formaction="/optionInforsDeleteServlet">
                            <%= optionInforRecord.get("OPTION_INFOR_ID") %>
                        </button>
                    </form>
                </td>
            </tr>
            <% } %>
            </tbody>
    </table>
    </div>

</body>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"></script>

</html>"