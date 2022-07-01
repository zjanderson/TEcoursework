package com.techelevator.auctions.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NO_CONTENT, reason = "No content")
public class AuctionNoContentException extends Exception{
//    private static final long

    public AuctionNoContentException(){
        super("No content");
    }
}
