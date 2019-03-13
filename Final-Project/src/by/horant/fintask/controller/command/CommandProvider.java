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
import by.horant.fintask.controller.command.impl.GoToUnapprovedOrderPageCommand;
import by.horant.fintask.controller.command.impl.GoToUpdateEmailPageCommand;
import by.horant.fintask.controller.command.impl.GoToUpdatePasswordPageCommand;
import by.horant.fintask.controller.command.impl.GoToUpdateProfilePageCommand;
import by.horant.fintask.controller.command.impl.GoToUserPageCommand;
import by.horant.fintask.controller.command.impl.RegistrationCommand;
import by.horant.fintask.controller.command.impl.RequestPrescriptionCommand;
import by.horant.fintask.controller.command.impl.UpdateEmailCommand;
import by.horant.fintask.controller.command.impl.UpdatePasswordCommand;
import by.horant.fintask.controller.command.impl.UpdateProfileCommand;

public class CommandProvider {

    private Map<String, Command> commands = new HashMap<>();

    private static final String TO_INDEX_PAGE_COMMAND_NAME = "go_to_index";
    private static final String TO_ADMIN_PAGE_COMMAND_NAME = "go_to_user_page";
    private static final String TO_USER_PAGE_COMMAND_NAME = "go_to_user_page";
    private static final String TO_REGISTRATION_PAGE_COMMAND_NAME = "go_to_registration_page";
    private static final String TO_UPDATE_PROFILE_PAGE_COMMAND_NAME = "go_to_update_profile_page";
    private static final String TO_UPDATE_PASSWORD_PAGE_COMMAND_NAME = "go_to_update_password_page";
    private static final String TO_UPDATE_EMAIL_PAGE_COMMAND_NAME = "go_to_update_email_page";
    private static final String TO_ORDER_PAGE_COMMAND_NAME = "go_to_order_page";
    private static final String TO_UNAPPROVED_ORDER_PAGE_COMMAND_NAME = "go_to_unapproved_order_page";

    private static final String AUTHORIZATION_COMMAND_NAME = "authorization";
    private static final String REGISTRATION_COMMAND_NAME = "registration";

    private static final String REQUEST_PRESCRIPTION_COMMAND_NAME = "request_prescription";
    private static final String ADD_TO_ORDER_COMMAND_NAME = "add_to_order";
    private static final String CHANGE_LOCALE_COMMAND_NAME = "change_locale";
    private static final String UPDATE_PASSWORD_COMMAND_NAME = "update_password";
    private static final String UPDATE_EMAIL_COMMAND_NAME = "update_email";
    private static final String UPDATE_PROFILE_COMMAND_NAME = "update_profile";

    public CommandProvider() {
	commands.put(TO_INDEX_PAGE_COMMAND_NAME, new GoToIndexPageCommand());
	commands.put(TO_ADMIN_PAGE_COMMAND_NAME, new GoToAdminPageCommand());
	commands.put(TO_USER_PAGE_COMMAND_NAME, new GoToUserPageCommand());
	commands.put(TO_REGISTRATION_PAGE_COMMAND_NAME, new GoToRegistrationCommand());
	commands.put(TO_ORDER_PAGE_COMMAND_NAME, new GoToOrderPageCommand());
	commands.put(TO_UPDATE_PROFILE_PAGE_COMMAND_NAME, new GoToUpdateProfilePageCommand());
	commands.put(TO_UPDATE_PASSWORD_PAGE_COMMAND_NAME, new GoToUpdatePasswordPageCommand());
	commands.put(TO_UPDATE_EMAIL_PAGE_COMMAND_NAME, new GoToUpdateEmailPageCommand());
	commands.put(TO_UNAPPROVED_ORDER_PAGE_COMMAND_NAME, new GoToUnapprovedOrderPageCommand());

	commands.put(AUTHORIZATION_COMMAND_NAME, new AuthorizationCommand());
	commands.put(REGISTRATION_COMMAND_NAME, new RegistrationCommand());

	commands.put(ADD_TO_ORDER_COMMAND_NAME, new AddToOrderCommand());
	commands.put(CHANGE_LOCALE_COMMAND_NAME, new ChangeLocale());
	commands.put(REQUEST_PRESCRIPTION_COMMAND_NAME, new RequestPrescriptionCommand());
	commands.put(UPDATE_PROFILE_COMMAND_NAME, new UpdateProfileCommand());
	commands.put(UPDATE_PASSWORD_COMMAND_NAME, new UpdatePasswordCommand());
	commands.put(UPDATE_EMAIL_COMMAND_NAME, new UpdateEmailCommand());
    }

    public Command getCommand(String commandName) {
	return commands.get(commandName);
    }

}
