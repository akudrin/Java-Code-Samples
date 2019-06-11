import java.io.*;

public class Team implements TeamType, Cloneable, Serializable {

    private List<Player> players;
    private String name;
    private String city;
    private volatile int cachedHashCode = 0;

    public List<Player> getPlayers() {
        return players;
    }

    public void setPlayers(List<Player> players) {
        this.players = players;
    }

    public String getName() {
        return name;
    }

 
    public void setName(String name) {
        this.name = name;
    }


    public String getCity() {
        return city;
    }

  
    public void setCity(String city) {
        this.city = city;
    }

    public String getFullName() {
        return this.name + " - " + this.city;
    }


    @Override
    public Team clone() {

        Team obj = null;
        try {
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            ObjectOutputStream oos = new ObjectOutputStream(baos);
            oos.writeObject(this);
            oos.close();

            ByteArrayInputStream bais = new ByteArrayInputStream(baos.toByteArray());
            ObjectInputStream ois = new ObjectInputStream(bais);
            obj = (Team) ois.readObject();
            ois.close();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException cnfe) {
            cnfe.printStackTrace();
        }
        return obj;
    }


    public Team shallowCopyClone() {

        try {
            return (Team) super.clone();
        } catch (CloneNotSupportedException ex) {
            return null;
        }
    }

    @Override
    public boolean equals(Object obj) {

        if (this == obj) {
            return true;
        }
        if (obj instanceof Team) {
            Team other = (Team) obj;
            return other.getName().equals(this.getName())
                    && other.getCity().equals(this.getCity())
                    && other.getPlayers().equals(this.getPlayers());
        } else {
            return false;
        }

    }

    @Override
    public int hashCode() {
        int hashCode = cachedHashCode;
        if (hashCode == 0) {
            String concatStrings = name + city;
            if (players.size() > 0) {
                for (Player player : players) {
                    concatStrings = concatStrings
                            + player.getFirstName()
                            + player.getLastName()
                            + player.getPosition()
                            + String.valueOf(player.getStatus());

                }
            }
            hashCode = concatStrings.hashCode();
        }
        return hashCode;
    }
}
