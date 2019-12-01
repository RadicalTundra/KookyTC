package hibernate.dao;

import hibernate.entity.Deck;

import java.util.List;

public interface DeckDAO {
    List<Deck> getDecks();

    void saveDeck(Deck aDeck);

    Deck getDeck(int theId);

    void deleteDeck(int theId);

    List<Deck> getDeckByName(String theSearchTerm);
}
