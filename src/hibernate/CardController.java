package hibernate;

import hibernate.entity.Card;
import hibernate.service.CardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/card")
public class CardController {

    @Autowired
    private CardService cardService;

    @GetMapping("/delete")
    public String deleteDonut(@RequestParam("card_id") int theId) {
        // Delete the donut
        cardService.deleteCard(theId);

        return "redirect:/card/List";
    }


    @RequestMapping("/List")
    public String showCardList(Model theModel){

        List<Card> cardList = cardService.getCards();

        theModel.addAttribute("cards", cardList);

        return "CardList";
    }

    @RequestMapping("/showAddCardForm")
    public String showAddDonutForm(Model theModel) {
        Card theCard = new Card();

        theModel.addAttribute("card", theCard);

        return "card-form";
    }

    @RequestMapping("/showUpdateCardForm")
    public String showUpdateDonutForm(@RequestParam("card_id") int theId,
                                      Model theModel) {

        Card theCard = cardService.getCard(theId);

        theModel.addAttribute("card", theCard);

        return "card-form";
    }

    @PostMapping("/save")
    public String saveCard(@RequestParam("image") MultipartFile file,
                           @Valid @ModelAttribute("card") Card theCard,
                           BindingResult bindingResult,
                           HttpServletRequest request,
                           Model theModel){

        if (bindingResult.hasErrors()) {

            System.out.println(bindingResult);


            return "card-form";
        }

        if(theCard.getArtist() == null)
        {
            theCard.setArtist("some person");
        }

        if(theCard.getCard_cost() == null)
        {
            theCard.setCard_cost("some amount");
        }

        String applicationPath = request.getServletContext().getRealPath("/");


        cardService.saveCard(theCard, file, applicationPath);


        return "redirect:/card/List";
    }

    @GetMapping("/search")
    public String search(@RequestParam("searchTerm") String theSearchTerm, Model theModel) {

        List<Card> matchingCards;
        if(theSearchTerm != null) {
            matchingCards = cardService.getCardByName(theSearchTerm);
        }
        else{
            matchingCards = cardService.getCards();
        }
        theModel.addAttribute("cards", matchingCards);

        return "CardList";
    }

    @InitBinder
    public void initBinder(WebDataBinder dataBinder) {
        StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
        dataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
    }

    @ExceptionHandler
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public void handle(Exception e) {
        e.printStackTrace();
    }
}
