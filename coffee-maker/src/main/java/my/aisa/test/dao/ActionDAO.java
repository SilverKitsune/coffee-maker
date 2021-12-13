package my.aisa.test.dao;

import my.aisa.test.models.Action;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ActionDAO {
    private List<Action> actions = new ArrayList<>();

    public void add(Action action) {
        actions.add(action);
    }

    public List<Action> index() {
        return actions;
    }

}
