package com.logger.controller;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import hsbc.common.logger.CommonLogger;


@Component("loggercontroller")
@RestController
public class LoggerController {
	@RequestMapping(name="sample",method=RequestMethod.GET)
	public String sayHello() {
		CommonLogger.info(this, "Inside sayHello! info");
		CommonLogger.warn(this, "Inside sayHello! warni");
		CommonLogger.debug(this, "Inside sayHello! debug");
		CommonLogger.error(this, "Inside sayHello! error");

		String msg = null;
		if ("Temp".equalsIgnoreCase("Logger")) {
			//throw new ApplicationException("Invalid user name!");
		} else {
			msg = "Hello " + "Logger" + "!";
		}
		return msg;
	}
}
