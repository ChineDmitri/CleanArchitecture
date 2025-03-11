package fr.esgi.controller;

import fr.esgi.avis.business.Editeur;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.servlet.ModelAndView;

import java.util.Arrays;
import java.util.Collections;

@Controller
@AllArgsConstructor
public class EditeurMvc {

    @GetMapping("/editeurs")
    public ModelAndView getEditeurs() {
        ModelAndView mav = new ModelAndView("editeurs");
        Editeur e = new Editeur(1L, "Editeur 1", null);
        mav.addObject("editeurs", Arrays.asList(e));

        return mav;
    }

    @GetMapping("editeur")
    public ModelAndView getEditeur(@ModelAttribute Editeur editeur) {
        ModelAndView mav = new ModelAndView("editeur");

        return mav;
    }

}
