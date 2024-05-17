package java.basic.naumov.social;

import java.util.Objects;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public class Post {

	@Getter
	int id;
	String content;
	User author;
	
    @Override
    public int hashCode() {
        return Objects.hash(id, content, author);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Post post = (Post) obj;
        return id == post.id && Objects.equals(content, post.content) && Objects.equals(author, post.author);
    }
}
