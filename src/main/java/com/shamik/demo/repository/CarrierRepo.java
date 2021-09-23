package com.shamik.demo.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.shamik.demo.bean.Carrier;

public interface CarrierRepo extends CrudRepository<Carrier, Integer> {
	
	@Query(value="select * from Carrier c where c.carrier_id= :carrierId", nativeQuery=true)
    Carrier getCarrierbyId(int carrierId);

}
