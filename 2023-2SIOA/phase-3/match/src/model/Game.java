package model;

public sealed interface Game permits Basketball, Football, Volleyball {
    public void setHomeTeam(String team);
    public void setAwayTeam(String team);
}
