import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BufferedReaderTest {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str1 = br.readLine();
        String str2 = br.readLine();
        String str3 = br.readLine();
        String str4 = br.readLine();
        String str5 = br.readLine();

        System.out.println("str = " + str1);
        System.out.println("str = " + str2);
        System.out.println("str = " + str3);
        System.out.println("str = " + str4);
        System.out.println("str = " + str5);
    }
}
