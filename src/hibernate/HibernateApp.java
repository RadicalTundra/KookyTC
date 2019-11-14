package hibernate;

import hibernate.entity.Card;
import hibernate.entity.Deck;
import hibernate.entity.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class HibernateApp {
    private SessionFactory factory;

    public HibernateApp()
    {
        factory = new Configuration().configure("hibernate.cfg.xml")
                .addAnnotatedClass(Card.class)
                .addAnnotatedClass(Deck.class)
                .addAnnotatedClass(User.class)
                .buildSessionFactory();
    }


    public static void main(String[] args) {
        HibernateApp app = new HibernateApp();

        //**DISCLAIMER**
        // I did not make my database very flexible for this type of program so it
        //functions kinda poorly.
        //All the cards that are created with a deck are created and assigned to it.
        //This means if there's duplicated cards they'll still be placed in the database as long
        //as they're assigned to a deck.

        //**EXPLANATION FOR CASCADING AND FETCH TYPES.**
        //When a User is deleted the Cascade is set up where it will delete all the decks assigned
        // to that user.
        //The Cascading for decks and cards make it so that all the cards related to those decks are
        // deleted as well.
        // All Fetch types are lazy loading, as a lot of information is interconnected, especially with decks
        // If I load a deck or a user, I don't want all information of all the cards and all user information
        // to load in as well.

        try{
            //Create, the C of CRUD
            //app.createCard();
            //app.createDeck();
            //app.createUser();
            //Read, the R of CRUD
            //app.listAllCards();
            //app.listAllDecks();
            //app.listAllUsers();
            //Update, the U of CRUD
                //FROM HERE ON OUT YOU'LL NEED ID'S INSIDE THE PARENTHESIS. YOU SHOULD HAVE 1-3 AVAILABLE TO YOU
                //IN DECK AND USER AND THE ONES YOU CREATED FOR ALL 3 TABLES.
            //app.updateCard();
            //app.updateDeck();
            //app.updateUser();
            //Delete, the D of CRUD
            //app.deleteCard();
            //app.deleteDeck();
            //app.deleteUser();
        }finally {
            app.close();
        }
    }

    private void createCard() {
        Session session = factory.getCurrentSession();

        session.beginTransaction();
        Deck deck1 = session.get(Deck.class, 1);

        Card card = new Card("505932ef-3791-4253-8a2a-b6a02ef45ab4",
                deck1, 20);
        session.save(card);

        session.getTransaction().commit();
    }

    private void createDeck() {
        Session session = factory.getCurrentSession();

        session.beginTransaction();
        User user = session.get(User.class, 1);
        List<Card> cards = session.createQuery("from Card where card_id < 100").getResultList();

        Deck deck = new Deck(user, cards, "Da new deck!", 2, 4, 1, 0, 2, 6);
        session.save(deck);

        session.getTransaction().commit();
    }

    private void createUser() {
        Session session = factory.getCurrentSession();

        session.beginTransaction();

        User user = new User("New User Yay", "cool new guy", "S3cureP4ssw0rd");
        session.save(user);

        session.getTransaction().commit();
    }

    private void listAllCards() {
        Session session = factory.getCurrentSession();

        session.beginTransaction();

        List<Card> cards = session.createQuery("from Card").getResultList();

        if (cards.isEmpty()) {
            System.out.println("No Cards in list");
        } else {
            for (Card card : cards) {
                System.out.println(card);
            }
        }
        session.getTransaction().commit();
    }

    private void listAllDecks() {
        Session session = factory.getCurrentSession();

        session.beginTransaction();

        List<Deck> decks = session.createQuery("from Deck").getResultList();

        if (decks.isEmpty()) {
            System.out.println("No Decks in list");
        } else {
            for (Deck deck : decks) {
                System.out.println(deck);
            }
        }
        session.getTransaction().commit();
    }

    private void listAllUsers() {
        Session session = factory.getCurrentSession();

        session.beginTransaction();

        List<User> users = session.createQuery("from User").getResultList();

        if (users.isEmpty()) {
            System.out.println("No Users in list");
        } else {
            for (User user : users) {
                System.out.println(user);
            }
        }
        session.getTransaction().commit();
    }

    private void updateCard(int cardId) {
        Session session = factory.getCurrentSession();

        session.beginTransaction();

        Card aCard = session.get(Card.class, cardId);
        if (aCard != null) {
            //WOW! You're rich! You have so many of that card now!
            aCard.setNumOfCards(aCard.getNumOfCards() + 50);
        }
        else
        {
            System.out.println("Hey, give us a proper cardId and then see what happens!");
        }

        session.getTransaction().commit();
    }

    private void updateDeck(int deckId) {
        Session session = factory.getCurrentSession();

        session.beginTransaction();

        Deck aDeck = session.get(Deck.class, deckId);
        if (aDeck != null) {
            //WOW! Nice name!
            aDeck.setDeck_name(aDeck.getDeck_name() + ": Now Updated!");
        }
        else
        {
            System.out.println("Hey, give us a proper cardId and then see what happens!");
        }

        session.getTransaction().commit();
    }

    private void updateUser(int userId) {
        Session session = factory.getCurrentSession();

        session.beginTransaction();

        User aUser = session.get(User.class, userId);
        if (aUser != null) {
            //WOW! Nice name!
            aUser.setUsername(aUser.getUsername() + ": Now Updated!");
        }
        else
        {
            System.out.println("Hey, give us a proper cardId and then see what happens!");
        }

        session.getTransaction().commit();
    }

    private void deleteCard(int cardId) {
        Session session = factory.getCurrentSession();

        session.beginTransaction();

        Card card = session.get(Card.class, cardId);

        session.delete(card);

        session.getTransaction().commit();
    }

    private void deleteDeck(int deckId) {
        Session session = factory.getCurrentSession();

        session.beginTransaction();

        Deck deck = session.get(Deck.class, deckId);

        session.delete(deck);

        session.getTransaction().commit();
    }

    private void deleteUser(int userId) {
        Session session = factory.getCurrentSession();

        session.beginTransaction();

        User user = session.get(User.class, userId);

        session.delete(user);

        session.getTransaction().commit();
    }

    private void close() {
        factory.close();
    }
}
