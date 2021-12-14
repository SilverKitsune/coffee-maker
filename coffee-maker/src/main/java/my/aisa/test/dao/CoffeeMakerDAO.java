package my.aisa.test.dao;
import my.aisa.test.enums.ResourcesType;
import my.aisa.test.models.Action;
import my.aisa.test.models.CoffeeMaker;
import my.aisa.test.repository.CoffeeMakerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

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
            action = new Action("Приготовлено " + isMade + " чашек кофе.");
        else
            action = new Action("Не получилось приготовить кофе. Не хватило ресурсов.");
        actionDAO.add(action);
        return isMade;
    }

    public void addWater(int water) {
        coffeeMaker.addWater(water);
        Action action = new Action("Налили " + water + " мл воды. " + getCurrentResources(ResourcesType.WATER));
        actionDAO.add(action);
        saveChanges();
    }

    public void addCoffee(int coffee) {
        coffeeMaker.addCoffee(coffee);
        Action action = new Action("Насыпали " + coffee + " г кофе. " + getCurrentResources(ResourcesType.COFFEE));
        actionDAO.add(action);
        saveChanges();
    }

    public void makeEmpty() {
        coffeeMaker.makeEmpty();
        Action action = new Action("Кофеварка очищена.");
        actionDAO.add(action);
        saveChanges();
    }

    public CoffeeMaker currentState() {
        String NAME = "Tefal";
        Action action = new Action("Пользователь запросил данные о кофеварке.");
        actionDAO.add(action);
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

    private String getCurrentResources(ResourcesType type) {
        String str = "";
        if(type == ResourcesType.WATER)
            str = "Текущий объем: " + coffeeMaker.getWater() + " мл воды.";
        if(type == ResourcesType.COFFEE)
            str = "Текущий вес: " + coffeeMaker.getCoffee() + " г кофе.";
        return str;
    }

}
