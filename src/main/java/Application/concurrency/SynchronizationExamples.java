package Application.concurrency;

import Application.DSA.LongestIncreasingSubArray;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.concurrent.locks.StampedLock;
import java.util.stream.IntStream;

public class SynchronizationExamples extends LongestIncreasingSubArray{


    public void callHello(){
        new SynchronizationExamples().hello();
    }

    private  int count=0;
    private ReentrantLock lock = new ReentrantLock();

    public static void main(String[] args) {

        SynchronizationExamples examples = new SynchronizationExamples();

      //  examples.incrementCount();
        //examples.trylockingtasks();
       // examples.readAndWriteTaskLock();
       // examples.readAndWriteTaskStampedLock();
        examples.usingSemaphores();

    }

    private void usingSemaphores() {
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        Semaphore semaphore = new Semaphore(3);

        Runnable task = () -> {
            boolean permit = false;
            try{
                permit = semaphore.tryAcquire(1, TimeUnit.SECONDS);
                if(permit){
                    System.out.println("semaphore acquired");
                    sleep(1);
                }else {
                    System.out.println("could not aquire semaphore");
                }
            } catch (InterruptedException e) {
                throw  new IllegalStateException();
            }finally {
                if(permit){
                    semaphore.release();
                }
            }

        };

        IntStream.rangeClosed(1,10).forEach(i -> executorService.submit(task));

        stop(executorService);

    }

    private void readAndWriteTaskStampedLock() {
        ExecutorService service =Executors.newFixedThreadPool(2);
        Map<String, String> map = new HashMap<>();
        StampedLock lock = new StampedLock();

        service.submit(() -> {
          long stamp =  lock.writeLock();
           try{
               sleep(1);
               map.put("foo", "bar");
           }finally {
               lock.unlockWrite(stamp);
           }
        });

        Runnable readTask = () -> {
          long stamp = lock.readLock();
          try {
              System.out.println(map.get("foo"));
              sleep(1);
          }finally {
              lock.unlockRead(stamp);
          }


        };


        service.submit(readTask);
        service.submit(readTask);

        stop(service);

    }

    private void readAndWriteTaskLock() {

        ExecutorService service = Executors.newFixedThreadPool(2);
        Map<String,String> map = new HashMap<>();
        ReadWriteLock lock = new ReentrantReadWriteLock();

        Runnable writeTask = () -> {
            lock.writeLock().lock();
            try {
                System.out.println("writing"+" : " + System.currentTimeMillis());
                sleep(1);
                map.put("foo", "bar");
                System.out.println("writing done"+" : " + System.currentTimeMillis());
            }finally {
                lock.writeLock().unlock();
            }
        };

        Runnable readTask = () -> {
            lock.readLock().lock();

            try {
                System.out.println(map.get("foo")+" : " + System.currentTimeMillis());
                sleep(1);
            }finally {
                lock.readLock().unlock();
            }
        };

        service.submit(writeTask);
        service.submit(readTask);
        service.submit(readTask);

        stop(service);




    }

    private void trylockingtasks() {

        ExecutorService service = Executors.newFixedThreadPool(2);

        ReentrantLock lock = new ReentrantLock();

        service.submit(() -> {
            lock.lock();
            try {
                System.out.println("hello "+Thread.currentThread().getName());
                sleep(1);
            }finally {
                lock.unlock();
            }
        });


        service.submit(() -> {
            System.out.println("hello "+Thread.currentThread().getName());
            System.out.println("locked :"+lock.isLocked());
            System.out.println("locked fair :"+lock.isFair());
            System.out.println("locked by me :"+lock.isHeldByCurrentThread());
            System.out.println("try lock : "+lock.tryLock());


        });

        stop(service);
    }

    private  void incrementCount() {

        ExecutorService service = Executors.newFixedThreadPool(2);

        //IntStream.rangeClosed(1,10000).forEach(i -> service.submit(this::incrementSync));
        IntStream.rangeClosed(1,10000).forEach(i -> service.submit(this::incrementLock));

        stop(service);
        System.out.println(count);
    }

    private  void incrementLock(){

        lock.lock();
        try {
            count = count + 1;
        }finally {
            lock.unlock();
        }
    }

    private  void incrementSync(){

        synchronized(this) {
            count = count + 1;
        }
    }

    private  void sleep(int seconds){

        try {
            TimeUnit.SECONDS.sleep(seconds);
        } catch (InterruptedException e) {
            System.out.println("Sleeping Interrupted : "+Thread.currentThread().getName());
        }
    }

    private  void stop(ExecutorService service){
        service.shutdown();
        try {
            service.awaitTermination(60, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            System.out.println("termination interrupted : "+Thread.currentThread().getName());
        }finally {
            if(!service.isTerminated()){
                System.out.println("cancel all pending tasks");
            }
            service.shutdownNow();
        }

    }


}
