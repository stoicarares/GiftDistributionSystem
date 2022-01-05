package Command;

import java.util.LinkedList;

public class Invoker {
    private final LinkedList<Command> commands = new LinkedList<>();

    public void execute(Command command) {
        commands.push(command);
        command.execute();
    }
}