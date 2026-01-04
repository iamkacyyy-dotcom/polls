
package com.example.polls.servlet;

import com.example.polls.repo.PollRepository;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet("/delete")
public class DeletePollServlet extends HttpServlet {
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        PollRepository.delete(id);
        req.getSession().setAttribute("msg", "Sondage supprimé");
        resp.sendRedirect("polls");
    }
}
