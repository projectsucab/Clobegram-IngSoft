package paquete1.amv.command;

import javax.validation.constraints.*;
import java.io.Serializable;
import lombok.Data;
import lombok.ToString;


@Data
@ToString


public class UsuarioSignUpCommand implements Serializable {

    @NotNull(message = "Se solicita un nombre")
    @NotEmpty(message = "Se solicita un nombre")
    @Size(min = validationRules.FIRST_LAST_NAME_MAX_SIZE, message = "El nombre no puede tener más de 30 letras")
    @Pattern(regexp = validationRules.FIRST_LAST_NAME_REGEX, message = "El nombre tiene algún caracter invalido")
    public String nombre;
    
    @NotNull(message = "Se solicita un apellido")
    @NotEmpty(message = "Se solicita un apellido")
    @Size(min = validationRules.FIRST_LAST_NAME_MAX_SIZE, message = "El apellido no puede tener más de 30 letras")
    @Pattern(regexp = validationRules.FIRST_LAST_NAME_REGEX, message = "El apellido tiene algún caracter invalido")
    private String apellido;
    
    @NotNull(message = "Se solicita un email")
    @NotEmpty(message = "Se solicita un email")
    @Size(min = validationRules.EMAIL_MIN_SIZE, message = "El email debe tener 10 o más caracteres")
    @Email(message = "error.format.email")
    private String email;

    @NotNull(message = "Se solicita contraseña")
    @NotEmpty(message = "Se solicita contraseña")
    @Size(min = validationRules.PASSWORD_MIN_SIZE, message = "La contraseña debe tener 10 o más caracteres")
    private String contraseña;

    @NotNull(message = "Se solicita confirmación de contraseña")
    @NotEmpty(message = "Se solicita confirmación de contraseña")
    @Size(min = validationRules.PASSWORD_MIN_SIZE, message = "La contraseña debe tener 10 o más caracteres")
    private String confirmacioncontraseña;
    
    @NotNull(message = "Se solicita fecha de nacimiento")
    @NotEmpty(message = "Se solicita fecha de nacimiento")
    private String fechanacimiento;
    
}
