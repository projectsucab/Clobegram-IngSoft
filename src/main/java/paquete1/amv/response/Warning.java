package paquete1.amv.response;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;


@Data

public class Warning {
    
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private String message;

}