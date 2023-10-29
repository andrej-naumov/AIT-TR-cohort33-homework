package lv.naumov.social;

public class Main {
    public static void main(String[] args) {
        // Create a social network
        SocialNetwork socialNetwork = new SocialNetwork();

        // Register users
        User user1 = socialNetwork.registerUser(1, "Маша");
        User user2 = socialNetwork.registerUser(2, "Саша");
        User user3 = socialNetwork.registerUser(3, "Даша");

        // Add friends
        user1.addFriend(user2);
        user2.addFriend(user1);
        user2.addFriend(user3);
        user3.addFriend(user2);

        // Create groups
        Group group1 = socialNetwork.createGroup(1, "Просто друзья");
        Group group2 = socialNetwork.createGroup(2, "Команда лучших программистов");

        // Add group members
        group1.addMember(user1);
        group1.addMember(user2);
        group2.addMember(user2);
        group2.addMember(user3);

        // Create posts
        Post post1 = socialNetwork.createPost(1, "Всем привет!", user1);
        Post post2 = socialNetwork.createPost(2, "Давайте наконец то работать!", user2);
        Post post3 = socialNetwork.createPost(3, "Кто за пивом?", user3);

        // Retrieve friends and groups for a user
        System.out.println("Friends of " + user2.getName() + ":");
        socialNetwork.getFriends(user2).forEach(friend -> System.out.println(friend.getName()));

        System.out.println("Groups of " + user2.getName() + ":");
        socialNetwork.getGroups(user2).forEach(group -> System.out.println(group.getName()));
    }
}

