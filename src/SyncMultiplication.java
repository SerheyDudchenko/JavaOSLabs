import java.util.Random;
import java.util.Scanner;

import static java.util.Arrays.stream;

public class SyncMultiplication {
    public static void main(String[] args) {
        int n = 10000;
        int[] input1 = new int[n];
        int[] input2 = new int[n];
        int[] result = new int[n];
        int sleep;


        FillArray(n, input1);
        FillArray(n, input2);

        sleep =  getSleep();
        long time1 = System.currentTimeMillis();

       // MultiplicationSync(n,input1, input2, result, sleep);
       // System.out.printf("Sync : %s\n", System.currentTimeMillis() - time1);

        MultiplicationParallel(input1, input2, result, sleep);
        System.out.printf("Parallel : %s\n", System.currentTimeMillis() - time1);


    }

    private static void MultiplicationSync(int n, int[] input1, int[] input2, int[] result, int sleep) {
        for (int i = 0; i < n; i++) {
            result[i] = input1[i] * input2[i];
            Sleep(sleep);
        }
    }

    private static void MultiplicationParallel(int[] input1, int[] input2, int[] result, int sleep) {
        stream(result).parallel().peek(i-> {
            result[i] = input1[i] * input2[i];
            Sleep(sleep);
        }).toArray();
    }

    private static void Sleep(int sleep) {
        try {
            Thread.sleep(sleep);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    static int getSleep() {
        int sleep;
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter sleep time in milliseconds: ");
        sleep = scanner.nextInt();
        scanner.close();
        return sleep;
    }

    static void FillArray(int n, int[] input1) {
        Random rand = new Random();
        for (int i = 0; i < n; i++) {
            input1[i] = rand.nextInt(101);
        }
    }
}
