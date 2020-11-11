package week4.JavaConcurrency;
import java.util.concurrent.*;

public class FutureDemo {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newCachedThreadPool();
        Future<String> result = executor.submit(new Callable<String>() {
            public String call() throws Exception {
                return Thread.currentThread().getName();
            }
        });
        executor.shutdown();
        try {
            System.out.println("result:" + result.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}