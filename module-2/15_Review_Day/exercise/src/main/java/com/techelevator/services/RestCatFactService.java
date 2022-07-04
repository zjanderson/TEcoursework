package com.techelevator.services;

import com.techelevator.model.CatCardNotFoundException;
import org.springframework.stereotype.Component;

import com.techelevator.model.CatFact;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.RestClientResponseException;
import org.springframework.web.client.RestTemplate;

@Component
public class RestCatFactService implements CatFactService { //need to work in here, too

	private static final String API_BASE_URL = "https://cat-data.netlify.app/api";
	private final RestTemplate restTemplate = new RestTemplate();

	@Override
	public CatFact getFact() {
		CatFact aCatFact = null;
		try {
			aCatFact = restTemplate.getForObject(API_BASE_URL + "/facts/random", CatFact.class);
		} catch (RestClientResponseException | ResourceAccessException e) {
			System.out.println("Not found");
		}
		return aCatFact;
	}

}
