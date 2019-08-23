public class Response {
    private static final String logo =
          "      ____        _        \n"
        + "     |  _ \\ _   _| | _____ \n"
        + "     | | | | | | | |/ / _ \\\n"
        + "     | |_| | |_| |   <  __/\n"
        + "     |____/ \\__,_|_|\\_\\___|\n";
    
    public static void printWelcome() {
        System.out.println(Format.divider
            + logo + "\n"
            + Format.indent + " Hello! I'm Duke\n"
            + Format.indent + " What can I do for you?\n"
            + Format.divider);
    }

    public static void printGoodbye() {
        System.out.println(Format.divider
            + Format.indent + " Bye. Hope to see you again soon!\n"
            + Format.divider);
    }
}