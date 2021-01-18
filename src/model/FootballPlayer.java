package model;


public class FootballPlayer  {
    private String name ;
    private int yearofbirth ;
    private String nationality;
    private Club club;
    private String location;
    private int number ;


    public FootballPlayer() {}

    public FootballPlayer(String name, int yearofbirth, String nationality, Club club, String location, int number) {
        this.name = name;
        this.yearofbirth = yearofbirth;
        this.nationality = nationality;
        this.club = club;
        this.location = location;
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public int getYearofbirth() {
        return yearofbirth;
    }

    public String getNationality() {
        return nationality;
    }

    public String getLocation() {
        return location;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setYearofbirth(int yearofbirth) {
        this.yearofbirth = yearofbirth;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public Club getClub() {
        return club;
    }

    public void setClub(Club club) {
        this.club = club;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }


    @Override
    public String toString() {
        return "Cầu thủ: " +
                name + '\'' +
                ",  Năm sinh: " + yearofbirth +
                ",  Quốc tịch: " + nationality +
                ",  Câu lạc bộ: " + getClub().getName() + '\'' +
                ",  Vị trí :" + location + '\'' +
                ",  Số áo :" + number ;
    }

}
