/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Mangl
 */
public class Name implements PlayerTrait<String>
{
    public static final String KEY = "Name";
    
    private String name;
    
    /**
     * adds each player's full name as a trait
     * not to be confused with identifier, which abbreviates the full name of
     * each player
     * @param name 
     */
    public Name(String name)
    {
        this.name = name;
    }
    
    /**
     * changes the value of name
     * @param name 
     */
    public void setName(String name) 
    {
        
    }
    
    /**
     * returns the value of name
     * @return 
     */
    public String getName() 
    {
        return name;
    }
    

    /**
     * uses the getName method to return the value of name as a trait
     * @return 
     */
    @Override
    public String getTraitValue() 
    {
        return getName();
    }

    /**
     * uses the setName method to change the value of name as a trait
     * @param name 
     */
    @Override
    public void setTraitValue(String name) 
    {
        setName(name);
    }
    
    /**
     * returns the trait key as well as the name associated with it
     * @return 
     */
    @Override
    public String toString() 
    {
        return String.format("{{Trait: %s} {Name: %s}}", Name.KEY, this.name);
    }
}
