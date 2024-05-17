package java.basic.naumov.social;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

import lombok.Getter;


public class User {
	@Getter
	int id;
	@Getter
	String name;
	List<User> friends = new ArrayList<>();
	Set<Group> groups = new HashSet<>();

    public User(int id, String name) {
        this.id = id;
        this.name = name;
    }
	
    public void addFriend(User friend) {
        if (friend != this && !friends.contains(friend)) {
            friends.add(friend);
            friend.friends.add(this);
        }
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        User user = (User) obj;
        return id == user.id;
    }

	public Set<Group> getGroups() {
		return groups;
	}

	public List<User> getFriends() {
		return friends;
	}
}
