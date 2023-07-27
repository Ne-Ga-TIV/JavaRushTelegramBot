package com.mycompany.javarushbot.command;


import com.mycompany.javarushbot.service.SendMsgBotService;
import lombok.AllArgsConstructor;
import org.telegram.telegrambots.meta.api.objects.Update;

import static com.mycompany.javarushbot.command.CommandName.HELP;

@AllArgsConstructor
public class NoCommands implements Command{

    public final static String no_cmd = "Прости, но я не понимаю тебя, используй команды пожалуйста";

    private final SendMsgBotService send;
    @Override
    public void execute(Update update) {
        send.sendMessage(update.getMessage().getChatId().toString(), no_cmd);
    }
}

