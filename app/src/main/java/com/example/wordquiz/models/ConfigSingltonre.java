package com.example.wordquiz.models;

public class ConfigSingltonre {
    public static ConfigSingltonre instance = new ConfigSingltonre();

    private String Team1Txt1 = "Team 1", Team2Txt1 = "Team 2";
    private String Team1Txt2 = "Թիմ 1", Team2Txt2 = "Թիմ 2";
    private String Team1Txt3 = "Команда 1", Team2Txt3 = "Команда 2";

    /*English*/
    public String getTeam1Txt1() {
        return Team1Txt1;
    }
    public void setTeam1Txt1(String team1Txt1) {
        Team1Txt1 = team1Txt1;
    }
    public String getTeam2Txt1() {
        return Team2Txt1;
    }
    public void setTeam2Txt1(String team2Txt) {
        Team2Txt1 = team2Txt;
    }
    /*English*/

    /*Armenian*/
    public String getTeam1Txt2() {
        return Team1Txt2;
    }
    public void setTeam1Txt2(String team1Txt2) {
        Team1Txt2 = team1Txt2;
    }
    public String getTeam2Txt2() {
        return Team2Txt2;
    }
    public void setTeam2Txt2(String team2Txt2) { Team2Txt2 = team2Txt2; }
    /*Armenian*/

    /*Russian*/
    public String getTeam1Txt3() {
        return Team1Txt3;
    }
    public void setTeam1Txt3(String team1Txt3) {
        Team1Txt3 = team1Txt3;
    }
    public String getTeam2Txt3() {
        return Team2Txt3;
    }
    public void setTeam2Txt3(String team2Txt3) { Team2Txt3 = team2Txt3; }
    /*Russian*/

    public static  ConfigSingltonre getInstance()
    {
        return instance;
    }
}
