package mannager;

import model.Club;
import model.Match;

public class FootballRanking {
    public Club club;
    private int point;
    private int numberOfMatches;

ListMatch listMatch = new ListMatch();
    public void setPoint(int point) {
        this.point = point;
    }

    public int getNumberOfMatches() {
        return numberOfMatches;
    }

    public void setNumberOfMatches(int numberOfMatches) {
        this.numberOfMatches = numberOfMatches;
    }

    public int getPoint(){
        return listMatch.getNumWin();
    }

}
