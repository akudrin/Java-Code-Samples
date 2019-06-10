import java.util.ArrayList;
import java.util.List;


public class InterfaceTester {

    static TeamType team = new Team();
    public static void main(String[] args){
        Player player1 = new HockeyPlayer();
        player1.setFirstName("Jonathan" );
        player1.setFirstName("Gennick");
        Player player2 = new HockeyPlayer();
        player2.setFirstName("Josh");
        player2.setLastName("Juneau");
        List<Player> playerList = new ArrayList();
        playerList.add(player1);
        playerList.add(player2);
        
        Team team1 = new Team();
        team1.setPlayers(playerList);
        // Call the default method
        team1.listPlayers();

        team.setCity("SomeCity");
        team.setName("SomeName");
        team.setPlayers(null);
        System.out.println(team.getFullName());
        
    }
}
