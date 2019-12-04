package hibernate;

import hibernate.entity.Card;
import hibernate.service.CardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

@Controller
@RequestMapping("/card")
public class CardController {

    @Autowired
    private CardService cardService;

    @RequestMapping("/List")
    public String showCardList(){
        return "CardList";
    }

    @RequestMapping("/showAddCardForm")
    public String showAddDonutForm(Model theModel) {
        Card theCard = new Card();

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
            // Display the errors in the console
            System.out.println(bindingResult);

            // Send back to form with error messages
            return "card-form";
        }

        // Find the complete path of the application
        String applicationPath = request.getServletContext().getRealPath("/");

        // Use the service to save the donut
        cardService.saveCard(theCard, file, applicationPath);

        // Redirect back to the donut list
        return "redirect:/card/List";
    }
}
