package kirasoft.anuva.model;

/**
 * Created by dekir on 12/14/2016.
 */

public class NameBlock {

    private int color;
    private String name;

    public int getColor() {
        return this.color;
    }

    public String getName() {
        return name;
    }

    public NameBlock(String name, int color){
        this.name =  name;
        this.color = color;
    }

}
