///*
// * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
// * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template


///**
// *
// * @author ryans
// */
public class Score implements PlayerTrait<Integer>{
    public static final String KEY = "Score";
    private int playerScore;

    public Score(int n) {
        this.playerScore = n;
    }

    public void setScore(int n) {
        this.playerScore = this.playerScore + n;
    }
    
    public int getScore() {
        return this.playerScore;
    }
    
    @Override
    public Integer getTraitValue(){
        return getScore();
    }
    
    @Override
    public void setTraitValue(Integer score){
        setScore((int)(score));
    }
}
