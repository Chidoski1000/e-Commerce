package com.example.demorestservice.request;

import lombok.*;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UpdateUserRequestDto {
    private String firstName;
    private String lastName;
    private Date dob;
    private String address;
    private String phoneNo;
    private String state;
    private String username;
    private String nin;
    private String acctNumber;
}
