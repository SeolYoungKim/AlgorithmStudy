package daily._2023._05;

import static org.assertj.core.api.Assertions.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class Day_18 {
    public List<Integer> findSmallestSetOfVertices(int n, List<List<Integer>> edges) {
        final Map<Integer, Boolean> hasNodeIncomingEdge = new HashMap<>();
        for (int i = 0; i < n; i++) {
            hasNodeIncomingEdge.put(i, false);
        }

        for (List<Integer> edge : edges) {
            final Integer linkedNode = edge.get(1);
            hasNodeIncomingEdge.put(linkedNode, true);
        }

        return hasNodeIncomingEdge.entrySet().stream()
                .filter(entry -> !entry.getValue())
                .map(entry -> entry.getKey())
                .toList();
    }

    @Test
    void test() {
        assertThat(findSmallestSetOfVertices(6, List.of(
                List.of(0, 1), List.of(0, 2), List.of(2, 5), List.of(3, 4), List.of(4, 2)))
        ).isEqualTo(List.of(0, 3));

        assertThat(findSmallestSetOfVertices(5, List.of(
                List.of(0, 1), List.of(2, 1), List.of(3, 1), List.of(1, 4), List.of(2, 4)))
        ).isEqualTo(List.of(0, 2, 3));
    }
}
