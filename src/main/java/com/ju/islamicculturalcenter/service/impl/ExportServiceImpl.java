package com.ju.islamicculturalcenter.service.impl;

import com.ju.islamicculturalcenter.entity.CourseEntity;
import com.ju.islamicculturalcenter.entity.InstructorEntity;
import com.ju.islamicculturalcenter.entity.StudentEntity;
import com.ju.islamicculturalcenter.repos.CourseRepo;
import com.ju.islamicculturalcenter.repos.InstructorRepo;
import com.ju.islamicculturalcenter.repos.StudentRepo;
import com.ju.islamicculturalcenter.service.iservice.ExportService;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.Writer;
import java.util.List;

@Service
public class ExportServiceImpl implements ExportService {

    private final StudentRepo studentRepo;
    private final CourseRepo courseRepo;
    private final InstructorRepo instructorRepo;

    public ExportServiceImpl(StudentRepo studentRepo, CourseRepo courseRepo, InstructorRepo instructorRepo) {
        this.studentRepo = studentRepo;
        this.courseRepo = courseRepo;
        this.instructorRepo = instructorRepo;
    }

    @Override
    public void exportInstructors(Writer writer) {
        try {
            List<InstructorEntity> instructors = instructorRepo.findAll(Example.of(InstructorEntity.builder().active(true).build()));
            CSVPrinter printer = new CSVPrinter(writer, CSVFormat.DEFAULT);
            printer.printRecord("ID", "First Name", "Last Name", "Email", "Phone Number", "Facebook Url", "isVolunteer", "Salary");
            for (InstructorEntity instructor : instructors) {
                printer.printRecord(instructor.getId(), instructor.getUser().getFirstName(), instructor.getUser().getLastName(),
                        instructor.getUser().getEmail(), instructor.getUser().getPhoneNumber(), instructor.getUser().getFacebookUrl(),
                        instructor.getIsVolunteer(), instructor.getSalary());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void exportStudents(Writer writer) {
        try {
            List<StudentEntity> students = studentRepo.findAll(Example.of(StudentEntity.builder().active(true).build()));
            CSVPrinter printer = new CSVPrinter(writer, CSVFormat.DEFAULT);
            printer.printRecord("ID", "First Name", "Last Name", "Email", "Phone Number", "Facebook Url");
            for (StudentEntity student : students) {
                printer.printRecord(student.getId(), student.getUser().getFirstName(), student.getUser().getLastName(),
                        student.getUser().getEmail(), student.getUser().getPhoneNumber(), student.getUser().getFacebookUrl());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void exportCourses(Writer writer) {
        try {
            List<CourseEntity> courses = courseRepo.findAll(Example.of(CourseEntity.builder().active(true).build()));
            CSVPrinter printer = new CSVPrinter(writer, CSVFormat.DEFAULT);
            printer.printRecord("ID", "Course Name", "Description", "Start Date", "End Date", "Lecture Time", "Days of Week",
                    "Price", "Classroom", "Last Registration Day");
            for (CourseEntity course : courses) {
                printer.printRecord(course.getId(), course.getName(), course.getDescription(), course.getStartDate(), course.getEndDate(),
                        course.getLectureTime(), course.getDaysOfWeek(), course.getPrice(), course.getClassroom(), course.getLastRegDay());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
