package model;

public class HotMeal extends Product{
    private Integer serves;
    public HotMeal(){
        super();
    }

    public HotMeal(String name, String ingredients, Double price, Integer serves) {
        super(name, ingredients, price);
        this.serves = serves;
    }

    public Integer getServes() {
        return serves;
    }

    public void setServes(Integer serves) {
        this.serves = serves;
    }

    public String getSummary(){
        return getName();
    }
}
