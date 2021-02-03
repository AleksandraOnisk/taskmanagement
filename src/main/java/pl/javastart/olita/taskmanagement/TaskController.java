package pl.javastart.olita.taskmanagement;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;

@Controller
public class TaskController {

    private TaskRepository taskRepository;

    public TaskController(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    @GetMapping("/")
    public String home(Model model){

        List<Task> tasksList = taskRepository.findAll();

        model.addAttribute("tasksList", tasksList);

        return "home";
    }

    @GetMapping("/task/{id}")
    public String showTask(@PathVariable Long id, Model model){
        Optional<Task> taskOptional = taskRepository.findById(id);

        if(taskOptional.isPresent()){
            Task task = taskOptional.get();
            model.addAttribute("task", task);

            return "task";
        } else {
            return "redirect:/";
        }

    }

}
