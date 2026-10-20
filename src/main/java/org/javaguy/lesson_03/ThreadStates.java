/**
 * Created by fpolizzi on 10/20/26
 */
final Object lock = new Object();

void main() throws InterruptedException {
    Thread sleeper = new Thread(() -> pause(500), "sleeper");
    IO.println("After new:         " + sleeper.getState());

    sleeper.start();
    IO.println("After start:       " + sleeper.getState());

    pause(100);
    IO.println("While sleeping:    " + sleeper.getState());

    sleeper.join();
    IO.println("After finish:      " + sleeper.getState());

    Thread waiter = new Thread(() -> {
        synchronized (lock) {
            try {
                lock.wait();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }, "waiter");
    waiter.start();
    pause(100);
    IO.println("Inside wait():     " + waiter.getState());

    Thread blocked;
    synchronized (lock) {
        blocked = new Thread(() -> {
            synchronized (lock) {
                IO.println("blocked thread finally got the lock");
            }
        }, "blocked");
        blocked.start();
        pause(100);
        IO.println("Lock held by main: " + blocked.getState());
        lock.notifyAll();
    }
    waiter.join();
    blocked.join();
}

void pause(long millis) {
    try {
        Thread.sleep(millis);
    } catch (InterruptedException e) {
        Thread.currentThread().interrupt();
    }
}