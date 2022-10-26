import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        VolleyballTeam team1 = new VolleyballTeam();
        VolleyballTeam team2 = new VolleyballTeam();
        File file1 = new File("teamTargovishteInfo.csv");
        File file2 = new File("teamRazgradInfo.csv");
        try {
            readTeamFile(file1, team1);
            readTeamFile(file2, team2);
            System.out.println(team1);
            System.out.println(team2);
            team1.compareTeamStrength(team2);
            team1.restTeam();
            team1.trainTeam();
            team2.trainTeam();
            team2.restTeam();
            System.out.println(team1);
            System.out.println(team2);
            team2.compareTeamStrength(team1);
            writeMatchResults(team1, team2);
        }
        catch (Exception e)
        {
            System.out.println(e);
        }
    }

    public static String showResultIfTeam1Win(VolleyballTeam team1, VolleyballTeam team2, int randomScore) {
        return team1.getTeamName() + " 25 VS " + randomScore + " " + team2.getTeamName();
    }

    public static String showResultIfTeam2Win(VolleyballTeam team1, VolleyballTeam team2, int randomScore) {
        return team2.getTeamName() + " 25 VS " + randomScore + " " +team1.getTeamName();
    }
    public static int calculateStatDifference(VolleyballTeam team1,VolleyballTeam team2)
    {
        return (int) (team1.calculateStrength() - team2.calculateStrength()) * 5;
    }
    public static String playMatch(VolleyballTeam team1, VolleyballTeam team2) {
        Random rnd = new Random();
        int chance = rnd.nextInt(100) + 1;
        int randomScore = rnd.nextInt(23) + 1;
        if (team1.calculateStrength() > team2.calculateStrength()) {
            calculateStatDifference(team1,team2);
            if (chance > (50 - calculateStatDifference(team1,team2))) {
                return showResultIfTeam1Win(team1, team2, randomScore);
            } else {
                return showResultIfTeam2Win(team1, team2, randomScore);
            }
        } else if (team1.calculateStrength() == team2.calculateStrength()) {
            if (chance > 50) {
                return showResultIfTeam1Win(team1, team2, randomScore);
            } else {
                return showResultIfTeam2Win(team1, team2, randomScore);
            }
        } else {
            calculateStatDifference(team1,team2);
            if (chance > (50 - calculateStatDifference(team1,team2))) {
                return showResultIfTeam2Win(team1, team2, randomScore);
            } else {
                return showResultIfTeam1Win(team1, team2, randomScore);
            }
        }
    }

    public static void writeMatchResults(VolleyballTeam team1, VolleyballTeam team2) {
        File file = new File("matchResults.txt");
        BufferedWriter bw = null;
        try {
            FileWriter fileWriter = new FileWriter(file);
            bw = new BufferedWriter(fileWriter);
            bw.write(playMatch(team1,team2));
        } catch (Exception e) {
            System.out.println(e);
        }
        finally
        {
            try{
                if(bw!=null)
                    bw.close();
            }catch(Exception ex){
                System.out.println("Error in closing the BufferedWriter"+ex);
            }
        }
    }

    public static void readTeamFile(File file, VolleyballTeam team) {
        try {
            FileReader fileReader = new FileReader(file);
            BufferedReader br = new BufferedReader(fileReader);
            String line = "";
            String[] tempArr;
            int i = 0;
            while ((line = br.readLine()) != null) {
                tempArr = line.split(", ");
                if (i < 1) {
                    team.setTeamName(tempArr[0]);
                    team.setStadiumName(tempArr[1]);
                    team.setCoachName(tempArr[2]);
                } else {
                    String playerName = tempArr[0];
                    String age = tempArr[1];
                    String playerPosition = tempArr[2];
                    String skill = tempArr[3];
                    String stamina = tempArr[4];
                    int playerAge = Integer.parseInt(age);
                    int playerSkill = Integer.parseInt(skill);
                    int playerStamina = Integer.parseInt(stamina);
                    VolleyballPlayer player = new VolleyballPlayer(playerName, playerAge, playerPosition, playerSkill, playerStamina);
                    team.getPlayers().add(player);
                }
                i++;
            }
            br.close();
            fileReader.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}