package org.samz.resilience4j.demo;


import java.time.Duration;

import io.github.resilience4j.bulkhead.Bulkhead;
import io.github.resilience4j.bulkhead.BulkheadConfig;
import io.github.resilience4j.bulkhead.BulkheadRegistry;

/**
 * Bulkhead提供两种实现
 * 1）一种是基于信号量的
 * 2）一种是基于有等待队列的固定大小的线程池的
 * @author: lilin
 * @Date: 2021/12/7 19:29
 * @Description:
 */
public class BulkheadConf {

    /**
     *如下配置
     * resilience4j:
     *   bulkhead:
     *     configs:
     *       default:
     *         maxConcurrentCalls: 10
     *         maxWaitDuration: 1
     *     instances:
     *       bulkhead:
     *         baseConfig: default
     * @return
     */

    public static Bulkhead getBulkhead() {

        //maxConcurrentCalls 允许最大的并发线程数
        //maxWaitDuration 尝试进入饱和舱壁时应阻止线程的最大时间
        BulkheadConfig config = BulkheadConfig.custom()
                .maxConcurrentCalls(2)
                .maxWaitDuration(Duration.ofSeconds(20))
                .build();

        BulkheadRegistry bulkheadRegistry =
                BulkheadRegistry.of(config);

        return bulkheadRegistry.bulkhead("bulkhead");
    }
}
