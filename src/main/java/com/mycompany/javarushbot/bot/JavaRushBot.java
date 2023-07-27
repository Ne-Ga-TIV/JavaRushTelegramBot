package com.mycompany.javarushbot.bot;

import com.mycompany.javarushbot.command.CommandContainer;
import com.mycompany.javarushbot.service.SendMsgBotService;
import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.objects.Update;

import static com.mycompany.javarushbot.command.CommandName.NO;

@Slf4j
@Component
public class JavaRushBot extends TelegramLongPollingBot {

    String COMMAND_PREFIX = "/";
    @Value("${bot.username}")
    private String username;
    @Value("${bot.token}")
    private String token;

    private final CommandContainer container;

    public JavaRushBot() {
        this.container = new CommandContainer(new SendMsgBotService(this));
    }


    @Override
    public void onUpdateReceived(Update update) {

        if(update.hasMessage() && update.getMessage().hasText()) {
            String message = update.getMessage().getText().trim();
            if(message.startsWith(COMMAND_PREFIX)){
                String command = message.split(" ")[0].toLowerCase();
                container.retrieveCommand(command).execute(update);
            }
            else
                container.retrieveCommand(NO.getCommandName()).execute(update);
        }
    }


    @Override
    public String getBotUsername() {
        return username;
    }

    @Override
    public String getBotToken() {
        return token;
    }
}
