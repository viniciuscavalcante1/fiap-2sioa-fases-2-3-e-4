package model;

public abstract class Product {
    private String name;
    private String ingredients;
    private Double price;

    public Product(){}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIngredients() {
        return ingredients;
    }

    public void setIngredients(String ingredients) {
        this.ingredients = ingredients;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Product(String name, String ingredients, Double price){
        this.name = name;
        this.ingredients = ingredients;
        this.price = price;
    }

    public abstract String getSummary();
}
