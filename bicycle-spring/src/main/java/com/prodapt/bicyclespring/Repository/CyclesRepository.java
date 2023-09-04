package com.prodapt.bicyclespring.Repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.prodapt.bicyclespring.entity.Bicycle;

@Repository
public interface CyclesRepository extends CrudRepository<Bicycle, Integer>{

}
