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

    //количество сделаных чашек кофе
    private int cupsCount;

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

    public void makeCoffee() {
        if (isReady()) {
            cupsCount+= water / MIN_WATER;
            coffee = 0;
            water = 0;
        }
    }

    public void addWater(int w) {
        water += w;
        if(water > MAX_WATER) {
            water = MAX_WATER;
        }
        System.out.println(w);
    }

    public void addCoffee(int c) {
        coffee += c;
        if(coffee > MAX_COFFEE) {
            coffee = MAX_COFFEE;
        }
        System.out.println(c);
    }

    public void makeEmpty() {
        coffee = 0;
        water = 0;
    }

    public int getCupsCount() {
        return cupsCount;
    }

    public void setCupsCount(int cupsCount) {
        this.cupsCount = cupsCount;
    }
}
