package de.klettermaterial.seil.controller;

import de.klettermaterial.seil.services.IndexService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {

    @Autowired
    private IndexService indexService;

    @Autowired
    private SeilController seilController;

    @GetMapping("/")
    public String index(Model model) {
        return indexService.index(model);
    }
}
