package tpo.as5.repositories;

import tpo.as5.entities.User;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserRepository {
    private static final String TABLE_USER = "my_user";
    private static final String COLUMN_USER_ID = "id_user";
    private static final String COLUMN_USER_FNAME = "fname";
    private static final String COLUMN_USER_LNAME = "lname";
    private static final String COLUMN_USER_LOGIN = "login";
    private static final String COLUMN_USER_PASSWORD = "password";
    private static final String SEQUENCE_USER = "'user_seq'";


    private DataSource dataSource;

    public UserRepository(DataSource ds){
        dataSource = ds;
    }

    public int get(User user) throws SQLException {
        Connection connection = null;
        try {
            connection = connection();
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM " +
                    TABLE_USER + " WHERE " +
                    COLUMN_USER_LOGIN + " = ? AND " + COLUMN_USER_PASSWORD + " = ?");
            statement.setString(1, user.getLogin());
            statement.setString(2, user.getPassword());
            ResultSet rs = statement.executeQuery();
            if(rs.next()){
                //int id = rs.getInt(1);
                int id = rs.getInt(COLUMN_USER_ID);
                return id;
            }
        } finally {
            if (connection !=null){
                connection.close();
            }
        }
        return -1;
    }

    public int get(String login, String password) throws SQLException {
        User user = new User(login, password);
        return get(user);
    }

    private synchronized Connection connection() throws SQLException {
        return dataSource.getConnection();
    }
}
