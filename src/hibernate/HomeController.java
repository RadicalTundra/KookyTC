package hibernate;

import hibernate.entity.Deck;
import hibernate.service.DeckService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

    @Autowired
    private DeckService deckService;

    @RequestMapping("/")
    public String showHomePage(){
        return "index";
    }
    @RequestMapping("/DeckList")
    public String showDeckList(){
        return "DeckList";
    }

    @PostMapping("/saveDeck")
    public String saveDeck(@ModelAttribute(name = "aDeck") Deck theDeck,
                           Model theModel)
    {
        deckService.saveDeck(theDeck);

        return "index";
    }

}
