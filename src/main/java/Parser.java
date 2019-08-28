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
                default:
                    throw new DukeException("☹ OOPS!!! I'm sorry, but I don't know what that means :-(\n");
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

    public static String parseDate(String input) throws DukeException {
        try {
            String output;
            String[] splitString = input.split("/", 3);
            String dd = splitString[0];
            String MM = splitString[1];
            splitString = splitString[2].split(" ", 2);
            String yyyy = splitString[0];
            String TTtt = splitString[1];
            if (!isInteger(dd, 10)
                || !isInteger(MM, 10)
                || !isInteger(yyyy, 10)
                || !isInteger(TTtt, 10)) {
                throw new DukeException("Date Time format invalid. Use dd/MM/yyyy TTtt.\n");
            }
            output = dd;
            switch(dd) {
                case "1":
                case "21":
                case "31":
                    output += "st of ";
                    break;
                case "2":
                case "22":
                    output += "nd of ";
                    break;
                case "3":
                case "23":
                    output += "rd of ";
                    break;
                default:
                    output += "th of ";
            }
            switch(MM) {
                case "1":
                    output += "January ";
                    break;
                case "2":
                    output += "February ";
                    break;
                case "3":
                    output += "March ";
                    break;
                case "4":
                    output += "April ";
                    break;
                case "5":
                    output += "May ";
                    break;
                case "6":
                    output += "June ";
                    break;
                case "7":
                    output += "July ";
                    break;
                case "8":
                    output += "August ";
                    break;
                case "9":
                    output += "September ";
                    break;
                case "10":
                    output += "October";
                    break;
                case "11":
                    output += "November";
                    break;
                case "12":
                    output += "December";
                    break;
                default:
                    throw new DukeException("Only 1 - 12 applicable for Month.\n");
            }
            output += yyyy + ", ";
            int hr = Integer.parseInt(TTtt.substring(0, 2));
            String min = TTtt.substring(2, 4);
            output += (hr = hr>12 ? hr%12 : hr) + ":" + min + " " + ((hr>=12) ? "PM" : "AM");
            return output;
        } catch (Exception e) {
            throw new DukeException("Date Time format invalid. Use dd/MM/yyyy TTtt.\n");
        }
    }
}