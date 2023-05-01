package daily._2023._05;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import org.assertj.core.data.Offset;
import org.junit.jupiter.api.Test;

public class Day_01 {
    public double average(int[] salary) {
        Arrays.sort(salary);
        int sum = 0;
        for (int i = 1; i < salary.length - 1; i++) {
            sum += salary[i];
        }

        return (double) sum / (salary.length - 2);
    }

    @Test
    void test() {
        assertThat(average(new int[]{4000, 3000, 1000, 2000})).isEqualTo(2500,
                Offset.offset(0.0001d));
    }
}
