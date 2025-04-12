package controllers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.TaskDAO;
import models.Task;

@WebServlet("/create")
public class CreateServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // フォームデータを取得して新規タスクを作成
        request.setCharacterEncoding("UTF-8");  // 文字エンコーディングの指定
        String content = request.getParameter("content");
        Task task = new Task();
        task.setContent(content);
        try {
            TaskDAO.create(task);
        } catch (Exception e) {
            throw new ServletException(e);
        }
        // 作成後はタスクリストページへリダイレクト
        response.sendRedirect(request.getContextPath() + "/index");
    }
}