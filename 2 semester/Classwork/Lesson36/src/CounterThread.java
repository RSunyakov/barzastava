public class CounterThread extends Thread{
    private int start;
    private int end;
    private int[] arr;

    public CounterThread(int[] arr, int start, int end) {
        this.arr = arr;
        this.start = start;
        this.end = end;

    }

    @Override
    public void run() {
        for (int i = start; i < end; i++) {
            synchronized (Main.MUTEX) {
                Main.mainSum += arr[i];
            }
        }
    }
}
