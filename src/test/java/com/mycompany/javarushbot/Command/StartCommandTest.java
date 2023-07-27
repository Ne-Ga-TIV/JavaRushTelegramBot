package com.mycompany.javarushbot.Command;

import com.mycompany.javarushbot.command.Command;
import com.mycompany.javarushbot.command.StartCommand;
import com.mycompany.javarushbot.service.SendMsgBotService;

import static com.mycompany.javarushbot.command.CommandName.START;

public class StartCommandTest extends AbstractCommandTest{
    @Override
    String getCommandName() {
        return START.getCommandName();
    }

    @Override
    String getCommandMessage() {
        return StartCommand.hello;
    }

    @Override
    Command getCommand() {
        return new StartCommand(send);
    }
}
