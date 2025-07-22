package com.lms.announcement.service;

import com.lms.announcement.model.Announcement;
import com.lms.announcement.repository.AnnouncementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class AnnouncementService {

    @Autowired
    private AnnouncementRepository repository;

    public Announcement create(Announcement announcement) {
        announcement.setPostedAt(LocalDateTime.now());
        return repository.save(announcement);
    }

    public List<Announcement> getAll() {
        return repository.findAll();
    }

    public List<Announcement> getByCourseId(Long courseId) {
        return repository.findByCourseId(courseId);
    }

    public List<Announcement> getGlobal() {
        return repository.findByCourseIdIsNull();
    }

    public Announcement get(Long id) {
        return repository.findById(id).orElse(null);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}
