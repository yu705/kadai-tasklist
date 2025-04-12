<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page import="models.Task" %>
<%
    Task task = (Task) request.getAttribute("task");
%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>タスク編集</title>
</head>
<body>
    <h1>タスクを編集</h1>

    <form action="update" method="post">
        <input type="hidden" name="id" value="<%= task.getId() %>">
        <textarea name="content" rows="4" cols="40" required><%= task.getContent() %></textarea><br>
        <input type="submit" value="更新">
    </form>

    <p><a href="index">戻る</a></p>
</body>
</html>