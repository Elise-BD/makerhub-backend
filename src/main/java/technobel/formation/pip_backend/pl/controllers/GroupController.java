package technobel.formation.pip_backend.pl.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import technobel.formation.pip_backend.bll.services.GroupService;
import technobel.formation.pip_backend.pl.models.DTOs.GroupDTO;

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


}
