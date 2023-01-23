package coding_test_company.brains;

public class Test1 {
    public static void main(String[] args) {
//        System.out.println(Arrays.toString(countNumbers(123456789L)));
//        System.out.println(Arrays.toString(countNumbers(123321)));
//        System.out.println(Arrays.toString(countNumbers(133355555000L)));

        System.out.println(checkWord("old macdonald had a farm", "a"));
        System.out.println(checkWord("old macdonald had a farm", "old"));
        System.out.println(checkWord("old macdonald had a farm", "the"));
    }

    static int[] countNumbers(long a) {
        String strNum = String.valueOf(a);

        int[] numbers = new int[10];
        for (int i = 0; i < strNum.length(); i++) {
            int num = strNum.charAt(i) - '0';
            numbers[num]++;
        }

        return numbers;
    }

    public static int checkWord(String s, String w) {
        if (!s.contains(w)) {
            return 0;
        }

        String[] words = s.split(" ");

        int count = 1;
        for (String word : words) {
            if (word.equals(w)) {
                break;
            }

            count++;
        }

        return count;
    }
}
