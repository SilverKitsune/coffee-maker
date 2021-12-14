package my.aisa.test.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;


@Entity
@Table(name = "actions")
public class Action {
    @Id
    @Column(name = "date")
    private Date dateAndTime;

    @Column(name = "message")
    private String actionMessage;

    public Action() {
        dateAndTime = new Date();
        actionMessage = "Ничего не произошло";
    }

    public Action(String actionMessage) {
        this.actionMessage = actionMessage;
        this.dateAndTime = new Date();
    }

    public Date getDateAndTime() {
        return dateAndTime;
    }

    public void setDateAndTime(Date dateAndTime) {
        this.dateAndTime = dateAndTime;
    }

    public String getActionMessage() {
        return actionMessage;
    }

    public void setActionMessage(String actionMessage) {
        this.actionMessage = actionMessage;
    }
}
