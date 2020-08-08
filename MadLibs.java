// Name: Jesse Uong
// Date: 08/06/2020
// Class: CS 140
// Assigment: lab 5: Madlibs
// This program will present the user with 3 options that will respond through commands.

import java.io.*; // for File
import java.util.*; // for Scanner

public class MadLibs {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner console = new Scanner(System.in);
        
        intro();
        menu(console);
 
    }
    // intro to the game of madlibs
    public static void intro() {
        System.out.println("Welcome to the game of Mad Libs.");
        System.out.println("I will ask you to provide various words");
        System.out.println("and phrases to fill in a story.");
        System.out.println("The result will be written to an output file.");
    }
    
    // allows the user to choose between play, view or quit madlibs
    public static boolean menu(Scanner console) throws FileNotFoundException {
        System.out.println("(C)reate mad-lib, (V)iew mad-lib, (Q)uit? ");
        boolean playGame = true;
        String answer = console.next();
        	
		if(answer.charAt(0) == 'c' || answer.charAt(0) == 'C'){
			createMadLib(console);
			return true;
		}
		if(answer.charAt(0) == 'v' || answer.charAt(0) == 'V' ){
			viewMadLib(console);
			return true;
		}
		if(answer.charAt(0) == 'q' || answer.charAt(0) == 'Q'){
			return false;
		}
		else{
			System.out.println("Invalid answer. Please try again.");
			 return true;
		}
	}
    
    // create a game of madlib
    public static void createMadLib(Scanner console) throws FileNotFoundException {
        System.out.println("Input file name: ");
        String userIn = console.next();
        File fIn = new File(userIn); // imports a file based on the user's input

        while (!fIn.exists()) { // if file doesnt exist, ask them to try again
            System.out.println("File not found. Try again: ");
            userIn = console.next();
            fIn = new File(userIn);
        }

        Scanner input = new Scanner(fIn);
        System.out.println("Output file name: ");
        String userOut = console.next();
        File fOut = new File(userOut);  // creates a file for the output based on the user's input

        PrintStream output = new PrintStream(fOut);
        while (input.hasNext()) {  // reads each line of the imported file
            String placeHolder = input.next();
               
            // looks for spots that the user can input
            if (placeHolder.startsWith("<") && placeHolder.endsWith(">")) {
            
            char a = placeHolder.charAt(0);
            String vowel = String.valueOf(a);
         switch (vowel) {
                case "a":
                  vowel = " an";
                  break;
                case "A":
                  vowel = " an";
                  break;
                case "i":
                  vowel = " an";
                  break;
                case "I":
                  vowel = " an";
                  break;
                case "E":
                  vowel = " an";
                  break;
                case "e":
                  vowel = " an";
                  break;
                case "o":
                  vowel = " an";
                  break;
                case "O":
                  vowel = " an";
                  break;
                case "U":
                  vowel = " an";
                  break;
                case "u":
                    vowel = " an";
                    break;
                default:
                    vowel = " a";
                    break;
            }

                placeHolder = placeHolder.replace('<', ' ');
                placeHolder = placeHolder.replace('>', ' ');
                placeHolder = placeHolder.replace('-', ' ');
                System.out.println("Please type" + vowel + placeHolder);
                String userInput = console.next();
                output.print(" " + vowel + userInput + " ");

            } else if (placeHolder.endsWith(".")) {
                output.print(placeHolder);
                output.println();

            } else {
                output.print(" " + placeHolder + " ");
            }
        }
        System.out.println("Your mad-lib has been created!");
    }
    
    // Ask what file they want to view   
    public static void viewMadLib(Scanner console) throws FileNotFoundException {
        System.out.println("Please enter the file name that you would like to look at.");
        String userIn = console.next();
        Scanner input = new Scanner(new File(userIn));
        while (input.hasNextLine()) {
            String text = input.nextLine();
            System.out.println(text);
        }
    }
}