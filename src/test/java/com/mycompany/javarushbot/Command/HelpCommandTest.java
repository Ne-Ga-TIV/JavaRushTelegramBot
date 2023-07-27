package com.mycompany.javarushbot.Command;

import com.mycompany.javarushbot.command.*;
import com.mycompany.javarushbot.service.SendMsgBotService;

import static com.mycompany.javarushbot.command.CommandName.HELP;

public class HelpCommandTest extends AbstractCommandTest{
    @Override
    String getCommandName() {
        return HELP.getCommandName();
    }

    @Override
    String getCommandMessage() {

        return HelpCommand.commandMenu;
    }

    @Override
    Command getCommand() {
        return new HelpCommand(send);
    }
}
