package tpo.as5.logic;

import tpo.as5.repositories.UserRepository;

import javax.sql.DataSource;
import java.sql.SQLException;

public class UserLogic {
    private UserRepository repository;

    public UserLogic(DataSource source){
        repository = new UserRepository(source);
    }

    public int get(String login, String password) throws SQLException {
        return repository.get(login, password);
    }

}
