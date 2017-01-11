package com.hsbc.common.beans;

import java.io.IOException;

import javax.annotation.PostConstruct;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.PatternLayout;
import org.apache.log4j.RollingFileAppender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Import;
import org.springframework.stereotype.Component;

@Component
@Import({ Environment.class,ServletFilterConfiguration.class })
public class Initialize {
	@Autowired
	private Environment prop;	

	@PostConstruct
	public void addlogAppenderToRoot() throws IOException {
		Logger logger = Logger.getRootLogger();
		System.out.println("inside       ----------" + logger.getRootLogger().getName());
		logger.addAppender(new RollingFileAppender(new PatternLayout(), "D:/loggs"));
		logger.setLevel(Level.INFO);

	}
}
