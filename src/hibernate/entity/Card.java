package hibernate.entity;

import javax.persistence.*;

@Entity
@Table(name = "cards")
public class Card {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "card_id")
    private int card_id;
    @Column(name = "api_id")
    private String api_id;
    //the default fetch type lazy loading is fine for this mapping
    @ManyToOne(cascade = {CascadeType.DETACH,
            CascadeType.MERGE,
            CascadeType.PERSIST,
            CascadeType.REFRESH})
    @JoinTable(name="deck_cards",
            joinColumns = @JoinColumn(name="card_id"),
            inverseJoinColumns = @JoinColumn(name="deck_id"))
    private Deck assignedDeck;

    @Column(name = "num_of_cards")
    private int numOfCards;

    public Card() {
    }

    public Card(String api_id, Deck assignedDeck, int numOfCards) {
        this.api_id = api_id;
        this.assignedDeck = assignedDeck;
        this.numOfCards = numOfCards;
    }

    public Deck getAssignedDeck() {
        return assignedDeck;
    }

    public void setAssignedDeck(Deck assignedDeck) {
        this.assignedDeck = assignedDeck;
    }

    public int getCard_id() {
        return card_id;
    }

    public void setCard_id(int card_id) {
        this.card_id = card_id;
    }

    public String getApi_id() {
        return api_id;
    }

    public void setApi_id(String api_id) {
        this.api_id = api_id;
    }

    public int getNumOfCards() {
        return numOfCards;
    }

    public void setNumOfCards(int numOfCards) {
        this.numOfCards = numOfCards;
    }

    @Override
    public String toString() {
        return "Card{" +
                "card_id=" + card_id +
                ", api_id='" + api_id + '\'' +
                ", numOfCards=" + numOfCards +
                ", assignedDeck=" + assignedDeck.getDeck_name() +
                '}';
    }
}

