package tpo.as5.repositories;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class ResourceRepository {
    private static final String TABLE_RESOURCE = "resource";
    private static final String COLUMN_NAME = "name";
    private static final String COLUMN_CONTENT = "content";

    private DataSource dataSource;
    public ResourceRepository(DataSource ds){
        dataSource = ds;
    }

    public String getContent(String name) throws SQLException {
        Connection connection = null;
        String content = "";
        try{
            connection = connection();
            PreparedStatement statement = connection.prepareStatement("SELECT " + COLUMN_CONTENT + " FROM " + TABLE_RESOURCE + " WHERE "
                    + COLUMN_NAME + " = ?");
            statement.setString(1, name);
            ResultSet rs = statement.executeQuery();
            if(rs.next()){
                content = rs.getString(COLUMN_CONTENT);
            }
        }finally {
            if(connection != null){
                connection.close();
            }
        }

        return content;
    }

    private synchronized Connection connection() throws SQLException {
        return dataSource.getConnection();
    }
}
