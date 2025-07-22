package com.lms.material.controller;

import com.lms.material.entity.Material;
import com.lms.material.repository.MaterialRepository;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/materials")
public class MaterialController {

    private final MaterialRepository materialRepository;

    public MaterialController(MaterialRepository materialRepository) {
        this.materialRepository = materialRepository;
    }

    @PostMapping
    public Material uploadMaterial(@RequestBody Material material) {
        material.setUploadedAt(LocalDateTime.now());
        return materialRepository.save(material);
    }

    @GetMapping
    public List<Material> getAllMaterials() {
        return materialRepository.findAll();
    }

    @GetMapping("/course/{courseId}")
    public List<Material> getMaterialsByCourse(@PathVariable Long courseId) {
        return materialRepository.findByCourseId(courseId);
    }

    @DeleteMapping("/{id}")
    public void deleteMaterial(@PathVariable Long id) {
        materialRepository.deleteById(id);
    }
}
