import java.util.StringTokenizer;
import java.util.Scanner;
public class CollectionManager {

    public static void main(String[]args){
        run();
    }

    public static void run(){
        Scanner sc = new Scanner(System.in);
        int i = 0;

        //Read in letter, Song, Artist as long as not Q

        //*->>>>>>>>>>>>>>>>>>>>DEAL WITH MISSING LAST LINE<<<<<<<<<<<<-*
        while(sc.hasNextLine()) {
            String inputLine = sc.nextLine();
            StringTokenizer st = new StringTokenizer(inputLine, ",");
            String letter = st.nextToken();
            int cmd = checkValidity(letter,st);
            //Invalid
            if(cmd==6){
                System.out.println("Invalid input!");
                sc.close();
                return;
            }
            //Q
            if(cmd==5){
                System.out.println("Collection Manager: Terminated.");
                sc.close();
                return;
            }
            //Print the msg only once it's clear it's running good
            if(i==0){
                System.out.println("Collection Manager Started.");
                i++;
            }
            doCommand(cmd, st);
        }
    }

    public static int checkValidity(String letter, StringTokenizer st){
        //Check st isn't null
        if(null==st){
            System.out.println("null=st");
            return 6;
        }
        //If it's Q, get outta there
        if(letter.equals("Q")){
            System.out.println("It's Q!");
            return 5;
        }
        //Check st has at least 3 tokens of (letter,artist,song,genre, date) -> min: letter,artist, song
        if(st.countTokens()<2){
            return 6;
        }
        //Check which command it is, else 6 for invalid.
        String[] validInputs = {"A","D","L","R","P"};
        int commandNum = 6;
        for(int i = 0; i < validInputs.length; i++){
            if(letter.equals(validInputs[i])){
                commandNum=i;
            }
        }
        //Assuming other inputs other than letter are correctly formatted
        return commandNum;
    }

    private static boolean checkCapitalized(String str){
        String upperStr = str.toUpperCase();
        return str.equals(upperStr);
    }

    //Takes the valid input and calls the places
    private static void doCommand(int a, StringTokenizer st){
        if(a==0){
            System.out.println("Doing command for A");
        }
        if(a==1){
            System.out.println("Doing command for D");
        }
        if(a==2){
            System.out.println("Doing command for L");
        }
        if(a==3){
            System.out.println("Doing command for R");
        }
        if(a==4){
            System.out.println("Doing command for P");
        }
    }
}
