package task03;

import java.io.*;

public class Product {
    private boolean isReady;
    private InputStream inputStream;
    private OutputStream outputStream;
    private int c;

    public Product(String filename1, String filename2) {
        this.inputStream = new InputStreamReader(new File(filename1));
        this.outputStream = new OutputStreamWriter(new File(filename1))
    }

    public void produce() throws IOException {
        c = inputStream.read();
        isReady = true;
    }

    public boolean isProduced() {
        return isReady;
    }

    public void consume() {
        outputStream.
        isReady = false;
    }

    public boolean isConsumed() {
        return !isReady;
    }
}
