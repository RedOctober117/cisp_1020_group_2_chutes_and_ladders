/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */

/**
 *
 * @author michaelrawiszer
 */
public class Events {
//instance varaibles
    public int source;
    public int destination;
    
    /**
     * events refers to when a player lands on the start of a chute or ladder
     * the chute or ladder has a source and a destination associated with it
     * 
     * @param source
     * @param destination 
     */
    public Events(int source, int destination)
    {
        this.source = source;
        this.destination = destination;
    }

    /**
     * changes the value of the source
     * @param source 
     */
    public void setSource(int source) {
        this.source = source;
    }
    
    /**
     * changes the value of the destination
     * @param destination 
     */
    public void setDestination(int destination) {
        this.destination = destination;
    }

    /**
     * returns the value of the source
     * @return 
     */
    public int getSource() {
        return source;
    }

    /**
     * returns the value of the destination
     * @return 
     */
    public int getDestination() {
        return destination;
    }
    
    /**
     * returns the source and destination values of the event as a string
     * @return 
     */
    @Override
    public String toString()
    {
        return "Source: " + source + " Destination: " + destination;
    }
}
