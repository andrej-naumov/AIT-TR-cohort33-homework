package basic.naumov.social;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class SocialNetwork {

	Set<User> users = new HashSet<>() ;
	Set<Group> groups = new HashSet<>();
	List<Post> posts = new ArrayList<>();
	
	   public User registerUser(int id, String name) {
	        // Check if the user with the given id already exists
	        for (User user : users) {
	            if (user.getId() == id) {
	                log.error("Пользователь с ID {} уже существует");
	                return null;
	            }
	        }
	        
	        // Инициализируем нового пользователя
	        User newUser = new User(id, name);
	        users.add(newUser);
	        log.info("Добавлен новый пользователь с именем {} и ID {}", name, id);
	        return newUser;
	    }

	    public Group createGroup(int id, String name) {
	        // Check if the group with the given id already exists
	        for (Group group : groups) {
	            if (group.getId() == id) {
	            	log.error("Группа с ID {} уже существует");
	            	return null;
	            }
	        }

	        // Create a new group and add it to the set of groups
	        Group newGroup = new Group(id, name);
	        groups.add(newGroup);
	        log.info("Добавлена новая группа с именем {} и ID {}", name, id);
	        return newGroup;
	    }

	    public Post createPost(int id, String content, User author) {
	        // Check if the post with the given id already exists
	        for (Post post : posts) {
	            if (post.getId() == id) {
	            	log.error("Пост с ID {} уже существует");
	            	return null;
	            }
	        }

	        // Create a new post and add it to the list of posts
	        Post newPost = new Post(id, content, author);
	        posts.add(newPost);
	        log.info("Добавлен новый пост с ID {}", id);
	        return newPost;
	    }

		public List<User> getFriends(User user) {
			return user.getFriends();
		}

		public Set<Group> getGroups(User user) {		
			return user.getGroups();
		}
}
