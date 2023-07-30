package com.mycompany.javarushbot.repository;


import com.mycompany.javarushbot.repository.entity.TelegramUser;
import lombok.AllArgsConstructor;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.AutoConfigureDataJpa;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.Sql;

import java.util.List;
import java.util.Optional;

import static org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace.NONE;

@ActiveProfiles("test")
@DataJpaTest
@AllArgsConstructor
@AutoConfigureTestDatabase(replace = NONE)
public class TelegramUserRepositoryIT {

    private TelegramUserRepository telegramUserRepository;
    @Sql(scripts = {"/sql/clearDbs.sql", "/sql/telegram_users.sql"})
    @Test
    public void shouldProperlyFindAllActiveUser(){
        //when
        List<TelegramUser> users = telegramUserRepository.findAllByActiveTrue();
        //then
        Assertions.assertEquals(5, users.size());
    }
    @Sql(scripts = {"/sql/clearDbs.sql"})
    @Test
    public void shouldProperlyTelegramUser(){
        //given
        TelegramUser telegramUser = new TelegramUser();
        telegramUser.setChatId("1234567890");
        telegramUser.setActive(false);
        telegramUserRepository.save(telegramUser);

        //when
        Optional<TelegramUser> saved = telegramUserRepository.findById(telegramUser.getChatId());

        Assertions.assertTrue(saved.isPresent());
        Assertions.assertEquals(telegramUser, saved.get());
    }

}
