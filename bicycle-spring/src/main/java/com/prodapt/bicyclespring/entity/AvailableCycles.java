package com.prodapt.bicyclespring.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

public class AvailableCycles {
	
	@ManyToOne(cascade = CascadeType.ALL)
	  @JoinColumn(name = "cycle_id", referencedColumnName = "id")
	  private Bicycle bicycle;

}
