package hibernate.entity;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "cards")
public class Card {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "card_id")
    private int card_id;
    //the default fetch type lazy loading is fine for this mapping
    @ManyToOne(cascade = {CascadeType.DETACH,
            CascadeType.MERGE,
            CascadeType.PERSIST,
            CascadeType.REFRESH})
    @JoinTable(name="deck_cards",
            joinColumns = @JoinColumn(name="card_id"),
            inverseJoinColumns = @JoinColumn(name="deck_id"))
    private Deck assignedDeck;

    @Column(name = "image")
    private String imageFileName;

    @NotNull(message = "required")
    @Column(name = "card_type")
    private String card_type;

    @NotNull(message = "required")
    @Size(min = 1, message = "must be greater than 0")
    @Column(name = "card_name")
    private String card_name;

    @NotNull(message = "required")
    @Size(min = 1, message = "must be greater than 0")
    @Column(name = "card_set")
    private String card_set;

    @Column(name = "power")
    private int power;

    @Column(name = "toughness")
    private int toughness;

    @Column(name = "card_cost")
    private String card_cost;

    @Column(name = "artist")
    private String artist;

    public Card() {
    }

    public Card(Deck assignedDeck, String imageFileName, String card_type, String card_name, String card_set, int power, int toughness, String card_cost, String artist) {
        this.assignedDeck = assignedDeck;
        this.imageFileName = imageFileName;
        this.card_type = card_type;
        this.card_name = card_name;
        this.card_set = card_set;
        this.power = power;
        this.toughness = toughness;
        this.card_cost = card_cost;
        this.artist = artist;
    }

    public int getCard_id() {
        return card_id;
    }

    public void setCard_id(int card_id) {
        this.card_id = card_id;
    }

    public Deck getAssignedDeck() {
        return assignedDeck;
    }

    public void setAssignedDeck(Deck assignedDeck) {
        this.assignedDeck = assignedDeck;
    }

    public String getImageFileName() {
        return imageFileName;
    }

    public void setImageFileName(String image) {
        this.imageFileName = image;
    }

    public String getCard_type() {
        return card_type;
    }

    public void setCard_type(String card_type) {
        this.card_type = card_type;
    }

    public String getCard_name() {
        return card_name;
    }

    public void setCard_name(String card_name) {
        this.card_name = card_name;
    }

    public String getCard_set() {
        return card_set;
    }

    public void setCard_set(String card_set) {
        this.card_set = card_set;
    }

    public int getPower() {
        return power;
    }

    public void setPower(int power) {
        this.power = power;
    }

    public int getToughness() {
        return toughness;
    }

    public void setToughness(int toughness) {
        this.toughness = toughness;
    }

    public String getCard_cost() {
        return card_cost;
    }

    public void setCard_cost(String card_cost) {
        this.card_cost = card_cost;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    @Override
    public String toString() {
        return "Card{" +
                "card_id=" + card_id +
                ", assignedDeck=" + assignedDeck +
                ", image='" + imageFileName + '\'' +
                ", card_type='" + card_type + '\'' +
                ", card_name='" + card_name + '\'' +
                ", card_set='" + card_set + '\'' +
                ", power=" + power +
                ", toughness=" + toughness +
                ", card_cost='" + card_cost + '\'' +
                ", artist='" + artist + '\'' +
                '}';
    }
}

