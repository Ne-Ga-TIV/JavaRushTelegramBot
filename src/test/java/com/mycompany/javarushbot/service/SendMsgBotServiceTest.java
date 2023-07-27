package com.mycompany.javarushbot.service;

import com.mycompany.javarushbot.bot.JavaRushBot;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;


@DisplayName("Unit-level testing for SendMsgBotService")
public class SendMsgBotServiceTest {

    private SendMsgBotService send;
    private JavaRushBot bot;

    @BeforeEach
    public void init(){
        bot = Mockito.mock(JavaRushBot.class);
        send = new SendMsgBotService(bot);

    }

    @Test
    public void shouldProperlySendMessage() throws TelegramApiException {
        //given
        String chatId = "test_chat_id";
        String message = "test_message";

        SendMessage sendMessage = new SendMessage();
        sendMessage.setText(message);
        sendMessage.setChatId(chatId);


        //when
        send.sendMessage(chatId, message);

        //then
        Mockito.verify(bot).execute(sendMessage);
    }
}
