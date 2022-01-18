package com.example.demorestservice.services;

import com.example.demorestservice.entities.DocumentFile;
import com.example.demorestservice.entities.Product;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface DocumentFileService {

    DocumentFile addDocumentFile(DocumentFile documentFile);

    DocumentFile getDocumentFile(Long documentFileId);

    List<DocumentFile> getAllDocumentFile();

    Boolean deleteDocumentFile(Long documentFileId);

}
