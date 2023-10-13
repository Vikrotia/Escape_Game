package game;

import com.beust.jcommander.JCommander;

public class Program {
    public static void main (String[] args) {
//        CommandLineArguments commandArg = new CommandLineArguments();
//        JCommander.newBuilder()
//                .addObject(commandArg)
//                .build()
//                .parse(args);
        try {
            Data data = new Data(args);
            Movement map = new Movement(commandArg.getWallsCount(), commandArg.getEnemiesCount(),
                    commandArg.getSize(), data);
            map.Action();
        } catch (IllegalParametersException ex) {
            System.err.println("Illegal parameters.");
            System.exit(-1);
        }
    }
}
