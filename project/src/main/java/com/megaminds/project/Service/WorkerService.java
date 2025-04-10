package com.megaminds.project.Service;

import com.megaminds.project.Entity.Project;
import com.megaminds.project.Entity.Worker;
import com.megaminds.project.Repository.ProjectRepository;
import com.megaminds.project.Repository.WorkerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class WorkerService {

    @Autowired
    private WorkerRepository workerRepository;

    @Autowired
    private ProjectRepository projectRepository;

    public Worker saveWorker(Worker worker) {
        return workerRepository.save(worker);
    }

    public List<Worker> getAllWorkers() {
        return workerRepository.findAll();
    }

    public Optional<Worker> getWorkerById(Long id) {
        return workerRepository.findById(id);
    }

    public Worker updateWorker(Long id, Worker updatedWorker) {
        return workerRepository.findById(id).map(worker -> {
            worker.setName(updatedWorker.getName());
            worker.setRole(updatedWorker.getRole());
            worker.setProject(updatedWorker.getProject());
            worker.setEmail(updatedWorker.getEmail());
            worker.setJoindate(updatedWorker.getJoindate());
            worker.setPhone(updatedWorker.getPhone());


            return workerRepository.save(worker);
        }).orElseThrow(() -> new RuntimeException("Worker not found"));
    }

    public void deleteWorker(Long id) {
        workerRepository.deleteById(id);
    }
    public Worker assignWorkerToProject(Long workerId, Long projectId) {
        Optional<Worker> workerOpt = workerRepository.findById(workerId);
        Optional<Project> projectOpt = projectRepository.findById(projectId);

        if (workerOpt.isPresent() && projectOpt.isPresent()) {
            Worker worker = workerOpt.get();
            Project project = projectOpt.get();
            worker.setProject(project);
            return workerRepository.save(worker);
        } else {
            throw new RuntimeException("Worker or Project not found");
        }
    }
    public Worker removeWorkerFromProject(Long workerId) {
        Optional<Worker> workerOpt = workerRepository.findById(workerId);

        if (workerOpt.isPresent()) {
            Worker worker = workerOpt.get();
            worker.setProject(null);
            return workerRepository.save(worker);
        } else {
            throw new RuntimeException("Worker not found");
        }
    }
}