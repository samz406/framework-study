package org.samz.resilience4j.function;

/**
 * @author: lilin
 * @Date: 2021/12/31 16:27
 * @Description:
 */
public class FlowDemo {

    public static void main(String[] args) {

        final Flow<Integer> flow = Flow.of(() -> 1).onFailure(throwable -> {
            System.out.println("error");
        });

        System.out.println(flow.get());
    }
}
