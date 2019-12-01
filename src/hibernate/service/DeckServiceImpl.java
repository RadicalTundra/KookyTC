package hibernate.service;

import hibernate.dao.DeckDAO;
import hibernate.entity.Deck;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeckServiceImpl implements DeckService {


    @Autowired
    private DeckDAO deckDAO;

    @Override
    public List<Deck> getDecks() {
        return deckDAO.getDecks();
    }

    @Override
    public void saveDeck(Deck aDeck) {
        deckDAO.saveDeck(aDeck);
    }

    @Override
    public Deck getDeck(int theId) {
        return deckDAO.getDeck(theId);
    }

    @Override
    public void deleteDeck(int theId) {
        deckDAO.deleteDeck(theId);
    }

    @Override
    public List<Deck> getDeckByName(String theSearchTerm) {
        return deckDAO.getDeckByName(theSearchTerm);
    }
}
