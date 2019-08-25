package students.logic;

import students.entity.Students;

import javax.ejb.Stateless;
import java.util.ArrayList;

@Stateless

public interface ManagementSystemLocal {
    Students getStudents(int studentId);
}
