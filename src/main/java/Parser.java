public class Parser {
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
                case FIND:
                    throw new DukeException("Please specify a task.\n");
                case LIST:
                    return new ListCommand();
                case EXIT:
                    return new ExitCommand();
                default:
                    throw new DukeException("☹ OOPS!!! I'm sorry, but I don't know what that means :-(\n");
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
                case FIND:
                    return new FindCommand(commandDetail);
                default:
                    throw new DukeException("☹ OOPS!!! I'm sorry, but I don't know what that means :-(\n");
            }
        }
    }

    public static CommandType checkCommand(String str) throws DukeException {
        switch(str) {
            case "todo":
            case "Todo":
            case "ToDo":
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
            case "find":
            case "Find":
                return CommandType.FIND;
            case "bye":
            case "Bye":
                return CommandType.EXIT;
            default:
                throw new DukeException("Command not recognised.\n");
        }
    }

    public static boolean isInteger(String string, int radix) {
        if (string.isEmpty()) {
            return false;
        }
        for (int i = 0; i < string.length(); i++) {
            if (i == 0 && string.charAt(i) == '-') {
                if (string.length() == 1) {
                    return false;
                } else {
                    continue;
                }
            }
            if (Character.digit(string.charAt(i),radix) < 0) {
                return false;
            }
        }
        return true;
    }

    public static String parseDateTime(String dateTime) throws DukeException {
        try {
            String parsedDateTime; // able to be printed
            String[] splitDateTime = dateTime.split(" ", 2);
            String[] splitDate = splitDateTime[0].split("/", 3);
            String dd = splitDate[0];
            String MM = splitDate[1];
            String yyyy = splitDate[2];
            String TTtt = splitDateTime[1];
            if (!Parser.isInteger(dd, 10)
                || !Parser.isInteger(MM, 10)
                || !Parser.isInteger(yyyy, 10)
                || !Parser.isInteger(TTtt, 10)
                || !Parser.isInteger(TTtt.substring(0, 2), 10)
                || !Parser.isInteger(TTtt.substring(2, 4), 10)) {
                throw new DukeException("Date Time format invalid. Use dd/MM/yyyy TTtt.\n");
            }
            if (Integer.parseInt(dd) < 1
                || Integer.parseInt(dd) > 31
                || Integer.parseInt(MM) < 1
                || Integer.parseInt(MM) > 12
                || Integer.parseInt(yyyy) < 0
                || Integer.parseInt(TTtt.substring(0, 2)) < 0
                || Integer.parseInt(TTtt.substring(0, 2)) > 24
                || Integer.parseInt(TTtt.substring(2, 4)) < 0
                || Integer.parseInt(TTtt.substring(2, 4)) > 59) {
                throw new DukeException("Invalid date/time given.\n");
            }
            parsedDateTime = dd;
            switch(dd) {
                case "1":
                case "21":
                case "31":
                    parsedDateTime += "st of ";
                    break;
                case "2":
                case "22":
                    parsedDateTime += "nd of ";
                    break;
                case "3":
                case "23":
                    parsedDateTime += "rd of ";
                    break;
                default:
                    parsedDateTime += "th of ";
                    break;
            }
            switch(MM) {
                case "1":
                    parsedDateTime += "January ";
                    break;
                case "2":
                    parsedDateTime += "February ";
                    break;
                case "3":
                    parsedDateTime += "March ";
                    break;
                case "4":
                    parsedDateTime += "April ";
                    break;
                case "5":
                    parsedDateTime += "May ";
                    break;
                case "6":
                    parsedDateTime += "June ";
                    break;
                case "7":
                    parsedDateTime += "July ";
                    break;
                case "8":
                    parsedDateTime += "August ";
                    break;
                case "9":
                    parsedDateTime += "September ";
                    break;
                case "10":
                    parsedDateTime += "October ";
                    break;
                case "11":
                    parsedDateTime += "November ";
                    break;
                case "12":
                    parsedDateTime += "December ";
                    break;
            }
            parsedDateTime += yyyy + ", ";
            int hr = Integer.parseInt(TTtt.substring(0, 2));
            String min = TTtt.substring(2, 4);
            parsedDateTime += (hr <= 12 ? hr : hr % 12) + ":" + min + " " + ((hr < 12) ? "AM" : "PM");
            return parsedDateTime;
        } catch (Exception e) {
            throw new DukeException("Date Time format invalid. Use dd/MM/yyyy TTtt.\n");
        }
    }
    
    public static void parseDukeToText() {
        
    }
}