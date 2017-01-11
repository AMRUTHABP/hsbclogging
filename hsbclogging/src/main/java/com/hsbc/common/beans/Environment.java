package com.hsbc.common.beans;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Environment {
	//Logging Framework Properties
	
		@Value("${hsbc.log.logPayload:true}")
		private boolean logPayload;
		
		@Value("${hsbc.config.fileName:properties.yml}")
		private String configFileName;

		public boolean isLogPayload() {
			return logPayload;
		}

		public String getConfigFileName() {
			return configFileName;
		}
		
		
		
}
