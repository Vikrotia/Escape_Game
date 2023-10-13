package game;
import java.util.Random;

public class MapGeneration {
    int wallsCount;
    int enemiesCount;
    int size;
    PropertiesParser propertiesParser;
    char [][] map;
    Random random;
    Enemy[] enemies;
    Player player;


    public PropertiesParser getProperties(){
        return propertiesParser;
    }
    public Enemy[] getEnemies() { return enemies;}
    public Player getPlayer() { return player;}


    public MapGeneration(int wC, int eC, int s) {
        wallsCount = wC;
        enemiesCount = eC;
        size = s;
        map = new char[size][size];
        random = new Random();
        enemies = new Enemy[enemiesCount];
    }


    public char [][] createMap() {
        initializeMap();
        generateWall();
        generateEnemies();
        generationPlayer();
        generationGoal();
        return map;
    }
    public void initializeMap(){
        for (int x = 0; x < size; ++x){
            for (int y = 0; y < size; ++y){
                map[x][y] = Data.EMPTY_CHAR;
            }
        }
    }

    public void generateWall() {
        for (int i = 0; i < wallsCount; ++i) {
            int x = random.nextInt(30);
            int y = random.nextInt(30);
            map[x][y] = Data.WALL_CHAR;
        }
    }

    public void generateEnemies() {
        int j = 0;
        for (int i = 0; i < enemiesCount; ++i) {
            int x, y;
            do {
                x = random.nextInt(30);
                y = random.nextInt(30);
            } while(map[x][y] != Data.EMPTY_CHAR);
            map[x][y] = Data.ENEMY_CHAR;
            Enemy enemy = new Enemy(x, y);
            enemies[j] = enemy;
            j++;
        }
    }

    public void generationPlayer() {
        int x;
        int y;
        do {
            x = random.nextInt(30);
            y = random.nextInt(30);
        } while(map[x][y] != Data.EMPTY_CHAR);
        map[x][y] = Data.PLAYER_CHAR;
        player = new Player(x, y);

    }


    public void generationGoal() {
        int x;
        int y;
        do {
            x = random.nextInt(30);
            y = random.nextInt(30);
        } while(map[x][y] != Data.EMPTY_CHAR);
        map[x][y] = Data.GOAL_CHAR;
    }
}
