package com.megaminds.project.Entity;

public enum Role {
    CHEF_CHANTIER , // L'administrateur a tous les droits
    CONDUCTEUR_TRAVEAUX, // Le chef de projet est responsable de la gestion du projet
    INGENIEUR, // Le développeur est chargé de la réalisation des tâches
    CONDUCTEUR_SECURITE, // Le testeur est chargé de la vérification de la qualité du code
    TECHNICIEN // Le client est le propriétaire du projet
}
