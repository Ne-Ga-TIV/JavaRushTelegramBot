package com.mycompany.javarushbot.command;

import com.mycompany.javarushbot.repository.entity.TelegramUser;
import com.mycompany.javarushbot.service.SendMsgBotService;
import com.mycompany.javarushbot.service.TelegramUserService;
import lombok.AllArgsConstructor;
import org.telegram.telegrambots.meta.api.objects.Update;

@AllArgsConstructor
public class StartCommand implements Command{


    private final SendMsgBotService send;
    private final TelegramUserService telegramUserService;

    public final static String hello = "Привет, я бот созданный в целях изучение Java и Java Spring";

    @Override
    public void execute(Update update) {
        String charId = update.getMessage().getChatId().toString();



        telegramUserService.findByChatId(charId).ifPresentOrElse(
            user -> {
             user.setActive(true);
             telegramUserService.save(user);
         }, () -> {
                    TelegramUser telegramUser = new TelegramUser();
                    telegramUser.setActive(true);
                     telegramUser.setChatId(charId);
                     telegramUserService.save(telegramUser);
            });
         send.sendMessage(charId, hello);


    }
}
