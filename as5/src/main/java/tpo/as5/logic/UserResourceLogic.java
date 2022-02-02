package tpo.as5.logic;

import tpo.as5.entities.Resource;
import tpo.as5.repositories.UserResourceRepository;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.List;

public class UserResourceLogic {
    private UserResourceRepository repository;

    public UserResourceLogic(DataSource source){
        repository = new UserResourceRepository(source);
    }

    public List<Resource> get(int id) throws SQLException {
        return repository.getResources(id);
    }
}
