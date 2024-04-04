import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {}
        System.out.print("Enter a line of input: ");
        String line = scanner.nextLine();
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {}
        System.out.println("You entered: " + line);
    }
}