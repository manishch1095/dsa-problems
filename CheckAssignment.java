import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CheckAssignment {
    public static void main(String ...args) {
        // 1. Using Thread class directly
        Thread thread1 = new Thread() {
            @Override
            public void run() {
                System.out.println("Running in Thread class: " + Thread.currentThread().getName());
            }
        };
        thread1.start();

        // 2. Using Runnable interface
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                System.out.println("Running in Runnable: " + Thread.currentThread().getName());
            }
        };
        Thread thread2 = new Thread(runnable);
        thread2.start();

        // 3. Using Lambda with Runnable (modern approach)
        Thread thread3 = new Thread(() -> {
            System.out.println("Running in Lambda: " + Thread.currentThread().getName());
        });
        thread3.start();

        // 4. Using ExecutorService (recommended approach)
        ExecutorService executor = Executors.newFixedThreadPool(2);
        executor.execute(() -> {
            System.out.println("Running in ExecutorService: " + Thread.currentThread().getName());
        });
        
        // Don't forget to shutdown the executor
        executor.shutdown();
    }
}

class A implements Cloneable {
    String str;
    Integer i;
    
    public A() {}
    
    @Override
    public A clone() {
        try {
            return (A) super.clone();
        } catch (CloneNotSupportedException e) {
            return null;
        }
    }
    
    public String toString() {
        return "A{" +
                "str='" + str + '\'' +
                ", i=" + i +
                '}';
    }
}
