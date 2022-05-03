package com.example.draft;

import java.util.Scanner;
public class WordleLab{
    
    //instance variables
    static Scanner input = new Scanner(System.in);
    
    static String WORDLE_OF_THE_DAY = "HAPPY";
    
    static String[] answer = new String[]{"_", "_", "_", "_", "_",};
    
    static final String[] alphabet = new String[]{"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z" };
    
    static String[] alphabetUser = new String[]{"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z" };

    //methods 
    public static void main(String[] args){
        int guessCount = 0;
        while(guessCount < 6){
            guessCount++;
            String userGuess = guess(guessCount);
            char[]guessAsChar = guessToChar(userGuess);
            analyzeGUESS(guessAsChar);
            printCONTENT(answer, alphabetUser);
            System.out.println("=====================");
            if(checkANSWER()){
                break;
            }
        }
        if(checkANSWER()){
            System.out.println("You finished the Wordle! Nice!");
        }
        else{
            System.out.println("You're out of tries! Try again!");
        }
    }

    public static String guess(int guessNUM){
        System.out.println("Guess number"+ guessNUM + ":");
        String userInput = input.nextLine();
        while(userInput.length() != 5){
            System.out.println("There is an error: the guess must be five letters only. Try again!");
            userInput = input.nextLine();
        }
        return userInput;
    }


    public static char[] guessToChar(String guess){
        char[] temp = new char[guess.length()];
        for(int i = 0; i< guess.length(); i++){
            temp[i] = guess.charAt(i);
        }
        return temp;
    }



    public static void analyzeGUESS(char[] guess){
        for(int i = 0; i < guess.length; i++){
            String character = String.valueOf(guess[i]).toUpperCase();
            if(character.equals(WORDLE_OF_THE_DAY.substring(i, i+1))){
                answer[i] = character;
            } else{
                int index = findIndexofALPHA(character);
                if(WORDLE_OF_THE_DAY.contains(character)){
                    alphabetUser[index] = character.toLowerCase();
                }else{
                    alphabetUser[index] = " ";
                }
            }
        }
    }


    public static int findIndexofALPHA(String key){
        for(int i = 0; i < alphabet.length; i++){
            if(alphabet[i].equals(key)){
                return i;
            }
        }
        return -1;
    }



    public static void printCONTENT(String[] solution, String[] alphabet){
        System.out.println("Current Solution is");
        for(String e : solution){
            System.out.println(e+" ");
        }
        System.out.println("");
        System.out.print("Remaining letters: ");
        for(int i = 0; i < alphabet.length ; i++){

            System.out.print(alphabet[i] + " ");
            if(i == 14) {
                System.out.println("");
                System.out.print("\t \t \t");
            }
        }
        System.out.println("");
    }


    public static boolean checkANSWER(){
        for(int i = 0; i < answer.length; i++){
            if(!answer[i].equals(WORDLE_OF_THE_DAY.substring(i, i+1))){
                return false;
            }

        }
        return true;
    }


}
