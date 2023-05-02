package model;

public class Basketball implements Sport{
    private String homeTeam;
    private String awayTeam;
    @Override
    public void setHomeTeam(String team) {
        homeTeam = team;
    }

    @Override
    public void setAwayTeam(String team) {
        awayTeam = team;
    }
}
