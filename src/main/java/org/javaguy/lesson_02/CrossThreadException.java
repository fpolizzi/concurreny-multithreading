/**
 * Created by fpolizzi on 10/19/26
 */
void main() throws InterruptedException {
    Thread failing = new Thread(() -> {
        throw new IllegalStateException("boom");
    }, "failing-worker");

    try {
        failing.start();
        failing.join();
    } catch (IllegalStateException e) {
        IO.println("caught in main? never printed");
    }
    IO.println("main carries on");
}