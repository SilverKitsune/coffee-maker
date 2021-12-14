package my.aisa.test.dao;
import my.aisa.test.models.Action;
import my.aisa.test.models.CoffeeMaker;
import my.aisa.test.repository.CoffeeMakerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class CoffeeMakerDAO {

    private CoffeeMaker coffeeMaker;
    private CoffeeMakerRepository coffeeMakerRepository;
    private ActionDAO actionDAO;

    @Autowired
    public CoffeeMakerDAO(CoffeeMakerRepository coffeeMakerRepository, ActionDAO actionDAO) {
        this.coffeeMakerRepository = coffeeMakerRepository;
        this.actionDAO = actionDAO;
        coffeeMaker = currentState();
    }

    public int makeCoffee() {
        int isMade = coffeeMaker.makeCoffee();
        saveChanges();
        Action action;
        if(isMade > 0)
            action = new Action("Приготовлено " + isMade + " чашек кофе");
        else
            action = new Action("Не получилось приготовить кофе. Не хватило ресурсов.");
        actionDAO.add(action);
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
