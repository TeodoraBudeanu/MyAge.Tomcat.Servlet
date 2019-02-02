package ro.sci.dao.sql;

import ro.sci.db.UsersDb;
import ro.sci.db.UsersDbException;
import ro.sci.model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SQLUsersDAO {

    private UsersDb db = new UsersDb();

    public List<User> getAll() throws Exception, UsersDbException {
        try (Connection conn = db.connect()) {
            PreparedStatement selectPs = null;
            try {
                selectPs = conn.prepareStatement("SELECT * from users;");
                ResultSet resultSet = selectPs.executeQuery();
                ArrayList<User> users = new ArrayList<>();
                while (resultSet.next()) {
                    User user = mapResultSetToUser(resultSet);
                    users.add(user);
                }
                return users;
            } catch (SQLException e) {
                System.err.println("Cannot retrieve all users: " + e.getMessage());
            } finally {
                if (selectPs != null) {
                    try {
                        selectPs.close();
                    } catch (SQLException e) {
                        System.out.println("Prepared Statement could not be closed: " + e.getMessage());
                    }
                }
            }
            return null;
        }
    }

    private User mapResultSetToUser(ResultSet resultSet) throws SQLException {
        User user = new User();
        user.setId(resultSet.getInt("id"));
        user.setUsername(resultSet.getString("username"));
        user.setPassword(resultSet.getString("password"));
        return user;

    }

    public void add(User user) throws UsersDbException, SQLException {
        try (Connection connection = db.connect()) {
            PreparedStatement insertionPs = null;
            PreparedStatement crtValPs = null;

            try {
                insertionPs = connection.prepareStatement("INSERT INTO users(username, password) values( ?, ?)");
                insertionPs.setString(1, user.getUsername());
                insertionPs.setString(2, user.getPassword());
                insertionPs.executeUpdate();

                crtValPs = connection.prepareStatement("SELECT CURRVAL('users_id_seq')");
                ResultSet resultSet = crtValPs.executeQuery();
                resultSet.next();
                user.setId(resultSet.getInt(1));
            } catch (SQLException e) {
                System.err.println("Cannot insert Users: " + e.getMessage());
            } finally {
                if (insertionPs != null && crtValPs!= null) {
                    try {
                        insertionPs.close();
                        crtValPs.close();
                    } catch (SQLException e) {
                        System.out.println("Prepared Statement could not be closed: " + e.getMessage());
                    }
                }
            }
        }
    }
}
