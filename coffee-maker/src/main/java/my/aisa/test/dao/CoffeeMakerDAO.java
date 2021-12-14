package my.aisa.test.dao;
import my.aisa.test.models.CoffeeMaker;
import my.aisa.test.repository.CoffeeMakerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;
import java.util.function.Supplier;


@Component
public class CoffeeMakerDAO {

    private CoffeeMaker coffeeMaker;
    private CoffeeMakerRepository coffeeMakerRepository;

    @Autowired
    public CoffeeMakerDAO(CoffeeMakerRepository coffeeMakerRepository) {
        this.coffeeMakerRepository = coffeeMakerRepository;
        coffeeMaker = currentState();
    }

    public boolean makeCoffee() {
        boolean isMade = coffeeMaker.makeCoffee();
        saveChanges();
        return isMade;
    }

    public void addWater(int water) {
        coffeeMaker.addWater(water);
        saveChanges();
    }

    public void addCoffee(int coffee) {
        coffeeMaker.addCoffee(coffee);
        saveChanges();
    }

    public void makeEmpty() {
        coffeeMaker.makeEmpty();
        saveChanges();
    }

    public CoffeeMaker currentState() {
        String NAME = "Tefal";
        return coffeeMakerRepository.findById(NAME).orElseGet(CoffeeMaker::new);

    }

    public int getWater() {
        return coffeeMaker.getWater();
    }

    public int getCoffee() {
        return coffeeMaker.getCoffee();
    }

    private void saveChanges() {
        coffeeMakerRepository.save(coffeeMaker);
    }

}
