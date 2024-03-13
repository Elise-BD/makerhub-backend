package technobel.formation.pip_backend.pl.controllers;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.*;
import technobel.formation.pip_backend.bll.services.UserService;
import technobel.formation.pip_backend.dal.entities.User;
import technobel.formation.pip_backend.pl.models.DTOs.AuthDTO;
import technobel.formation.pip_backend.pl.models.DTOs.UserDTO;
import technobel.formation.pip_backend.pl.models.forms.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin("*")
public class UserController {

    private final UserService userService;
    private final UserDetailsService userDetailsService;


    public UserController(UserService userService, UserDetailsService userDetailsService) {
        this.userService = userService;
        this.userDetailsService = userDetailsService;
    }

    @PreAuthorize("isAnonymous()")
    @PostMapping("/login")
    public AuthDTO login(@RequestBody LoginForm form) {
        return userService.login(form);
    }

    @PreAuthorize("isAnonymous()")
    @PostMapping("/register")
    @ResponseStatus(HttpStatus.CREATED)
    public void register(@RequestBody RegisterForm form){
        userService.register(form);
    }

    @PreAuthorize("isAuthenticated()")
    @GetMapping("/user/{id:[0-9]+}")
    public ResponseEntity<UserDTO> getById(@PathVariable Integer id){
        return ResponseEntity.ok(UserDTO.fromEntityToDTO(userService.getById(id).orElseThrow(()-> new EntityNotFoundException("Aucune entité trouvée pour cet ID :" +id))));
    }

    @PreAuthorize("isAuthenticated()")
    @GetMapping("/user/{username}")
    public ResponseEntity<UserDTO> findByUsername(@PathVariable String username){
        return ResponseEntity.ok(UserDTO.fromEntityToDTO(userService.findByUsername(username).orElseThrow(()-> new EntityNotFoundException("Aucune entité trouvée pour ce username :" +username))));
    }

    @PreAuthorize("isAuthenticated()")
    @GetMapping("/user/all")
    public ResponseEntity<List<UserDTO>> getAll() {
        return ResponseEntity.ok(userService.getAll().stream().map(UserDTO::fromEntityToDTO).toList());
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/user/{id:[0-9]+}")
    public void update(@PathVariable("id") Integer id, @RequestBody UserFormAdmin form){
        userService.update(form, id);
    }

    @PreAuthorize("isAuthenticated()")
    @PutMapping("/profile/{id:[0-9]+}")
    public void update(@PathVariable("id") Integer id, @RequestBody UserFormProfile form){
        userService.update(form, id);
    }

    @PreAuthorize("isAuthenticated()")
    @PutMapping("/user/{id:[0-9]+}/personality")
    public void updatePersonality(@PathVariable("id") Integer id, @RequestBody PersonalityForm form){
        userService.updatePersonality(form, id);
    }

    @PreAuthorize("isAuthenticated()")
    @PutMapping("/user/{id:[0-9]+}/riasec")
    public void updateRiasec(@PathVariable("id") Integer id, @RequestBody RiasecForm form){
        userService.updateRiasec(form, id);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/user/{id:[0-9]+}")
    public void delete(@PathVariable("id") Integer id){
        userService.delete(id);
    }
}
