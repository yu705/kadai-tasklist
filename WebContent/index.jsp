<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page import="java.util.*, models.Task" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>タスク一覧</title>
</head>
<body>
    <h1>タスク一覧</h1>

    <a href="new">新しいタスクを追加</a>
    <hr>

    <ul>
        <%
            List<Task> tasks = (List<Task>) request.getAttribute("tasks");
            if (tasks != null && !tasks.isEmpty()) {
                for (Task task : tasks) {
        %>
            <li>
                <%= task.getContent() %>
                [<a href="show?id=<%= task.getId() %>">詳細</a>]
                [<a href="edit?id=<%= task.getId() %>">編集</a>]
                <form action="destroy" method="post" style="display:inline;">
                    <input type="hidden" name="id" value="<%= task.getId() %>">
                    <input type="submit" value="削除">
                </form>
            </li>
        <%
                }
            } else {
        %>
            <li>タスクがありません。</li>
        <%
            }
        %>
    </ul>
</body>
</html>