package com.mycompany.javarushbot.repository;

import com.mycompany.javarushbot.repository.entity.TelegramUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TelegramUserRepository extends CrudRepository<TelegramUser, String> {
    List<TelegramUser> findAllByActiveTrue();
}
