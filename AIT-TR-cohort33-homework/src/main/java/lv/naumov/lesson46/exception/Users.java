package lv.naumov.lesson46.exception;

import lombok.extern.slf4j.Slf4j;

import java.util.HashSet;
import java.util.Set;

@Slf4j
public class Users {
    private final Set<User> users = new HashSet<>();

    public void addUser(User user) {
      users.add(user);
      log.info("Пользователь добавлен в систему");
    }
}
