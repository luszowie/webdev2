package pl.wszib.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import pl.wszib.domain.Person;

import java.util.ArrayList;
import java.util.List;

@Controller
public class SimpleController {

    private List<Person> listPerson;

    public SimpleController() {
        listPerson = generalList();

    }

    @GetMapping("basic")
    public String basic(Model model){
        String firestName = "Jan";
        String lastName = "Kowalski";

        model.addAttribute("fName", firestName);
        model.addAttribute("lName", lastName);

        Person person = new Person();
        person.setFirstName("Jacek");
        person.setLastName("Nowak");
        person.setPhoneNumber("12121212");
        person.setSalary(1000);
        person.setVisible(true);

        model.addAttribute("person", person);



        return "basicTemplate";
    }

    @GetMapping("iteration")
    public String iteration(Model model) {
        /*List<Person> list = generalList();*/
        model.addAttribute("list", listPerson);
        return "iterationTemplate";
    }

    @GetMapping("links")
    public String links (Model model) {
        return "linksTemplate";
    }

    @GetMapping("inter")
    public String inter (Model model) {

        return "interTemplate";
    }

    @GetMapping("forms")
    public String forms (Model model){
        model.addAttribute("person", new Person());
        return"formsTemplate";
    }

    @PostMapping("formsSave")
    public String formsSave(Person person, Model model) {
        listPerson.add(person);

        return "successTemplate";
    }




    private List<Person> generalList() {
        List<Person> list = new ArrayList<>();

        Person person1 = new Person();
        person1.setFirstName("Wacek");
        person1.setLastName("Kowal");
        person1.setPhoneNumber("1111111");
        person1.setSalary(2000);
        person1.setVisible(true);
        list.add(person1);

        Person person2 = new Person();
        person2.setFirstName("Zdenek");
        person2.setLastName("Nowak");
        person2.setPhoneNumber("22222222");
        person2.setSalary(3000);
        person2.setVisible(false);
        list.add(person2);

        Person person3 = new Person();
        person3.setFirstName("Harry");
        person3.setLastName("Nowak");
        person3.setPhoneNumber("33333333");
        person3.setSalary(4000);
        person3.setVisible(true);
        list.add(person3);

        return list;
    }

    @GetMapping("fragments")
    public String fragments (Model model){
        return "fragments/fragmentsTemplate";
    }
    @GetMapping("fragmentsT")
    public String fragments2 (Model model){
        return "fragments/fragmentsTemplateT";
    }

}
