package com.ufbatickets.project.utils;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class EndpointUtils {

    public ResponseEntity<?> returnObjectOrNotFound (Object object) {
        return object == null ? new ResponseEntity<>(HttpStatus.NOT_FOUND) : new ResponseEntity<>(object, HttpStatus.ACCEPTED);
    }
}
