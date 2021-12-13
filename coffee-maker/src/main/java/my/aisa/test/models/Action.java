package my.aisa.test.models;

public class Action {
    private String dateAndTime;
    private String actionMessage;

    public Action(String dateAndTime, String actionMessage) {
        this.actionMessage = actionMessage;
        this.dateAndTime = dateAndTime;
    }

    public String getDateAndTime() {
        return dateAndTime;
    }

    public void setDateAndTime(String dateAndTime) {
        this.dateAndTime = dateAndTime;
    }

    public String getActionMessage() {
        return actionMessage;
    }

    public void setActionMessage(String actionMessage) {
        this.actionMessage = actionMessage;
    }
}
