

public class Test {

    public static void main(String[] args) {

        if (args.length > 0) {
        
            for (String s: args) {
               if (s.equals("true") || s.equals("false")) {
                   continue;
               }
               
               String filename = "../".concat(s);
               System.out.println(Solution.getRankings(filename,Boolean.valueOf(args[0])));
            }
        
        } else {
            System.out.println(Solution.getRankings("example.log",false));
        }
       
    }

}
