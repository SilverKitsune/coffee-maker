package my.aisa.test.dao;

import my.aisa.test.models.Action;
import my.aisa.test.repository.ActionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ActionDAO {
    private ActionRepository actionRepository;

    @Autowired
    public ActionDAO(ActionRepository actionRepository) {
        this.actionRepository = actionRepository;
    }

    public void add(Action action) {
        actionRepository.save(action);
    }

    public List<Action> index() {
        return actionRepository.findAll();
    }

}
