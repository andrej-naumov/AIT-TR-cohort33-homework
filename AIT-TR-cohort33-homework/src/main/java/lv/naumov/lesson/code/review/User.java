package lv.naumov.lesson.code.review;

import java.util.ArrayList;

import lombok.Getter;
import lombok.Setter;

public class User {
	@Getter // надо, если используются вне этого класса (?)
	@Setter // ?
	private String userName;
	@Getter // ?
	@Setter // ?
	private int age;
	private ArrayList<String> friends = new ArrayList<>();

	public User(String name, int age) {
		this.userName = name;
		this.age = age;
	}

	public void addFriend(String friendName) {
		friends.add(friendName);
	}

	public void removeFriend(String friendName) {
		friends.remove(friendName);
	}

	public ArrayList<String> getFriends() {
		return new ArrayList<>(friends);
	}
}

/**
 * Инструкции:<br>
 * 1. Ознакомьтесь с кодом. <br>
 * 2. Обратите внимание на стиль кодирования, именование переменных и методов,
 * структуру кода, принципы ООП. <br>
 * 3. Выпишите все замечания, которые у вас возникли по коду, и предложите свои
 * корректировки.<br>
 * 4. Объясните причины ваших предложений
 * 
 * 
 * package de.cohort33.review; import java.util.ArrayList; public class User {
 * private String user_name; private int age; ArrayList<String> friendsList =
 * new ArrayList<>(); public User(String name, int age) { this.user_name = name;
 * this.age = name; } public String GetName() { return user_name; } public void
 * SetName(String newName) { this.user_name = newName; } public int getAge() {
 * return age; } public void setAge(int newAge) { age = newAge; } public void
 * addFriend(String friendName) { friendsList.add(friendName); } public void
 * removeFriend(String friendName) { friendsList.remove(friendName); } public
 * ArrayList<String> GetFriends() { return friendsList; } }
 */