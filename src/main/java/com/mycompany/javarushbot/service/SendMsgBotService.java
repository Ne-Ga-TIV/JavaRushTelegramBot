package com.mycompany.javarushbot.service;

import com.mycompany.javarushbot.bot.JavaRushBot;
import lombok.AllArgsConstructor;
import org.jvnet.hk2.annotations.Service;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;


@Service
@AllArgsConstructor
public class SendMsgBotService {

    private  final JavaRushBot bot;


    public void sendMessage(String chatId, String message){
        SendMessage sm = new SendMessage();
        sm.setText(message);
        sm.setChatId(chatId);

        try{
            bot.execute(sm);
        }catch (TelegramApiException e)
        {
            e.printStackTrace();
        }
    }

}
