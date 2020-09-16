package com.baerwang.delegate.company;

/**
 * 委派模式（Delegate Pattern）
 * <p>
 * 委派模式不属于GOF23种设计模式。委派模式的基本作用就是负责任务的调用和分配，跟代理模式很像，
 * 可以看作一个特殊情况下的静态全权代理，但是代理模式注重过程，而委派模式注重结果。
 * </p>
 *
 * @author baerwang
 * @since 2020/9/4 11:18
 */
public class DelegateTest {

    public static void main(String[] args) {

        // 代理模式注重的是过程，委派模式注重的是结果
        // 策略模式注重可扩展性（外部扩展性），委派模式注重内部的灵活性和可复用性
        // 委派模式的核心就是分发，调度，派遣，委派模式是静态代理和策略模式的一种特殊组合
        new Boss().command("登录", new Leader());
    }


    /*
        BlockingQueue<Runnable> queue = new ArrayBlockingQueue<>(10);
        ThreadFactory factory = r -> new Thread(r, "test_thread_pool");
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(5, 5, 0L, TimeUnit.SECONDS, queue, factory, new ThreadPoolExecutor.DiscardPolicy());
        for (int i = 0; i < 1000; i++) {
            threadPoolExecutor.submit(() -> {
                try {
                    System.out.println(Thread.currentThread().getName() + ":执行任务" + queue.size());
                    TimeUnit.MILLISECONDS.sleep(10000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }
    * */
}
