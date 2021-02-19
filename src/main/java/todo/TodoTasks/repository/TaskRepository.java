package todo.TodoTasks.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import todo.TodoTasks.models.Task;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {}