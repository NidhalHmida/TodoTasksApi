package todo.TodoTasks.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import javax.persistence.*;
import javax.validation.constraints.*;
import java.time.LocalDate;

@Entity
@Table (name="task")

public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotBlank(message = "Titre est obligatoire")
    @Pattern(regexp = "([A-Za-zéàè:' ]+)",message = "titre doit contenir des caractéres alphabitiques")
    private String title;


    @NotBlank(message = "Description est obligatoire")
    private String description;

    @JsonFormat(pattern = "yyyy-MM-dd")
    @FutureOrPresent(message="Veuillez sélectionner une date présente ou future")
    @NotNull(message="date de début est obligatoire")
    private LocalDate startDate;

    @JsonFormat(pattern = "yyyy-MM-dd")
    @NotNull(message="date d'échance est obligatoire")
    private LocalDate  endDate;


    @NotBlank(message = "status est obligatoire")
    private String status;


    //  Getters and setters
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}