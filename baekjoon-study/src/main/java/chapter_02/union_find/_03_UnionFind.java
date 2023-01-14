package chapter_02.union_find;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

/**
 * 백준 1043번
 */
public class _03_UnionFind {
    static int[] people;
    static int[] truthPeople;

    public static void main(String[] args) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int numberOfPerson = Integer.parseInt(st.nextToken());
            int partyCount = Integer.parseInt(st.nextToken());

            people = new int[numberOfPerson + 1];
            for (int i = 0; i <= numberOfPerson; i++) {
                people[i] = i;
            }

            String[] truth = br.readLine().split(" ");
            int truthCounts = Integer.parseInt(truth[0]);

            truthPeople = new int[truthCounts];
            for (int i = 1; i < truth.length; i++) {
                truthPeople[i - 1] = Integer.parseInt(truth[i]);
            }

            Map<Integer, List<Integer>> parties = new HashMap<>();
            for (int i = 0; i < partyCount; i++) {
                String[] partyInfo = br.readLine().split(" ");
                List<Integer> participants = parties.computeIfAbsent(i, integer -> new ArrayList<>());
                for (int j = 1; j < partyInfo.length; j++) {
                    participants.add(Integer.valueOf(partyInfo[j]));
                }
            }

            for (List<Integer> participants : parties.values()) {
                Integer first = participants.get(0);
                for (int i = 1; i < participants.size(); i++) {
                    union(first, participants.get(i));
                }
            }

            int result = 0;
            outer:
            for (List<Integer> participants : parties.values()) {
                Integer value = participants.get(0);
                int rootInParty = find(value);
                for (int truthPerson : truthPeople) {
                    int t = find(truthPerson);
                    if (t == rootInParty) {
                        continue outer;
                    }
                }

                result++;
            }

            System.out.println(result);
        }
    }

    static int find(int num) {
        if (people[num] == num) {
            return num;
        }

        return people[num] = find(people[num]);
    }

    static void union(int num1, int num2) {
        num1 = find(num1);
        num2 = find(num2);

        if (num1 != num2) {
            people[num2] = num1;
        }
    }
}
