package com.prodapt.bicyclespring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.prodapt.bicyclespring.entity.Bicycle;
import com.prodapt.bicyclespring.model.BicycleService;
import com.prodapt.bicyclespring.Repository.CyclesRepository;
@Controller
@RequestMapping("/bicycles")
public class BicycleController {

    @Autowired
    private CyclesRepository bicycleRepository;

    @GetMapping
    public String listBicycles(Model model) {
        List<Bicycle> bicycles = (List<Bicycle>)bicycleRepository.findAll();
        model.addAttribute("bicycles", bicycles);
        model.addAttribute("bicycle", new Bicycle());
        
        return "bicycle"; // Thymeleaf template for listing bicycles
    }
    
    @PostMapping("/borrow")
    public String borrow(@RequestParam int id) {
    	
    	Bicycle bicycle = bicycleRepository.findById(id).orElse(null);
    	if (bicycle != null && bicycle.getStock() > 0) {
            // Decrease the stock by 1
            bicycle.setStock(bicycle.getStock() - 1);
            bicycleRepository.save(bicycle);
        }

        return "redirect:/bicycles";
    	
    }

    @GetMapping("/add")
    public String showAddBicycleForm(Model model ) {
        model.addAttribute("bicycle", new Bicycle());
        return "redirect:/bicycles"; // Thymeleaf template for adding bicycles
    }

    @PostMapping("/add")
    public String addBicycle(@ModelAttribute Bicycle bicycle,BindingResult bindingResult) {
    	if(bindingResult.hasErrors()) {
    		
    	}
    	else
    		bicycleRepository.save(bicycle);
        return "redirect:/bicycles";
    }
    @PostMapping("/restock")
    public String restockBicycle(
            @RequestParam Integer id,
            @RequestParam Integer quantity
    ) {
        // Retrieve the bicycle by its ID
        Bicycle bicycle = bicycleRepository.findById(id).orElse(null);

        if (bicycle != null) {
            // Increase the stock by the specified quantity
            bicycle.setStock(bicycle.getStock() + quantity);
            bicycleRepository.save(bicycle);
        }

        return "redirect:/bicycles";
    }
}
