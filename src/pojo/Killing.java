package pojo;

import java.util.Date;

public class Killing {

   
    private Date   killingTime;
    private String killingMethod;
    private String playerThatKills;
    private String playerThatDies;
    
    
    public Killing(Date killingTime,
                   String killingMethod,
                   String playerThatKills,
                   String playerThatDies) {
        super();
        this.killingTime        = killingTime;
        this.killingMethod      = killingMethod;
        this.playerThatKills    = playerThatKills;
        this.playerThatDies     = playerThatDies;
    }


    public Date getKillingTime() {
        return killingTime;
    }


    public void setKillingTime(Date killingTime) {
        this.killingTime = killingTime;
    }


    public String getKillingMethod() {
        return killingMethod;
    }


    public void setKillingMethod(String killingMethod) {
        this.killingMethod = killingMethod;
    }


    public String getPlayerThatKills() {
        return playerThatKills;
    }


    public void setPlayerThatKills(String playerThatKills) {
        this.playerThatKills = playerThatKills;
    }


    public String getPlayerThatDies() {
        return playerThatDies;
    }


    public void setPlayerThatDies(String playerThatDies) {
        this.playerThatDies = playerThatDies;
    }


    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("\n\tKilling [killingTime=");
        builder.append(killingTime);
        builder.append(", playerThatKills=");
        builder.append(playerThatKills);
        builder.append(", playerThatDies=");
        builder.append(playerThatDies);
        builder.append(", killingMethod=");
        builder.append(killingMethod);
        builder.append("]");
        return builder.toString();
    }
    
    
    
   
   
    
}
