package com.shamik.demo.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.shamik.demo.bean.Carrier;
import com.shamik.demo.repository.CarrierRepo;
/*import com.shamik.demo.service.CarrierService;*/
import com.shamik.demo.service.EmailSenderService;


@Controller
public class HomeController {
	
	/*
	 * @Autowired CarrierService carrierService;
	 */
	@Autowired
	CarrierRepo carrierRepo;
	@Autowired
	EmailSenderService service;
	
	@RequestMapping("home")
	public String home()
	{	
		return "home";
	}
	@RequestMapping("/searchCarrier")
	public String searchCarrier()
	{
		return "searchCarrier";
	}
	@RequestMapping("/serach")
	public ModelAndView searchById(@RequestParam ("carrierId") int cid)
	{
		ModelAndView md=new ModelAndView();
		System.out.println(cid);
		 Carrier c= carrierRepo.getCarrierbyId(cid); 
		//Carrier c=carrierRepo.findById(cid).orElse(null);
		System.out.println(c);
		if (c!=null)
		{
			service.sendSimpleEmial("shamiksarkar2012@gmail.com", "This is body..", "greeting");
			md.addObject("obj", c);
			md.setViewName("findCarrier");
			
		}
		else
			md.setViewName("notfound");
		return md;
	}
		

}
