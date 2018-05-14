package paquete1.amv.command;

import lombok.*;
import java.io.Serializable;
import javax.validation.constraints.*;

@Data
@ToString

public class UsuarioSignInCommand implements  Serializable {
    
    @NotNull(message = "Se solicita un email")
    @NotEmpty(message = "Se solicita un email")
    @Size(min = validationRules.EMAIL_MIN_SIZE, message = "El email debe tener 10 o más caracteres")
    @Email(message = "error.format.email")
    private String email;
    
    @NotNull(message = "Se solicita contraseña")
    @NotEmpty(message = "Se solicita contraseña")
    @Size(min = validationRules.PASSWORD_MIN_SIZE, message = "La contraseña debe tener 10 o más caracteres")
    private String contraseña;
    
}