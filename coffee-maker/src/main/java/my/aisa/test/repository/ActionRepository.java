package my.aisa.test.repository;

import my.aisa.test.models.Action;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ActionRepository  extends JpaRepository<Action, String> {
}
