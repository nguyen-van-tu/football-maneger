package view;

import controller.*;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
//        List<Club>list = ReadAndWriteFile.readFile();
//        ListClub listClub = new ListClub(list);
        ListClub listClub =new ListClub();
        ListFootballPlayer listFootballFlayer = new ListFootballPlayer(listClub);
        ListMatch listMatch = new ListMatch();
        WriteFile w = new WriteFile();
        Scanner sc = new Scanner(System.in);
        int input;
        do {
            System.out.println("Menu :");
            System.out.println("1: Thêm clb");
            System.out.println("2: Thêm cầu thủ");
            System.out.println("3: Thêm trận đấu");
            System.out.println("4: Hiển thị thông tin");
            System.out.println("5: Xóa clb");
            System.out.println("6: Sửa  clb");
            System.out.println("7: Tìm kiếm");
            System.out.println("8: Lưu thông tin vào file");
            System.out.println("9: Bảng xếp hạng");
            System.out.println("0: Thoát");
            System.out.println("---------------");
            System.out.println("Mời chọn: ");
            input = Integer.parseInt(sc.nextLine());
            switch (input) {
                case 1:
                    do {
                        listClub.addClub();
                        System.out.println("1: Thêm clb");
                        System.out.println("0: Quay lại menu");
                    } while (Integer.parseInt(sc.nextLine()) == 1);
                    break;
                case 2:
                    do {
                        listFootballFlayer.addFootballPlayer(listClub);
                        System.out.println("1: Thêm cầu thủ");
                        System.out.println("0: Quay lại menu");
                    } while (Integer.parseInt(sc.nextLine()) == 1);
                    break;
                case 3:
                    listMatch.addMatch(listClub, listFootballFlayer);
                    break;
                case 4:
                    int i = 0;
                    do {
                        System.out.println("1: Hiển thị danh sách clb");
                        System.out.println("2: Hiển thị danh sách cầu thủ");
                        System.out.println("3: Hiển thị thông tin trận đấu");
                        System.out.println("0: Quay lại");
                        switch (i) {
                            case 1:
                                System.out.println("Thông tin clb");
                                listClub.showClub();
                                break;
                            case 2:
                                System.out.println("Thông tin cầu thủ");
                                listFootballFlayer.showFootballFlayer();
                                break;
                            case 3:
                                System.out.println("Thông tin trận đấu");
                                listMatch.showMatch();
                                break;
                        }
                        i = Integer.parseInt(sc.nextLine());
                    } while (i != 0);
                    break;
                case 5:
                    listClub.deleteCulb();
                    break;
                case 6:
                    listClub.repairClub();
                    break;
                case 7:
                    int i1 ;
                    do {
                        System.out.println("Bạn muốn tìm ?");
                        System.out.println("1: Câu lạc bộ");
                        System.out.println("2: Cầu thủ");
                        System.out.println("3: Trận đấu");
                        System.out.println("0: Quay lại");
                        i1 = Integer.parseInt(sc.nextLine());
                        switch (i1){
                            case 1:
                                listClub.searchClub();
                                break;
                            case 2:
                                listFootballFlayer.searchFootballPlayer();
                                break;
                            case 3:
                                listMatch.searchMatch();
                                break;
                        }
                    }while (i1 != 0);
                case 8:
                    w.writeFile(listClub,listFootballFlayer,listMatch);
                    break;
                case 9:
                    int a;
                    do {
                        System.out.println("Bạn muốn sắp xếp ?");
                        System.out.println("1: Câu lạc bộ");
                        System.out.println("2: Cầu thủ");
                        System.out.println("0: Exit");
                        a=Integer.parseInt(sc.nextLine());
                        switch (a){
                            case 1:
                                listClub.sortClub();
                                listClub.showClub();
                                break;
                            case 2:
                                int b;
                                do {
                                    System.out.println("Sắp xếp theo ?");
                                    System.out.println("1: Số áo");
                                    System.out.println("2: Tên");
                                    System.out.println("0: Exit");
                                    b=Integer.parseInt(sc.nextLine());
                                    switch (b){
                                        case 1:
                                            listFootballFlayer.sortFootballPlayer();
                                            listFootballFlayer.showFootballFlayer();
                                            break;
                                        case 2:
                                            listFootballFlayer.sortFootballPlayerName();
                                            listFootballFlayer.showFootballFlayer();
                                            break;
                                    }
                                }while (b != 0);
                        }
                    }while (a != 0);
            }
        }
        while (input != 0);
        System.out.println("Bye bye");
    }
}