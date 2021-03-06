public class Center extends Player implements PlayerType {
    
    private int totalShots;
    private int shotsOnGoal;
    private int steals;

    public Center(){
        super.setPosition("CENTER");
    }
    
    public int getTotalShots() {
        return totalShots;
    }

    public void setTotalShots(int totalShots) {
        this.totalShots = totalShots;
    }

    public int getShotsOnGoal() {
        return shotsOnGoal;
    }

    public void setShotsOnGoal(int shotsOnGoal) {
        this.shotsOnGoal = shotsOnGoal;
    }

    public int getSteals() {
        return steals;
    }

    public void setSteals(int steals) {
        this.steals = steals;
    }
    
    
}
