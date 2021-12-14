package my.aisa.test.controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import my.aisa.test.dao.ActionDAO;
import my.aisa.test.models.Action;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Tag(name = "Отчет о работе кофеварки", description = "\"Лог\" работы кофеварки")
public class ActionController {
    final ActionDAO actionDAO;

    @Autowired
    public ActionController(ActionDAO actionDAO) {
        this.actionDAO = actionDAO;
    }

    @GetMapping("/actions")
    @Operation(summary = "Получение всех действий кофеварки", description = "Позволяет получить все данные о действиях кофеварки")
    public ResponseEntity<List<Action>> getStatus() {
        return ResponseEntity.ok(actionDAO.index());
    }
}
