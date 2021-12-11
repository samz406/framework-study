package org.samz.resilience4j.demo;

import java.util.concurrent.TimeoutException;

import io.github.resilience4j.bulkhead.Bulkhead;
import io.github.resilience4j.bulkhead.BulkheadFullException;
import io.vavr.control.Try;

/**
 *
 */
public class BulkHeadService {

    public static void main(String[] args) {

        Bulkhead bulkhead = BulkheadConf.getBulkhead();
        UserService userService = new UserService();
        for (int i = 0; i < 10; i++) {

            new Thread(() -> {
                Try<Integer> tryOf = Try.of(Bulkhead.decorateCheckedSupplier(bulkhead, userService::getAge)).recover(
                        BulkheadFullException.class, t -> {
                            System.out.println("服务调用失败：" + t.getLocalizedMessage());
                            //默认返回
                            return -1;
                        }
                );
                System.out.println("返回结果是" + tryOf.get());

            }).start();
        }
    }

}
