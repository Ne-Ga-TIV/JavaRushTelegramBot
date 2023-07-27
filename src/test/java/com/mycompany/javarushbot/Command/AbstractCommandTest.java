package com.mycompany.javarushbot.Command;

import com.mycompany.javarushbot.bot.JavaRushBot;
import com.mycompany.javarushbot.command.Command;
import com.mycompany.javarushbot.service.SendMsgBotService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

abstract class AbstractCommandTest {
    protected JavaRushBot bot = Mockito.mock(JavaRushBot.class);
    protected SendMsgBotService send = new SendMsgBotService(bot);

    abstract String getCommandName();

    abstract  String getCommandMessage();

    abstract Command getCommand();


    @Test
    public void shouldProretlyExecuteCommand() throws TelegramApiException {
        //given
        Long chatId = 1111111111L;

        Update update = new Update();
        Message message = Mockito.mock(Message.class);
        Mockito.when(message.getChatId()).thenReturn(chatId);
        Mockito.when(message.getText()).thenReturn(getCommandName());
        update.setMessage(message);

        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(chatId.toString());
        sendMessage.setText(getCommandMessage());

        //when
        getCommand().execute(update);

        //then
        Mockito.verify(bot).execute(sendMessage);
    }
}
