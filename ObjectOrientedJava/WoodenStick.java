
public class WoodenStick extends HockeyStick {
    
    private static final String material = "WOOD";
    private int lie;
    private int flex;
    
    public WoodenStick(int length, boolean isCurved){
        super(length, isCurved, material);
    }
    
    public WoodenStick(int length, boolean isCurved, int lie, int flex){
        super(length, isCurved, material);
        this.lie = lie;
        this.flex = flex;
    }

    public int getLie() {
        return lie;
    }

    public void setLie(int lie) {
        this.lie = lie;
    }

    public int getFlex() {
        return flex;
    }

    public void setFlex(int flex) {
        this.flex = flex;
    }
}
