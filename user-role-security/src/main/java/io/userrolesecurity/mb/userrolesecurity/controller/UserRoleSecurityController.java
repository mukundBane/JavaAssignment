package io.userrolesecurity.mb.userrolesecurity.controller;

import io.userrolesecurity.mb.userrolesecurity.entity.RoleEntity;
import io.userrolesecurity.mb.userrolesecurity.entity.UserEntity;
import io.userrolesecurity.mb.userrolesecurity.model.AuthenticationRequest;
import io.userrolesecurity.mb.userrolesecurity.model.AuthenticationResponse;
import io.userrolesecurity.mb.userrolesecurity.service.RoleService;
import io.userrolesecurity.mb.userrolesecurity.service.UserService;
import io.userrolesecurity.mb.userrolesecurity.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/urs")
public class UserRoleSecurityController {

      @Autowired
      private UserService userService;

    @Autowired
    private RoleService roleService;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserDetailsService userDetailsService;

    @Autowired
    private JwtUtil jwtUtil;

    @PostMapping("/authenticate")
    public ResponseEntity<?> createAuthenticationToken(@RequestBody AuthenticationRequest authenticationRequest) throws Exception {
        try{
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken
                    (authenticationRequest.getUsername(), authenticationRequest.getPassword()));
        }catch(BadCredentialsException e){
            throw new Exception("Incorrect username or password ",e);
        }

        final UserDetails userDetails = userDetailsService.loadUserByUsername(authenticationRequest.getUsername());
        final String jwtToken= jwtUtil.generateToken(userDetails);
        return ResponseEntity.ok(new AuthenticationResponse(jwtToken));
    }


    @PostMapping("/users")
    public UserEntity createUser(@RequestBody UserEntity userEntity){
        System.out.println("UE : "+userEntity);
        return userService.createUser(userEntity);
    }

    @PostMapping("/roles")
    public RoleEntity createRole(@RequestBody RoleEntity roleEntity){
        System.out.println("RE : "+roleEntity);
        return roleService.createRole(roleEntity);
    }

    @DeleteMapping("/users/{username}")
    public String deleteEmployee(@PathVariable("username") String username) {
        return userService.deleteUserByName(username);
    }
}
