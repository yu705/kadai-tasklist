<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page import="models.Task" %>
<%
    Task task = (Task) request.getAttribute("task");
%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>タスク詳細</title>
</head>
<body>
    <h1>タスク詳細</h1>

    <p>内容：<%= task.getContent() %></p>
    <p>作成日時：<%= task.getCreatedAt() %></p>
    <p>更新日時：<%= task.getUpdatedAt() %></p>

    <p><a href="index">戻る</a></p>
</body>
</html>