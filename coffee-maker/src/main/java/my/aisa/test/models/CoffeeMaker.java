package my.aisa.test.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="coffeemakers")
public class CoffeeMaker {

    //Название кофеварки
    @Id
    @Column(name = "name")
    private String name;

    //количество кофе в граммах
    @Column(name = "coffee")
    private int coffee;

    //объем воды в миллилитрах
    @Column(name = "water")
    private int water;

    //количество сделаных чашек кофе
    @Column(name = "cupscount")
    private int cupsCount;

    //максимальная вместительность
    @Column(name = "max_coffee")
    public final int MAX_COFFEE;

    @Column(name = "max_water")
    public final int MAX_WATER;

    //необходимый минимум для приготовления кофе
    @Column(name = "min_coffee")
    public final int MIN_COFFEE;

    @Column(name = "min_water")
    public final int MIN_WATER;

    public CoffeeMaker() {
        MIN_WATER = 100;
        MAX_WATER = 500;
        MIN_COFFEE = 6;
        MAX_COFFEE = 30;
    }

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

    private boolean isReady() {
        return water > MIN_WATER && coffee > MIN_COFFEE;
    }


    /**
     * Имитация приготовления кофе. Все что было в резервуарах обнуляется,
     * а количество приготовленных кружек увеличивается в зависимости от объема воды.
     * @return true - если кофе и воды достаточно для варки кофе,
     *         false - если не хватает кофе или воды.
     */
    public boolean makeCoffee() {
        if (isReady()) {
            cupsCount+= water / MIN_WATER;
            coffee = 0;
            water = 0;
            return true;
        }
        return false;
    }

    /**
     *  Добавляет указанный объем воды в кофеварку. Если итоговый объем больше MAX_WATER,
     *  то лишняя вода "выливается" и значение остается равным MAX_WATER.
     * @param w - добавляемый объем воды
     */
    public void addWater(int w) {
        water += w;
        if(water > MAX_WATER) {
            water = MAX_WATER;
        }
    }

    /**
     *  Добавляет указанное количество кофе в кофеварку. Если итоговый вес больше MAX_COFFEE,
     *  то лишнее "высыпается" и значение остается равным MAX_COFFEE.
     * @param c - добавляемый вес кофе
     */
    public void addCoffee(int c) {
        coffee += c;
        if(coffee > MAX_COFFEE) {
            coffee = MAX_COFFEE;
        }
    }

    /**
     * Опустошение кофеварки
     */
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
