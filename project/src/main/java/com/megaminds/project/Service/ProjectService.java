package com.megaminds.project.Service;

import com.megaminds.project.Entity.Project;
import com.megaminds.project.Repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProjectService {

    @Autowired
    private ProjectRepository projectRepository;



    // 🔹 Ajouter un projet
    public Project saveProject(Project project) {
        return projectRepository.save(project);
    }

    // 🔹 Récupérer tous les projets
    public List<Project> getAllProjects() {
        List<Project> projects = projectRepository.findAll();
        for (Project project : projects) {
            System.out.println("Project: " + project.getProjet_name());
        }
        return projects;
    }

    // 🔹 Récupérer un projet par ID
    public Optional<Project> getProjectById(Long id) {
        return projectRepository.findById(id);
    }

    // 🔹 Mettre à jour un projet
    public Project updateProject(Long id, Project updatedProject) {
        return projectRepository.findById(id).map(project -> {
            project.setProjet_name(updatedProject.getProjet_name());
            project.setProjet_description(updatedProject.getProjet_description());
            project.setStart_date(updatedProject.getStart_date());
            project.setEnd_date(updatedProject.getEnd_date());
            project.setStatut_projet(updatedProject.getStatut_projet());
            project.setBudget_estime(updatedProject.getBudget_estime());
            project.setRisque_retard(updatedProject.getRisque_retard());
            return projectRepository.save(project);
        }).orElseThrow(() -> new RuntimeException("Projet non trouvé"));
    }


    // 🔹 Supprimer un projet
    public void deleteProject(Long id) {
        projectRepository.deleteById(id);
    }


}