package com.company;

import java.util.*;

public class ElizaChatbot {

    public static void main(String[] args) {

        // Create Random and Scanner objects
        Scanner keyboard = new Scanner(System.in);
        Random random = new Random();

        // Initialize answer to an empty string
        String answer = "";

        // Add first-person pronouns as keys with their second-person equivalencies as values to a hash map
        HashMap<String, String> replacements = new HashMap<>();
        replacements.put("I", "you");
        replacements.put("me", "you");
        replacements.put("my", "your");
        replacements.put("am", "are");

        // Create ArrayList of Strings and add hedges to it
        ArrayList<String> hedges = new ArrayList<>();
        hedges.add(0, "Please tell me more.");
        hedges.add(1, "Many of my patients tell me the same thing.");
        hedges.add(2, "It is getting late, maybe we had better quit.");

        // Prompt the user to enter his or her problem and get the response
        System.out.print("Good day. What is your problem? Enter your response here or Q to quit: ");
        answer = keyboard.nextLine();

        // Initialize loop count to zero
        int loopCount = 0;
        // Continue the dialogue between Eliza and the user until the user enter Q or q
        while (!(answer.equalsIgnoreCase("Q"))) {
            // Create dialogues with the user if the loop count is not 8
            if (loopCount != 8) {
                // Create ArrayList and add qualifiers with the second-person version of user's responses
                ArrayList<String> qualifiers = new ArrayList<>();
                // Assign returned String from replaceWords
                String secondPersonSentence = replaceWords(replacements, answer);
                qualifiers.add(0, "Why do you say that " + secondPersonSentence + "?");
                qualifiers.add(1, "You seem to think that " + secondPersonSentence + ".");
                qualifiers.add(2, "So, you are concerned that " + secondPersonSentence + ".");

                // Display Eliza's response to the user randomly
                System.out.print(
                        (random.nextBoolean() ? (hedges.get(random.nextInt(1)))
                        : qualifiers.get(random.nextInt(qualifiers.size())))
                        + " Enter your response here or Q to quit: ");
                answer = keyboard.nextLine();
            } else {
				/* If the loop counts gets to 8,
					the "chat-bot" breaks the while loop and terminates the program */
                System.out.print(hedges.get(2));
                break;
            }
            loopCount++;
        }

        keyboard.close();
    }

    /* This method is responsible for splitting first-person sentence
        and returns a second-person sentence */
    public static String replaceWords(HashMap<String, String> map, String message) {

        // Initialize new sentence to empty string
        String newSentence = "";
        // Convert the first-person sentence into an array of words using split
        String[] response = message.split(" ");
        for (int i = 0; i < response.length; i++) {

            // Change first person to second person with if-else statements
            if (map.containsKey(response[i]))
                response[i] = map.get(response[i]);

            // Add words separated by spaces if it's not the last word. If it is, just add the last word
            newSentence += ((i != response.length - 1) ? (response[i] + " ") : (response[i]));
        }
        return newSentence;
    }
}
