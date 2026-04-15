package be.technifutur.heroesvsmonsters.world;

public class Bloodstain {

    private final int ames;
    private final String zoneName;

    public Bloodstain(int ames, String zoneName) {
        this.ames = ames;
        this.zoneName = zoneName;
    }

    public int getAmes() {
        return ames;
    }

    public String getZoneName() {
        return zoneName;
    }
}