package paquete1.amv.command;

import javax.validation.constraints.*;
import java.io.Serializable;
import lombok.*;

@Data
@ToString


public class UsuarioGestionCommand implements Serializable {

    @NotNull(message = "Se solicita un nuevo nombre")
    @NotEmpty(message = "Se solicita un nuevo nombre")    
    @Size(min = validationRules.FIRST_LAST_NAME_MAX_SIZE, message = "El nombre no puede tener más de 30 letras")
    @Pattern(regexp = validationRules.FIRST_LAST_NAME_REGEX, message = "El nombre tiene algún caracter invalido")
    private String nombre;
    

    @NotNull(message = "Se solicita un nuevo apellido")
    @NotEmpty(message = "Se solicita un nuevo apellido")
    @Size(min = validationRules.FIRST_LAST_NAME_MAX_SIZE, message = "El apellido no puede tener más de 30 letras")
    @Pattern(regexp = validationRules.FIRST_LAST_NAME_REGEX, message = "El apellido tiene algún caracter invalido")
    private String apellido;
    

    @NotNull(message = "Se solicita un nuevo email")
    @NotEmpty(message = "Se solicita un nuevo email")    
    @Size(min = validationRules.EMAIL_MIN_SIZE, message = "El email debe tener 10 o más caracteres")
    @Email(message = "error.format.email")
    private String email;
    
    
    @NotNull(message = "Se solicita una nueva contraseña")
    @NotEmpty(message = "Se solicita una nueva contraseña")
    @Size(min = validationRules.PASSWORD_MIN_SIZE, message = "La contraseña debe tener 10 o más caracteres")
    private String contraseña;
    
    
    @NotNull(message = "Se solicita una nueva fecha de nacimiento")
    @NotEmpty(message = "Se solicita una nueva fecha de nacimiento")
    private String fechanacimiento; 
}
