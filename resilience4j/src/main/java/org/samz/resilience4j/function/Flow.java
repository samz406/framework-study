package org.samz.resilience4j.function;


import java.io.Serializable;
import java.util.Objects;
import java.util.function.Consumer;
import java.util.function.Supplier;

/**
 * @author: lilin
 * @Date: 2021/12/31 16:12
 * @Description:
 */
public interface Flow<T> {


    boolean isFailure();

    Throwable getCause();

    T get();

    static <T> Flow<T> of(Supplier<T> supplier) {
        try {
            return new Success<>(supplier.get());
        } catch (Throwable throwable) {
            return new Failure<>(throwable);
        }
    }

    default Flow<T> onFailure(Consumer<? super Throwable> action) {
        Objects.requireNonNull(action, "action is null");
        if (isFailure()) {
            action.accept(getCause());
        }
        return this;
    }


    final class Success<T> implements Flow<T>, Serializable {

        private static final long serialVersionUID = 1L;

        private final T value;

        /**
         * Constructs a Success.
         *
         * @param value The value of this Success.
         */
        private Success(T value) {
            this.value = value;
        }

        @Override
        public boolean isFailure() {
            return false;
        }

        @Override
        public Throwable getCause() {
            return null;
        }

        @Override
        public T get() {
            return value;
        }
    }

    final class Failure<T> implements Flow<T>, Serializable {

        private static final long serialVersionUID = 1L;


        private final Throwable cause;

        private Failure(Throwable cause) {
            Objects.requireNonNull(cause, "cause is null");
            this.cause = cause;
        }

        @Override
        public boolean isFailure() {
            return true;
        }

        @Override
        public Throwable getCause() {
            return cause;
        }

        @Override
        public T get() {
            return null;
        }
    }


}
