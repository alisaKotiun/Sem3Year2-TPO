package tpo.as5.entities;

public class Resource {
    private int id;
    private String name;

    public Resource(int i, String n){
        id = i;
        name = n;
    }

    @Override
    public String toString() {
        return name;
    }

    public String getName() {
        return name;
    }
}
