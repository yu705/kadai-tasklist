package controllers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.TaskDAO;
import models.Task;

@WebServlet("/update")
public class UpdateServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // フォームのデータで指定IDのタスクを更新
        request.setCharacterEncoding("UTF-8");
        String idStr = request.getParameter("id");
        String content = request.getParameter("content");
        if (idStr == null || idStr.isEmpty()) {
            response.sendRedirect(request.getContextPath() + "/index");
            return;
        }
        int taskId;
        try {
            taskId = Integer.parseInt(idStr);
        } catch (NumberFormatException e) {
            response.sendRedirect(request.getContextPath() + "/index");
            return;
        }
        Task task = new Task();
        task.setId(taskId);
        task.setContent(content);
        try {
            TaskDAO.update(task);
        } catch (Exception e) {
            throw new ServletException(e);
        }
        // 更新後はタスクリストページへリダイレクト
        response.sendRedirect(request.getContextPath() + "/index");
    }
}
