package tpo.as7_2.as4;

public class Logic {
    public Model add(Integer i1, Integer i2){
        return new Model(process(i1, i2));
    }

    private Integer process (Integer i1, Integer i2){
        if(i1 == null || i2 == null) return null;
        return i1 + i2;
    }
}
