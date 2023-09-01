package com.portal.exercise;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {
	
	Logger log = LoggerFactory.getLogger(Controller.class);
	
	@GetMapping("/test")
	public String hello()
	{
		log.trace("A Trace Message");//more detailed info about the flow of the system
		log.debug("A Debbug Message");//line by line execution
		log.info("A Info Message");//event occuring at the run time
		log.warn("A warning Message");//warning for the error caused due to the usage of deprecated API
		log.error("A Error Message");
		return "Hello Rathi";
	}

}
