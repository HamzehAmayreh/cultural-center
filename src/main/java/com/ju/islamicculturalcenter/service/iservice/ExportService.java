package com.ju.islamicculturalcenter.service.iservice;

import java.io.Writer;

public interface ExportService {

    void exportInstructors(Writer writer);

    void exportStudents(Writer writer);

    void exportCourses(Writer writer);
}
