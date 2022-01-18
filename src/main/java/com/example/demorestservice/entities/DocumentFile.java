package com.example.demorestservice.entities;

import com.example.demorestservice.enums.DocumentType;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
public class DocumentFile {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long documentFileId;
    private String name;
    private String type;
    @Enumerated(EnumType.STRING)
    private DocumentType uploadType;
    @Lob
    private byte[] data;
    private Date dateUploaded;
}
