
package rpgprototype;
import java.io.*;
import rpgprototype.Monster;
import rpgprototype.Player;
import java.util.Scanner;

import java.util.Random;
/**
 *
 * @author 176878
 */
public class RPGPrototype  {
   
        static int days = 1;
    
        //Update function to keep the game progessing
        public static void update(){
            if(Player.alive == true){
        Scanner reader = new Scanner(System.in);
        System.out.println("You've been venturing for " + days + " days..." );
        System.out.println("Choose a direction to move");
        char c = reader.next().trim().charAt(0);
        keyPressed(c); 
        randomEncounter();
        update();
            }
            else Player.alive = false;
        }
        
        public static void start(){
            System.out.println("Welcome to the Jungle!");
            System.out.println("You're gonna die...\n");
            Player.maxHP = 20;
            Player.currentHP = 20;
            Player.maxMP = 20;
            Player.currentMP = 20;
            Player.alive = true;
            update();
        }
        
        //Determine if menu choice is within range
        public static boolean choiceIsWithinRange(Integer i){
        while (i >= 5){
            System.out.println("Invalid Selection");
            int n = getInteger("Choice: ");
            choiceIsWithinRange(n);
            return false;
        }
        return true;
    }
        
        //Determine if menu choice entered is an integer for input validation
        public static boolean isInteger(String s){

        if(s.isEmpty())return false;
            for (int i = 0; i <s.length();++i){
            char c = s.charAt(i);
        if(!Character.isDigit(c) && c !='-')
            return false;
    }
        return true;
}
        
        //Convert the string entered to an integer
        public static int getInteger(String prompt){
            Scanner input = new Scanner(System.in);
            String in = "";
            System.out.println(prompt);
            in = input.nextLine();
            isInteger(in);
            while(!isInteger(in)){
                System.out.println("Invalid Selection");
                System.out.println(prompt);
                in = input.nextLine();
               
            }
            int verifiedInt = Integer.parseInt(in);
            return verifiedInt;
        }
        //Encounter fight menu
       public static void randomEncounter(){
            Random rand = new Random();
            int x = rand.nextInt(10)+1;
            if (x <= 2){
                Monster newMonster = new Monster();
                    System.out.println("YOU ENCOUNTERED A WILD MONSTER!");
                    Player.fightMenu();
                    
                } 
            }
            
        public static void restartGame(char s){
            
            if (s == 'y' || s == 'Y'){
                start();
            }
            else if (s == 'n' || s == 'N'){
                System.exit(0);
            }
            else
                Player.playerDead();
                
        }

       //Determine which direction to move
        public static void keyPressed(char s){
                   
        if ( s == 'a' || s == 'A'){
            System.out.println("Heading West...\n");
            days++;
        }
        else if (s == 'd' || s == 'D'){
            System.out.println("Heading East...\n");
            days++;
        }
        else if (s == 'w' || s == 'W'){
            System.out.println("Heading North...\n");
            days++;
        }
        else if (s == 's' || s == 'S'){
            System.out.println("Heading South...\n");
            days++;
        }
        else{
            System.out.println("Invalid choice...");
            update();
        }
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
                  start();
        
    }
    
}
