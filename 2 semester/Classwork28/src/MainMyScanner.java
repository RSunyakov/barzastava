import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

public class MainMyScanner {
    public static void main(String[] args) throws IOException {
        InputStream is = new FileInputStream("text1.txt");
        MyScanner ms = new MyScanner(is);
        String s = ms.nextLine();
        System.out.println(s);
    }
}
