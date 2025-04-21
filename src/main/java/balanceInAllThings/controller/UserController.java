package balanceInAllThings.controller;


import balanceInAllThings.model.User;
import balanceInAllThings.service.ServiceBase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping("/users")
public class UserController  {

    @Autowired
    private final ServiceBase serviceBase;

    public UserController(ServiceBase serviceBase) {
        this.serviceBase = serviceBase;
    }


    @GetMapping()
    public String index(Model model) {
        model.addAttribute("users", serviceBase.index());
        return "users/index";   //index view
    }

    @GetMapping("/new")
    public String newUser(@ModelAttribute("user") User user) {
        return "users/user_form"; // new view
    }

    @PostMapping()
    public String save(@ModelAttribute("user") User user) {
        serviceBase.save(user);
        return "redirect:/users";
    }

    @GetMapping("/edit")
    public String edit(@RequestParam("id") Long id, Model model) {
        model.addAttribute("user", serviceBase.show(id));
        return "users/edit";  //edit view
    }
    @PostMapping("/update")
    public String update(@RequestParam("id") Long id, @ModelAttribute("user") User user) {
        serviceBase.update(id, user);
        return "redirect:/users"; //функционал изменения, сначала правим в модель выше, затем обновляем объект.
    }

    @GetMapping("/delete")
    public String delete(@RequestParam("id") Long id) {
        serviceBase.delete(id);
        return "redirect:/users";
    }


}
