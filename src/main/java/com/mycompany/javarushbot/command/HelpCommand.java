package com.mycompany.javarushbot.command;

import com.mycompany.javarushbot.service.SendMsgBotService;
import lombok.AllArgsConstructor;
import org.telegram.telegrambots.meta.api.objects.Update;
@AllArgsConstructor
public class HelpCommand implements  Command{

    public final static String commandMenu = "/start - Команда для начала работы\n" +
                                              "/stop - Остановить бота\n";
    private final SendMsgBotService send;
    @Override
    public void execute(Update update) {
        send.sendMessage(update.getMessage().getChatId().toString(), commandMenu);
    }
}
