package model;

public class Drum extends Product {
    public Integer numberOfDrums;

    public Drum(){
        super();
    }

    public Integer getNumberOfDrums() {
        return numberOfDrums;
    }

    public void setNumberOfDrums(Integer numberOfDrums) {
        this.numberOfDrums = numberOfDrums;
    }

    public Drum(String name, String brand, Integer numberOfDrums){
        super(name, brand);
        this.numberOfDrums = numberOfDrums;
    }

    @Override
    public String getDeliveryMode(){
        return "Delivery only in-store!";
    }

    @Override
    public String toString(){
        return "Drum{" + "numberOfDrums=" + numberOfDrums + ",name=" + name + "'" +
                ",brand=" + brand + "'" +
                "}";
    }
}
