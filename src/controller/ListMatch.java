package controller;

import model.Club;
import model.FootballPlayer;
import model.Match;

import java.util.ArrayList;
import java.util.Scanner;

public class ListMatch {
    Scanner sc = new Scanner(System.in);
    public ArrayList<Match> matchArrayList = new ArrayList<>();

    public ArrayList<Match> getMatchArrayList() {
        return matchArrayList;
    }

    public void addMatch(ListClub listClub, ListFootballPlayer listFootballPlayer) {

        Match m = new Match();
        Club club1;
        String clubCode1;
        do {
            System.out.print("Nhập đội chủ nhà:");
            clubCode1 = sc.nextLine();
            club1 = listClub.findByCode(clubCode1);
        } while (club1 == null);
        m.setClub1(club1);

        Club club2;
        String clubCode2;
        do {
            System.out.print("Nhập đội khách:");
            clubCode2 = sc.nextLine();
            club2 = listClub.findByCode(clubCode2);
        }
        while (club2 == null || club2 == club1);
        m.setClub2(club2);
        m.setMatchID(clubCode1+clubCode2);
        m.setStadium(club1.getStadium());

        System.out.print("Nhập số bàn thắng clb 1: ");
        int goal1 = Integer.parseInt(sc.nextLine());
        m.setNumOfGoalTeam1(goal1);

        System.out.print("Nhập số bàn thắng clb 2: ");
        int goal2 = Integer.parseInt(sc.nextLine());
        m.setNumOfGoalTeam2(goal2);


        ListFootballPlayer scorePlayer1 = new ListFootballPlayer();
        for (int i = 0; i < goal1; i++) {
            FootballPlayer footballPlayer;
            do {
                System.out.print("Nhập số áo cầu thủ ghi bàn clb1:");
                int num1 = Integer.parseInt(sc.nextLine());
                footballPlayer = listFootballPlayer.checkNumberPlayer(num1,clubCode1);
            } while (footballPlayer == null);
            scorePlayer1.footballPlayerArrayList.add(footballPlayer);
}
        m.setScorePlayer1(scorePlayer1);

        ListFootballPlayer scorePlayer2 = new ListFootballPlayer();
        for (int i = 0; i < goal2; i++) {
            FootballPlayer footballPlayer;
            do {
                System.out.print("Nhập số áo cầu thủ ghi bàn clb2:");
                int num2 = Integer.parseInt(sc.nextLine());
                footballPlayer = listFootballPlayer.checkNumberPlayer(num2,clubCode2);
            } while (footballPlayer == null);
            scorePlayer2.footballPlayerArrayList.add(footballPlayer);

        }
        m.setScorePlayer2(scorePlayer2);

        matchArrayList.add(m);
    }


    public void showMatch() {
        for (Match m : matchArrayList) {
            System.out.println(m.toString());
        }

    }

    public void searchMatch() {
        System.out.println("Nhập mã trận đấu cần tìm");
        String id = sc.nextLine();
        int index = 0;
        for (Match match : matchArrayList) {
            if (match.getMatchID().equals(id)) {
                index++;
                System.out.println(match.toString());
                break;
            }
        }
        if (index == 0) {
            System.out.println("Không tìm thấy mã trận đấu");
        }
    }

}

