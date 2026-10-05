/**
 * Created by fpolizzi on 9/6/26
 */

void main() {
    greet("threads");
    var counter = new Counter();
    counter.increment();
    IO.println(counter.value());
}

void greet(String topic) {
    IO.println("Let's learn " + topic);
}

class Counter {
    private int value;

    void increment() {
        value++;
    }

    int value() {
        return value;
    }
}
