package com.anchtun.config;

import java.util.List;
import java.util.Map;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

import lombok.Data;

/**
 * We inject this bean in ContactService class
 */

@Component
@Data
// used to mention the property file name if we are using something other than application.properties 
@PropertySource("classpath:pagination.properties")
// used to mention the prefix value that needs to be considered while loading the properties
@ConfigurationProperties(prefix = "anchtun.app")
// used if we want to perform validations on the properties based on the validation mentioned on the field
// mean validate if the values in the property file are ok mean between 2 and 4 in our case
@Validated
public class AnchtunProps {
	
	@Min(value = 2, message = "must be between 2 and 4")
	@Max(value = 4, message = "must be between 2 and 4")
	// check the property: anchtun.app.pageSize
	private int pageSize;
	// key,value: example: contact.pageSize=2: key = pageSize and the value = 2
	private Map<String, String> contact;
	private List<String> capitals;

}
