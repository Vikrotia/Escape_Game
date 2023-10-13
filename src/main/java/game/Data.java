package game;
import com.beust.jcommander.JCommander;
import com.diogonunes.jcdp.color.api.Ansi.BColor;

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
    public static boolean devMode;

    Data (String[] args) throws IllegalParametersException {
        CommandLineArguments commandArg = new CommandLineArguments();
        JCommander.newBuilder()
                .addObject(commandArg)
                .build()
                .parse(args);
        commandArg.CheckParameters();
        devMode = commandArg.getProfile().equals("dev");
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
