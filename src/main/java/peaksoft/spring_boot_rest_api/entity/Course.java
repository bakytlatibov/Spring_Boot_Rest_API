package peaksoft.spring_boot_rest_api.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Entity
@Table(name = "courses")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter

public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "course_name")
    private String courseName;
    @Column(name = "duration_month")
    private String durationMonth;
    @CreatedDate
    private LocalDate localDate;
    private  Boolean isActive=true;
    private  Boolean isDeleted=false;

    @ManyToOne(cascade = {CascadeType.REFRESH, CascadeType.MERGE,CascadeType.PERSIST,CascadeType.DETACH})
    @JoinColumn(name = "company_id")
    private Company company;

    @ManyToMany(cascade = {CascadeType.ALL}, mappedBy = "courses")
    @JsonIgnore
    private List<Group> groups;


    @OneToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL,mappedBy = "course")
    @JsonIgnore
    private User teacher;

    @Override
    public String toString() {
        return "Course{" +
                "id=" + id +
                ", courseName='" + courseName + '\'' +
                ", durationMonth='" + durationMonth + '\'' +
                ", localDate=" + localDate +
                ", isActive=" + isActive +
                ", isDeleted=" + isDeleted +
                ", company=" + company +
                '}';
    }
}