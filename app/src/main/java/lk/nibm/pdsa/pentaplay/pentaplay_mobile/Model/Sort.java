package lk.nibm.pdsa.pentaplay.pentaplay_mobile.Model;

public class Sort {
    private String type;
    private long duration;

    public Sort(String type, long duration) {
        this.type = type;
        this.duration = duration;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public long getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }
}
