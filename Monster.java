/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rpgprototype;

import java.util.Random;
import static rpgprototype.Player.name;

/**
 *
 * @author 176878
 */
public class Monster {
    static String name;
    static int maxhp;
    static int currenthp;
    static int damage;
        
    public static void attack(){
                Random randAttack = new Random();
                damage = randAttack.nextInt(10)+1;
                Player.currentHP = Player.currentHP - damage;
                System.out.println(name + " attacked you for " + damage + " damage!\n");
                Player.playerDead();
                
    
    }  
    
    public static String monsterName(){
    String nameList[] = {"Goblin", "Troll", "Bee"};
    Random rand = new Random();
    int x = rand.nextInt(3);
    return nameList[x];
    }
    
    public static int monsterHP(){
        Random rand = new Random();
        int x =  rand.nextInt(20)+1;
        return x;
        
    }
    public static boolean stateCheck(){
        if (Monster.currenthp <= 0){
                    System.out.println(Monster.name + " has been defeated! \n");
        return false;        
        }
        else {
                    System.out.println(Monster.name + " has " + Monster.currenthp + " HP left...\n ");
            return true;
        }
       
    }
   
    public Monster(){
       Monster.name = monsterName();
       Monster.currenthp = monsterHP(); 
    }
}
