package springxml.beans;

import springxml.services.ModifyObjectService;

import java.util.ArrayList;

public class User {
    private ArrayList<Deck> decks = new ArrayList();
    private int user_id;
    private String username;
    private String password;
    private ModifyObjectService service;

    public User() {
    }

    public User(ModifyObjectService service) {
        this.service = service;
    }

    public String objectChange()
    {
        return service.modifyObject("User");
    }

    public void objectError()
    {
        service.error("There was an error creating a User object.");
    }

    public ArrayList<Deck> getDecks() {
        return decks;
    }

    public void setDecks(ArrayList<Deck> decks) {
        this.decks = decks;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setService(ModifyObjectService service) {
        this.service = service;
    }
}
