
public class Test {

    public static void main(String[] args) {

        if (args.length > 0) {
        
            for (String s: args) {
               String filename = "../".concat(s);
               System.out.println(Solution.getRankings(filename,true));
            }
        
        } else {
            System.out.println(Solution.getRankings("example.log",true));
        }
       
    }

}
