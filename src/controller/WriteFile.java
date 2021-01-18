package controller;
import model.Club;
import model.FootballPlayer;
import model.Match;
import java.io.FileWriter;
import java.io.IOException;

public class WriteFile {
    public void writeFile(ListClub listClub, ListFootballPlayer listFootballFlayer, ListMatch listMatch){
        try {
            FileWriter file = new FileWriter("./giaidau.txt");
            file.write("------Thông tin câu lạc bộ-------");
            file.write('\n');
            for (Club c : listClub.getClubArrayList()) {
                file.write(c.toString());
                file.write('\n');
            }

            file.write("\n------Thông tin cầu thủ-------");
            file.write('\n');
            for (FootballPlayer f : listFootballFlayer.getFootballPlayerArrayList()) {
                file.write(f.toString());
                file.write('\n');
            }

            file.write("\n------Thông tin trận đấu-------");
            file.write('\n');
            for (Match m : listMatch.getMatchArrayList()) {
                file.write(m.toString());
                file.write('\n');
            }
            file.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Lưu thành công !!");
    }
}
