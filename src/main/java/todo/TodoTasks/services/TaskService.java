package todo.TodoTasks.services;

import org.springframework.validation.annotation.Validated;
import todo.TodoTasks.models.Task;
import todo.TodoTasks.interfaces.ITaskService;
import org.springframework.beans.factory.annotation.Autowired;
import todo.TodoTasks.Exception.ResourceNotFoundException;
import org.springframework.stereotype.Service;
import todo.TodoTasks.repository.TaskRepository;
import java.util.List;


@Service
public class TaskService implements ITaskService {

    @Autowired
    private TaskRepository repository ;

    @Override
    public Task saveTask(Task task)
    {
        return repository.save(task) ;
    }

    @Override
    public List<Task> getAll()
    {
        return repository.findAll();
    }

    @Override
    public Task updateTask(long id,Task task)
    {
        Task existedTask = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("task not found on :: " + task.getId()));

       task.setId(id);
        return repository.save(task);
    }

    @Override
    public void deleteTask(long id)
    {
        repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("task not found on :: " + id));
        repository.deleteById(id);
    }
}
