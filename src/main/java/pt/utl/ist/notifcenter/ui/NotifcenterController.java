package pt.utl.ist.notifcenter.ui;

import org.fenixedu.bennu.spring.portal.SpringApplication;
import org.fenixedu.bennu.spring.portal.SpringFunctionality;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pt.utl.ist.notifcenter.utils.NotifcenterException;

@RequestMapping("/notifcenter")
@SpringApplication(group = "anyone", path = "notifcenter", title = "title.Notifcenter")
@SpringFunctionality(app = NotifcenterController.class, title = "title.Notifcenter")
public class NotifcenterController {

    @RequestMapping
    public String home(Model model) {
        model.addAttribute("world", "World");
        return "notifcenter/home";
    }

    @ExceptionHandler({NotifcenterException.class})
    public ResponseEntity<String> errorHandlerHTML(NotifcenterException ex) {

        HttpHeaders header = new HttpHeaders();

        if (ex.getMoreDetails() != null) {
            return new ResponseEntity<>(ex.getErrorsAndWarnings().toHTMLWithDetails(ex.getMoreDetails()), header, ex.getErrorsAndWarnings().getHttpStatus());
        }
        else {
            return new ResponseEntity<>(ex.getErrorsAndWarnings().toHTML(), header, ex.getErrorsAndWarnings().getHttpStatus());
        }
    }

}
