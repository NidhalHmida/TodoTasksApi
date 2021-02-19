package todo.TodoTasks.interfaces;

import todo.TodoTasks.models.Task;
import java.util.List;

public interface ITaskService
{
   Task saveTask(Task task);
   List<Task> getAll();
   Task updateTask(long id,Task task);
   void deleteTask(long id);
}