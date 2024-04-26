package lk.nibm.pdsa.pentaplay.pentaplay_mobile.Model;

import java.util.Date;
import java.util.Map;
import java.util.UUID;

public class Player {

    private String id;
    private String name;
    private Map<String, Object> board;
    private String date;
    private String time;
    private String gameCode;

    public Player(String playerName) {
        this.id = UUID.randomUUID().toString(); // Generate a unique ID for the player
        this.name = playerName;
        initializeDateTime();
    }

    public Player(String playerName, String gameCode) {
        this.id = UUID.randomUUID().toString(); // Generate a unique ID for the player
        this.name = playerName;
        this.gameCode = gameCode;
        initializeDateTime();
    }

    private void initializeDateTime() {
        Date currentDate = new Date();
        this.date = currentDate.toString().split(" ")[1] + " " + currentDate.toString().split(" ")[2] + ", " + currentDate.toString().split(" ")[5];
        this.time = currentDate.toString().split(" ")[3];
    }

    public String getId() {
        return id;
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

    public String getGameCode() {
        return gameCode;
    }

    public void setGameCode(String gameCode) {
        this.gameCode = gameCode;
    }
}
