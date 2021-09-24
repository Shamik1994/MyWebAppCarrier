package com.shamik.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.shamik.demo.bean.Carrier;
import com.shamik.demo.bean.CarrierReq;
import com.shamik.demo.service.CarrierService;
import com.shamik.demo.service.EmailSenderService;

@org.springframework.web.bind.annotation.RestController
public class RestController {
	@Autowired
	private ObjectMapper objmapper;
	@Autowired
	CarrierService carrierService;
	@Autowired
	EmailSenderService service;
	
	@RequestMapping(value = "/getCarrier" ,method=RequestMethod.POST)
	public @ResponseBody String getCarrier(@RequestBody String reqJson) throws JsonMappingException, JsonProcessingException
	{
		String message=null;
		
		CarrierReq carrierJson=objmapper.readValue(reqJson, CarrierReq.class);
		
		if(carrierJson.getCarrierDetail()!=null)
		{
			Carrier c=carrierService.findByCarrierId(carrierJson.getCarrierDetail().getCarrierId());
			if(c!=null)
			{
				service.sendSimpleEmial(carrierJson.getCarrierDetail().getMailId(), "Order Supressed", "greeting");
				message="Order Supressed";
			}
			else
			{
				message="Carrier not found";
			}
			
		}
		else
		{
			message="Carrier not found";
		}
		return message;
	}

}
