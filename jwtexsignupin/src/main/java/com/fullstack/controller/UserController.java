package com.fullstack.controller;

import com.fullstack.entity.User;
import com.fullstack.model.AuthRequest;
import com.fullstack.service.UserService;
import com.fullstack.util.JWTUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    private final JWTUtil jwtUtil;

    private final AuthenticationManager authenticationManager;

    @PostMapping("/signup")
    public ResponseEntity<User> signUp(@RequestBody User user){
        return new ResponseEntity<>(userService.signUp(user), HttpStatus.CREATED);
    }

    @PostMapping("/signin")
    public ResponseEntity<String> generateToken(@RequestBody AuthRequest authRequest){

         authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authRequest.getUserName(), authRequest.getUserPassword()));

         return new ResponseEntity<>(jwtUtil.generateToken(authRequest.getUserName()), HttpStatus.OK);
    }
}
