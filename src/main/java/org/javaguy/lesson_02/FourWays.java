/**
 * Created by fpolizzi on 10/19/26
 */
void main() throws InterruptedException {
    Thread first = new PrinterThread();

    Thread second = new Thread(new PrinterTask());

    Thread third = new Thread(() -> printFrom("lambda"));

    Thread fourth = Thread.ofPlatform()
            .name("builder-thread")
            .unstarted(() -> printFrom("builder"));

    first.start();
    second.start();
    third.start();
    fourth.start();

    first.join();
    second.join();
    third.join();
    fourth.join();
    IO.println("main is done");
}

void printFrom(String style) {
    IO.println(style + " running on " + Thread.currentThread().getName());
}

class PrinterThread extends Thread {
    @Override
    public void run() {
        IO.println("subclass running on " + getName());
    }
}

class PrinterTask implements Runnable {
    @Override
    public void run() {
        IO.println("runnable running on " + Thread.currentThread().getName());
    }
}