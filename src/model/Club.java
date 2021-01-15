package model;


public class Club {
    // tên
    private String name;
    // mã clb
    private String clubCode;
    // quốc gia
    private String nation;
    //    svđ
    private String stadium;
    //    hlv
    private String coach;


    public Club(String name, String clubCode, String nation, String stadium, String coach) {
        this.name = name;
        this.clubCode = clubCode;
        this.nation = nation;
        this.stadium = stadium;
        this.coach = coach;
    }



    public Club() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getClubCode() {
        return clubCode;
    }

    public void setClubCode(String clubCode) {
        this.clubCode = clubCode;
    }

    public String getNation() {
        return nation;
    }

    public void setNation(String nation) {
        this.nation = nation;
    }

    public String getStadium() {
        return stadium;
    }

    public void setStadium(String stadium) {
        this.stadium = stadium;
    }

    public String getCoach() {
        return coach;
    }

    public void setCoach(String coach) {
        this.coach = coach;
    }


    @Override
    public String toString() {
        return " " +
                "Tên clb: " + name +
                ", Mã clb: " + clubCode +
                ", Quốc gia: " + nation +
                ", Sân nhà: " + stadium +
                ", Huấn luận viên: " + coach  ;
    }
}

