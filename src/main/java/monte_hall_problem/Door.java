package monte_hall_problem;

import java.util.Arrays;
import java.util.Objects;
import java.util.Random;

/**
 * A door has hidden prize in it which only Monty has complete information about
 * And it has a door state which mimics whether it is open or closed
 */
public class Door {
    private final Prize hiddenPrize;
    private DoorState doorState;

    public Door(Prize hiddenPrize, DoorState doorState) {
        this.hiddenPrize = hiddenPrize;
        this.doorState = doorState;
    }

    public static Door[] getDoorsWithRandomPrizes(int numOfDoors) {
        final Random random = new Random((long) 1e9);
        final Door[] doors = new Door[numOfDoors];
        Arrays.fill(doors, new Door(Prize.GOAT, DoorState.CLOSE));
        int choice = getChoice(random, numOfDoors);
        doors[choice] = new Door(Prize.CAR, DoorState.CLOSE);
        return doors;
    }

    private static int getChoice(Random random, int numOfDoors) {
        return random.nextInt(numOfDoors);
    }

    public Prize getHiddenPrize() {
        return hiddenPrize;
    }

    public void setDoorState(DoorState doorState) {
        this.doorState = doorState;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) return true;
        if (obj == null || obj.getClass() != this.getClass()) return false;
        var that = (Door) obj;
        return Objects.equals(this.hiddenPrize, that.hiddenPrize) &&
                Objects.equals(this.doorState, that.doorState);
    }

    @Override
    public int hashCode() {
        return Objects.hash(hiddenPrize, doorState);
    }

    @Override
    public String toString() {
        return "Door[" +
                "hiddenPrize=" + hiddenPrize + ", " +
                "doorState=" + doorState + ']';
    }

}
