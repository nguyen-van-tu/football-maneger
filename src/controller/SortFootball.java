package controller;

import model.Club;
import model.FootballPlayer;

import java.util.Comparator;

public class SortFootball implements Comparator<FootballPlayer> {

    @Override
    public int compare(FootballPlayer o1, FootballPlayer o2) {
        if (o1.getNumber() > o2.getNumber()) {
            return 1;
        }
        return -1;
    }

    public static class SortFootballName implements Comparator<FootballPlayer> {

        @Override
        public int compare(FootballPlayer o1, FootballPlayer o2) {
            return (o1.getName().compareTo(o2.getName()));
        }
    }

    public static class SortClub implements Comparator<Club> {
        public int compare(Club c1, Club c2) {
            return (c1.getName().compareTo(c2.getName()));
        }
    }
}
