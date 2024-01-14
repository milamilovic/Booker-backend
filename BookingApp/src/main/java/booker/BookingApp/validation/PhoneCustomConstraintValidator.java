package booker.BookingApp.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class PhoneCustomConstraintValidator implements ConstraintValidator<PhoneCustomConstraint, String> {
    @Override
    public void initialize(PhoneCustomConstraint string) {
    }

    @Override
    public boolean isValid(String customField, ConstraintValidatorContext ctx) {
        if (customField == null) {
            return false;
        }
        return customField.matches("^\\d{10}$");
    }
}
