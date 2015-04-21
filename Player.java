/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rpgprototype;

import java.util.Random;
import java.util.Scanner;
import static rpgprototype.Monster.name;
import static rpgprototype.RPGPrototype.choiceIsWithinRange;
import static rpgprototype.RPGPrototype.getInteger;

/**
 *
 * @author 176878
 */
public class Player {
    static String name;
    static int currentHP;
    static int maxHP;
    static int currentMP;
    static int maxMP;
    static float damage;
    static boolean alive = true;
    
    public static void playerDead(){
        if (Player.currentHP <= 0 || alive == false){
            alive = false;
            System.out.println("You were slain by a " + Monster.name + "...");
            System.out.println("Your bravey and noble deeds shall not be forgotten...\n");
            System.out.println("You survived for " + RPGPrototype.days + " days...");
            System.out.println("Do you want to start a new quest? (Y or N)");
            Scanner reader = new Scanner(System.in);
            Scanner input = new Scanner(System.in);
            String in = "";
            char c = reader.next().trim().charAt(0);
            RPGPrototype.restartGame(c);
            
        }
 
    else alive = true;
    }
    
    public static void attack(){
                Random randAttack = new Random();
                int attack = randAttack.nextInt(10)+1;
                System.out.println("You attacked " + Monster.name + " for " + attack + " damage!");
                Monster.currenthp = (Monster.currenthp - attack);
                if (Monster.stateCheck() == true){
                    Monster.attack();
                    if(alive == true){
                    fightMenu();
                    }
                }
                else{
                    RPGPrototype.update();
                }
    }
    
    public static void run(){
        Random rand = new Random();
        int runChance = rand.nextInt(10)+1;
        if (runChance >= 5){
            System.out.println("You escaped the " + Monster.name + "!\n");
            RPGPrototype.update();
        }
        else {
            System.out.println("You are trapped!");
            Monster.attack();
            playerDead();
            fightMenu();
        }
    }
    
    public static void magic(){
        System.out.println("Max MP: " + maxMP);
                System.out.println("Current MP: " + currentMP);
                System.out.println("Choose a spell...");
                System.out.println("1. Fireball!");
                System.out.println("2. Heal!");
                System.out.println("3. Petrify!");
                System.out.println("4. Cancel");
                int verifiedInt = getInteger("Choice: ");
                System.out.println("\n");
                choiceIsWithinRange(verifiedInt);
                if ( verifiedInt == 1){
                    MagicSpells.castSpell(1);
                }
                else if (verifiedInt == 2){
                    MagicSpells.castSpell(2);
                            }
                else if (verifiedInt == 3){
                       
                            }
                else if (verifiedInt == 4){
                       Player.fightMenu();
                            }
    }
    
    public static void defend(){
        Random rand = new Random();
        int block = rand.nextInt(10)+1;
        Monster.damage = (rand.nextInt(10)+1);
        System.out.println(Monster.name + " attacked you for " + Monster.damage + " damage!");
        Monster.damage = Monster.damage - block;
        if (Monster.damage < 0){
            Monster.damage = 0;
        }
            
        Player.currentHP = Player.currentHP - Monster.damage;
        if (Monster.damage <= 0){
            Monster.damage = 0;
        
    }
        System.out.println("You defend and blocked " + block + " damage from " + Monster.name + "'s attack!");
        System.out.println(Monster.name + " hit you for " + Monster.damage + " damage\n");
        playerDead();
        if (alive == true){
        fightMenu();
        }
    }      

    public static void fightMenu(){
                System.out.println("Max HP: " + maxHP);
                System.out.println("Current HP: " + currentHP);
                System.out.println("What will you do?");
                System.out.println("1. Attack!");
                System.out.println("2. Magic!");
                System.out.println("3. Defend!");
                System.out.println("4. Run!");
                int verifiedInt = getInteger("Choice: ");
                System.out.println("\n");
                choiceIsWithinRange(verifiedInt);
                if ( verifiedInt == 1){
                    Player.attack();
                }
                else if (verifiedInt == 2){
                       Player.magic();
                            }
                else if (verifiedInt == 3){
                       Player.defend();
                            }
                else if (verifiedInt == 4){
                       Player.run();
                            }
                   
    }
    }
