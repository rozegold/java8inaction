package Application.concurrency;

import java.sql.Time;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.*;

public class ExecutorServiceExamples {


    public static void main(String[] args) {



       // simpleRunnable();
        // usingExecutorService();
         // usingCallable();
       // bulkCallablesInvokeAll();
       // bulkCallablesInvokeAny();
       // scheduledFixRate();
        scheduledFixDelay();

    }

    private static void scheduledFixDelay() {

        ScheduledExecutorService service = Executors.newScheduledThreadPool(1);
        Runnable task = () -> {

            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("scheduling: "+System.nanoTime());
        };

        service.scheduleWithFixedDelay(task,0,1,TimeUnit.SECONDS);
    }

    private static void scheduledFixRate() {
        ScheduledExecutorService service = Executors.newScheduledThreadPool(1);
        Runnable task = () -> System.out.println("scheduling : "+ System.nanoTime());

        int initialDelay = 0;
        int period = 1;
        service.scheduleAtFixedRate(task,initialDelay,period,TimeUnit.SECONDS);
    }

    private static void bulkCallablesInvokeAny() {

        ExecutorService service = Executors.newWorkStealingPool();

        List<Callable<String>> callables = Arrays.asList(

                callable("task1", 3),
                callable("task2" , 11),
                callable("task3", 1)


        );

        try {
            System.out.println(service.invokeAny(callables));
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }


    }

    private static Callable<String>  callable(String result, int i) {

        return () -> {
            TimeUnit.SECONDS.sleep(i);
            return result;
        };
    }

    private static void bulkCallablesInvokeAll() {


        ExecutorService service = Executors.newWorkStealingPool();

        List<Callable<String>> callables = Arrays.asList(
                () -> "task1",
                () -> "task2",
                () -> "task3"
        );

        try {
            service.invokeAll(callables).stream().map(future -> {
                try {
                    return future.get();
                }
                catch (Exception e) {
                    throw new IllegalStateException(e);
                }
            }).forEach(System.out::println);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    private static void usingCallable() {
        Callable<Integer> task = () -> {
            TimeUnit.SECONDS.sleep(2);
            return 123;
        };
        System.out.println("executing task");
        ExecutorService service = Executors.newFixedThreadPool(1);
        Future<Integer> future = service.submit(task);
        try {
            System.out.println("is Done : "+future.isDone());
           // s.shutdownNow();
            Integer i = future.get(1, TimeUnit.SECONDS);
            System.out.println("result : "+i);
            System.out.println("isDone : "+future.isDone());
            System.out.println("isCancelled : "+future.isCancelled());
        } catch (InterruptedException e) {
            System.out.println("InterruptedException"+e.getMessage());
        } catch (ExecutionException e) {
            System.out.println("ExecutionException" + e.getMessage());

        } catch (TimeoutException e) {
            System.out.println("TimeoutException "+e.getMessage());
            e.printStackTrace();
        }

        service.shutdown();
    }

    private static void usingExecutorService() {

        ExecutorService service = Executors.newSingleThreadExecutor();
        service.submit(() -> {
            String name = Thread.currentThread().getName();
            System.out.println("hi : "+name);

        });

        service.shutdown();
        try {
            service.awaitTermination(5,TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            System.out.println("tasks interrupted");
        }finally {
            if(!service.isTerminated()) {
                System.out.println("cancel all unfinished tasks");
                service.shutdownNow();

            }
            System.out.println("shutdown finished");
        }
    }

    private static void simpleRunnable() {
        Runnable task = () -> {

            try {
                String threadName = Thread.currentThread().getName();
                System.out.println("foo : "+threadName);


                TimeUnit.SECONDS.sleep(1);
                System.out.println("bar :"+threadName);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };

        task.run();

        Thread t = new Thread(task);
        Thread t1 = new Thread(task);
        Thread t2 = new Thread(task);
        t.start();
        t1.start();
        t2.start();

        System.out.println("Done");
    }




}

