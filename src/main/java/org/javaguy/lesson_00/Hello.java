/**
 * Created by fpolizzi on 10/6/26
 */
void main() {
    // print the name of the current thread
    IO.println("org.javaguy.lesson_00.Hello from " + Thread.currentThread().getName());
    // print available cpu cores
    IO.println("CPU cores available: " + Runtime.getRuntime().availableProcessors());
}