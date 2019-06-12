public class HockeyStick {
 
    private int length;
    private boolean curved;
    private String material;
    
    public HockeyStick(int length, boolean curved, String material){
        this.length = length;
        this.curved = curved;
        this.material = material;
    }
    
    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public boolean isCurved() {
        return curved;
    }

    public void setCurved(boolean curved) {
        this.curved = curved;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

}
