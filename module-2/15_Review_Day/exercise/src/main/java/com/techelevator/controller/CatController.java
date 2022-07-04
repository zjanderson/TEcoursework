package com.techelevator.controller;

import com.techelevator.dao.CatCardDao;
import com.techelevator.services.CatFactService;
import com.techelevator.services.CatPicService;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CatController {  //we work in here, partially
                              //Hint: Start w/the controller method that provides a new, randomly created card.

    private CatCardDao catCardDao;
    private CatFactService catFactService;
    private CatPicService catPicService;

    public CatController(CatCardDao catCardDao, CatFactService catFactService, CatPicService catPicService) {
        this.catCardDao = catCardDao;
        this.catFactService = catFactService;
        this.catPicService = catPicService;
    }

//    Create a new, randomly created card here



}
