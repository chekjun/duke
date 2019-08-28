class Parser {
    public static Command parse(String fullCommand) throws DukeException {
        String[] splitString = fullCommand.split(" ", 2);
        CommandType commandType = checkCommand(splitString[0]);
        if (splitString.length == 1) {
            switch(commandType) {
                case TODO:
                    throw new DukeException("☹ OOPS!!! The description of a todo cannot be empty.\n");
                case DEADLINE:
                    throw new DukeException("☹ OOPS!!! The description of a deadline cannot be empty.\n");
                case EVENT:
                    throw new DukeException("☹ OOPS!!! The description of an event cannot be empty.\n");
                case DONE:
                case DELETE:
                    throw new DukeException("Please specify a task.\n");
                case LIST:
                    return new ListCommand();
                case EXIT:
                    return new ExitCommand();
                default:
                    throw new DukeException("☹ OOPS!!! I'm sorry, but I don't know what that means :-(");
            }
        } else {
            String commandDetail = splitString[1];
            switch(commandType) {
                case TODO:
                case DEADLINE:
                case EVENT:
                    return new AddCommand(commandType, commandDetail);
                case DONE:
                    return new DoneCommand(commandDetail);
                case DELETE:
                    return new DeleteCommand(commandDetail);
                default:
                    throw new DukeException("☹ OOPS!!! I'm sorry, but I don't know what that means :-(");
            }
        }
    }

    public static CommandType checkCommand(String str) throws DukeException {
        switch(str) {
            case "todo":
            case "Todo":
                return CommandType.TODO;
            case "deadline":
            case "Deadline":
                return CommandType.DEADLINE;
            case "event":
            case "Event":
                return CommandType.EVENT;
            case "done":
            case "Done":
                return CommandType.DONE;
            case "delete":
            case "Delete":
                return CommandType.DELETE;
            case "list":
            case "List":
                return CommandType.LIST;
            case "bye":
            case "Bye":
                return CommandType.EXIT;
            default:
                throw new DukeException("☹ OOPS!!! I'm sorry, but I don't know what that means :-(\n");
        }
    }
}