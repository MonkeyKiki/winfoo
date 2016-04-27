package com.orange.upro.winfoo.web.pgm;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

/**
 *
 * @author beaufils
 */
@Component
public class PgmFileValidator implements Validator {

    public boolean supports(Class<?> clazz) {
        return PgmFileForm.class.isAssignableFrom(clazz);
    }

    public void validate(Object obj, Errors errors) {
        PgmFileForm file = (PgmFileForm) obj;

        if (file.getFile() != null) {
            if (file.getFile().getSize() == 0) {
                errors.rejectValue("file", "missing.file");
            }
        }
    }
}
