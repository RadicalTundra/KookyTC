package hibernate.dao;

import hibernate.entity.Card;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CardDAOImpl implements CardDAO {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Card> getCards() {
        Session session = sessionFactory.getCurrentSession();

        List<Card> list = session.createQuery("from Card", Card.class).getResultList();

        return list;
    }

    @Override
    public void saveCard(Card aCard) {
        Session session = sessionFactory.getCurrentSession();

        session.saveOrUpdate(aCard);
    }

    @Override
    public Card getCard(int theId) {
        Session session = sessionFactory.getCurrentSession();

        return session.get(Card.class, theId);
    }

    @Override
    public void deleteCard(int theId) {
        Session session = sessionFactory.getCurrentSession();

        Query query = session.createQuery("delete from Card where card_id = :realSadDeckId");

        query.setParameter("realSadDeckId", theId);

        query.executeUpdate();
    }

    @Override
    public List<Card> getCardByName(String theSearchTerm) {
        Session session = sessionFactory.getCurrentSession();

        Query<Card> query = session.createQuery("from Card where lower(card_name) like :searchTerm ");

        theSearchTerm = "%" + theSearchTerm.toLowerCase() + "%";

        query.setParameter("searchTerm", theSearchTerm);

        return query.getResultList();
    }
}
