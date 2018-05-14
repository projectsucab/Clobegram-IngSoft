package paquete1.amv.service;

import static com.sun.activation.registries.LogSupport.log;
import static com.sun.webkit.perf.WCFontPerfLogger.log;
import static java.lang.Math.log;
import paquete1.amv.command.UsuarioSignUpCommand;
import paquete1.amv.repository.*;
import paquete1.amv.model.Usuario;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import lombok.Data;
import org.springframework.http.ResponseEntity;
import paquete1.amv.command.UsuarioSignInCommand;
import paquete1.amv.response.Warning;

@Data
@Slf4j
@Service("usuarioService")

public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

        private Usuario buildUsuario(UsuarioSignUpCommand command) {
        
        Usuario usuario = new Usuario();
        usuario.setNombre(command.getNombre());
        usuario.setApellido(command.getApellido());
        usuario.setEmail(command.getEmail());
        usuario.setContraseña(command.getContraseña());
        usuario.setFechanacimiento(command.getFechanacimiento());

        return usuario;
    }

    public ResponseEntity<Object> validacionResgitroUsuario (UsuarioSignUpCommand command) { 
        log.debug("About to process [{}]", command);

        if(usuarioRepository.foundEmail(command.getEmail())){ 
            log.info("email {} already registered", command.getEmail());
            return ResponseEntity.badRequest().body(buildWarning("Usuario registrado"));
        }
        else if (!command.getContraseña().equals(command.getConfirmacioncontraseña())) { 
                log.info("Mismatching passwords.");
                return ResponseEntity.badRequest().body(buildWarning("No son iguales las contraseñas"));
            }
            else { 
                Usuario usuario = buildUsuario(command);
                usuario = usuarioRepository.save(usuario);
                
                return ResponseEntity.ok().body(buildWarning("Operacion Exitosa."));
            }
    }

    
    private Warning buildWarning(String message){ 

        Warning response = new Warning();
        response.setMessage(message);

        return response;
    }
    
   
    public  ResponseEntity<Object> SignIn (UsuarioSignInCommand command) {
        log.debug("About to process [{}]", command);

        Usuario usuario =usuarioRepository.findEmail(command.getEmail());
        if (usuario == null){
            log.info("email not found={}", command.getEmail());
            return  ResponseEntity.badRequest().body(buildWarning("Email no encontrado"));
        }
        else{
            if(usuario.getContraseña().equals(command.getContraseña())){
                log.info("Account founded for email={}",usuario.getEmail());

                Usuario usuarioser = new Usuario();
                usuarioser.setNombre(usuarioser.getNombre());
                usuarioser.setApellido(usuarioser.getApellido());
                usuarioser.setEmail(usuarioser.getEmail());
                return ResponseEntity.ok(usuarioser);
                
            }
            else {
                
                log.info("password not valid for account= {}",usuario.getEmail());

                return  ResponseEntity.badRequest().body(buildWarning("Clave invalida"));
                
            }
        }
    }


    public List<Usuario> findAccountsEmail(String email) {

        List<Usuario> usuario = usuarioRepository.findFirstEmail(email);

        log.info("Found {} records with the partial email address={}", usuario.size(), email);
        return usuario;
    }
    
   /* public  ResponseEntity<Object> actualizarCuenta (UsuarioSignUpCommand command, String correpElectronico) {
        log.debug("About to process [{}]", command);

        Usuario informacionUsuario =usuarioRepository.findEmail(command.getEmail());
        if (informacionUsuario == null){
            log.info("email not found={}", command.getEmail());
            return  ResponseEntity.badRequest().body(buildWarning("Email no encontrado"));
        }
        else{
                log.info("Account founded for email={}",informacionUsuario.getEmail());

                Usuario usuarioActualizado = new Usuario();
                usuarioActualizado.setNombre(usuarioser.getNombre());
                usuarioActualizado.setApellido(usuarioser.getApellido());
                usuarioActualizado.setEmail(usuarioser.getEmail());
                return ResponseEntity.ok(usuarioser);
            
        }
    }
    
    
   
     public ResponseEntity<Object> actualizarCuenta(UsuarioSignUpCommand command, String email) {
        log.debug("About to process [{}]", command);
        try {
            if (!usuarioRepository.existsById(Long.parseLong(email))) { //se verifica si el id proporcionado es correcto
                log.info("Cannot find user with ID={}", id);

                return ResponseEntity.badRequest().body(buildAlertResponse("invalid_Id"));
            } else {

                String emailOriginal = userRepository.findById(Long.parseLong(id)).get().getEmail();
                String emailNuevo = command.getEmail();
                if ((userRepository.existsByEmail(emailNuevo)) && !(emailNuevo.equals(emailOriginal))) { // se revisa si el email ya existe en la base de datos
                    log.info("email {} already registered", command.getEmail());

                    return ResponseEntity.badRequest().body(buildAlertResponse("El email ya se encuentra registrado en el sistema."));
                } else {    //se actualiza la informacion del usuario
                    User user = buildExistingUser(command, id);
                    user = userRepository.save(user);

                    log.info("Updated user with ID={}", user.getId());

                    return ResponseEntity.ok().body(buildAlertResponse("Operación Exitosa."));
                }
            }
        } catch(NumberFormatException e){
            log.info("Cannot find user with ID={}", id);

            return ResponseEntity.badRequest().body(buildAlertResponse("invalid_Id"));
        }
    }
  */  
    
    
    
}







