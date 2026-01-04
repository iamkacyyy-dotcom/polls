
package com.example.polls.servlet;

import com.example.polls.repo.PollRepository;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.Arrays;

@WebServlet("/polls")
public class PollServlet extends HttpServlet {
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        req.setAttribute("polls", PollRepository.findAll());
        req.getRequestDispatcher("/jsp/list.jsp").forward(req, resp);
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws IOException {
        String question = req.getParameter("question");
        String[] options = req.getParameterValues("options");

        if (question == null || question.trim().isEmpty()) {
            req.getSession().setAttribute("msg", "Question invalide");
            resp.sendRedirect("polls");
            return;
        }

        PollRepository.add(question, Arrays.asList(options));
        req.getSession().setAttribute("msg", "Sondage créé avec succès");
        resp.sendRedirect("polls");
    }
}
