package test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class MyTest {

    public static void main(String[] args) {
        String[] strArr = {
                "jean:0,0,11,20,0",
                "alex:21,2,7,11,4",
                "kevin:8,4,5,0,0",
                "brown:3,5,16,3,18",
        };

        List<Player> players = Arrays.stream(strArr)
                .map(strings -> strings.split(":"))
                .map(strings -> new Player(strings[0], strings[1]))
                .map(Player::scoresToZeroCountOfPlayer)
                .collect(Collectors.toList());

//        players.forEach(Player::scoresToZeroCount);

        List<Player> collect = players.stream()
                .sorted()
                .collect(Collectors.toList());

        System.out.println(collect);

    }

    static class Player implements Comparable<Player> {

        private final String name;
        private final String scores;
        private int zeroCount;

        public Player(String name, String scores) {
            this.name = name;
            this.scores = scores;
        }

        public void scoresToZeroCount() {
            zeroCount = (int) Arrays.stream(scores.split(","))
                    .filter(str -> str.equals("0"))
                    .count();
        }

        public Player scoresToZeroCountOfPlayer() {
            zeroCount = (int) Arrays.stream(scores.split(","))
                    .filter(str -> str.equals("0"))
                    .count();

            return this;
        }

        @Override
        public String toString() {
            return "Player{" +
                    "name='" + name + '\'' +
                    ", scores='" + scores + '\'' +
                    ", zeroCount=" + zeroCount +
                    '}';
        }

        @Override
        public int compareTo(Player o) {
            return o.zeroCount - zeroCount;
        }
    }
}
