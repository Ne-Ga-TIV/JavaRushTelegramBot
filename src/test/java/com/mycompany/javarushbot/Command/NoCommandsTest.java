package com.mycompany.javarushbot.Command;

import com.mycompany.javarushbot.command.Command;
import com.mycompany.javarushbot.command.NoCommands;
import com.mycompany.javarushbot.command.StartCommand;
import com.mycompany.javarushbot.command.StopCommand;
import com.mycompany.javarushbot.service.SendMsgBotService;
import static com.mycompany.javarushbot.command.CommandName.NO;

public class NoCommandsTest extends AbstractCommandTest{
    @Override
    String getCommandName() {
        return NO.getCommandName();
    }

    @Override
    String getCommandMessage() {
        return NoCommands.no_cmd;
    }

    @Override
    Command getCommand() {
        return new NoCommands(send);
    }
}
