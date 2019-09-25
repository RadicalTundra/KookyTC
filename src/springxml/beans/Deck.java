package springxml.beans;

import springxml.services.ModifyObjectService;

import java.util.ArrayList;

public class Deck {
    private User assignedUser;
    private ArrayList<Card> cards = new ArrayList();
    private int deck_id;
    private String deck_name;
    private int spell_count;
    private int creature_count;
    private int planeswalker_count;
    private int artifact_count;
    private int enchantment_count;
    private int land_count;
    private ModifyObjectService service;

    public Deck() {
    }

    public Deck(ModifyObjectService service) {
        this.service = service;
    }

    public String objectChange()
    {
        return service.modifyObject("Deck");
    }

    public void objectError()
    {
        service.error("There was an error creating a Deck object.");
    }

    public User getUser() {
        return assignedUser;
    }

    public void setUser(User user) {
        this.assignedUser = user;
    }

    public ArrayList<Card> getCards() {
        return cards;
    }

    public void setCards(ArrayList<Card> cards) {
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

    public void setService(ModifyObjectService service) {
        this.service = service;
    }
}
