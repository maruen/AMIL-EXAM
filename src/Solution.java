import java.io.FileNotFoundException;
import java.io.FileReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import pojo.Killing;
import pojo.Match;


public class Solution {
    
    private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss"); 

    public static String getRankings(String filename, Boolean returnBonusQuestions) {
        
        Scanner in = null;
        
        List<Match> allMatches = new ArrayList<Match>();
       
        try {
            in = new Scanner(new FileReader(filename));
            
            Match currentMatch = null;
            while(in.hasNext()) {
                
                String line = in.nextLine();
                String[] lineSplited = line.split("-");
                String timeAsString  = lineSplited[0];
                String description   = lineSplited[1].trim();
                
                Date dateAsDate;
                try {
                    dateAsDate = sdf.parse(timeAsString);
                } catch (ParseException e) {
                    continue;
                }
                
                if (description.contains("New match")) {
                    
                    String matchName = description.split(" ")[2];
                    currentMatch = new Match(dateAsDate, matchName);
                
                } else if (description.contains("has ended")){
                    allMatches.add(currentMatch);
          
                } else if (description.contains("killed")) {
                    
                    String  playerThatKills     = description.split(" ")[0];
                    String  playerThatDies      = description.split(" ")[2];
                    Integer killingMethodIndex  = description.split(" ").length -1;
                    String  killingMethod       = description.split(" ")[killingMethodIndex];
                    
                    Killing newKilling = new Killing(dateAsDate,
                                                     killingMethod,
                                                     playerThatKills,
                                                     playerThatDies);
                
                    currentMatch.getKillings().add(newKilling);
                }
            }
            
            
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally  {
            in.close();
        }
     
        HashMap<String,Integer> killings                 = new HashMap<String,Integer>();
        HashMap<String,Integer> deaths                   = new HashMap<String,Integer>();
        HashMap<String,Integer> preferredWeaponByPlayer   = new HashMap<String,Integer>();
        
        
        StringBuffer result = new StringBuffer();
        result.append("Rankings").append("\n");
        
        for (Match match: allMatches) {
            result.append("Match: ").append(match.getMatchName()).append("\n");
            
            for (Killing killing: match.getKillings()) {
                if ( killing.getPlayerThatKills().equals("<WORLD>") ) {
                    Integer numberOfDeaths = deaths.getOrDefault(killing.getPlayerThatDies(), 0);
                    numberOfDeaths++;
                    deaths.put(killing.getPlayerThatDies(), numberOfDeaths);
                } else {
                    Integer numberOfKillings = killings.getOrDefault(killing.getPlayerThatKills(), 0);
                    numberOfKillings++;
                    killings.put(killing.getPlayerThatKills(), numberOfKillings);
                    
                    String key = killing.getPlayerThatKills().concat("-").concat(killing.getKillingMethod());
                    Integer killingsByPlayerAndWeapon = preferredWeaponByPlayer.getOrDefault(key,0);
                    killingsByPlayerAndWeapon++;
                    preferredWeaponByPlayer.put(key, killingsByPlayerAndWeapon);
                
                }
            }
         
            for (Map.Entry<String, Integer> entry : killings.entrySet()) {
                result.append("Nickname ")
                      .append(entry.getKey())
                      .append(" has done ")
                      .append(entry.getValue())
                      .append(" killings")
                      .append("\n");
            }
            
            for (Map.Entry<String, Integer> entry : deaths.entrySet()) {
                result.append("Nickname ")
                      .append(entry.getKey())
                      .append(" has suffered ")
                      .append(entry.getValue())
                      .append(" deaths")
                      .append("\n");
            }
            
            killings.clear();
            deaths.clear();
        }
        
        Integer preferedWeaponByPlayerCount = 0;
        String  winner                      = null;
        String  preferedWeapon              = null;
        for (Map.Entry<String, Integer> entry : preferredWeaponByPlayer.entrySet()) {
       
            if (entry.getValue() > preferedWeaponByPlayerCount ) {
                preferedWeaponByPlayerCount = entry.getValue();
                winner = entry.getKey().split("-")[0];
                preferedWeapon = entry.getKey().split("-")[1];
            }
        
        }
        
        
        if (returnBonusQuestions == Boolean.TRUE) {
        
            result.append("Bonus Questions\n")
                  .append("The winner was: ")
                  .append(winner)
                  .append(" and the weapon that more killed was ")
                  .append(preferedWeapon);
            
        }
        
        return result.toString();
   
  }
  
    
  public static String getRankings(String filename) {
      return getRankings(filename,false);
  }
    
    
  @SuppressWarnings("unused")
  private static void printLog(Scanner in) {
      int i = 0;
      while (in.hasNext()) {
          System.out.println("line " + i + " -> " + in.nextLine());
          i++;
      }
  }

}
