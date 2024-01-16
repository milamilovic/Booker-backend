package booker.BookingApp.validation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.METHOD, ElementType.FIELD})    // definise nad cime anotacija moze da se koristi
@Retention(RetentionPolicy.RUNTIME)     // definise politiku zadrzavanja anotacije
@Constraint(validatedBy=PasswordCustomConstraintValidator.class)       // povezuje anotaciju sa validatorom
public @interface PasswordCustomConstraint {
    String message() default "Field must contain exactly 8 digits";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
