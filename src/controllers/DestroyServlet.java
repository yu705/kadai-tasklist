package controllers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.TaskDAO;

@WebServlet("/destroy")
public class DestroyServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // リクエストからタスクIDを取得し、該当タスクを削除
        String idStr = request.getParameter("id");
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
        try {
            TaskDAO.delete(taskId);
        } catch (Exception e) {
            throw new ServletException(e);
        }
        // 削除後はタスクリストページへリダイレクト
        response.sendRedirect(request.getContextPath() + "/index");
    }
}
