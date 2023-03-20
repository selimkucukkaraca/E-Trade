package com.example.etrade.dto.request;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import lombok.AllArgsConstructor;
import lombok.Data;

import static com.example.etrade.util.ErrorMessage.*;

@Data
@AllArgsConstructor
public class CreateProductCommentRequest {

    private String title;
    private String body;
    @Min(value = 1, message = STAR_REQUEST_ERROR_MESSAGE)
    @Max(value = 5, message = STAR_REQUEST_ERROR_MESSAGE)
    private int star;
    private String userMail;
    private String productId;

}