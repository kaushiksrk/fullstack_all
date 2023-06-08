package com.cgi.controller;

import java.time.LocalDate;
import java.util.Collections;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cgi.dto.ErrorTO;
import com.cgi.dto.LoginDto;
import com.cgi.dto.SignUpDto;
import com.cgi.exceptions.MovieException;
import com.cgi.model.Role;
import com.cgi.model.User;
import com.cgi.repository.RoleRepository;
import com.cgi.repository.UserRepository;

@RestController
@RequestMapping("/auth")
public class LoginController {
	
	@Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;
    
    @ExceptionHandler(value = Exception.class)
	public ResponseEntity<ErrorTO> handleException(Exception e) {
		ErrorTO errorTO=new ErrorTO(HttpStatus.BAD_REQUEST.value(), e.getMessage(), System.currentTimeMillis(), LocalDate.now());
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorTO);
	}
    
    @PostMapping("/signup")
    public ResponseEntity<?> registerUser(@RequestBody SignUpDto signUpDto, @RequestParam("roleName") String roleName){

        // add check for username exists in a DB
        if(userRepository.existsByUsername(signUpDto.getUsername())){
            return new ResponseEntity<>("Username already exists!", HttpStatus.BAD_REQUEST);
        }

        // add check for email exists in DB
        if(userRepository.existsByEmail(signUpDto.getEmail())){
            return new ResponseEntity<>("Email already exists!", HttpStatus.BAD_REQUEST);
        }

        // create user object
        User user = new User();
        user.setName(signUpDto.getName());
        user.setUsername(signUpDto.getUsername());
        user.setEmail(signUpDto.getEmail());
        user.setPassword(passwordEncoder.encode(signUpDto.getPassword()));

        Optional<Role> optRole =  Optional.ofNullable(roleRepository.findByName(roleName).orElseThrow(() -> new MovieException("Role Not Configured.")));
        
        Role roles = optRole.get();
        user.setRoles(Collections.singleton(roles));

        userRepository.save(user);

        return new ResponseEntity<>("User registered successfully", HttpStatus.OK);
    }
    
    @PostMapping("/signin")
    public ResponseEntity<String> authenticateUser(@RequestBody LoginDto loginDto){
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                loginDto.getUsernameOrEmail(), loginDto.getPassword()));

        SecurityContextHolder.getContext().setAuthentication(authentication);
        return new ResponseEntity<>("User logged in successfully!.", HttpStatus.OK);
    }
}
