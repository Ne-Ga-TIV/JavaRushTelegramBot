package com.mycompany.javarushbot.command;

import com.mycompany.javarushbot.service.SendMsgBotService;
import lombok.AllArgsConstructor;
import org.telegram.telegrambots.meta.api.objects.Update;

@AllArgsConstructor
public class StartCommand implements Command{


    private final SendMsgBotService send;

    public final static String hello = "Привет, я бот созданный в целях изучение Java и Java Spring";

    @Override
    public void execute(Update update) {
        send.sendMessage(update.getMessage().getChatId().toString(), hello);
    }
}
