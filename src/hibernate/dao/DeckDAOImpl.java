package hibernate.dao;

import hibernate.entity.Deck;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class DeckDAOImpl implements DeckDAO {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Deck> getDecks() {
        Session session = sessionFactory.getCurrentSession();

        List<Deck> list = session.createQuery("from Deck", Deck.class).getResultList();

        return list;
    }

    @Override
    public void saveDeck(Deck aDeck) {
        Session session = sessionFactory.getCurrentSession();

        session.saveOrUpdate(aDeck);
    }

    @Override
    public Deck getDeck(int theId) {
        Session session = sessionFactory.getCurrentSession();

        return session.get(Deck.class, theId);
    }

    @Override
    public void deleteDeck(int theId) {
        Session session = sessionFactory.getCurrentSession();

        Query query = session.createQuery("delete from Deck where deck_id = :realSadDeckId");

        query.setParameter("realSadDeckId", theId);

        query.executeUpdate();
    }

    @Override
    public List<Deck> getDeckByName(String theSearchTerm) {
        Session session = sessionFactory.getCurrentSession();

        Query<Deck> query = session.createQuery("from Deck where lower(deck_name) like :searchTerm ");

        theSearchTerm = "%" + theSearchTerm.toLowerCase() + "%";

        query.setParameter("searchTerm", theSearchTerm);

        return query.getResultList();
    }
}
