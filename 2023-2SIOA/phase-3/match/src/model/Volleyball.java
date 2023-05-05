package model;

public final class Volleyball implements Game {
    private String homeTeam;
    private String awayTeam;

    @Override
    public void setHomeTeam(String team) {
        this.homeTeam = team;
    }

    @Override
    public void setAwayTeam(String team) {
        this.awayTeam = team;
    }
}
