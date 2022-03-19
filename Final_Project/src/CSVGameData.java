import java.io.File;

public class CSVGameData extends GameData{
    public CSVGameData(String gamedata, String saveData) {
        CSVGameData gameData = new CSVGameData(new File(gamedata));
    }
}
