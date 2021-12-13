package my.aisa.test.models;

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

    public int getCoffee() {
        return coffee;
    }

    public int getWater() {
        return water;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void turnOn() {
        if (isReady())
            System.out.println("Варит кофе");

    }

    public void addWater(int w) {
        water += w;
        //System.out.println("Налили " + w + " мл воды");
        if(water > MAX_WATER) {
            //System.out.println("Вылилось " + (water - MAX_WATER) + " мл воды");
            water = MAX_WATER;
        }
    }

    private boolean isReady() {
        return water > MIN_WATER && coffee > MIN_COFFEE;
    }

    public void addCoffee(int c) {
        coffee += c;
        //System.out.println("Насыпали " + c + "г кофе");
        if(coffee > MAX_COFFEE) {
            //System.out.println("Высыпалось " + (coffee - MAX_COFFEE) + " г кофе");
            coffee = MAX_COFFEE;
        }
    }

    public void takeCoffee() {
        coffee = 0;
        water = 0;
        //System.out.println("Можно сварить еще кофе");
    }
}
