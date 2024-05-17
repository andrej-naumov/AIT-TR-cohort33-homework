package java.basic.naumov.social;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import lombok.Getter;

public class Group {

	@Getter
	int id;
	@Getter
	String name;
	Set<User> members = new HashSet<>();
	
    public Group(int id, String name) {
        this.id = id;
        this.name = name;
    }
	
    public void addMember(User user) {
        members.add(user);
        user.getGroups().add(this);
    }
    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Group group = (Group) obj;
        return id == group.id && Objects.equals(name, group.name);
    }
}
