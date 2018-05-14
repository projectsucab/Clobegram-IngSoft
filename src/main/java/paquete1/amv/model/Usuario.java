package paquete1.amv.model;

import lombok.*;
import java.io.Serializable;
//import org.springframework.data.mongodb.core.*;

@ToString
@Data public class Usuario implements Serializable {

    private String nombre;
    private String apellido;
    private String email;
    private String contraseña;   
    private String fechanacimiento;
}