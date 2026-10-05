/**
 * Created by fpolizzi on 10/6/26
 */

// example of a compact source file (available since java 25)
// - no imports are needed, everything is in the base module
// - instance method | public, static or String[] args is not needed
void main() {
    greet("threads");
    var counter = new Counter();
    counter.increment();
    // integrated system out in java.lang
    IO.println(counter.value());
}

// methods are possible
void greet(String topic) {
    IO.println("Let's learn " + topic);
}

// inner classes are possible
class Counter {
    private int value;

    void increment() {
        value++;
    }

    int value() {
        return value;
    }
}
