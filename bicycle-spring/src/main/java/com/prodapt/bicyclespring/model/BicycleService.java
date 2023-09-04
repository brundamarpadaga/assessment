package com.prodapt.bicyclespring.model;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.prodapt.bicyclespring.entity.Bicycle;

public class BicycleService {

	private List<Bicycle> bicycles;
	private int idCounter;
	
	 public BicycleService() {
		    if (bicycles == null)
		    	bicycles = new ArrayList<>();
		  }
	public void addBicycle(Bicycle bicycle) {
		idCounter++;
		bicycles.add(bicycle);
		
	}
	
	 


	
	
	
}
