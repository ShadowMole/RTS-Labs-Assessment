import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;

public class Driver {

    private static BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));

    private static Assessment assessment = new Assessment();

    public static void main(String[] args){

        boolean replay = true;
        do {
            System.out.println("Hello, this is my solution for the RTS Assessment.");
            printMainMenu();
            boolean next = true;
            int command = -1;
            do {
                try {
                    command = Integer.parseInt(stdin.readLine());
                } catch (IOException ioe) {
                    next = false;
                    System.out.println("Please enter a valid input.");
                }
            } while (!next);
            replay = chooseMainMenu(command);
        } while(replay);
    }

    public static boolean chooseMainMenu(int command){
        boolean replay;
        switch(command){
            case 1:
                runAboveBelow();
                replay = true;
                break;

            case 2:
                runStringRotation();
                replay = true;
                break;

            case 3:
                System.out.println("Thank you for testing my submission. Have a good day.");
                replay = false;
                break;

            default:
                System.out.println("That is an invalid option, please try again.");
                replay = true;
                break;
        }
        return replay;
    }

    public static void runAboveBelow(){

        System.out.println("Please enter a list of integers separated by spaces:");
        String inputList = "";
        boolean next = true;
        do {
            try {
                inputList = stdin.readLine();
            } catch (IOException ioe) {
                next = false;
                System.out.println("Please enter a valid input.");
            }
        } while (!next);

        System.out.println("Please enter an integer to use as a comparison value:");
        int comparison = 0;
        do {
            try {
                comparison = Integer.parseInt(stdin.readLine());
            } catch (IOException ioe) {
                next = false;
                System.out.println("Please enter a valid input.");
            }
        } while (!next);

        String[] separatedInts = inputList.split(" ");
        ArrayList<Integer> list = new ArrayList<>();
        for(int i = 0; i < separatedInts.length; i++){
            list.add(Integer.parseInt(separatedInts[i]));
        }

        HashMap<String, Integer> counts = assessment.aboveBelow(list, comparison);

        System.out.println(counts);
    }


    public static void runStringRotation(){
        System.out.println("Please enter a string:");
        String input = "";
        boolean next = true;
        do {
            try {
                input = stdin.readLine();
            } catch (IOException ioe) {
                next = false;
                System.out.println("Please enter a valid input.");
            }
        } while (!next);

        System.out.println("Please enter the amount to the rotate the string by:");
        int rotationAmount = -1;

        do {
            try {
                rotationAmount = Integer.parseInt(stdin.readLine());
            } catch (IOException ioe) {
                next = false;
                System.out.println("Please enter a valid input.");
            }
        } while (!next);

        String rotated = assessment.stringRotation(input, rotationAmount);
        System.out.println(rotated);
    }

    public static void printMainMenu(){
        System.out.println("1. Test aboveBelow. \n2. Test stringRotation. \n3. Exit.");
    }
}
