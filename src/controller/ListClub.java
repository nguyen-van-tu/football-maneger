package controller;

import model.Club;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ListClub {
    Scanner sc = new Scanner(System.in);
    public ArrayList<Club> clubArrayList;
//
//    public ListClub() {
//        clubArrayList = new ArrayList<>();
//    }

    public ArrayList<Club> getClubArrayList() {
        return clubArrayList;
    }

    public ListClub() {
        Club c1 = new Club("Barcalona","FCB","Tây Ban Nha","CampNou","Koeman");
        Club c2 = new Club("Bayern Munich","BAY","Đức","Allianz","Hans-Dieter Flick");
        Club c3 = new Club("Liverpool","LIV","Anh","Anfield","Jürgen Klopp");
        Club c4 = new Club("Juventus","JUV","Italy","Juventus","Andrea Pirlo");
        Club c5 = new Club("Paris Saint-Germain","PSG","Pháp","CV các Hoàng tử","Mauricio Pochettino");
        clubArrayList = new ArrayList<>(Arrays.asList(c1,c2,c3,c4,c5));
    }

    public void addClub() {

        Club club = new Club();

        System.out.print("Nhập tên clb: ");
        club.setName(sc.nextLine());

        boolean checkID= false;
        do {
            System.out.print("Nhập mã clb: ");
            String id = sc.nextLine();
            String regex = "^[A-Z]{3}$";
            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(id);
            if (matcher.find()){
                club.setClubCode(id);
                checkID = true;
            }
        }while (!checkID);

        System.out.print("Nhập tên quốc gia: ");
        club.setNation(sc.nextLine());
        System.out.print("Nhập tên svđ: ");
        club.setStadium(sc.nextLine());
        System.out.print("Nhập tên hlv: ");
        club.setCoach(sc.nextLine());


        clubArrayList.add(club);
//        ReadAndWriteFile.witeFile(clubArrayList);
    }

    public void showClub() {
        System.out.printf("\n%-20s%-20s%-20s%-20s%-20s"
                , "Tên CLB"
                , "Mã CLB"
                , "Quốc gia"
                , "Sân vận động"
                , "Huấn luận viên");
        for (Club e : clubArrayList) {
            System.out.printf("\n%-20s%-20s%-20s%-20s%-20s"
                    , e.getName()
                    , e.getClubCode()
                    , e.getNation()
                    , e.getStadium()
                    , e.getCoach());
        }
        System.out.println();
    }

    public Club findByCode(String clubCode) {
        for (Club e : clubArrayList) {
            if (e.getClubCode().equals(clubCode)) {
                return e;
            }
        }
        return null;
    }

    public void deleteCulb() {
        System.out.println(" nhập mã clb cần xóa");
        String m = sc.nextLine();
        int index = 0;
        for (int i = 0; i < getClubArrayList().size(); i++) {
            if (m.equals(getClubArrayList().get(i).getClubCode())) {
                System.out.println(" thông tin clb đã xóa " + getClubArrayList().get(i).toString());
                getClubArrayList().remove(getClubArrayList().get(i));
                index++;
            }
        }
        if (index == 0) {
            System.out.println(" Không tìm thấy ");
        }
    }

    public void repairClub() {
        System.out.println("nhập mã clb cần sửa");
        String id = sc.nextLine();
        int a = 0;
        for (int i = 0; i < getClubArrayList().size(); i++) {
            if (id.equals(getClubArrayList().get(i).getClubCode())) {
                System.out.println("Nhập lại thông tin clb mới");
                System.out.print("Nhập tên clb :");
                String c = sc.nextLine();
                getClubArrayList().get(i).setName(c);
                System.out.print("Nhập mã clb :");
                String q = sc.nextLine();
                getClubArrayList().get(i).setClubCode(q);
                System.out.print("nhập tên quốc gia :");
                String s = sc.nextLine();
                getClubArrayList().get(i).setNation(s);
                System.out.print("nhập svđ :");
                String h = sc.nextLine();
                getClubArrayList().get(i).setStadium(h);
                System.out.print("nhập tên hlv ");
                String m = sc.nextLine();
                getClubArrayList().get(i).setCoach(m);

                System.out.println("thông tin clb đã sửa thành công!"
                        + "\n  Tên clb: " + getClubArrayList().get(i).getName() +
                        " Mã clb: " + getClubArrayList().get(i).getClubCode() +
                        " Quốc gia: " + getClubArrayList().get(i).getNation() +
                        " Sân vận động: " + getClubArrayList().get(i).getStadium() +
                        " Huấn luận viên: " + getClubArrayList().get(i).getCoach()
                );
                a++;
            }
        }
        if (a == 0){
            System.out.println("Không tìm thấy");
        }
    }

    public void searchClub() {

        int a = 0;
        System.out.println("Nhập mã clb cần tìm");
        String id = sc.nextLine();

        for (int i = 0; i < clubArrayList.size(); i++) {
            if (clubArrayList.get(i).getClubCode().equals(id)) {

                System.out.println("CLB bạn cần tìm là:");
                System.out.println(getClubArrayList().get(i).toString());
                a++;
                break;
            }
        }
        if (a == 0) {
            System.out.println("Không thấy clb bạn tìm !");
        }
    }

    public void sortClub(){
        clubArrayList.sort(new SortFootball.SortClub());
        System.out.println("Sắp xếp thành công");
    }
}

