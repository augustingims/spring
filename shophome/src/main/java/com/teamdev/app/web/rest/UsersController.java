package com.teamdev.app.web.rest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.teamdev.app.domain.Roles;
import com.teamdev.app.domain.Users;
import com.teamdev.app.exception.AppException;
import com.teamdev.app.exception.ResourceNotFoundException;
import com.teamdev.app.repository.RolesRepository;
import com.teamdev.app.repository.UsersRepository;
import com.teamdev.app.security.AuthoritiesConstants;
import com.teamdev.app.security.CurrentUser;
import com.teamdev.app.security.UserPrincipal;
import com.teamdev.app.security.jwt.JwtAuthenticationResponse;
import com.teamdev.app.security.jwt.JwtTokenProvider;
import com.teamdev.app.services.dto.LoginDTO;
import com.teamdev.app.services.dto.UserDTO;
import com.teamdev.app.services.dto.UserIdentityAvailability;
import com.teamdev.app.services.dto.UserProfile;
import com.teamdev.app.services.dto.UserSummary;

import javax.validation.Valid;
import java.net.URI;
import java.util.Collections;


@Controller
public class UsersController {
	
	private static final Logger logger = LoggerFactory.getLogger(UsersController.class);
	
	@Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    UsersRepository userRepository;

    @Autowired
    RolesRepository roleRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    JwtTokenProvider tokenProvider;

    @PostMapping("/login")
    public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginDTO loginRequest) {

        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        loginRequest.getUsernameOrEmail(),
                        loginRequest.getPassword()
                )
        );

        SecurityContextHolder.getContext().setAuthentication(authentication);

        String jwt = tokenProvider.generateToken(authentication);
        return ResponseEntity.ok(new JwtAuthenticationResponse(jwt));
    }

    @PostMapping("/register")
    public String registerUser(@Valid UserDTO signUpRequest,BindingResult bindingResult, Model model) {

    	if(bindingResult.hasErrors()) {
    		return "views/register";
    	}else {
    		if(userRepository.existsByUsername(signUpRequest.getUsername())) {
            	model.addAttribute("msg", "Username is already taken!");
            	model.addAttribute("exist", true);
            	return "views/register";
            }else if(userRepository.existsByEmail(signUpRequest.getEmail())) {
                model.addAttribute("msg", "Email Address already in use!");
                model.addAttribute("exist", true);
                return "views/register";
            }else {
            	Users user = new Users();
                
                user.setUsername(signUpRequest.getUsername());
                user.setEmail(signUpRequest.getEmail());
                user.setFirstName(signUpRequest.getFirstName());
                user.setLastName(signUpRequest.getLastName());
                user.setPhone(signUpRequest.getPhone());
                user.setFullName(signUpRequest.getFirstName()+" "+signUpRequest.getLastName());
                user.setLogin(signUpRequest.getUsername());

                user.setPassword(passwordEncoder.encode(signUpRequest.getPassword()));

                Roles userRole = roleRepository.findByName(AuthoritiesConstants.USER)
                        .orElseThrow(() -> new AppException("User Role not set."));

                user.setRoles(Collections.singleton(userRole));

                Users result = userRepository.save(user);

                URI location = ServletUriComponentsBuilder
                        .fromCurrentContextPath().path("/user/{username}")
                        .buildAndExpand(result.getUsername()).toUri();
                
                model.addAttribute("location", location);
                model.addAttribute("success", "User registered successfully !! please sign to continue");
            }
    	}
    	
    	return "views/success";
    }
    
    @GetMapping("/user/me")
    @PreAuthorize("hasRole('USER')")
    public UserSummary getCurrentUser(@CurrentUser UserPrincipal currentUser) {
        UserSummary userSummary = new UserSummary(currentUser.getId(), currentUser.getUsername(), currentUser.getFullName());
        return userSummary;
    }

    @GetMapping("/user/checkUsernameAvailability")
    public UserIdentityAvailability checkUsernameAvailability(@RequestParam(value = "username") String username) {
        Boolean isAvailable = !userRepository.existsByUsername(username);
        return new UserIdentityAvailability(isAvailable);
    }

    @GetMapping("/user/checkEmailAvailability")
    public UserIdentityAvailability checkEmailAvailability(@RequestParam(value = "email") String email) {
        Boolean isAvailable = !userRepository.existsByEmail(email);
        return new UserIdentityAvailability(isAvailable);
    }

    @GetMapping("/user/{username}")
    public UserProfile getUserProfile(@PathVariable(value = "username") String username) {
        Users user = userRepository.findByUsername(username)
                .orElseThrow(() -> new ResourceNotFoundException("Users", "username", username));


        UserProfile userProfile = new UserProfile(user.getId(), user.getUsername(), user.getFullName());

        return userProfile;
    }


}
