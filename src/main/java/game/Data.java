package game;
import com.diogonunes.jcdp.color.ColoredPrinter;
import com.diogonunes.jcdp.color.api.Ansi.BColor;
import com.diogonunes.jcolor.Ansi;

public class Data {
    public static char PLAYER_CHAR;
    public static char EMPTY_CHAR;
    public static char ENEMY_CHAR;
    public static char WALL_CHAR;
    public static char GOAL_CHAR;
    public static BColor PLAYER_COLOR;
    public static BColor EMPTY_COLOR;
    public static BColor ENEMY_COLOR;
    public static BColor WALL_COLOR;
    public static BColor GOAL_COLOR;

    Data (String profile) {
        PropertiesParser propertiesParser = new PropertiesParser();
        propertiesParser.readProperties(profile);

        PLAYER_CHAR = propertiesParser.getPropertyChar("player.char");
        EMPTY_CHAR = propertiesParser.getPropertyChar("empty.char");
        ENEMY_CHAR = propertiesParser.getPropertyChar("enemy.char");
        WALL_CHAR = propertiesParser.getPropertyChar("wall.char");
        GOAL_CHAR = propertiesParser.getPropertyChar("goal.char");
        PLAYER_COLOR = BColor.valueOf(propertiesParser.getPropertyString("player.color"));
        EMPTY_COLOR = BColor.valueOf(propertiesParser.getPropertyString("empty.color"));
        ENEMY_COLOR = BColor.valueOf(propertiesParser.getPropertyString("enemy.color"));
        WALL_COLOR = BColor.valueOf(propertiesParser.getPropertyString("wall.color"));
        WALL_COLOR = BColor.valueOf(propertiesParser.getPropertyString("wall.color"));
        GOAL_COLOR = BColor.valueOf(propertiesParser.getPropertyString("goal.color"));
    }
}
