package model;

public class Product {
    public String name;
    public String brand;

    public Product(){}

    public Product(String name, String brand){
        this.name = name;
        this.brand = brand;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getDeliveryMode(){
        return "We deliver this product.";
    }

    @Override
    public String toString(){
        return "Product{" + "name=" + name + "'" +
                ",brand=" + brand + "'" +
                "}";
    }
}
