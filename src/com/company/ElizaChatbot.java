package com.company;

// Import Random and Scanner classes
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;
import java.util.Scanner;


public class ElizaChatbot {

    public static void main(String[] args) {

        // Create Random and Scanner objects
        Scanner keyboard = new Scanner(System.in);
        Random random = new Random();

        // Initialize answer to an empty string
        String answer = "";


        HashMap<String, String> replacements = new HashMap<>();
        replacements.put("I", "you");
        replacements.put("me", "you");
        replacements.put("my", "your");
        replacements.put("am", "are");

        ArrayList<String> hedges = new ArrayList<>();
        hedges.add(0, "Please tell me more.");
        hedges.add(1, "Many of my patients tell me the same thing.");
        hedges.add(2, "It is getting late, maybe we had better quit.");

        ArrayList<String> qualifiers = new ArrayList<>();
        qualifiers.add(0, "Why do you say that ");
        qualifiers.add(1, "You seem to think that ");
        qualifiers.add(2, "So, you are concerned that ");
    }
}
