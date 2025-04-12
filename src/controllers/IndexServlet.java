package controllers;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.TaskDAO;
import models.Task;

@WebServlet("/index")
public class IndexServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // データベースから全タスクを取得
        List<Task> taskList = null;
        try {
            taskList = TaskDAO.findAll();
        } catch (Exception e) {
            throw new ServletException(e);
        }
        // タスクリストをリクエスト属性に保存し、一覧表示ページへフォワード
        request.setAttribute("tasks", taskList);
        RequestDispatcher rd = request.getRequestDispatcher("/index.jsp");
        rd.forward(request, response);
    }
}
