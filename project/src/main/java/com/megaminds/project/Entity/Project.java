package com.megaminds.project.Entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long projet_id;

    @Column(nullable = false)
    private String projet_name;

    @Column(columnDefinition = "TEXT")
    private String projet_description;

    @Column(nullable = false)
    @JsonFormat(pattern = "yyyy-MM-dd")

    private LocalDate start_date;
    @Column(nullable = false)
    private String projectManager;
    @JsonFormat(pattern = "yyyy-MM-dd")

    private LocalDate end_date;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private StatutProjet statut_projet;



    @OneToMany(mappedBy = "project", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    private List<Worker> workers = new ArrayList<>();




    private String imagePath;
    private Float latitude ;
    private Float longitude ;
    // Stores the file path or URL of the image

    // Getters and setters
    public String getImagePath() {
        return imagePath;
    }

    public Float getLongitude() {
        return longitude;
    }

    public void setLongitude(Float longitude) {
        this.longitude = longitude;
    }

    public Float getLatitude() {
        return latitude;
    }

    public void setLatitude(Float latitude) {
        this.latitude = latitude;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    private Double budget_estime;

    private Float risque_retard;

    public Long getProjet_id() {
        return projet_id;
    }

    public void setProjet_id(Long projet_id) {
        this.projet_id = projet_id;
    }

    public String getProjet_name() {
        return projet_name;
    }
    public String getProjectManager() {
        return projectManager;
    }

    public void setProjectManager(String projectManager) {
        this.projectManager = projectManager;
    }

    public void setProjet_name(String projet_name) {
        this.projet_name = projet_name;
    }

    public String getProjet_description() {
        return projet_description;
    }

    public void setProjet_description(String projet_description) {
        this.projet_description = projet_description;
    }

    public LocalDate getStart_date() {
        return start_date;
    }

    public void setStart_date(LocalDate start_date) {
        this.start_date = start_date;
    }

    public LocalDate getEnd_date() {
        return end_date;
    }

    public void setEnd_date(LocalDate end_date) {
        this.end_date = end_date;
    }

    public StatutProjet getStatut_projet() {
        return statut_projet;
    }

    public void setStatut_projet(StatutProjet statut_projet) {
        this.statut_projet = statut_projet;
    }

    public Double getBudget_estime() {
        return budget_estime;
    }

    public void setBudget_estime(Double budget_estime) {
        this.budget_estime = budget_estime;
    }

    public Float getRisque_retard() {
        return risque_retard;
    }

    public void setRisque_retard(Float risque_retard) {
        this.risque_retard = risque_retard;
    }

    public List<Worker> getWorkers() {
        return workers;
    }

    public void setWorkers(List<Worker> workers) {
        this.workers = workers;
    }
}

