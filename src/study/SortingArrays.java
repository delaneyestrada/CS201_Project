package study;

import java.util.Scanner;   // imports the Scanner class

public class SortingArrays {
    public static void main(String[] args) {
        // prints array values
        arrayValues(statesAndCapitals);
        // bubble sorts two-dimensional array by capital
        bubbleSort(statesAndCapitals);

        // sets condition for while loop to keep running until user chooses
        boolean keepRunning = true;

        while (keepRunning) {
            // sets counter to 0
            int numCorrect = 0;

            // iterates through each state
            for (int i = 0; i < 50; i++) {
                System.out.println("What is the capital of " + statesAndCapitals[i][0] + "?");
                // prompts user and stores answer in a variable
                String answer = getAnswer();
                if (answer.equalsIgnoreCase(statesAndCapitals[i][1])) {
                    System.out.println("Correct!");
                    // add 1 to counter
                    numCorrect++;
                } else {
                    System.out.println("Wrong!");
                }
            }

            // tells the user how many correct answers they got
            System.out.println("You got " + String.valueOf(numCorrect) + " correct answers!");

            while(keepRunning) {
                // prompts user to choose whether to try again
                System.out.println("Would you like to try again? (y/n)");
                String userContinue = getAnswer();

                // if the user enters "n" the while loop will stop at next condition check
                if (userContinue.equalsIgnoreCase("n")) {
                    keepRunning = false;
                }
                // if the user enters "y" the while loop continues
                else if (userContinue.equalsIgnoreCase("y")) {
                    break;
                } else {
                    System.out.println("Invalid input.");
                }
            }
        }
    }

    static String getAnswer() {
        // creates scanner
        Scanner scanner = new Scanner(System.in);

        // returns user input
        return scanner.nextLine();
    }

    static void arrayValues(String[][] array) {
        for (int i = 0; i < array.length; i++){
            System.out.println(array[i][0] + ": " + array[i][1]);
        }
    }

    static void bubbleSort(String[][] array){
        int numColumns = array.length;
        for(int i = 0; i < numColumns - 1; i++) {
            for(int j = 0; j < numColumns - i - 1; j++) {
                if (array[j][1].compareTo(array[j + 1][1]) > 0) {
                    String[] temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
    }
    // creates two-dimensional array to hold state and capital values
    private static String[][] statesAndCapitals = { { "Alabama", "Montgomery" }, { "Alaska", "Juneau" },
            { "Arizona", "Phoenix" }, { "Arkansas", "Little Rock" }, { "California", "Sacramento" },
            { "Colorado", "Denver" }, { "Connecticut", "Hartford" }, { "Delaware", "Dover" },
            { "Florida", "Tallahassee" }, { "Georgia", "Atlanta" }, { "Hawaii", "Honolulu" }, { "Idaho", "Boise" },
            { "Illinois", "Springfield" }, { "Maryland", "Annapolis" }, { "Minnesota", "Saint Paul" },
            { "Iowa", "Des Moines" }, { "Maine", "Augusta" }, { "Kentucky", "Frankfort" },
            { "Indiana", "Indianapolis" }, { "Kansas", "Topeka" }, { "Louisiana", "Baton Rouge" },
            { "Oregon", "Salem" }, { "Oklahoma", "Oklahoma City" }, { "Ohio", "Columbus" },
            { "North Dakota", "Bismark" }, { "New York", "Albany" }, { "New Mexico", "Santa Fe" },
            { "New Jersey", "Trenton" }, { "New Hampshire", "Concord" }, { "Nevada", "Carson City" },
            { "Nebraska", "Lincoln" }, { "Montana", "Helena" }, { "North Carolina", "Raleigh" },
            { "Missouri", "Jefferson City" }, { "Mississippi", "Jackson" }, { "Massachusetts", "Boston" },
            { "Michigan", "Lansing" }, { "Pennsylvania", "Harrisburg" }, { "Rhode Island", "Providence" },
            { "South Carolina", "Columbia" }, { "South Dakota", "Pierre" }, { "Tennessee", "Nashville" },
            { "Texas", "Austin" }, { "Utah", "Salt Lake City" }, { "Vermont", "Montpelier" },
            { "Virginia", "Richmond" }, { "Washington", "Olympia" }, { "West Virginia", "Charleston" },
            { "Wisconsin", "Madison" }, { "Wyoming", "Cheyenne" } };
}

