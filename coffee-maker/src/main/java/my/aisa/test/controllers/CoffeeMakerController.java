package my.aisa.test.controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import my.aisa.test.dao.CoffeeMakerDAO;
import my.aisa.test.models.CoffeeMaker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Validated
@RestController
@Tag(name = "Кофеварка", description = "Управление работой кофеварки")
@RequestMapping("/coffeeMaker")
public class CoffeeMakerController {

    private CoffeeMakerDAO coffeeMakerDAO;

    @Autowired
    public CoffeeMakerController(CoffeeMakerDAO coffeeMakerDAO) {
        this.coffeeMakerDAO = coffeeMakerDAO;
    }

    @PatchMapping("/addWater")
    @Operation(summary = "Загрузка воды", description = "Позволяет налить в кофеварку указанное количество воды")
    public HttpStatus addWater(@RequestBody Integer water) {
        if(water < 0) return HttpStatus.BAD_REQUEST;
        coffeeMakerDAO.addWater(water);
        System.out.println(coffeeMakerDAO.getWater());
        return HttpStatus.OK;
    }

    @PatchMapping("/addCoffee")
    @Operation(summary = "Загрузка кофе", description = "Позволяет насыпать в кофеварку указанное количество кофе")
    public HttpStatus addCoffee(@RequestBody int coffee) {
        if(coffee < 0) return HttpStatus.BAD_REQUEST;
        coffeeMakerDAO.addCoffee(coffee);
        System.out.println(coffeeMakerDAO.getCoffee());
        return  HttpStatus.OK;
    }

    @GetMapping("/makeEmpty")
    @Operation(summary = "Опустошение кофеварки", description = "Позволяет обнулить количество воды и кофе")
    public HttpStatus makeEmpty() {
        coffeeMakerDAO.makeEmpty();
        return HttpStatus.OK;
    }

    @GetMapping("/makeCoffee")
    @Operation(summary = "Производство напитка", description = "Варит кофе")
    public HttpStatus makeCoffee() {
        if(coffeeMakerDAO.makeCoffee() > 0) {
            return HttpStatus.OK;
        }
        return HttpStatus.BAD_REQUEST;
    }
    @GetMapping("/getStatus")
    @Operation(summary = "Получение всех текущих данных о кофеварке", description = "Позволяет получить все текущие данные о кофеварке")
    public ResponseEntity<CoffeeMaker> getStatus() {
        return ResponseEntity.ok(coffeeMakerDAO.currentState());
    }
}
