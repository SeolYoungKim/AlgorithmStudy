package ThisIsCodingTest.dfs_and_dfs.recursive;

public class Gcd {
    public static void main(String[] args) {
        System.out.println(gcd(192, 162));
    }

    public static int gcd(int a, int b) {
        if (a % b == 0) {
            return b;
        }

        return gcd(b, a % b);
    }
}
