package ro.sci.servlet;

import ro.sci.db.UsersDbException;
import ro.sci.model.User;
import ro.sci.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class UsersServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UserService userService = new UserService();
        List<User> users = null;
        try {
            users = userService.getAllUsers();
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            for (User u : users) {
                resp.getWriter().println(u);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UserService userService = new UserService();
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        try {
            userService.createUser(username, password);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (UsersDbException e) {
            e.printStackTrace();
        }

    }

}
