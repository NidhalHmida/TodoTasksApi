package todo.TodoTasks.controllers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import todo.TodoTasks.models.Task;
import todo.TodoTasks.services.TaskService;
import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@RestController
@RequestMapping("api/todotasks")
@CrossOrigin(origins = "*")
public class TaskController {

    @Autowired
    private TaskService service;

    @GetMapping("/tasks")
    public List<Task> getAllTasks() {
        return service.getAll();
    }

    @PostMapping("/tasks")
    public ResponseEntity<?> addTask( @RequestBody @Valid Task task) {
        Task createdTask=null ;
        Map<String, Task> response = new HashMap<>();
        if(task.getStartDate().isBefore(task.getEndDate())) {
            createdTask = service.saveTask(task);
        }
        response.put("task",createdTask);
        return new ResponseEntity<>(createdTask, HttpStatus.OK);
    }

    @PutMapping("/tasks/{id}")
    public ResponseEntity<?> updateTask(@PathVariable(value = "id") long taskId, @Valid @RequestBody Task task) {
        Task updatedTask=null ;
        Map<String, Task> response = new HashMap<>();
        if(task.getStartDate().isBefore(task.getEndDate())) {
            updatedTask = service.updateTask(taskId,task);
        }
        response.put("task", updatedTask);
        return new ResponseEntity<>(updatedTask, HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/tasks/{id}")
    public Map<String, Boolean> deleteTask(@PathVariable(value = "id") long taskId) {
        Map<String, Boolean> response = new HashMap<>();
        service.deleteTask(taskId);
        response.put("deleted", Boolean.TRUE);
        return response;

    }

}
