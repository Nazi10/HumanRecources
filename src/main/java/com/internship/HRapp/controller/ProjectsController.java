package com.internship.HRapp.controller;

import com.internship.HRapp.dto.projectsDto.ProjectsDTO;
import com.internship.HRapp.dto.userDto.AssignUserDTO;
import com.internship.HRapp.service.interfaces.ProjectsServiceInterface;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequiredArgsConstructor
@RequestMapping(path = "hr_management/projects")
public class ProjectsController {
    private final ProjectsServiceInterface projectsServiceInterface;

    @PostMapping("/addProject")
    public ResponseEntity<ProjectsDTO> save(@RequestBody ProjectsDTO projectsDTO) {
        return ResponseEntity.ok(projectsServiceInterface.addNewProjects(projectsDTO));
    }

    @GetMapping("/getProjectsByUserId/{userId}")
    public ResponseEntity<List<ProjectsDTO>> getProjectsByUserId(@PathVariable UUID userId) {
        return ResponseEntity.ok(projectsServiceInterface.getProjectsByUserId(userId));
    }

    @GetMapping("/getProjectsById/{projectsId}")
    public ResponseEntity<ProjectsDTO> getProjectById(@PathVariable UUID projectsId) {
        return ResponseEntity.ok(projectsServiceInterface.getProjectById(projectsId));
    }

    @GetMapping("/getProjectsByName/{projectsName}")
    public ResponseEntity<ProjectsDTO> findProjectByName(@PathVariable String projectsName) {
        return ResponseEntity.ok(projectsServiceInterface.getProjectByProjectName(projectsName));
    }

    @GetMapping("/getAllProjects")
    public ResponseEntity<List<ProjectsDTO>> getProjects() {
        return ResponseEntity.ok(projectsServiceInterface.getProjects());
    }

    @PutMapping("updateProject/")
    public void updateProject(@RequestBody ProjectsDTO projectsDTO) {
        projectsServiceInterface.updateProject(projectsDTO);
    }

    @PatchMapping("/changeProjectStatus/{projectId}/status/{status}")
    public ResponseEntity<String> changeProjectStatus(@PathVariable UUID projectId, @PathVariable Boolean status) {
        return ResponseEntity.ok(projectsServiceInterface.changeProjectStatus(projectId, status));
    }

    @PatchMapping("/assignUser/{projectId}/username/{username}")
    public ResponseEntity<AssignUserDTO> assignUserToProject(@PathVariable UUID projectId, @PathVariable String username) {
        return ResponseEntity.ok(projectsServiceInterface.assignUserToProject(projectId, username));
    }
}