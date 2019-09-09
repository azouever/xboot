package com.process.boot.rxjava;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import rx.Observable;
import rx.Observable.OnSubscribe;
import rx.Observer;
import rx.observables.SyncOnSubscribe;

/**
 * @author xkx
 * @description
 */
public class RxJavaDemo {

  private final Logger log = LoggerFactory.getLogger(getClass());

  public static void main(String[] args) {

    Observable.create(new SyncOnSubscribe() {
      @Override
      protected Object generateState() {
        return null;
      }

      @Override
      protected Object next(Object state, Observer observer) {
        return null;
      }
    }).subscribe(new Observer() {
      @Override
      public void onCompleted() {

      }

      @Override
      public void onError(Throwable e) {

      }

      @Override
      public void onNext(Object o) {

      }
    });

  }


}
