package com.mapsa.demovalidation.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import org.springframework.stereotype.Service;


import javax.validation.constraints.*;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class User {
    //@NotEmpty(message = "first name is required")
    @NotNull(message = "first name is required")
    private String firstName;
    @NotEmpty(message = "last name is required")
    private String lastName;
    @Email
    @NotEmpty(message = " Email is required")
    private String email;
    //@NotEmpty(message = "Password is required") + @NotNull = @NotBlank
    @NotBlank(message = "Password is required")
    @Size(min = 4,max = 8,message = "Wrong")
    private String password;
    @Min(18)
    @Digits(integer = 2,fraction = 0) // 2 ragham bashe , ashar nabashe
    private int age;
    @Pattern(regexp = "09[0-9]+7")
    private String subscribedNumber;
    @Past
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate birthday;
}
