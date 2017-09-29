import sun.misc.Unsafe;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by Administrator on 2017/9/21.
 */
public class Test {
    private static final ThreadLocal<Long> threadLocal = new ThreadLocal<>();
    private static final int HASH_INCREMENT = 0x61c88647;
    private final int threadLocalHashCode = nextHashCode();
    private static int nextHashCode() {
        return nextHashCode.getAndAdd(HASH_INCREMENT);
    }
    private static AtomicInteger nextHashCode =
            new AtomicInteger();

    private int tt(){
        return threadLocalHashCode & (16 - 1);
    }
    public static void main(String[] args) {
//        for (int i = 0;i<1000;i++) {
//            System.out.println(new Test().tt());
//        }

        FutureTask futureTask = new FutureTask(()->{
            return 2;
        });
        try {
            futureTask.run();
            System.out.println(futureTask.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        Runnable runnable = ()->{
            Thread.currentThread().getId();
            threadLocal.set(Thread.currentThread().getId());
        };
        Thread.currentThread().getId();
        Thread thread1 = new Thread(runnable);
        thread1.start();
        Thread thread2 = new Thread(runnable);
        thread2.start();
        while (Thread.activeCount()>1)
            Thread.yield();
        System.out.println("end");
        threadLocal.get();
    }


}
