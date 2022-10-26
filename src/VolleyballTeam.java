import java.util.ArrayList;

public class VolleyballTeam implements Comparable{
    private String teamName;
    private String stadiumName;
    private String coachName;
    private ArrayList<VolleyballPlayer> players;

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public String getStadiumName() {
        return stadiumName;
    }

    public void setStadiumName(String stadiumName) {
        this.stadiumName = stadiumName;
    }

    public String getCoachName() {
        return coachName;
    }

    public void setCoachName(String trainerName) {
        this.coachName = trainerName;
    }

    public ArrayList<VolleyballPlayer> getPlayers() {
        return players;
    }

    public void setPlayers(ArrayList<VolleyballPlayer> players) {
        this.players = players;
    }

    public VolleyballTeam() {
        this.teamName = "default";
        this.stadiumName = "default";
        this.coachName = "default";
        this.players = new ArrayList<>();
    }

    public VolleyballTeam(String teamName, String stadiumName, String coachName, ArrayList<VolleyballPlayer> players) {
        this.teamName = teamName;
        this.stadiumName = stadiumName;
        this.coachName = coachName;
        this.players = players;
    }
    public double calculateStrength(){
        double sum=0;
        for (VolleyballPlayer player : players) {
            sum+=player.getSkill();
        }
        return sum/players.size();
    }
    public void trainTeam() throws Exception {
        for (VolleyballPlayer player: players) {
            player.train();
            System.out.println();
        }
    }
    public void restTeam() throws Exception {
        for (VolleyballPlayer player: players) {
            player.rest();
            System.out.println();
        }
    }

    @Override
    public void compareTeamStrength(VolleyballTeam team2) {
        System.out.println("             TEAM COMPARISON");
        System.out.println("Libero:               " + getPlayers().get(0).getName() + " " + getPlayers().get(0).getSkill() + " : " + team2.getPlayers().get(0).getSkill() + " " + team2.getPlayers().get(0).getName());
        System.out.println("Setter:               " + getPlayers().get(1).getName() + " " + getPlayers().get(1).getSkill() + " : " + team2.getPlayers().get(1).getSkill() + " " + team2.getPlayers().get(1).getName());
        System.out.println("Right side hitter:    " + getPlayers().get(2).getName() + " " + getPlayers().get(2).getSkill() + " : " + team2.getPlayers().get(2).getSkill() + " " + team2.getPlayers().get(2).getName());
        System.out.println("Outside hitter:       " + getPlayers().get(3).getName() + " " + getPlayers().get(3).getSkill() + " : " + team2.getPlayers().get(3).getSkill() + " " + team2.getPlayers().get(3).getName());
        System.out.println("Middle blocker:       " + getPlayers().get(4).getName() + " " + getPlayers().get(4).getSkill() + " : " + team2.getPlayers().get(4).getSkill() + " " + team2.getPlayers().get(4).getName());
        System.out.println("Opposite:             " + getPlayers().get(5).getName() + " " + getPlayers().get(5).getSkill() + " : " + team2.getPlayers().get(5).getSkill() + " " + team2.getPlayers().get(5).getName());
        System.out.printf("Team overall:         " + getTeamName() + " " + calculateStrength() + " : " + team2.calculateStrength() + " " + team2.getTeamName());
    }

    @Override
    public String toString() {
        return "VolleyballTeam{" +
                "teamName='" + teamName + '\'' +
                ", stadiumName='" + stadiumName + '\'' +
                ", coachName='" + coachName + '\'' +
                ", players=\n" + players +
                '}';
    }
}
