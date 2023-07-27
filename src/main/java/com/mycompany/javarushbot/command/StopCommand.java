package com.mycompany.javarushbot.command;

import com.mycompany.javarushbot.service.SendMsgBotService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.telegram.telegrambots.meta.api.objects.Update;

@AllArgsConstructor
public class StopCommand implements Command{

    private final static String bye = "Пока, до новый встреч!";

    private final SendMsgBotService send;

    @Override
    public void execute(Update update) {
        send.sendMessage(update.getMessage().getChatId().toString(), bye);
    }
}
