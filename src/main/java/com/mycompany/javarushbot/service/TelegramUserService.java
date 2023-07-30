package com.mycompany.javarushbot.service;

import com.mycompany.javarushbot.repository.entity.TelegramUser;

import java.util.List;
import java.util.Optional;

import org.jvnet.hk2.annotations.Service;

public interface TelegramUserService {

    void save(TelegramUser telegramUser);

    List<TelegramUser> retrieveAllActiveUsers();

    Optional<TelegramUser> findByChatId(String chatId);
}