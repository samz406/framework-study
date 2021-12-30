package org.samz.resilience4j.function;

import org.junit.Test;

import io.vavr.Function1;
import io.vavr.Function2;
import io.vavr.Function4;
import io.vavr.Function8;
import io.vavr.control.Option;
import io.vavr.control.Try;

/**
 * @author: lilin
 * @Date: 2021/12/30 17:21
 * @Description:
 */
public class FunctionDemo {


    @Test
    public void func1() {

        //1个入参
        Function1<Integer, Integer> sum1 = (a) -> a + a;
        System.out.println(sum1.apply(1));

        //2个入参
        Function2<Integer, Integer, Integer> sum2 = (a, b) -> a + b;
        System.out.println(sum2.apply(1, 3));

        //4个入参
        Function4<Integer, Integer, Integer, Integer, Integer> sum4 = (a, b, c, d) -> a + b + c + d;
        System.out.println(sum4.apply(1, 2, 3, 4));
        //.....
        //8个入参.....
        Function8<Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer> sum8 = (a, b, c, d, e, f, g, h) -> a + b + c + d + e + f + g + h;
        System.out.println(sum8.apply(1, 2, 3, 4, 5, 6, 7, 8));

        Function1<Integer, Integer> sumOf = Function1.of(this::get);

        System.out.println(sumOf.apply(2));


    }

    public Integer get(Integer i) {
        return i * i;
    }

    @Test
    public void optionTest() {


        String result = Option.of(1).map(String::valueOf).get();

        System.out.println(result);
    }

    @Test
    public void tryTest() {

        String result = Try.of(() -> "1").getOrElse(() -> "2");
        System.out.println(result);
        //报错
        final Integer t1 = Try.of(() -> 1 / 0).getOrElse(() -> 2);
        System.out.println(t1);
        //and then
        Try.of(() -> "3").andThen(i -> System.out.println(i));


        Try.of(() -> 2).andThen((i) -> {
            i = i / 1;
        }).onFailure((t) -> System.out.println("报错了啊" + t.getMessage())).onSuccess((i) -> System.out.println("结果是" + i));


    }


}
