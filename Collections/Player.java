public class Player {
    
    private String firstName = null;
    private String lastName = null;
    private String position = null;
    private int status = -1;
    private int goals;
    
    public Player(){
        
    }
    
    public Player(String position, int status){
        this.position = position;
        this.status = status;
    }
    
    public Player(String first, String last, int goals){
        this.firstName = first;
        this.lastName = last;
        this.goals = goals;
    }
    
    public Player(String position, int status, String first, String last){
        this.position = position;
        this.status = status;
        this.firstName = first;
        this.lastName = last;
    }
    
    protected String playerStatus(){
        String returnValue = null;
        
        switch(getStatus()){
                case 0:
                        returnValue = "ACTIVE";
                case 1:
                        returnValue = "INACTIVE";
                case 2:
                        returnValue = "INJURY";
                default:
                        returnValue = "ON_BENCH";
        }
        
        return returnValue;
    }
    
    public String playerString(){
        return getFirstName() + " " + getLastName() + " - " + getPosition();
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getGoals() {
        return goals;
    }

    public void setGoals(int goals) {
        this.goals = goals;
    }
    
    public static int compareByGoal(Player a, Player b){
        int eval;
        if(a.getGoals() > b.getGoals()){
            eval = 1;
        } else if (a.getGoals() < b.getGoals()){
            eval = -1;
        } else {
            eval = 0;
        }
        return eval;
    }

}

