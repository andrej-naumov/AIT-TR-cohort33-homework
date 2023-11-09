package lv.naumov.lesson46.exception;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

@EqualsAndHashCode
@Slf4j
public class User {

private    int id = 0;
@Getter
private final String name;
private  final   String pwd;
    public User(String name, String pwd){
        id++;
        this.name = name;
        this.pwd = pwd;
        //log.info("Новый пользователь создан - Имя: " + name  + " id: " + id);
    }
}
