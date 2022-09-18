package LeetCode.hashtable.easy;

/**
 * https://leetcode.com/problems/design-hashset/
 */
public class L705 {
    public static void main(String[] args) {
        L705 obj = new L705();

        obj.add(1);
        obj.add(2);
        System.out.println(obj.set);

        System.out.println(obj.contains(1));
        System.out.println(obj.contains(3));

        obj.add(2);
        System.out.println(obj.set);
        System.out.println(obj.contains(2));

        obj.remove(2);
        System.out.println(obj.set);

        System.out.println((obj.contains(2)));

    }

    String set = "";

    public L705() {
    }

    public void add(int key) {
        if (!set.contains(String.valueOf(key))) {
            set += key;
        }
    }

    public void remove(int key) {
        if (set.contains(String.valueOf(key))) {
            set = set.replace(String.valueOf(key), "");
        }
    }

    public boolean contains(int key) {
        return set.contains(String.valueOf(key));
    }
}
