package ro.sci.servlet;

import ro.sci.service.MyAgeService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;

public class MyAgeServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        LocalDate birthDate = LocalDate.parse(req.getParameter("birthDate"));
        resp.getWriter().println(MyAgeService.getAge(birthDate));
    }
}
