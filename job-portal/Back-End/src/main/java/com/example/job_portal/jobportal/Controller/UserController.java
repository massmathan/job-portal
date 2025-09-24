package com.example.job_portal.jobportal.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.job_portal.jobportal.Service.UserService;
import com.example.job_portal.jobportal.module.User;


import com.example.job_portal.jobportal.Repository.UserRepository;
import com.example.job_portal.jobportal.module.UserRequest;


@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    private UserService userService;

    private UserRepository userRepository;

    public UserController(UserService userService) {
        this.userService = userService; 
    }

    @PostMapping("/")
    public ResponseEntity<String> createUser(@RequestBody User user) {
    String msg = userService.create(user);
    return ResponseEntity
        .status(HttpStatus.CREATED)
        .body(msg);
    }
}
    //    @PostMapping("/existsEmail")
    //    public ResponseEntity<?> checkUserDetails(@RequestBody UserRequest userRequest) {
    //         System.out.println("existsEmail: " + userRequest);
    //         boolean msg = (userRepository.existsByEmail(userRequest.getEmail()));
    //         return ResponseEntity.ok("msg");
    //     }








// package com.example.job_portal.jobportal.Controller;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.http.HttpStatus;
// import org.springframework.http.ResponseEntity;
// import org.springframework.security.authentication.AuthenticationManager;
// import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
// import org.springframework.security.core.Authentication;
// import org.springframework.security.core.userdetails.UsernameNotFoundException;
// import org.springframework.web.bind.annotation.*;

// import com.example.job_portal.jobportal.Service.JwtService;
// import com.example.job_portal.jobportal.Service.UserService;
// import com.example.job_portal.jobportal.module.AuthRequest;
// import com.example.job_portal.jobportal.module.User;


// import lombok.RequiredArgsConstructor;



// @CrossOrigin(origins = "http://localhost:3000")
// @RestController
// @RequestMapping("/api/auth")
// public class UserController {

//     private UserService userService;

//     private JwtService jwtService;

//     private AuthenticationManager authenticationManager;

//     @PostMapping("/")
//     public ResponseEntity<String> createUser(@RequestBody User user) {
//         String msg = userService.create(user);
//         return ResponseEntity.status(HttpStatus.CREATED).body(msg);
//     }

//     @GetMapping("/welcome")
//     public String welcome() {
//         return "Welcome this endpoint is not secure";
//     }

//     @PostMapping("/addNewUser")
//     public String addNewUser(@RequestBody User userInfo) {
//         return userService.create(userInfo);
//     }

//     @PostMapping("/generateToken")
//     public String authenticateAndGetToken(@RequestBody AuthRequest authRequest) {
//         Authentication authentication = authenticationManager.authenticate(
//                 new UsernamePasswordAuthenticationToken(authRequest.getUsername(), authRequest.getPassword())
//         );
//         if (authentication.isAuthenticated()) {
//             return jwtService.generateToken(authRequest.getUsername());
//         } else {
//             throw new UsernameNotFoundException("Invalid user request!");
//         }
//     }
// }
