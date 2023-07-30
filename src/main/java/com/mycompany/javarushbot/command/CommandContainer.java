package com.mycompany.javarushbot.command;

import com.mycompany.javarushbot.service.SendMsgBotService;
import com.mycompany.javarushbot.service.TelegramUserService;
import java.util.HashMap;

import static com.mycompany.javarushbot.command.CommandName.*;

public class CommandContainer {

    private final HashMap<String, Command> commmands;
    private final UnknownCommand unknownCommand;
    public CommandContainer(SendMsgBotService send, TelegramUserService telegramUserService){
        commmands =  new HashMap<String, Command>();
        commmands.put(START.getCommandName(), new StartCommand(send, telegramUserService));
        commmands.put(STOP.getCommandName(), new StopCommand(send, telegramUserService));
        commmands.put(HELP.getCommandName(), new HelpCommand(send));
        commmands.put(NO.getCommandName(), new NoCommands(send));
        commmands.put(STAT.getCommandName(), new StatCommand(send, telegramUserService));

        unknownCommand = new UnknownCommand(send);

    }


    public Command retrieveCommand(String input){
        return commmands.getOrDefault(input, unknownCommand);
    }
}
