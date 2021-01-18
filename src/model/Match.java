package model;

import controller.ListFootballPlayer;

public class Match {
    private String matchID;
    private Club club1;
    private Club club2;
    private String stadium;
    private int numOfGoalTeam1;
    private int numOfGoalTeam2;
    private ListFootballPlayer scorePlayer1;
    private ListFootballPlayer scorePlayer2;
    private int minutes;


    public Match() {
    }

    public String getMatchID() {
        return matchID;
    }

    public void setMatchID(String matchID) {
        this.matchID = matchID;
    }

    public Club getClub1() {
        return club1;
    }

    public void setClub1(Club club1) {
        this.club1 = club1;
    }

    public Club getClub2() {
        return club2;
    }

    public void setClub2(Club club2) {
        this.club2 = club2;
    }

    public void setStadium(String stadium) {
        this.stadium = stadium;
    }

    public void setNumOfGoalTeam1(int numOfGoalTeam1) {
        this.numOfGoalTeam1 = numOfGoalTeam1;
    }

    public void setNumOfGoalTeam2(int numOfGoalTeam2) {
        this.numOfGoalTeam2 = numOfGoalTeam2;
    }

    public void setScorePlayer1(ListFootballPlayer scorePlayer1) {
        this.scorePlayer1 = scorePlayer1;
    }

    public void setScorePlayer2(ListFootballPlayer scorePlayer2) {
        this.scorePlayer2 = scorePlayer2;
    }

    public int getNumOfGoalTeam1() {
        return numOfGoalTeam1;
    }

    public int getNumOfGoalTeam2() {
        return numOfGoalTeam2;
    }

    public int getMinutes() {
        return minutes;
    }

    public void setMinutes(int minutes) {
        this.minutes = minutes;
    }

    @Override
    public String toString() {
        return
                "Mã trận đấu: " + matchID+ '\n' +
                "Câu lạc bộ 1: " + getClub1().getName() + '\n' +
                        "Câu lạc bộ 2: " + getClub2().getName() + '\n' +
                        "Sân vận động: " + stadium + '\n' +
                        "Tỉ số trận đấu: " + getClub1().getName() + " " + numOfGoalTeam1 + "-" + numOfGoalTeam2 + " " + getClub2().getName() + '\n' +
                        "Cầu thủ ghi bàn cho "+ getClub1().getName() +": "+ (scorePlayer1.getName() + "(" +minutes+")")+'\n' +
                        "Cầu thủ ghi bàn cho "+ getClub2().getName() +": "+ scorePlayer2.getName() +  "(" +minutes+")"+'\n'
                ;
    }
}