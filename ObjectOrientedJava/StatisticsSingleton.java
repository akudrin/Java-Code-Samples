
import java.util.ArrayList;
import java.util.List;

public enum StatisticsSingleton {
    INSTANCE;
    
    private final List teams = new ArrayList();
    
    public List getTeams() {
        return teams;
    }

    public void setTeams(List teams) {
        teams = teams;
    }
    
}
