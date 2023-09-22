import java.util.*;
import java.io.File;

/**
 * Parses commands for a command-line program.
 * 
 * This class takes an array of command-line inputs and then performs
 * operations like insert, delete, search and print based on the input commands.
 * 
 * @author Shankar Srinidhi Srinivas (shankarsrinidhi), Swetha Rajeev (rswetha)
 * @version 0.1
 * 
 */

public class CommandParser {

    private String[] args;
    private String worldSize; 
    private String commandFile; 


    public CommandParser(String[] args) {
        this.args = args;
        this.worldSize = args[0]; 
        this.commandFile = args[1]; 

    }

    public void parseInput() {
        try {
            Scanner sc = new Scanner(new File(commandFile));
            while (sc.hasNext()) {
                String cmd = sc.next();
                switch (cmd) {
                    case "insert":
                        int insertId = sc.nextInt();
                        sc.nextLine();
                        String inputTitle = sc.nextLine().trim();
                        String inputDate = sc.next();
                        int inputLength = sc.nextInt();
                        short inputX = sc.nextShort();
                        short inputY = sc.nextShort();
                        int inputCost = sc.nextInt();
                        sc.nextLine();
                        ArrayList<String> keyWordsAl = new ArrayList<String>();
                        Scanner lineScanner = new Scanner(sc.nextLine());
                        while (lineScanner.hasNext()) {

                            keyWordsAl.add(lineScanner.next());
                        }
                        String[] inputKeywords = new String[keyWordsAl.size()];
                        inputKeywords = keyWordsAl.toArray(inputKeywords);

                        String inputDesc = sc.nextLine().trim();

                        Seminar sem = new Seminar(insertId, inputTitle,
                            inputDate, inputLength, inputX, inputY, inputCost,
                            inputKeywords, inputDesc);

                        try {
                           
                            System.out.println("Successfully inserted record with ID " + insertId);
                            
                                    System.out.println("ID: " + insertId
                                        + ", Title: " + inputTitle);
                                    System.out.println("Date: " + inputDate
                                        + ", Length: " + inputLength + ", X: "
                                        + inputX + ", Y: " + inputY + ", Cost: "
                                        + inputCost);
                                    System.out.println("Description: "
                                        + inputDesc);
                                    System.out.print("Keywords: ");
                                    for (int i =
                                        0; i < inputKeywords.length; i++) {
                                        if (i != inputKeywords.length - 1)
                                            System.out.print(inputKeywords[i]
                                                + ", ");
                                        else
                                            System.out.print(inputKeywords[i]
                                                + "\n");
                                    }
                                    
                                
                            
                        }
                        catch (Exception e) {
                            e.printStackTrace();
                        }

                        break;
                        
                        
                    case "delete":
                        int deleteId = sc.nextInt();
                        sc.nextLine();
                        break;
                        
                        
                    case "search":
                        String searchType = sc.next();
                        switch (searchType) {
                            case "ID":
                                int searchId = sc.nextInt();
                                break;
                            case "cost":
                                int lowCost = sc.nextInt();
                                int highCost = sc.nextInt();
                                break;
                            case "date":
                                String lowDate = sc.next();
                                String highDate = sc.next();
                                break;
                            case "keyword":
                                String searchKeyword = sc.next();
                                break;
                            case "location":
                                short X = sc.nextShort();
                                short Y = sc.nextShort();
                                int radius = sc.nextInt();
                                break;
                                
                        }
                        
                        break;
                        
                    case "print":
                        String printType = sc.next();
                        switch (printType) {
                            case "ID":
                                
                                break;
                            case "cost":
                                
                                break;
                            case "date":
                                
                                break;
                            case "keyword":
                                
                                break;
                            case "location":
                                
                                break;
                                
                        }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}