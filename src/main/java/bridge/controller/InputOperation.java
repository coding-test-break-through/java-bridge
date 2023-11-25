package bridge.controller;

@FunctionalInterface
public interface InputOperation<T> {
    T operate() throws IllegalArgumentException;
}
