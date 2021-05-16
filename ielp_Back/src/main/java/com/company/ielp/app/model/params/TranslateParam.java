package com.company.ielp.app.model.params;

import lombok.Data;

@Data
public class TranslateParam {

    private String languageFrom;

    private String languageTo;

    private String translatedWord;

    private Integer userId;
}
