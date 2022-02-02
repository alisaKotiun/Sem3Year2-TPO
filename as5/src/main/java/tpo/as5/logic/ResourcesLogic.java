package tpo.as5.logic;

import tpo.as5.repositories.ResourceRepository;

import javax.sql.DataSource;
import java.sql.SQLException;

public class ResourcesLogic {
    private ResourceRepository repository;

    public ResourcesLogic(DataSource source){
        repository = new ResourceRepository(source);
    }

    public String get(String name) throws SQLException {
        return repository.getContent(name);
    }
}
