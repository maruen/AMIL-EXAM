import junit.framework.TestCase;


public class SolutionTest extends TestCase {

    protected void setUp() throws Exception {
        super.setUp();
    }
    
    public void testExample() throws Exception {
        
        String expected = "Rankings"                    + "\n" + 
                "Match: 11348965"                       + "\n" + 
                "Nickname Roman has done 1 killings"    + "\n" + 
                "Nickname Nick has suffered 1 deaths"   + "\n";
        
        String actual = Solution.getRankings("example.log");
        assertEquals( expected, actual);
    }
    
    
    public void testInput1() throws Exception {
        
        String expected = "Rankings"                    + "\n" + 
                "Match: 11348965"                       + "\n" + 
                "Nickname Roman has done 5 killings"    + "\n" + 
                "Nickname Nick has suffered 5 deaths"   + "\n";
        
        String actual = Solution.getRankings("input1.log");
        assertEquals( expected, actual);
    }
    
    public void testInput2() throws Exception {
        
        String expected = "Rankings"                    + "\n" +
                "Match: 1"                              + "\n" +
                "Nickname Andrew has done 1 killings"   + "\n" +
                "Nickname Roman has done 1 killings"    + "\n" +
                "Nickname Scott has done 1 killings"    + "\n" +
                "Nickname Nick has suffered 1 deaths"   + "\n" +
                "Nickname Roman has suffered 1 deaths"  + "\n" +
                "Nickname Scott has suffered 1 deaths"  + "\n" +    
                "Match: 2"                              + "\n" +
                "Nickname John has done 1 killings"     + "\n" +
                "Nickname karl has suffered 1 deaths"   + "\n";
       
       
        String actual = Solution.getRankings("input2.log");
        assertEquals( expected, actual);
   }
    
    
    /**
     * Bônus Item, first question test
     */
    
    public void testInput3() throws Exception {
        
         String expected = "Rankings"                                   + "\n" + 
        "Match: 1"                                                      + "\n" + 
        "Nickname Andrew has done 1 killings"                           + "\n" + 
        "Nickname Roman has done 1 killings"                            + "\n" + 
        "Nickname Scott has done 3 killings"                            + "\n" + 
        "Nickname Nick has suffered 1 deaths"                           + "\n" + 
        "Nickname Roman has suffered 1 deaths"                          + "\n" + 
        "Nickname Scott has suffered 1 deaths"                          + "\n" + 
        "Bonus Questions"                                               + "\n" + 
        "The winner was: Scott and the weapon that more killed was M17" + "\n" + 
        "Match: 2"                                                      + "\n" + 
        "Nickname John has done 1 killings"                             + "\n" + 
        "Nickname karl has suffered 1 deaths"                           + "\n" + 
        "Bonus Questions"                                               + "\n" + 
        "The winner was: Scott and the weapon that more killed was M17" + "\n";
        
        
         String actual = Solution.getRankings("input3.log",true);
         assertEquals( expected, actual);
    }
    
    
    
    public void testInput4() throws Exception {
        
        String expected = "Rankings"                                    + "\n" + 
       "Match: 1"                                                       + "\n" + 
       "Nickname Andrew has done 1 killings"                            + "\n" + 
       "Nickname Roman has done 1 killings"                             + "\n" + 
       "Nickname Scott has done 3 killings"                             + "\n" + 
       "Nickname Nick has suffered 1 deaths"                            + "\n" + 
       "Nickname Roman has suffered 1 deaths"                           + "\n" +
       "Bonus Questions"                                                + "\n" + 
       "The winner was: Scott and the weapon that more killed was M17"  + "\n" + 
       "The player Scott has an award for not beeing killed in a match" + "\n" + 
       "Match: 2"                                                       + "\n" + 
       "Nickname John has done 1 killings"                              + "\n" + 
       "Nickname karl has suffered 1 deaths"                            + "\n" + 
       "Bonus Questions"                                                + "\n" + 
       "The winner was: Scott and the weapon that more killed was M17"  + "\n" +
       "The player Scott has an award for not beeing killed in a match" + "\n";
       
       
        String actual = Solution.getRankings("input4.log",true);
        assertEquals( expected, actual);
   }
    
    
    
    
    protected void tearDown() throws Exception {
        super.tearDown();
    }

}
