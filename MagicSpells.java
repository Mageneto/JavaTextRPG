/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rpgprototype;

import java.util.Random;
import static rpgprototype.Player.alive;

/**
 *
 * @author 176878
 */
public class MagicSpells {
    static String name;
    static int healAmt;
    static int dmgAmt;
    static int mpCost;
    
    public static void castSpell(int i){
    String nameList[] = {"Fireball", "Heal", "Petrify"};
    if(i == 1){
        System.out.println("Casting " + nameList[0] + "!");
            Random randAttack = new Random();
            int attack = randAttack.nextInt(20)+1;
            System.out.println("Your " + nameList[0] + " hit " + Monster.name + " for " + attack + " damage!");
            Monster.currenthp = (Monster.currenthp - attack);
                if (Monster.stateCheck() == true){
                    Monster.attack();
                    if(alive == true){
                    Player.fightMenu();
                    }
                }
                else{
                    RPGPrototype.update();
                }
    }
    else if (i == 2){
        System.out.println("Casting " + nameList[1] + "!");
        Random randHeal = new Random();
        int heal = randHeal.nextInt(10)+1;
        System.out.println("Your " + nameList[1] + " spell healed you for " + heal + " HP!");
        Player.currentHP = (Player.currentHP + heal);
        if (Monster.stateCheck() == true){
                    Monster.attack();
                    if(alive == true){
                    Player.fightMenu();
                    }
                }
                else{
                    RPGPrototype.update();
                }
    }
    else if (i == 3){
        System.out.println("Casting " + nameList[2] + "!");
    }
    
    }
    public MagicSpells(){
       
    }
}
