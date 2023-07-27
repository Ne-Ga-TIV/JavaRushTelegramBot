package com.mycompany.javarushbot.command;

import com.mycompany.javarushbot.service.SendMsgBotService;

import java.util.ConcurrentModificationException;
import java.util.HashMap;
import java.util.Map;

import static com.mycompany.javarushbot.command.CommandName.*;
import static java.util.stream.Stream.builder;

public class CommandContainer {

    private final HashMap<String, Command> commmands;
    private final UnknownCommand unknownCommand;
    public CommandContainer(SendMsgBotService send){
        commmands =  new HashMap<String, Command>();
        commmands.put(START.getCommandName(), new StartCommand(send));
        commmands.put(STOP.getCommandName(), new StopCommand(send));
        commmands.put(HELP.getCommandName(), new HelpCommand(send));
        commmands.put(NO.getCommandName(), new NoCommands(send));

        unknownCommand = new UnknownCommand(send);

    }

    public Command retrieveCommand(String input){
        return commmands.getOrDefault(input, unknownCommand);
    }
}
