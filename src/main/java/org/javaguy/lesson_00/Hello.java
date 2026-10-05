/**
 * Created by fpolizzi on 10/6/26
 */

void main() {
    // print the name of the current thread
    IO.println("Hello from " + Thread.currentThread().getName());
    // print available cpu cores
    IO.println("CPU cores available: " + Runtime.getRuntime().availableProcessors());
}

