package com.techelevator.controller;

import com.techelevator.dao.CatCardDao;
import com.techelevator.model.CatCard;
import com.techelevator.model.CatCardNotFoundException;
import com.techelevator.services.CatFactService;
import com.techelevator.services.CatPicService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

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



//    Provide a list of all Cat Cards in a users
    @RequestMapping(path = "/cards", method = RequestMethod.GET)
    public List<CatCard> list() {
        return catCardDao.list();
    }

//    Provide a cat card with a given ID
    @RequestMapping(path = "cards/{id}", method = RequestMethod.GET)
    public CatCard get(@PathVariable int id) throws CatCardNotFoundException {
        return catCardDao.get(id);
    }

//    save a card to user collection
    @ResponseStatus(HttpStatus.CREATED)
    @RequestMapping(path = "/cards", method = RequestMethod.POST)
    public void addCatCard(@Valid @RequestBody CatCard card) throws CatCardNotFoundException {
         catCardDao.save(card);
    }

//    update a card in user collection

    @RequestMapping(path = "cards/{id}", method = RequestMethod.PUT)
    public void updateCard(@PathVariable long cardId,
                           @Valid @RequestBody CatCard changedCard) throws CatCardNotFoundException {
        changedCard.setCatCardId(cardId);

        catCardDao.update(changedCard.getCatCardId(), changedCard);
    }

//      delete a card from user collection



}
