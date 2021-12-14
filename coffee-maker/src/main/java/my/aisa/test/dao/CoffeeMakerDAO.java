package my.aisa.test.dao;


import my.aisa.test.models.CoffeeMaker;
import org.springframework.stereotype.Component;


@Component
public class CoffeeMakerDAO {

    private CoffeeMaker coffeeMaker;

    public CoffeeMakerDAO() {

        coffeeMaker = new CoffeeMaker("Tefal", 30, 500, 100, 6);
    }

    public void makeCoffee() {
        coffeeMaker.makeCoffee();
    }

    public void addWater(int water) {
        coffeeMaker.addWater(water);
    }

    public void addCoffee(int coffee) {
        coffeeMaker.addCoffee(coffee);
    }

    public void makeEmpty() {
        coffeeMaker.makeEmpty();
    }

    public CoffeeMaker currentState() {
        return coffeeMaker;
    }
}
