package study;

import java.util.*;

public class SortSearchHashMap {
    public static void main(String[] args) {
        // puts values into map
        HashMap<String, String> statesHash = new HashMap<>();

        // creates binary search tree
        BinarySearchTree statesBST = new BinarySearchTree();

        for(int i=0; i < statesAndCapitals.length; i++){
            statesHash.put(statesAndCapitals[i][0], statesAndCapitals[i][1]);
        }

        // prints HashMap values
        mapValues(statesHash);

        for (String kv : statesHash.keySet()) {
            // inserts values into BinarySearchTree
            statesBST.insert(kv, statesHash.get(kv));
        }

        // converts statesHash into a TreeMap to sort the values
        TreeMap<String, String> statesTree = new TreeMap<>(statesHash);

        // uncomment next line to see the sorted TreeMap
        // mapValues(statesTree);

        // sets condition for while loop to keep running until user chooses
        boolean keepRunning = true;

        while(keepRunning) {
            // asks user for a state
            System.out.println("Enter a state and the capital will be returned:");
            String answer = getAnswer();

            BinarySearchTree.Node state = statesBST.search(statesBST.root, answer);
            if (state != null) {
                System.out.println("The capital of " + answer + " is " + state.value);
            } else {
                System.out.println("No such state");
            }

            while(keepRunning) {
                // prompts user to choose whether to continue
                System.out.println("Would you like to continue? (y/n)");
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

    static void mapValues(Map<String, String> map) {
        map.entrySet().forEach(entry -> {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        });
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

