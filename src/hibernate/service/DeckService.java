package hibernate.service;

import hibernate.entity.Deck;

import java.util.List;

public interface DeckService {
    List<Deck> getDecks();

    void saveDeck(Deck aDeck);

    Deck getDeck(int theId);

    void deleteDeck(int theId);

    List<Deck> getDeckByName(String theSearchTerm);
}
