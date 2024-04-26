package lk.nibm.pdsa.pentaplay.pentaplay_mobile.Model;

public class Search {
    private String type;
    private int duration;

    public Search(String type, int duration) {
        this.type = type;
        this.duration = duration;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }
}
