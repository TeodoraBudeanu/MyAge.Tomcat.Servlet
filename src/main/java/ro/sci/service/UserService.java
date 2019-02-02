package ro.sci.service;

import ro.sci.dao.sql.SQLUsersDAO;
import ro.sci.db.UsersDbException;
import ro.sci.model.User;

import java.sql.SQLException;
import java.util.List;

public class UserService {

    private SQLUsersDAO sqlUsersDAO = new SQLUsersDAO();

    public void createUser(String username, String password) throws SQLException, UsersDbException {
        sqlUsersDAO.add(new User(username, password));
    }

    public List<User> getAllUsers() throws Exception {
        SQLUsersDAO sqlUsersDAO = new SQLUsersDAO();
        List<User> users = sqlUsersDAO.getAll();
        return users;
    }


}
