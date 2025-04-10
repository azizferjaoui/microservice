    package com.megaminds.project.Controller;

    import org.springframework.web.bind.annotation.RestController;
    import com.megaminds.project.Entity.Project;
    import com.megaminds.project.Service.ProjectService;
    import org.springframework.beans.factory.annotation.Autowired;
    import org.springframework.http.ResponseEntity;
    import org.springframework.web.bind.annotation.*;

    import java.util.List;
    import java.util.Optional;
    @CrossOrigin("http://localhost:4200")
    @RestController
    public class ProjectController {

        @Autowired
        private ProjectService projectService;

        // 🔹 Ajouter un projet
        @PostMapping("/save/projects")
        public ResponseEntity<Project> createProject(@RequestBody Project project) {
            Project savedProject = projectService.saveProject(project);
            return ResponseEntity.ok(savedProject);
        }

        // 🔹 Récupérer tous les projets
        @GetMapping("/get/projects")
        public ResponseEntity<List<Project>> getAllProjects() {
            List<Project> projects = projectService.getAllProjects();
            return ResponseEntity.ok(projects);
        }

        // 🔹 Récupérer un projet par ID
        @GetMapping("/get/projects/{id}")
        public ResponseEntity<Project> getProjectById(@PathVariable Long id) {
            Optional<Project> project = projectService.getProjectById(id);
            return project.map(ResponseEntity::ok)
                    .orElseGet(() -> ResponseEntity.notFound().build());
        }

        // 🔹 Mettre à jour un projet
        @PutMapping("/update/projects/{id}")
        public ResponseEntity<Project> updateProject(@PathVariable Long id, @RequestBody Project updatedProject) {
            try {
                Project project = projectService.updateProject(id, updatedProject);
                return ResponseEntity.ok(project);
            } catch (RuntimeException e) {
                return ResponseEntity.notFound().build();
            }
        }

        // 🔹 Supprimer un projet
        @DeleteMapping("/delete/projects/{id}")
        public ResponseEntity<Void> deleteProject(@PathVariable Long id) {
            projectService.deleteProject(id);
            return ResponseEntity.noContent().build();
        }


    }
