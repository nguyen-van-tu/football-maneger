package controller;
import model.Club;
import model.FootballPlayer;
import java.util.Comparator;

public class SortFootball implements Comparator<FootballPlayer> {

    @Override
    public int compare(FootballPlayer f1, FootballPlayer f2) {
        if (f1.getNumber() > f2.getNumber()) {
            return 1;
        }
        return -1;
    }

    public static class SortFootballName implements Comparator<FootballPlayer> {

        @Override
        public int compare(FootballPlayer f1, FootballPlayer f2) {
            return (f1.getName().compareTo(f2.getName()));
        }
    }

    public static class SortClub implements Comparator<Club> {
        public int compare(Club c1, Club c2) {
            return (c1.getName().compareTo(c2.getName()));
        }
    }
}
