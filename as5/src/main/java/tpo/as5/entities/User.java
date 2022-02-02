package tpo.as5.entities;

public class User {
    private int id;
    private String login;
    private String password;

    public User(int i, String l, String p){
        id = i;
        login = l;
        password = p;
    }

    public User(String log, String pas){
        this(0, log, pas);
    }

    public int getId() {return id;}

    public String getLogin() {return login;}

    public String getPassword() {return password;}
}
