package com.mycompany.javarushbot.command;

import com.mycompany.javarushbot.service.SendMsgBotService;
import com.mycompany.javarushbot.service.TelegramUserService;
import lombok.AllArgsConstructor;
import org.telegram.telegrambots.meta.api.objects.Update;

@AllArgsConstructor
public class StatCommand implements  Command{

    private final SendMsgBotService send;
    private final TelegramUserService telegramUserService;

    private final String stat = "Наданный момент ботом пользоуютеся %s человек";


    @Override
    public void execute(Update update) {
        int activeUsers =  telegramUserService.retrieveAllActiveUsers().size();
        send.sendMessage(update.getMessage().getChatId().toString(), String.format(stat, activeUsers));
    }
}
