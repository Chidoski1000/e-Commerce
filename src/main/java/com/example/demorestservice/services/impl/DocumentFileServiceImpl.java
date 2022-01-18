package com.example.demorestservice.services.impl;

import com.example.demorestservice.entities.DocumentFile;
import com.example.demorestservice.entities.Product;
import com.example.demorestservice.repositories.DocumentFileRepository;
import com.example.demorestservice.services.DocumentFileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DocumentFileServiceImpl implements DocumentFileService {

    @Autowired
    private DocumentFileRepository documentFileRepository;

    @Override
    public DocumentFile addDocumentFile(DocumentFile documentFile) {
        return documentFileRepository.save(documentFile);
    }

    @Override
    public DocumentFile getDocumentFile(Long documentFileId) {
        Optional<DocumentFile> file = documentFileRepository.findById(documentFileId);
        return file.orElse(null);
    }

    @Override
    public List<DocumentFile> getAllDocumentFile() {
        return documentFileRepository.findAll();
    }

    @Override
    public Boolean deleteDocumentFile(Long documentFileId) {
        DocumentFile file = getDocumentFile(documentFileId);
        if(file != null){
             documentFileRepository.delete(file);
             return true;
        }
        return false;
    }
}
