package monte_hall_problem;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MonteHallProblemRunner {
    private static final Logger logger = Logger.getLogger(MonteHallProblemRunner.class.getName());

    private static final Integer NUM_OF_GAMES = 1_000_000;
    private static final Integer NUM_OF_DOORS = 100;

    public static void main(String[] args) {
        final Door[] doors = Door.getDoorsWithRandomPrizes(NUM_OF_DOORS);
        final Simulate simulation = new SimulatePlayer(doors);
        List<GameResult> gameResult = simulation.simulate(NUM_OF_GAMES);
        long wonCount = gameResult.stream().filter(res -> res == GameResult.WON).count();
        double wonPercentage = (( wonCount * 1.0) / ( NUM_OF_GAMES * 1.0)) * 100.0;
        double lostPercentage = 100.0 - wonPercentage;
        logger.log(Level.INFO, String.format("Won percentage: %f, lost percentage: %f", wonPercentage, lostPercentage));
    }
}
