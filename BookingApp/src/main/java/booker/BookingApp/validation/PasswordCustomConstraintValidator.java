package booker.BookingApp.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class PasswordCustomConstraintValidator implements ConstraintValidator<PasswordCustomConstraint, String> {
    /*
        poziva se svaki put pre upotrebe instance validatora
         */
    @Override
    public void initialize(PasswordCustomConstraint string) {

    }

    /*
    vrsi validaciju custom polja koje je anotirano
     */
    @Override
    public boolean isValid(String customField, ConstraintValidatorContext ctx) {

        if (customField == null) {
            return false;
        }
        return customField.matches("[0-9]{8,32}");
    }
}
