package bridge.util;

@FunctionalInterface
public interface ErrorProducer {

    void produce() throws IllegalArgumentException;
}
