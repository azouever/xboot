package com.process.xboot.ds.list;


import com.google.common.util.concurrent.FutureCallback;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.ListeningExecutorService;
import com.google.common.util.concurrent.MoreExecutors;
import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import org.checkerframework.checker.nullness.qual.Nullable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author Kai
 * @description do something
 */
public class ArrayListDemo {

  private static final Logger log = LoggerFactory.getLogger(ArrayListDemo.class);

  public static void main(String[] args) {

    ArrayList<String> list = new ArrayList<>();
    list.add("hello");

    ExecutorService executorService = Executors.newFixedThreadPool(20);

    ExecutorService executorServiceCallback = Executors.newFixedThreadPool(20);
    ListeningExecutorService listeningExecutorService = MoreExecutors
        .listeningDecorator(executorService);
    ListenableFuture<?> listenableFuture = listeningExecutorService.submit(new Runnable() {
      @Override
      public void run() {
        System.out.println("异步任务执行ing");
      }
    });

    Futures.addCallback(listenableFuture, new FutureCallback<Object>() {
      @Override
      public void onSuccess(@Nullable Object result) {

      }

      @Override
      public void onFailure(Throwable t) {

      }
    }, executorServiceCallback);

    ThreadFactory threadFactory = MoreExecutors.platformThreadFactory();

  }

}
