package springxml.beans;

import springxml.services.ModifyObjectService;

public class Card {
    private Deck assignedDeck;
    private int card_id;
    private String api_id;
    private ModifyObjectService service;

    public Card() {
    }

    public Card(ModifyObjectService service) {
        this.service = service;
    }

    public String objectChange()
    {
        return service.modifyObject("Card");
    }

    public void objectError()
    {
        service.error("There was an error creating a Card object.");
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

    public void setService(ModifyObjectService service) {
        this.service = service;
    }
}
