package lk.nibm.pdsa.pentaplay.pentaplay_mobile.Model;

import java.util.Date;
import java.util.Map;

public class Player {

    private String name;
    private Map<String, Object> board;
    private String date;
    private String time;
    private String game;

    public Player(String playerName) {
        this.name = playerName;
        Date currentDate = new Date();
        this.date = currentDate.toString().split(" ")[1] + " " + currentDate.toString().split(" ")[2] + ", " + currentDate.toString().split(" ")[5];
        this.time = currentDate.toString().split(" ")[3];
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Map<String, Object> getBoard() {
        return board;
    }

    public void setBoard(Map<String, Object> board) {
        this.board = board;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

}
