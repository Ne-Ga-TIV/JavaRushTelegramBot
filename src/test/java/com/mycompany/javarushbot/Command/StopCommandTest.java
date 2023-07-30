package com.mycompany.javarushbot.Command;

import com.mycompany.javarushbot.command.Command;
import com.mycompany.javarushbot.command.StartCommand;
import com.mycompany.javarushbot.command.StopCommand;
import com.mycompany.javarushbot.service.SendMsgBotService;
import static com.mycompany.javarushbot.command.CommandName.STOP;

public class StopCommandTest extends AbstractCommandTest{
    @Override
    String getCommandName() {
        return STOP.getCommandName();
    }

    @Override
    String getCommandMessage() {
        return StopCommand.bye;
    }

    @Override
    Command getCommand() {
        return new StopCommand(send, telegramUserService);
    }
}
