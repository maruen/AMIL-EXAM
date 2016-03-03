package pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Match {

    private Date   startTime;
    private Date   endTime;
    private String matchName;
    List<Killing>  killings = new ArrayList<Killing>();
    
    
    public Match(Date startTime, String matchName) {
        super();
        this.startTime = startTime;
        this.matchName = matchName;
    }
    
    
    public Date getStartTime() {
        return startTime;
    }
    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }
    public Date getEndTime() {
        return endTime;
    }
    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }
    public String getMatchName() {
        return matchName;
    }
    public void setMatchName(String matchName) {
        this.matchName = matchName;
    }
    public List<Killing> getKillings() {
        return killings;
    }
    public void setKillings(List<Killing> killings) {
        this.killings = killings;
    }


    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("Match [startTime=");
        builder.append(startTime);
        builder.append(", endTime=");
        builder.append(endTime);
        builder.append(", matchName=");
        builder.append(matchName);
        builder.append(", \t\tkillings=");
        builder.append(killings);
        builder.append("]");
        return builder.toString();
    }

    
    
    
  
    
}
