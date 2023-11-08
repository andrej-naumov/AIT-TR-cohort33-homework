package lv.naumov.lesson46.exception;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
@Getter
@EqualsAndHashCode
@Slf4j
public class User {

private    int id = 0;
private String name;
private    String pwd;
    public User(String name, String pwd){
        id++;
        this.name = name;
        this.pwd = pwd;
        log.info("Новый пользователь создан - Имя: " + name  + " id: " + id);
    }
}
