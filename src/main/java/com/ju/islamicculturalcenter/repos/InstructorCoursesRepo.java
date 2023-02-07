package com.ju.islamicculturalcenter.repos;

import com.ju.islamicculturalcenter.entity.InstructorCoursesEntity;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;
import java.util.List;

@Repository
public interface InstructorCoursesRepo extends BaseRepo<InstructorCoursesEntity, Long> {

    @Query("select i from InstructorCoursesEntity i where i.instructor.user.id=:instructorId and i.course.name like %:name%")
    List<InstructorCoursesEntity> searchMyCourses(Long instructorId, String name);

    @Query("select count(distinct instructor) from InstructorCoursesEntity where isActive = true")
    Long findAssignedInstructors();

    @Query("select count(distinct instructor) from InstructorCoursesEntity where isActive = true and creationDate < :date")
    Long findAssignedInstructorsWithDate(Timestamp date);
}
