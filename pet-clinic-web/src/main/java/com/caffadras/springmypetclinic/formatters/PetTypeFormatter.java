package com.caffadras.springmypetclinic.formatters;

import com.caffadras.springmypetclinic.model.PetType;
import com.caffadras.springmypetclinic.services.PetTypeService;
import org.springframework.format.Formatter;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.util.Locale;

@Component
public class PetTypeFormatter implements Formatter<PetType> {

    private final PetTypeService petTypeService;

    public PetTypeFormatter(PetTypeService petTypeService) {
        this.petTypeService = petTypeService;
    }

    @Override
    public PetType parse(String text, Locale locale) throws ParseException {
        return petTypeService.findByName(text).orElseThrow(() -> new ParseException("Pet type not found: " + text, 0));
    }

    @Override
    public String print(PetType object, Locale locale) {
        return object.getName();
    }
}
