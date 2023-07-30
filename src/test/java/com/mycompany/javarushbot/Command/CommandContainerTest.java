package com.mycompany.javarushbot.Command;

import com.mycompany.javarushbot.command.Command;
import com.mycompany.javarushbot.command.CommandContainer;
import com.mycompany.javarushbot.command.CommandName;
import com.mycompany.javarushbot.command.UnknownCommand;
import com.mycompany.javarushbot.service.SendMsgBotService;
import com.mycompany.javarushbot.service.TelegramUserServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Arrays;
@DisplayName("Unit-level testing for CommandContainer")
public class CommandContainerTest {

    private CommandContainer cmdContainer;

    @BeforeEach
    public void init(){
        SendMsgBotService send = Mockito.mock(SendMsgBotService.class);
        TelegramUserServiceImpl telegramUserService = Mockito.mock(TelegramUserServiceImpl.class);
        cmdContainer = new CommandContainer(send, telegramUserService);
    }

    @Test
    public  void shouldGetAllTheExistingCommands() {
        //when-then
        Arrays.stream(CommandName.values()).forEach(commandName -> {
            Command command = cmdContainer.retrieveCommand(commandName.getCommandName());
            Assertions.assertNotEquals(UnknownCommand.class, command.getClass());
        });
    }

    @Test
    public void shouldReturnUnknownCommand() {
        //given
        String unknownCommand = "/asdf";

        //when
        Command command = cmdContainer.retrieveCommand(unknownCommand);

        //then
        Assertions.assertEquals(UnknownCommand.class, command.getClass());
    }
}
