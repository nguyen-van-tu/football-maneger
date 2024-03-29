package controller;

import model.Club;
import model.FootballPlayer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ListFootballPlayer {
    Scanner sc = new Scanner(System.in);
    public ArrayList<FootballPlayer> footballPlayerArrayList = new ArrayList<>();
    ListClub listClub = new ListClub();

    public ArrayList<FootballPlayer> getFootballPlayerArrayList() {
        return footballPlayerArrayList;
    }
    public ListFootballPlayer() {

    }
    public ListFootballPlayer(ListClub listClub) {
        FootballPlayer f1 = new FootballPlayer("Messi", 1987, "Argentina", listClub.findByCode("FCB"), "Tiền đạo", 10);
        FootballPlayer f2 = new FootballPlayer("De Jong", 1997, "Hà lan", listClub.findByCode("FCB"), "Tiền vệ", 21);
        FootballPlayer f3 = new FootballPlayer("Lewandowski", 1988, "Ba lan", listClub.findByCode("BAY"), "Tiền đạo", 9);
        FootballPlayer f4 = new FootballPlayer("Thomas Müller", 1989, "Đức", listClub.findByCode("BAY"), "Tiền đạo", 25);
        FootballPlayer f5 = new FootballPlayer("Salah", 1992, "Ai cập", listClub.findByCode("LIV"), "Tiền đạo", 11);
        FootballPlayer f6 = new FootballPlayer("van Dijk", 1991, "Hà lan", listClub.findByCode("LIV"), "Hậu vệ", 4);
        FootballPlayer f7 = new FootballPlayer("Dybala", 1993, "Argentina", listClub.findByCode("JUV"), "Tiền đạo", 10);
        FootballPlayer f8 = new FootballPlayer("Ronaldo", 1985, "Bồ đào nha", listClub.findByCode("JUV"), "Tiền đạo", 7);
        FootballPlayer f9 = new FootballPlayer("Neymar Jr", 1992, "Brazil", listClub.findByCode("PSG"), "Tiền đạo", 10);
        FootballPlayer f10 = new FootballPlayer("Verratti", 1992, "Italy", listClub.findByCode("PSG"), "Tiền vệ", 6);
        footballPlayerArrayList = new ArrayList<>(Arrays.asList(f1, f2, f3, f4, f5, f6, f7, f8, f9, f10));
    }

    public void addFootballPlayer(ListClub listClub) {


        FootballPlayer f = new FootballPlayer();

        System.out.print("Nhập tên cầu thủ: ");
        String name = sc.nextLine();
        f.setName(name);

        System.out.print("Nhập năm sinh: ");
        int ns = Integer.parseInt(sc.nextLine());
        f.setYearofbirth(ns);

        System.out.print("Nhập quốc tịch: ");
        String qt = sc.nextLine();
        f.setNationality(qt);

        Club club;
        String clubCode1 ;
        do {
            System.out.print("Nhập mã clb:");
            clubCode1 = sc.nextLine();
            club = listClub.findByCode(clubCode1);
        } while (club == null);
        f.setClub(club);

        System.out.print("Nhập vị trí: ");
        String hlv = sc.nextLine();
        f.setLocation(hlv);

        FootballPlayer footballPlayer;
        int number;
        do {
            System.out.print("Nhập số áo: ");
            number = Integer.parseInt(sc.nextLine());
            footballPlayer = checkNumberPlayer(number,clubCode1);
        } while (footballPlayer != null && number < 100 && number > 0);
        f.setNumber(number);


        footballPlayerArrayList.add(f);
    }

    public void showFootballFlayer() {
        System.out.printf("\n%-20s%-20s%-20s%-20s%-20s%-20s"
                , "Cầu thủ"
                , "Năm sinh"
                , "Quốc gia"
                , "Câu lạc bộ"
                , "Vị trí"
                , "Số áo");
        for (FootballPlayer f : footballPlayerArrayList) {
            System.out.printf("\n%-20s%-20s%-20s%-20s%-20s%-20s"
                    , f.getName()
                    , f.getYearofbirth()
                    , f.getNationality()
                    , f.getClub().getName()
                    , f.getLocation()
                    , f.getNumber());
        }
        System.out.println();
    }
    public void showFootballFlayerByClub(String clubName) {
        System.out.printf("Danh sách cầu thủ " + clubName);
        System.out.printf("\n%-20s%-20s%-20s%-20s%-20s%-20s"
                , "Cầu thủ"
                , "Năm sinh"
                , "Quốc gia"
                , "Câu lạc bộ"
                , "Vị trí"
                , "Số áo");

        for (FootballPlayer f : footballPlayerArrayList) {
            if (f.getClub().getName().equals(clubName)){
                System.out.printf("\n%-20s%-20s%-20s%-20s%-20s%-20s"
                        , f.getName()
                        , f.getYearofbirth()
                        , f.getNationality()
                        , f.getClub().getName()
                        , f.getLocation()
                        , f.getNumber());
            }
        }
        System.out.println();
    }

    public void searchFootballPlayer() {
        int a = 0;
        System.out.print("Nhập tên cầu thủ cần tìm");
        String name = sc.nextLine();
        for (int i = 0; i < footballPlayerArrayList.size(); i++) {
            if (footballPlayerArrayList.get(i).getName().contains(name)) {
                a++;
                System.out.println("Cầu thủ bạn cần tìm là :");
                System.out.println(getFootballPlayerArrayList().get(i).toString());
                break;
            }
        }
        if (a == 0) {
            System.out.println("Không thấy cầu thủ bạn tìm !");
        }
    }

    public String getName() {
        StringBuilder name = new StringBuilder();
        for (FootballPlayer f : footballPlayerArrayList) {
            name.append(f.getName()).append(",");
        }
        return name.toString();
    }

    public void sortFootballPlayer() {
        footballPlayerArrayList.sort(new SortFootball());
        System.out.println("Sắp xếp thành công");
    }

    public void sortFootballPlayerName(){
        footballPlayerArrayList.sort(new SortFootball.SortFootballName());
        System.out.println("Sắp xếp thành công");
    }
    public void transferPlayer(String playerName){
        Club club;
        String newClub;
        boolean check = false;
        for (FootballPlayer f: footballPlayerArrayList) {
            if (f.getName().equals(playerName)) {
                do {
                    System.out.println("Nhập clb chuyển đến");
                    newClub = sc.nextLine();
                    club = listClub.findByCode(newClub);
                } while (club == null && f.getClub().getName().equals(newClub));
                f.setClub(club);

                FootballPlayer footballPlayer;
                int number;
                do {
                    System.out.print("Nhập số áo: ");
                    number = Integer.parseInt(sc.nextLine());
                    footballPlayer = checkNumberPlayer(number,newClub);
                } while (footballPlayer != null && number < 100 && number > 0);
                f.setNumber(number);
                check=true;
            }
        }
        if (!check){
            System.out.println("Không tìm thấy cầu thủ !");
        }
    }

    public FootballPlayer checkNumberPlayer(int numberPlayer, String club) {
        for (FootballPlayer f : footballPlayerArrayList) {
            if (f.getClub().getClubCode().equals(club) && f.getNumber()==numberPlayer) {
                return f;
                }
            }
        return null;
        }

    }


