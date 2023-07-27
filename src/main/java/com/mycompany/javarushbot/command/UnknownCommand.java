package com.mycompany.javarushbot.command;

import com.mycompany.javarushbot.service.SendMsgBotService;
import lombok.AllArgsConstructor;
import org.telegram.telegrambots.meta.api.objects.Update;

import static com.mycompany.javarushbot.command.CommandName.HELP;

@AllArgsConstructor
public class UnknownCommand implements Command{
    public final static String unknownCommand = "Прости, но я выполняю только готовые команды, чтобы узнать их список введи " + HELP.getCommandName() ;

    private final SendMsgBotService send;
    @Override
    public void execute(Update update) {
        send.sendMessage(update.getMessage().getChatId().toString(), unknownCommand);
    }
}
