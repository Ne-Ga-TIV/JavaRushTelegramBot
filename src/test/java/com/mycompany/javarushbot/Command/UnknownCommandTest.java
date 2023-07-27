package com.mycompany.javarushbot.Command;

import com.mycompany.javarushbot.command.*;
import com.mycompany.javarushbot.service.SendMsgBotService;

import static com.mycompany.javarushbot.command.CommandName.HELP;

public class UnknownCommandTest extends AbstractCommandTest{
    @Override
    String getCommandName() {
        return "/asdf";
    }

    @Override
    String getCommandMessage() {

        return UnknownCommand.unknownCommand;
    }

    @Override
    Command getCommand() {
        return new UnknownCommand(send);
    }
}
