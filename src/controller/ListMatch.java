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
        System.out.println("Nhập mã trận đấu");
        m.setMatchID(sc.nextLine());


        Club club1;
        do {
            System.out.print("Nhập mã clb 1:");
            String clubCode1 = sc.nextLine();
            club1 = listClub.findByCode(clubCode1);
        } while (club1 == null);
        m.setClub1(club1);

        Club club2;
        do {
            System.out.print("Nhập mã clb 2:");
            String clubCode2 = sc.nextLine();
            club2 = listClub.findByCode(clubCode2);
        }
        while (club2 == null || club2 == club1);
        m.setClub2(club2);

        System.out.print("Nhập sân vận động: ");
        String svd = sc.nextLine();
        m.setStadium(svd);

        System.out.print("Nhập số bàn thắng clb 1: ");
        int goal1 = Integer.parseInt(sc.nextLine());
        m.setNumOfGoalTeam1(goal1);

        System.out.print("Nhập số bàn thắng clb 2: ");
        int goal2 = Integer.parseInt(sc.nextLine());
        m.setNumOfGoalTeam2(goal2);


        ListFootballPlayer scorePlayer1 = new ListFootballPlayer();
        for (int i = 0; i < goal1; i++) {
            FootballPlayer match1;
            do {
                System.out.print("Nhập số áo cầu thủ ghi bàn clb1:");
                int num1 = Integer.parseInt(sc.nextLine());
                match1 = listFootballPlayer.findByNumber(num1);
            } while (match1 == null);
            scorePlayer1.footballPlayerArrayList.add(match1);
}
        m.setScorePlayer1(scorePlayer1);

        ListFootballPlayer scorePlayer2 = new ListFootballPlayer();
        for (int i = 0; i < goal2; i++) {
            FootballPlayer match2;
            do {
                System.out.print("Nhập số áo cầu thủ ghi bàn clb2:");
                int num2 = Integer.parseInt(sc.nextLine());
                match2 = listFootballPlayer.findByNumber(num2);
            } while (match2 == null);
            scorePlayer2.footballPlayerArrayList.add(match2);

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

