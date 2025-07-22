package com.lms.announcement.controller;

import com.lms.announcement.model.Announcement;
import com.lms.announcement.service.AnnouncementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/announcements")
public class AnnouncementController {

    @Autowired
    private AnnouncementService service;

    @PostMapping
    public Announcement post(@RequestBody Announcement announcement) {
        return service.create(announcement);
    }

    @GetMapping
    public List<Announcement> getAll() {
        return service.getAll();
    }

    @GetMapping("/global")
    public List<Announcement> getGlobal() {
        return service.getGlobal();
    }

    @GetMapping("/course/{courseId}")
    public List<Announcement> getByCourse(@PathVariable Long courseId) {
        return service.getByCourseId(courseId);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}
