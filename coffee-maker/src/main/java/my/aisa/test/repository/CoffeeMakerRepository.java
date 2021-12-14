package my.aisa.test.repository;

import my.aisa.test.models.CoffeeMaker;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CoffeeMakerRepository extends JpaRepository<CoffeeMaker, String> {

}
