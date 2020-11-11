package week4.JavaConcurrency;

import java.util.Random;
import java.util.concurrent.*;

public class FutureTask1 {
    public static void main(String[] args) {
        //绗竴绉嶆柟寮�
        FutureTask<Integer> task = new FutureTask<Integer>(new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                return new Random().nextInt();
            }
        });
        new Thread(task).start();
        
        try {
            System.out.println("result: " + task.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
    
}