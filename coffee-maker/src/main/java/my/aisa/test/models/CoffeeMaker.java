package my.aisa.test.models;

import java.util.Date;

///TODO(разобраться с датами)
///TODO(посчитать сваренный кофе)
///TODO(избавиться от повторений)

public class CoffeeMaker {

    private String name;

    //количество кофе в граммах
    private int coffee;

    //объем воды в миллилитрах
    private int water;

    public final int MAX_COFFEE;/* = 30*/
    public final int MIN_COFFEE; /*= 8*/

    public final int MAX_WATER;// = 500
    public final int MIN_WATER;// = 125

    public CoffeeMaker(String name,
                       int max_coffee,
                       int max_water,
                       int min_water,
                       int min_coffee) {
        this.name = name;
        MAX_COFFEE = max_coffee;
        MIN_COFFEE = min_coffee;
        MAX_WATER = max_water;
        MIN_WATER = min_water;
    }

    public String getName() {
        return name;
    }

    private boolean isReady() {
        return water > MIN_WATER && coffee > MIN_COFFEE;
    }

    public Action makeCoffee() {
        String actionMessage;
        if (isReady()) {
            actionMessage = "Кофе сварен";
            coffee = 0;
            water = 0;
        }
        else
            actionMessage = "Недостаточно ингредиентов";
        return new Action(new Date().toString(), actionMessage);

    }

    public Action addWater(int w) {

        water += w;

        String actionMessage = "Налили " + w + " мл воды";

        if(water > MAX_WATER) {
            actionMessage += "Вылилось " + (water - MAX_WATER) + " мл воды";
            water = MAX_WATER;
        }
        actionMessage += "Текущий уровень:" + water + " мл воды";

        return new Action(new Date().toString(), actionMessage);
    }

    public Action addCoffee(int c) {
        coffee += c;

        String actionMessage = "Насыпали " + c + "г кофе.";

        if(coffee > MAX_COFFEE) {

            actionMessage += " Высыпалось " + (coffee - MAX_COFFEE) + " г кофе";
            coffee = MAX_COFFEE;
        }
        actionMessage += "Текущий уровень:" + coffee + " г кофе";

        return new Action(new Date().toString(), actionMessage);
    }
}
