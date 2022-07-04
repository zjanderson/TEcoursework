package com.techelevator.services;

import com.techelevator.model.CatFact;
import org.springframework.stereotype.Component;

import com.techelevator.model.CatPic;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.RestClientResponseException;
import org.springframework.web.client.RestTemplate;

@Component
public class RestCatPicService implements CatPicService { //need to work in here too

	private static final String API_BASE_URL = "https://cat-data.netlify.app/api";
	private final RestTemplate restTemplate = new RestTemplate();

	@Override
	public CatPic getPic() {
		CatPic aCatPic = null;
		try {
			aCatPic = restTemplate.getForObject(API_BASE_URL + "/pictures/random", CatPic.class);
		} catch (RestClientResponseException | ResourceAccessException e) {
			System.out.println("Not found");
		}
		return aCatPic;
	}

}	
