package com.minagri.amis.controllers;

import com.minagri.amis.dto.OrganizationDTO;
import com.minagri.amis.dto.PersonDTO;
import com.minagri.amis.models.UserEntity;
import com.minagri.amis.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
public class UserEntityController {

    private final UserService userService;

    @Autowired
    public UserEntityController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register/person")
    public ResponseEntity<?> registerPerson(@RequestBody PersonDTO personDTO) {
        try {
            UserEntity registeredUser = userService.registerPerson(personDTO);
            return new ResponseEntity<>(registeredUser, HttpStatus.OK);
        } catch (IllegalArgumentException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/register/organization")
    public ResponseEntity<?> registerOrganization(@RequestBody OrganizationDTO organizationDTO) {
        try {
            UserEntity registeredUser = userService.registerOrganization(organizationDTO);
            return new ResponseEntity<>(registeredUser, HttpStatus.OK);
        } catch (IllegalArgumentException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
}
