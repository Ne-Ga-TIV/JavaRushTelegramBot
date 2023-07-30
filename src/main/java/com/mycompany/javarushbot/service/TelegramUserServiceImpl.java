package com.mycompany.javarushbot.service;

import com.mycompany.javarushbot.repository.TelegramUserRepository;
import com.mycompany.javarushbot.repository.entity.TelegramUser;
import lombok.AllArgsConstructor;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
@AllArgsConstructor
@Primary
public class TelegramUserServiceImpl implements TelegramUserService{

    private final TelegramUserRepository telegramUserRepository;


    public void save(TelegramUser telegramUser) {
        telegramUserRepository.save(telegramUser);
    }

    public List<TelegramUser> retrieveAllActiveUsers() {
        return telegramUserRepository.findAllByActiveTrue();
    }

    public Optional<TelegramUser> findByChatId(String chatId) {
        return telegramUserRepository.findById(chatId);
    }
}