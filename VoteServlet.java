
package com.example.polls.servlet;

import com.example.polls.repo.PollRepository;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet("/vote")
public class VoteServlet extends HttpServlet {
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws IOException {
        int pollId = Integer.parseInt(req.getParameter("pollId"));
        int option = Integer.parseInt(req.getParameter("option"));
        PollRepository.vote(pollId, option);
        resp.sendRedirect("polls");
    }
}
