package monte_hall_problem;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SimulatePlayerTest {
    @Test
    public void test_correct_closed_door() {
        Door[] doors = {new Door(Prize.CAR, DoorState.CLOSE), new Door(Prize.GOAT, DoorState.CLOSE),
                new Door(Prize.GOAT, DoorState.CLOSE)};
        SimulatePlayer simulate = new SimulatePlayer(doors);
        assertEquals(simulate.getClosedDoor(1), 0);
        assertEquals(simulate.getClosedDoor(2), 0);
        assertEquals(simulate.getClosedDoor(0), 2);
        Door[] fourDoors = {new Door(Prize.CAR, DoorState.CLOSE), new Door(Prize.GOAT, DoorState.CLOSE),
                new Door(Prize.GOAT, DoorState.CLOSE), new Door(Prize.GOAT, DoorState.CLOSE)};
        simulate = new SimulatePlayer(fourDoors);
        assertEquals(simulate.getClosedDoor(0), 3);
        assertEquals(simulate.getClosedDoor(1), 0);
        assertEquals(simulate.getClosedDoor(2), 0);
    }
}