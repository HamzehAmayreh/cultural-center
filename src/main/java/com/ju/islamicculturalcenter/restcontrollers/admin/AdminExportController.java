package com.ju.islamicculturalcenter.restcontrollers.admin;

import com.ju.islamicculturalcenter.service.iservice.ExportService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Timestamp;

@RestController
@RequestMapping("/api/v1/admin/export")
public class AdminExportController{

    private final ExportService exportService;

    public AdminExportController(ExportService exportService) {
        this.exportService = exportService;
    }

    @GetMapping("/students")
    public void exportStudents(HttpServletResponse response) throws IOException {
        response.setContentType("text/csv");
        response.addHeader("Content-Disposition", "attachment; filename=\"students.csv\"");
        exportService.exportStudents(response.getWriter());
    }

    @GetMapping("/courses")
    public void exportCourses(HttpServletResponse response) throws IOException {
        response.setContentType("text/csv");
        response.addHeader("Content-Disposition", "attachment; filename=\"courses.csv\"");
        exportService.exportCourses(response.getWriter());
    }

    @GetMapping("/instructor")
    public void exportInstructors(HttpServletResponse response) throws IOException {
        response.setContentType("text/csv");
        response.addHeader("Content-Disposition", "attachment; filename=\"instructors.csv\"");
        exportService.exportInstructors(response.getWriter());
    }

    public static void main(String[] args) {
        System.out.println(new Timestamp(System.currentTimeMillis()));
    }
}
