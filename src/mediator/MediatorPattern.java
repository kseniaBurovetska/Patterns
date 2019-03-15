package mediator;

import java.util.ArrayList;
import java.util.List;

public class MediatorPattern {

    public static void main(String[] args) {
        TextChat chat = new TextChat();

        User admin = new Admin(chat);
        User u1 = new SimpleUser(chat);
        User u2 = new SimpleUser(chat);

        chat.setAdmin(admin);
        chat.addUser(u1);
        chat.addUser(u2);

        u1.sendMessage("Hello, I am u1");
        admin.sendMessage("ADMIN is in the chat");
    }

}

abstract class User {

    Chat chat;

    public User(Chat chat) {
        this.chat = chat;
    }

    public void sendMessage(String message) {
        chat.sendMessage(message, this);
    }

    abstract void getMessage(String message);
}

class Admin extends User {

    public Admin(Chat chat) {
        super(chat);
    }

    @Override
    public void getMessage(String message) {
        System.out.println("Admin receives message: " + message);
    }
}

class SimpleUser extends User {

    public SimpleUser(Chat chat) {
        super(chat);
    }

    @Override
    public void getMessage(String message) {
        System.out.println("User receives message: " + message);
    }
}

//Mediator
interface Chat {
    void sendMessage(String message, User user);
}

//Concrete mediator
class TextChat implements Chat {

    User admin;
    List<User> users = new ArrayList<>();

    public void setAdmin(User admin){
        this.admin = admin;
    }

    public void addUser(User user){
        users.add(user);
    }

    @Override
    public void sendMessage(String message, User user) {

        users.forEach(u -> u.getMessage(message));
        admin.getMessage(message);
    }
}