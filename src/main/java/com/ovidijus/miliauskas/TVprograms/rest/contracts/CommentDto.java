package com.ovidijus.miliauskas.TVprograms.rest.contracts;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class CommentDto {
    private String text;
    private Integer personId;

}
