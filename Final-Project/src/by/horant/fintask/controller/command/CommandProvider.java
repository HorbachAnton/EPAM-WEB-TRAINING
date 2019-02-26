package by.horant.fintask.controller.command;

import java.util.HashMap;
import java.util.Map;

import by.horant.fintask.controller.command.impl.AuthorizationCommand;
import by.horant.fintask.controller.command.impl.GoToIndexPageCommand;
import by.horant.fintask.controller.command.impl.GoToRegistrationCommand;
import by.horant.fintask.controller.command.impl.RegistrationCommand;

public class CommandProvider {

    private Map<String, Command> commands = new HashMap<>();

    public CommandProvider() {
	commands.put("go_to_index", new GoToIndexPageCommand());
	commands.put("authorization", new AuthorizationCommand());
	commands.put("registration", new RegistrationCommand());
	commands.put("goToRegistrationPage", new GoToRegistrationCommand());
    }

    public Command getCommand(String commandName) {
	return commands.get(commandName);
    }

}
