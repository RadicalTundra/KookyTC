package hibernate.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "users_id")
    private int user_id;
    //the default fetch type lazy loading is fine for this mapping
    @OneToMany(cascade = CascadeType.ALL)
    @JoinTable(name="users_decks",
            joinColumns = @JoinColumn(name="users_id"),
            inverseJoinColumns = @JoinColumn(name="deck_id"))
    private List<Deck> decks;
    @Column(name = "username")
    private String username;
    @Column(name = "display_name")
    private String display_name;
    @Column(name = "pass_word")
    private String password;

    public User() {
    }

    //A user needs a username and password, but not a list of decks. Those are created after the user starts using the site!
    //That's why the list of decks are not included in the constructor.
    public User(String username, String display_name, String password) {
        this.username = username;
        this.display_name = display_name;
        this.password = password;
    }

    public List<Deck> getDecks() {
        return decks;
    }

    public void setDecks(List<Deck> decks) {
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

    public String getDisplay_name() {
        return display_name;
    }

    public void setDisplay_name(String display_name) {
        this.display_name = display_name;
    }

    @Override
    public String toString() {
        return "User{" +
                "user_id=" + user_id +
                ", numOfDecks=" + decks.size() +
                ", username='" + username + '\'' +
                ", username='" + display_name + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
