package hibernate.service;

import hibernate.entity.Card;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface CardService {
    List<Card> getCards();

    void saveCard(Card aCard, MultipartFile file, String applicationPath);

    Card getCard(int theId);

    void deleteCard(int theId);

    List<Card> getCardByName(String theSearchTerm);
}
