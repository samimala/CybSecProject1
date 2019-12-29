package sec.project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import sec.project.domain.Account;
import sec.project.repository.AccountRepository;
import org.springframework.ui.Model;

@Controller
public class AccountController {

    @Autowired
    private AccountRepository accountRepository;

    @RequestMapping(value = "/admin", method = RequestMethod.GET)
    public String defaultMapping(Model model) {
        model.addAttribute("accounts", accountRepository.findAll());
        return "users";
    }

    @RequestMapping(value = "/newuser", method = RequestMethod.POST)
    public String submitForm(@RequestParam String username, @RequestParam String password, @RequestParam(defaultValue="false") boolean admin) {
        System.out.println("Adding user " + username + "," + password + "," + admin);
        accountRepository.save(new Account(username, password, admin));
        return "redirect:/admin";
    }

}
