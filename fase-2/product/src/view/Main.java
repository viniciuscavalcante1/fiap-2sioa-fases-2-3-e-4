package view;

import model.Drink;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        Drink drink = new Drink("Orange juice", "Water, orange, sugar, ice", 7.85, 500);
        System.out.print("The drink " + drink.getName());
        System.out.print(" is made of " + drink.getIngredients());
        System.out.print(". It costs R$" + drink.getPrice());
        System.out.print(" and its size is about " + drink.getSize() + "ml.");
    }
}