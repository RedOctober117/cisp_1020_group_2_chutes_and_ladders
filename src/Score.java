///*
// * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
// * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template


///**
// *
// * @author ryan
// */
public class Score implements PlayerTrait<Integer>{
    public static final String KEY = "Score";
    private int playerScore;

    /**
     * constructor that accepts an integer value for the score
     * @param n 
     */
    public Score(int n) {
        this.playerScore = n;
    }
    
    /**
     * changes the score of a specific player
     * @param n 
     */
    public void setScore(int n) {
        this.playerScore = this.playerScore + n;
    }
    
    /**
     * retrieves the score of a specific player
     * @return 
     */
    public int getScore() {
        return this.playerScore;
    }
    
    /**
     * uses the getScore method to return the value of the score trait
     * 
     * @return 
     */
    @Override
    public Integer getTraitValue(){
        return getScore();
    }
    
    /**
     * uses the setScore method and the values of the object to update the
     * score trait
     * 
     * @param score 
     */
    @Override
    public void setTraitValue(Integer score){
        setScore((int)(score));
    }
}
