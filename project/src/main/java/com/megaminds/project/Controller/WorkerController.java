    package com.megaminds.project.Controller;

    import com.megaminds.project.Entity.Worker;
    import com.megaminds.project.Service.WorkerService;
    import org.springframework.beans.factory.annotation.Autowired;
    import org.springframework.http.ResponseEntity;
    import org.springframework.web.bind.annotation.*;

    import java.util.List;

    @CrossOrigin("http://localhost:4200")
    @RestController
    @RequestMapping("/workers")
    public class WorkerController {

        @Autowired
        private WorkerService workerService;

        @PostMapping
        public ResponseEntity<Worker> createWorker(@RequestBody Worker worker) {
            Worker savedWorker = workerService.saveWorker(worker);
            return ResponseEntity.ok(savedWorker);
        }

        @GetMapping
        public ResponseEntity<List<Worker>> getAllWorkers() {
            List<Worker> workers = workerService.getAllWorkers();
            return ResponseEntity.ok(workers);
        }

        @GetMapping("/{id}")
        public ResponseEntity<Worker> getWorkerById(@PathVariable Long id) {
            Worker worker = workerService.getWorkerById(id)
                    .orElseThrow(() -> new RuntimeException("Worker not found"));
            return ResponseEntity.ok(worker);
        }

        @PutMapping("/{id}")
        public ResponseEntity<Worker> updateWorker(@PathVariable Long id, @RequestBody Worker updatedWorker) {
            Worker worker = workerService.updateWorker(id, updatedWorker);
            return ResponseEntity.ok(worker);
        }

        @DeleteMapping("/{id}")
        public ResponseEntity<Void> deleteWorker(@PathVariable Long id) {
            workerService.deleteWorker(id);
            return ResponseEntity.noContent().build();
        }
        @PutMapping("/{workerId}/assign/{projectId}")
        public ResponseEntity<Worker> assignWorkerToProject(@PathVariable Long workerId, @PathVariable Long projectId) {
            Worker worker = workerService.assignWorkerToProject(workerId, projectId);
            return ResponseEntity.ok(worker);
        }
            @PutMapping("/{workerId}/removeProject")
            public ResponseEntity<Worker> removeWorkerFromProject(@PathVariable Long workerId) {
                Worker worker = workerService.removeWorkerFromProject(workerId);
                return ResponseEntity.ok(worker);
            }
    }