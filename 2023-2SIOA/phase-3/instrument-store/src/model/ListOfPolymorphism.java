package model;
import java.util.ArrayList;
public class ListOfPolymorphism {
    public static void main(String[] args) {
        var products = new ArrayList<Product>();

        products.add(new Drum("HD-1", "Roland", 7));
        products.add(new Guitar("T-S06C", "Tagima", "Mapple"));
        products.add(new Drum("Premium", "Pinguim", 5));

        for(var product : products) {
            System.out.println("The product " + product + " has delivery mode: " + product.getDeliveryMode());
        }
    }
}
