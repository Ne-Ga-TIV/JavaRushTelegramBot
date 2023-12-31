package com.mycompany.javarushbot.command;

import com.mycompany.javarushbot.service.SendMsgBotService;
import com.mycompany.javarushbot.service.TelegramUserService;
import lombok.AllArgsConstructor;
import org.telegram.telegrambots.meta.api.objects.Update;

@AllArgsConstructor
public class StopCommand implements Command{

    public final static String bye = "Пока, до новый встреч!";

    private final SendMsgBotService send;
    private final TelegramUserService telegramUserService;

    @Override
    public void execute(Update update) {

        send.sendMessage(update.getMessage().getChatId().toString(), bye);
        telegramUserService.findByChatId(update.getMessage().getChatId().toString())
                .ifPresent(it -> {
                    it.setActive(false);
                    telegramUserService.save(it);
                });
    }
}
