/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Mangl
 */
public class Test {

    public static void main(String[] args) {
        Player p1 = new Player("");
        Player p2 = new Player("B");
        Player p3 = new Player("De");
        Player p4 = new Player("Gamma");
        
        System.out.println("Player 1 nickname:");
        p1.setNickName(p1.getName());
        System.out.println((p1.getNickName()));
        
        System.out.println("");
        System.out.println("Player 2 nickname:");
        p2.setNickName(p2.getName());
        System.out.println((p2.getNickName()));
        
        System.out.println("");
        System.out.println("Player 3 nickname:");
        p3.setNickName(p3.getName());
        System.out.println((p3.getNickName()));
        
        System.out.println("");
        System.out.println("Player 4 nickname:");
        p4.setNickName(p4.getName());
        System.out.println((p4.getNickName()));
        
        System.out.println("");
        System.out.println("Player numbers:");
        System.out.println(p1.getName() + " " + p1.getPlayerNum());
        System.out.println(p2.getName() + " " + p2.getPlayerNum());
        System.out.println(p3.getName() + " " + p3.getPlayerNum());
        System.out.println(p4.getName() + " " + p4.getPlayerNum());
        
        System.out.println("");
        System.out.println("Player numbers test 2. Numbers should be the same");
        System.out.println(p1.getName() + " " + p1.getPlayerNum());
        System.out.println(p2.getName() + " " + p2.getPlayerNum());
        System.out.println(p3.getName() + " " + p3.getPlayerNum());
        System.out.println(p4.getName() + " " + p4.getPlayerNum());
        
    }

}
