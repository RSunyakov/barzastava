import java.util.Random;

public class Main {
    static int mainSum = 0;
    static final Object MUTEX = new Object();
    public static void main(String[] args) throws InterruptedException {
        Random random = new Random();
        int[] arr = new int[100];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = random.nextInt();
        }
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
        }
        CounterThread count1 = new CounterThread(arr, 0, 33);
        CounterThread count2 = new CounterThread(arr, 33, 66);
        CounterThread count3 = new CounterThread(arr, 66, 100);
        count1.start();
        count2.start();
        count3.start();
        count1.join();
        count2.join();
        count3.join();
        System.out.println(mainSum);
        System.out.println(sum);
    }
}

