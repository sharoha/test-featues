package monte_hall_problem;

import java.util.*;

public class SimulatePlayer implements Simulate {
    private final Door[] doors;

    public SimulatePlayer(Door[] doors) {
        this.doors = doors;
    }

    @Override
    public List<GameResult> simulate(int numOfGames) {
        final List<GameResult> gameResults = new ArrayList<>();
        for (int i = 0; i < numOfGames; i++) {
            final Random random = new Random();
            shuffleArray(doors);
            int doorChoice = random.nextInt(doors.length);
            // simulate door open and close operation in a simulation game
            // get the door which is not opened
            doorChoice = getClosedDoor(doorChoice); // change your choice to the new found closed door
            // add the result for later calculation
            if (doors[doorChoice].getHiddenPrize() == Prize.CAR) {
                gameResults.add(GameResult.WON);
            } else {
                gameResults.add(GameResult.LOST);
            }
        }
        return gameResults;
    }

    public int getClosedDoor(int doorChoice) {
        int openDoorCount = 0;
        int closeDoorLocation = -1;
        int numOfDoors = doors.length;
        for (int j = 0; j < numOfDoors; j++) {
            if (j != doorChoice) {
                if (doors[j].getHiddenPrize() == Prize.GOAT && openDoorCount < numOfDoors - 2) {
                    openDoorCount++;
                    doors[j].setDoorState(DoorState.OPEN);
                } else {
                    closeDoorLocation = j;
                }
            }
        }
        return closeDoorLocation;
    }

    // a simple method to shuffle array, like Collections.shuffle, Arrays class does not have any similar method
    // so have to write out my own implementation
    private static void shuffleArray(Door[] array) {
        int index;
        Random random = new Random();
        for (int i = array.length - 1; i > 0; i--) {
            index = random.nextInt(i + 1);
            if (index != i) {
                Door temp = array[i];
                array[i] = array[index];
                array[index] = temp;
            }
        }
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) return true;
        if (obj == null || obj.getClass() != this.getClass()) return false;
        var that = (SimulatePlayer) obj;
        return Arrays.equals(this.doors, that.doors);
    }

    @Override
    public int hashCode() {
        return Objects.hash(doors);
    }

    @Override
    public String toString() {
        return "SimulatePlayer[" +
                "doors=" + doors + ']';
    }

}
