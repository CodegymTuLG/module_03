package model;

public class LevelMaster {
    private int level_id;
    private String level;

    public LevelMaster() {
    }

    public LevelMaster(int level_id) {
        this.level_id = level_id;
    }

    public LevelMaster(int level_id, String level) {
        this.level_id = level_id;
        this.level = level;
    }

    public int getLevel_id() {
        return level_id;
    }

    public void setLevel_id(int level_id) {
        this.level_id = level_id;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }
}
