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
    public static Integer enemiesCount;
    public static Integer wallsCount;
    public static Integer size;
    Enemy[] enemies;
    Player player;
    char [][] map;


    Data (String[] args) throws IllegalParametersException {
        CommandLineArguments commandArg = new CommandLineArguments();
        JCommander.newBuilder()
                .addObject(commandArg)
                .build()
                .parse(args);
        commandArg.CheckParameters();
        devMode = commandArg.getProfile().equals("dev");
        PropertiesParser propertiesParser = new PropertiesParser();
        propertiesParser.readProperties(devMode);

        PLAYER_CHAR = propertiesParser.getProperty("player.char",' ');
        EMPTY_CHAR = propertiesParser.getProperty("empty.char",' ');
        ENEMY_CHAR = propertiesParser.getProperty("enemy.char",' ');
        WALL_CHAR = propertiesParser.getProperty("wall.char",' ');
        GOAL_CHAR = propertiesParser.getProperty("goal.char",' ');
        PLAYER_COLOR = BColor.valueOf(propertiesParser.getProperty("player.color", "BLACK"));
        EMPTY_COLOR = BColor.valueOf(propertiesParser.getProperty("empty.color", "BLACK"));
        ENEMY_COLOR = BColor.valueOf(propertiesParser.getProperty("enemy.color", "BLACK"));
        WALL_COLOR = BColor.valueOf(propertiesParser.getProperty("wall.color", "BLACK"));
        WALL_COLOR = BColor.valueOf(propertiesParser.getProperty("wall.color", "BLACK"));
        GOAL_COLOR = BColor.valueOf(propertiesParser.getProperty("goal.color", "BLACK"));

        enemiesCount = commandArg.getEnemiesCount();
        wallsCount = commandArg.getWallsCount();
        size = commandArg.getSize();
        player = new Player(0, 0);
        enemies = new Enemy[enemiesCount];
        map = new char[size][size];
    }
}
