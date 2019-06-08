public class Goalie extends Player implements PlayerType {
    
    private int totalSaves;
    
    public Goalie(){
        this.setPosition("GOALIE");
    }
    
    public int getTotalSaves() {
        return totalSaves;
    }

    public void setTotalSaves(int totalSaves) {
        this.totalSaves = totalSaves;
    }
    
    
}
