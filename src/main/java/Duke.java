import java.util.Scanner;

public class Duke {
    public static void main(String[] args) {
        String logo =
                  " ____        _        \n"
                + "|  _ \\ _   _| | _____ \n"
                + "| | | | | | | |/ / _ \\\n"
                + "| |_| | |_| |   <  __/\n"
                + "|____/ \\__,_|_|\\_\\___|\n";
        System.out.println("Hello from\n" + logo);
        Scanner scanner = new Scanner(System.in);

        String inputString;
        boolean shutdown = false;
        while (!shutdown) {
            inputString = scanner.nextLine();
            if (inputString.equals("bye")) {
                shutdown = true;
                System.out.println("Bye. Hope to see you again soon!");
                
            } else {
                System.out.println(inputString);
            }
        }
    }

}