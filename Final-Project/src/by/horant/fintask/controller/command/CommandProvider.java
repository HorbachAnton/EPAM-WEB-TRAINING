package by.horant.fintask.controller.command;

import java.util.HashMap;
import java.util.Map;

import by.horant.fintask.controller.command.impl.AddToOrderCommand;
import by.horant.fintask.controller.command.impl.AuthorizationCommand;
import by.horant.fintask.controller.command.impl.ChangeLocale;
import by.horant.fintask.controller.command.impl.GoToAdminPageCommand;
import by.horant.fintask.controller.command.impl.GoToIndexPageCommand;
import by.horant.fintask.controller.command.impl.GoToOrderPageCommand;
import by.horant.fintask.controller.command.impl.GoToRegistrationCommand;
import by.horant.fintask.controller.command.impl.GoToUpdateProfilePageCommand;
import by.horant.fintask.controller.command.impl.GoToUserPageCommand;
import by.horant.fintask.controller.command.impl.RegistrationCommand;
import by.horant.fintask.controller.command.impl.UpdateProfileCommand;

public class CommandProvider {

    private Map<String, Command> commands = new HashMap<>();

    public CommandProvider() {
	commands.put("go_to_index", new GoToIndexPageCommand());
	commands.put("go_to_admin_page", new GoToAdminPageCommand());
	commands.put("go_to_user_page", new GoToUserPageCommand());
	commands.put("go_to_registration_page", new GoToRegistrationCommand());
	commands.put("go_to_update_profile_page", new GoToUpdateProfilePageCommand());
	commands.put("go_to_order_page", new GoToOrderPageCommand());

	commands.put("authorization", new AuthorizationCommand());
	commands.put("registration", new RegistrationCommand());

	commands.put("change_locale", new ChangeLocale());
	commands.put("update_profile", new UpdateProfileCommand());
	commands.put("add_to_order", new AddToOrderCommand());
    }

    public Command getCommand(String commandName) {
	return commands.get(commandName);
    }

}
