import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadExample {

    private int cnt = 0;

    public void add() {
        ++cnt;
    }

    public int getCnt() {
        return cnt;
    }

    public static void main(String[] args) throws InterruptedException {

        final int threadSize = 1000;
        ThreadExample threadExample = new ThreadExample();
        final CountDownLatch countDownLatch = new CountDownLatch(threadSize);
        ExecutorService service = Executors.newCachedThreadPool();
        for (int i = 0; i < threadSize; ++i) {
            service.execute(() -> {
                threadExample.add();
                countDownLatch.countDown();
            });
        }

        countDownLatch.await();
        service.shutdown();
        System.out.println(threadExample.getCnt());

    }


}
