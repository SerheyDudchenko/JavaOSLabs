import java.util.concurrent.CompletableFuture;

public class FibonacciAsync {
    public static void main(String[] args) {
        long number = 47;
        long result = CalculateAsyncFibonacci(number);
        System.out.println("Fibonacci(" + number + ") = " + result);
    }

    private static long CalculateAsyncFibonacci(long number) {
        System.out.println("Calculating Fibonacci number asynchronously...");
        CompletableFuture<Long> future = CompletableFuture.supplyAsync(() -> fibonacci(number));
        System.out.println("Waiting for the calculation to complete...");
        return future.join();
    }

    private static long fibonacci(long number) {
        if (number <= 1) {
            return number;
        } else {
            return fibonacci(number - 1) + fibonacci(number - 2);
        }
    }
}
