package my.aisa.test.dao;

import my.aisa.test.models.Action;
import my.aisa.test.models.CoffeeMaker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CoffeeMakerDAO {

    private final ActionDAO actionDAO;
    private CoffeeMaker coffeeMaker;


    public CoffeeMakerDAO(@Autowired ActionDAO actionDAO) {
        this.actionDAO = actionDAO;
        coffeeMaker = new CoffeeMaker("Tefal", 30, 500, 100, 6);
    }

    public void makeCoffee() {
        actionDAO.add(coffeeMaker.makeCoffee());
    }

    public void addWater(int water) {
        actionDAO.add(coffeeMaker.addWater(water));
    }

    public void addCoffee(int coffee) {
        actionDAO.add(coffeeMaker.addCoffee(coffee));
    }

    public List<Action> getHistory() {
        return actionDAO.index();
    }
}
