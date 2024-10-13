package com.blogwebsite.blog_wesite_apis.Exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.http.HttpStatus;

@Data

public class UserException {

    //if using lombok, make sure implementation parameter are in same order as this
    private final HttpStatus httpStatus;
    private final String message;
}
