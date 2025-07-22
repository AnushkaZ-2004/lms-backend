package com.lms.announcement.repository;

import com.lms.announcement.model.Announcement;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AnnouncementRepository extends JpaRepository<Announcement, Long> {
    List<Announcement> findByCourseId(Long courseId);
    List<Announcement> findByCourseIdIsNull(); // Global
}
