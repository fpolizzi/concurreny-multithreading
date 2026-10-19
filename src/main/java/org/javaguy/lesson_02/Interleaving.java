/**
 * Created by fpolizzi on 10/19/26
 */
void main() {
    Thread letters = new Thread(() -> {
        for (char letter = 'A'; letter <= 'E'; letter++) {
            IO.println("letters: " + letter);
        }
    });

    Thread numbers = new Thread(() -> {
        for (int number = 1; number <= 5; number++) {
            IO.println("numbers: " + number);
        }
    });

    letters.start();
    numbers.start();
}