/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Mangl
 */
public class Player 
{
    private String name;
    private static int lastPlayerNum = 0; 
    private int playerNum;
    private String nickName;


    /**
     * Creates a Player object. Only needs a name for input
     * Also ensures that every player has an individual number
     * @param name 
     */
    public Player(String name) {
        this.name = name;
        lastPlayerNum++;
        playerNum = lastPlayerNum;
    }    

    /**
     * Sets the name for a player, in case you want to change it
     * @param name 
     */
    public void setName(String name) 
    {
        this.name = name;
    }
    
    /**
     * Sets the nickname for a given player, fills in blank space if name is too short
     * @param nickName 
     */
    public void setNickName(String nickName)
    {
        while(name.length() < 3)
        {
            name = name +"#";  //This can be whatever chracter works best. # is a placeholder
        }
        this.nickName = name.substring(0, 3);
    }

    /**
     * Returns a given player's name
     * @return 
     */
    public String getName() 
    {
        return name;
    }


    /**
     * Returns a given player's number
     * @return 
     */
    public int getPlayerNum() {
        return playerNum;
    }

    public String getNickName() {
        return nickName.toUpperCase();
    }  
}
