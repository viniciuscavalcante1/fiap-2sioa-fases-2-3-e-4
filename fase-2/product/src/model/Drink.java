package model;

public class Drink extends Product{

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

    private Integer size;

    public Drink(){
        super();
    }
    public Drink(String name, String ingredients, Double price, Integer size) {
        super(name, ingredients, price);
        this.size = size;
    }

    public String getSummary() {
        return getName();
    }
}
