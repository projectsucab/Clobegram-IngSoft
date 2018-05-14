package paquete1.amv.response;

import lombok.*;

@Data
@ToString


public class UsuarioResponse {

    private String nombre;
    private String apellido;
    private String email;
    private String fechanacimiento;
    
}