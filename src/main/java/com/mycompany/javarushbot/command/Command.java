package com.mycompany.javarushbot.command;

import org.telegram.telegrambots.meta.api.objects.Update;

public interface Command {
    public void execute(Update update);
}
