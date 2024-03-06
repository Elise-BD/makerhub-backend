package technobel.formation.pip_backend.pl.controllers;

import jakarta.persistence.EntityNotFoundException;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import technobel.formation.pip_backend.bll.services.UserService;
import technobel.formation.pip_backend.pl.models.DTOs.UserDTO;
import technobel.formation.pip_backend.pl.models.forms.RegisterForm;
import technobel.formation.pip_backend.pl.models.forms.UserForm;

@RestController
@RequestMapping("/api/user")
public class UserController {

    private final UserService userService;


    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    @ResponseStatus(HttpStatus.CREATED)
    public void register(@RequestBody RegisterForm form){
        userService.register(form);
    }

    @GetMapping("/{id:[0-9]+}")
    public ResponseEntity<UserDTO> getById(@PathVariable Integer id){
        return ResponseEntity.ok(UserDTO.fromEntityToDTO(userService.getById(id).orElseThrow(()-> new EntityNotFoundException("Aucune entité trouvée pour cet ID :" +id))));
    }

    @GetMapping("/all")
    public ResponseEntity<Page<UserDTO>> getAll(Pageable pageable){
        return ResponseEntity.ok((Page<UserDTO>) userService.getAll(pageable).stream().map(UserDTO::fromEntityToDTO).toList());
    }

    @PutMapping("/{id:[0-9]+}")
    public void update(@PathVariable("id") Integer id, @RequestBody UserForm form){
        userService.update(form, id);
    }


}
