package tpo.as5.repositories;

import tpo.as5.entities.Resource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserResourceRepository {
    private static final String TABLE_RESOURCE = "resource";
    private static final String TABLE_USER_RESOURCE = "user_resource";
    private static final String COLUMN_ID = "id_resource";
    private static final String COLUMN_ID_USER = "id_user";
    private static final String COLUMN_NAME = "name";
    private static final String COLUMN_CONTENT = "content";

    private DataSource dataSource;
    public UserResourceRepository(DataSource ds){
        dataSource = ds;
    }

    public List<Resource> getResources(int id) throws SQLException {
        Connection connection = null;
        List<Resource> list = new ArrayList<>();
        try{
            connection = connection();
            PreparedStatement statement = connection.prepareStatement("SELECT " + TABLE_RESOURCE + "." + COLUMN_ID + ", "
                    + TABLE_RESOURCE + "." + COLUMN_NAME + " FROM " + TABLE_RESOURCE + " JOIN " + TABLE_USER_RESOURCE
                    + " ON " + TABLE_RESOURCE + "." + COLUMN_ID + " = " + TABLE_USER_RESOURCE + "." + COLUMN_ID + " WHERE " + COLUMN_ID_USER + " = ?");
            statement.setInt(1, id);
            System.out.println(statement);
            ResultSet rs = statement.executeQuery();
            while (rs.next()){
                Resource resource = new Resource(rs.getInt(COLUMN_ID), rs.getString(COLUMN_NAME));
                list.add(resource);
            }
        } finally {
            if(connection != null){
                connection.close();
            }
        }
        return list;
    }

    private synchronized Connection connection() throws SQLException {
        return dataSource.getConnection();
    }

}
