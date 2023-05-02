package model;

public class Guitar extends Product {
    public String material;

    public Guitar(){
        super();
    }

    public Guitar(String name, String brand, String material){
        super(name, brand);
        this.material = material;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    @Override
    public String getDeliveryMode(){
        return "We deliver it by mail or pickup!";
    }

    @Override
    public String toString(){
        return "Guitar{" + "material=" + material + ",name=" + name + "'" +
                ",brand=" + brand + "'" +
                "}";
    }
}
