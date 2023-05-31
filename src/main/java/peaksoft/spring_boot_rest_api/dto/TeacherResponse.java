package peaksoft.spring_boot_rest_api.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import peaksoft.spring_boot_rest_api.entity.Course;

import java.time.LocalDate;
@Getter
@Setter
@Builder
public class TeacherResponse {
    private Long id;
    private String firstName;
    private  String lastName;
    private  String email;
    private  String roleName;
    private LocalDate localDate;
    private  Boolean isActivity;
    private  Boolean isDelete;
    private Course course;
}
