package com.design_project.voting_system.controller;


import com.design_project.voting_system.model.Candidate;
import com.design_project.voting_system.service.CandidateService;
import com.design_project.voting_system.service.FileStorageService;
import lombok.SneakyThrows;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/candidate")
public class CandidateController {

    @Autowired
    private CandidateService candidateService;
    @Autowired
    private FileStorageService fileStorageService;
    private static final Logger logger = LoggerFactory.getLogger(CandidateController.class);

    @PostMapping("/add")
    public String addCandidate(@RequestParam("file") MultipartFile file , @RequestBody Candidate candidate) {
        return candidateService.addCandidate(candidate,file);

    }

    @GetMapping("/all")
    public List<Candidate> getCandidates() {
        return candidateService.getCandidates();
    }

    @GetMapping("all/{id}")
    public Optional<Candidate> getCandidates(@PathVariable String id) {
        return candidateService.getCandidate(id);
    }

    @DeleteMapping("delete/{id}")
    public String deleteCandidate(@PathVariable String id) {
        return candidateService.deleteCandidate(id);

    }

    @SneakyThrows
    @GetMapping("/uploads/{filename}")
    public ResponseEntity<Resource> getImageResource(@PathVariable String filename, HttpServletRequest request) {

        Resource resource = fileStorageService.loadFileAsResource(filename);
        // Try to determine file's content type
        String contentType = null;
        try {
            contentType = request.getServletContext().getMimeType(resource.getFile().getAbsolutePath());
        } catch (IOException ex) {
            logger.info("Could not determine file type.");
        }

        // Fallback to the default content type if type could not be determined
        if (contentType == null) {
            contentType = "application/octet-stream";
        }

        return ResponseEntity.ok()
                .contentType(MediaType.parseMediaType(contentType))
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + resource.getFilename() + "\"")
                .body(resource);

    }

}