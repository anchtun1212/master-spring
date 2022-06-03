package com.anchtun.audit;

import java.util.HashMap;
import java.util.Map;

import org.springframework.boot.actuate.info.Info.Builder;
import org.springframework.boot.actuate.info.InfoContributor;
import org.springframework.stereotype.Component;

@Component
public class AnchtunInfoContributor implements InfoContributor {

	// we can see those info in: http://localhost:8080/anchtun/actuator/info
	@Override
	public void contribute(Builder builder) {
		Map<String, String> map = new HashMap<>();
		map.put("App name", "Anchtun web application");
		map.put("App version", "v1.0");
		builder.withDetail("Anchtun app", map);
	}

}
