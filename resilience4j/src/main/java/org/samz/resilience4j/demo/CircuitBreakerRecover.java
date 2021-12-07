package org.samz.resilience4j.demo;

import java.util.function.Supplier;

import io.github.resilience4j.core.SupplierUtils;

/**
 * @author: lilin
 * @Date: 2021/12/7 19:22
 * @Description:
 */
public class CircuitBreakerRecover {

    public static void main(String[] args) {

        Supplier<String> supplier = () -> {
            throw new RuntimeException("BAM!");
        };

        Supplier<String> supplierWithRecovery = SupplierUtils
                .recover(supplier, (exception) -> "Hello Recovery");
        String result = CircuitBreakerObj.getCircuitBreaker().executeSupplier(supplierWithRecovery);
        System.out.println(result);




    }
}
