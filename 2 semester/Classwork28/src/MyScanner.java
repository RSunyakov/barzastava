import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

public class MyScanner {
    private InputStream is;

    public MyScanner(InputStream is) {
        this.is = is;
    }

    private void forNextMethods(StringBuffer sb) throws IOException {
        int i;
        while ((i = is.read()) != ' ') {
            sb.append((char)i);
        }

    }

    public int nextInt() throws IOException {
        StringBuffer sb = new StringBuffer();
        forNextMethods(sb);
        String s = new String(sb);
        return Integer.parseInt(s);
    }

    public double nextDouble() throws IOException {
        StringBuffer sb = new StringBuffer();
        forNextMethods(sb);
        String s = new String(sb);
        return Double.parseDouble(s);
    }

    private void forNextString(ArrayList<Byte> byteList, byte[] bytesNew) throws IOException {
        Byte[] bytes = new Byte[byteList.size()];
        bytes = byteList.toArray(bytes);
        for (int k = 0; k < byteList.size() ; k++) {
            bytesNew[k] = bytes[k];
        }
    }

    public String next() throws IOException {
        /*byte[] bytes = new byte[is.available()];
        int length = is.read(bytes);
        for (int j = 0; j < bytes.length; j++) {
            if (bytes[j] == ' ') {
                for (int k = j + 1; k < bytes.length ; k++) {
                    bytes[k] = 0;
                }
                break;
            }
        }*/
        int i;
       ArrayList<Byte> byteList = new ArrayList<>();
        while ((i = is.read()) != ' ') {
            byteList.add((byte)i);
        }
       byte[] bytesNew = new byte[byteList.size()];
        forNextString(byteList, bytesNew);
        return new String(bytesNew,StandardCharsets.UTF_8);
    }

    public String nextLine() throws IOException {
        int i;
        ArrayList<Byte> byteList = new ArrayList<>();
        while ((i = is.read()) != '\n') {
            byteList.add((byte)i);
        }
        byte[] bytesNew = new byte[byteList.size()];
        forNextString(byteList, bytesNew);
        return new String(bytesNew, StandardCharsets.UTF_8);
    }
}
