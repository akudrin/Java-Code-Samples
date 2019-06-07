
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Statistics implements Serializable {
    
    // Definition for the class instance
    private static final Statistics instance = new Statistics();

    private List teams = new ArrayList();

    private Statistics(){ 
    }

    public static Statistics getInstanceEager(){

        return instance;
    }

    public List getTeams() {
        return teams;
    }

    public void setTeams(List teams) {
        this.teams = teams;
    }
    
    protected Object readResolve(){
        return instance;
    }
    
}
