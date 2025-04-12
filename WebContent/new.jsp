<%@ page contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>新規タスク作成</title>
</head>
<body>
    <h1>新しいタスクを作成</h1>

    <form action="create" method="post">
        <textarea name="content" rows="4" cols="40" required></textarea><br>
        <input type="submit" value="作成">
    </form>

    <p><a href="index">戻る</a></p>
</body>
</html>
