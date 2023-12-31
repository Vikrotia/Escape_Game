package game;

public class Program {
    public static void main (String[] args) {
        try {
            Data data = new Data(args);
            Movement map = new Movement(data);
            map.Action();
        } catch (IllegalParametersException ex) {
            System.err.println("Illegal parameters.");
            System.exit(-1);
        }
    }
}
