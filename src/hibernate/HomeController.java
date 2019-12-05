package hibernate;

import hibernate.entity.Deck;
import hibernate.service.DeckService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

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

    @RequestMapping(path = "/errors")
    public String showErrorPage(HttpServletRequest request, Model theModel) {
        int httpErrorCode = (Integer) request.getAttribute("javax.servlet.error.status_code");
        String errorMsg;

        switch (httpErrorCode) {
            case 400:
                errorMsg = "Http Error Code 400: Bad request";
                break;
            case 401:
                errorMsg = "Http Error Code 401: Unauthorized";
                break;
            case 404:
                errorMsg = "Http Error Code 404: Resource not found";
                break;
            case 500:
                errorMsg = "Http Error Code 500: Internal server error";
                break;
            default:
                errorMsg = "Http Error Code " + httpErrorCode;
        }

        theModel.addAttribute("errorMessage", errorMsg);

        return "handleErrors";
    }

}
