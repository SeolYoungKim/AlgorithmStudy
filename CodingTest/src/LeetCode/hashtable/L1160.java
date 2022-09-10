package LeetCode.hashtable;

public class L1160 {
    public static void main(String[] args) {
        String[] words = {"dyiclysmffuhibgfvapygkorkqllqlvokosagyelotobicwcmebnpznjbirzrzsrtzjxhsfpiwyfhzyonmuabtlwin","ndqeyhhcquplmznwslewjzuyfgklssvkqxmqjpwhrshycmvrb","ulrrbpspyudncdlbkxkrqpivfftrggemkpyjl","boygirdlggnh","xmqohbyqwagkjzpyawsydmdaattthmuvjbzwpyopyafphx","nulvimegcsiwvhwuiyednoxpugfeimnnyeoczuzxgxbqjvegcxeqnjbwnbvowastqhojepisusvsidhqmszbrnynkyop","hiefuovybkpgzygprmndrkyspoiyapdwkxebgsmodhzpx","juldqdzeskpffaoqcyyxiqqowsalqumddcufhouhrskozhlmobiwzxnhdkidr","lnnvsdcrvzfmrvurucrzlfyigcycffpiuoo","oxgaskztzroxuntiwlfyufddl","tfspedteabxatkaypitjfkhkkigdwdkctqbczcugripkgcyfezpuklfqfcsccboarbfbjfrkxp","qnagrpfzlyrouolqquytwnwnsqnmuzphne","eeilfdaookieawrrbvtnqfzcricvhpiv","sisvsjzyrbdsjcwwygdnxcjhzhsxhpceqz","yhouqhjevqxtecomahbwoptzlkyvjexhzcbccusbjjdgcfzlkoqwiwue","hwxxighzvceaplsycajkhynkhzkwkouszwaiuzqcleyflqrxgjsvlegvupzqijbornbfwpefhxekgpuvgiyeudhncv","cpwcjwgbcquirnsazumgjjcltitmeyfaudbnbqhflvecjsupjmgwfbjo","teyygdmmyadppuopvqdodaczob","qaeowuwqsqffvibrtxnjnzvzuuonrkwpysyxvkijemmpdmtnqxwekbpfzs","qqxpxpmemkldghbmbyxpkwgkaykaerhmwwjonrhcsubchs"};
        String chars = "usdruypficfbpfbivlrhutcgvyjenlxzeovdyjtgvvfdjzcmikjraspdfp";

        System.out.println(method(words, chars));;
    }

    public static int method(String[] words, String chars) {

        // chars로 만들 수 있는 단어 == good word
        // chars 재배열로 만들 수 있어야 함. (set X)

        // 조건 1. word의 길이 <= chars의 길이
        // 조건 2. 만약 word에 중복 문자가 2개 있으면 chars에도 2개 있어야 한다. (word의 중복 문자 수 <= chars의 중복 문자 수)
        int result = 0;

        int[] counts = new int[26];
        int charsLength = chars.length();

        for (int i = 0; i < charsLength; i++) {
            counts[chars.charAt(i) - 'a']++;
        }

        outer:
        for (String word : words) {
            int wordLength = word.length();

            if (wordLength > charsLength) {
                continue;
            }

            int[] wordCount = new int[26];
            for (int i = 0; i < wordLength; i++) {
                wordCount[word.charAt(i) - 'a']++;
            }

            for (int j = 0; j < 26; j++) {
                if (wordCount[j] > counts[j]) {
                    continue outer;
                }
            }

            result += wordLength;
        }



        return result;
    }
}
