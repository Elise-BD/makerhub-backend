package technobel.formation.pip_backend.pl.controllers;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;
import technobel.formation.pip_backend.bll.services.GroupService;
import technobel.formation.pip_backend.pl.models.DTOs.GroupDTO;
import technobel.formation.pip_backend.pl.models.DTOs.UserDTO;
import technobel.formation.pip_backend.pl.models.forms.GroupForm;
import technobel.formation.pip_backend.pl.models.forms.RegisterForm;

import java.util.List;
@RestController
@RequestMapping("/api/group")
@CrossOrigin("*")
public class GroupController {

    private final GroupService groupService;

    public GroupController(GroupService groupService) {
        this.groupService = groupService;
    }


    @PreAuthorize("isAuthenticated()")
    @GetMapping("/all")
    public ResponseEntity<List<GroupDTO>> getAll() {
        return ResponseEntity.ok(groupService.getAll().stream().map(GroupDTO::fromEntityToDTO).toList());
    }

    @PreAuthorize("isAuthenticated()")
    @GetMapping("/{id:[0-9]+}")
    public ResponseEntity<GroupDTO> getById(@PathVariable Integer id){
        return ResponseEntity.ok(GroupDTO.fromEntityToDTO(groupService.getById(id).orElseThrow(()-> new EntityNotFoundException("Aucune entité GROUPE trouvée pour cet ID :" +id))));
    }

    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/{id:[0-9]+}")
    public void delete(@PathVariable("id") Integer id){
        groupService.delete(id);
    }

    @PreAuthorize("isAuthenticated()")
    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public void create(@RequestBody GroupForm form){
        groupService.create(form);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/join/{groupId:[0-9]+}/{username}")
    @ResponseStatus(HttpStatus.OK)
    public void join(@PathVariable Integer groupId, @PathVariable String username){
        groupService.join(groupId,username);
    }

    @PreAuthorize("isAuthenticated()")
    @GetMapping("/join/{groupId:[0-9]+}")
    @ResponseStatus(HttpStatus.OK)
    public void join(@PathVariable Integer groupId, Authentication auth){
        groupService.join(groupId, auth.getName());
    }

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/unjoin/{groupId:[0-9]+}/{username}")
    @ResponseStatus(HttpStatus.OK)
    public void leave(@PathVariable Integer groupId, @PathVariable String username){
        groupService.leave(groupId,username);
    }
    @PreAuthorize("isAuthenticated()")
    @GetMapping("/leave/{groupId:[0-9]+}")
    @ResponseStatus(HttpStatus.OK)
    public void leave(@PathVariable Integer groupId, Authentication auth){
        groupService.leave(groupId, auth.getName());
    }
}
