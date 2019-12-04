package hibernate.service;

import hibernate.dao.CardDAO;
import hibernate.entity.Card;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Service
public class CardServiceImpl implements CardService {

    @Autowired
    private CardDAO cardDAO;

    @Autowired
    private ImageFileService imageFileService;

    @Override
    @Transactional
    public List<Card> getCards() {
        return cardDAO.getCards();
    }

    @Override
    @Transactional
    public void saveCard(Card aCard, MultipartFile file, String applicationPath) {

        String fileName = imageFileService.saveFile(file, applicationPath);
        if (fileName != null) {
            aCard.setImage(fileName);
        }


        cardDAO.saveCard(aCard);
    }

    @Override
    @Transactional
    public Card getCard(int theId) {
        return cardDAO.getCard(theId);
    }

    @Override
    @Transactional
    public void deleteCard(int theId) {
        cardDAO.deleteCard(theId);
    }

    @Override
    @Transactional
    public List<Card> getCardByName(String theSearchTerm) {
        return cardDAO.getCardByName(theSearchTerm);
    }
}
