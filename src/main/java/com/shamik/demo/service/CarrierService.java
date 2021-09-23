
  package com.shamik.demo.service;
  
  import org.springframework.beans.factory.annotation.Autowired; import
  org.springframework.stereotype.Service;
  
  import com.shamik.demo.bean.Carrier; import
  com.shamik.demo.repository.CarrierRepo;
  
  @Service public class CarrierService {
  
  @Autowired 
  CarrierRepo carrierRepo;
  
  public Carrier findByCarrierId(int id) 
  { 
	  Carrier c=carrierRepo.getCarrierbyId(id); 
	  return c; 
  }
  
  }
 