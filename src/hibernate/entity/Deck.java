package hibernate.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "deck")
public class Deck {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "deck_id")
    private int deck_id;
    //the default fetch type lazy loading is fine for this mapping
    @ManyToOne(cascade = {CascadeType.DETACH,
            CascadeType.MERGE,
            CascadeType.PERSIST,
            CascadeType.REFRESH})
    @JoinTable(name="users_decks",
            joinColumns = @JoinColumn(name="deck_id"),
            inverseJoinColumns = @JoinColumn(name="users_id"))
    private User assignedUser;
    //the default fetch type lazy loading is fine for this mapping
    @OneToMany(cascade = CascadeType.ALL)
    @JoinTable(name="deck_cards",
            joinColumns = @JoinColumn(name="deck_id"),
            inverseJoinColumns = @JoinColumn(name="card_id"))
    private List<Card> cards;
    @Column(name = "deck_name")
    private String deck_name;
    @Column(name = "spell_count")
    private int spell_count;
    @Column(name = "creature_count")
    private int creature_count;
    @Column(name = "planeswalker_count")
    private int planeswalker_count;
    @Column(name = "artifact_count")
    private int artifact_count;
    @Column(name = "enchantment_count")
    private int enchantment_count;
    @Column(name = "land_count")
    private int land_count;

    public Deck() {
    }

    public Deck(User assignedUser, List<Card> cards, String deck_name, int spell_count, int creature_count, int planeswalker_count, int artifact_count, int enchantment_count, int land_count) {
        this.assignedUser = assignedUser;
        this.cards = cards;
        this.deck_name = deck_name;
        this.spell_count = spell_count;
        this.creature_count = creature_count;
        this.planeswalker_count = planeswalker_count;
        this.artifact_count = artifact_count;
        this.enchantment_count = enchantment_count;
        this.land_count = land_count;
    }

    public User getUser() {
        return assignedUser;
    }

    public void setUser(User user) {
        this.assignedUser = user;
    }

    public List<Card> getCards() {
        return cards;
    }

    public void setCards(List<Card> cards) {
        this.cards = cards;
    }

    public int getDeck_id() {
        return deck_id;
    }

    public void setDeck_id(int deck_id) {
        this.deck_id = deck_id;
    }

    public String getDeck_name() {
        return deck_name;
    }

    public void setDeck_name(String deck_name) {
        this.deck_name = deck_name;
    }

    public int getSpell_count() {
        return spell_count;
    }

    public void setSpell_count(int spell_count) {
        this.spell_count = spell_count;
    }

    public int getCreature_count() {
        return creature_count;
    }

    public void setCreature_count(int creature_count) {
        this.creature_count = creature_count;
    }

    public int getPlaneswalker_count() {
        return planeswalker_count;
    }

    public void setPlaneswalker_count(int planeswalker_count) {
        this.planeswalker_count = planeswalker_count;
    }

    public int getArtifact_count() {
        return artifact_count;
    }

    public void setArtifact_count(int artifact_count) {
        this.artifact_count = artifact_count;
    }

    public int getEnchantment_count() {
        return enchantment_count;
    }

    public void setEnchantment_count(int enchantment_count) {
        this.enchantment_count = enchantment_count;
    }

    public int getLand_count() {
        return land_count;
    }

    public void setLand_count(int land_count) {
        this.land_count = land_count;
    }

    @Override
    public String toString() {
        return "Deck{" +
                "deck_id=" + deck_id +
                ", assignedUser=" + assignedUser.getUsername() +
                ", NumOfCards=" + cards.size() +
                ", deck_name='" + deck_name + '\'' +
                ", spell_count=" + spell_count +
                ", creature_count=" + creature_count +
                ", planeswalker_count=" + planeswalker_count +
                ", artifact_count=" + artifact_count +
                ", enchantment_count=" + enchantment_count +
                ", land_count=" + land_count +
                '}';
    }
}
