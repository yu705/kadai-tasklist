package controllers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.TaskDAO;
import models.Task;

@WebServlet("/show")
public class ShowServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // リクエストパラメータからタスクIDを取得し、該当タスクを検索
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
        Task task = null;
        try {
            task = TaskDAO.findById(taskId);
        } catch (Exception e) {
            throw new ServletException(e);
        }
        if (task == null) {
            response.sendRedirect(request.getContextPath() + "/index");
            return;
        }
        // 取得したタスクをリクエスト属性にセットし、詳細ページへフォワード
        request.setAttribute("task", task);
        RequestDispatcher rd = request.getRequestDispatcher("/show.jsp");
        rd.forward(request, response);
    }
}
