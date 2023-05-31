package daily._2023._05;

import static org.assertj.core.api.Assertions.*;

import java.util.HashMap;
import java.util.Map;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class Day_29 {
    private static class ParkingSystem {
        private final Map<Integer, Integer> parkingLot = new HashMap<>();

        public ParkingSystem(final int big, final int medium, final int small) {
            parkingLot.put(1, big);
            parkingLot.put(2, medium);
            parkingLot.put(3, small);
        }

        // 1: big
        // 2: medium
        // 3: small
        public boolean addCar(int carType) {
            return hasEmptySpace(carType);
        }

        private boolean hasEmptySpace(final int carType) {
            final Integer numberOfParkingLot = parkingLot.get(carType);

            if (numberOfParkingLot > 0) {
                parkingLot.put(carType, parkingLot.get(carType) - 1);
                return true;
            }

            return false;
        }
    }

    @Test
    void test() {
        final ParkingSystem parkingSystem = new ParkingSystem(1, 1, 0);
        assertThat(parkingSystem.addCar(1)).isTrue();
        assertThat(parkingSystem.addCar(2)).isTrue();
        assertThat(parkingSystem.addCar(3)).isFalse();
    }
}
