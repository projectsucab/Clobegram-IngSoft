package paquete1.amv.controller;

import paquete1.amv.command.UsuarioSignUpCommand;
import paquete1.amv.command.*;
//import paquete1.amv.response.UsuarioResponse;
import paquete1.amv.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
//import java.util.*;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping(value="/usuario", produces = "application/json")


public class UsuarioController {

    @Autowired
    
    private UsuarioService usuarioService;
    
    
    @RequestMapping(value = "/signup", consumes = "application/json", method = RequestMethod.POST)
    public ResponseEntity SignUp (@Valid @RequestBody UsuarioSignUpCommand command) {
        return usuarioService.validacionResgitroUsuario(command);
    }

    @RequestMapping(value = "/signin", consumes = "application/json", method = RequestMethod.POST)
    public ResponseEntity SignIn (@Valid @RequestBody UsuarioSignInCommand command) {
        return usuarioService.SignIn(command);
    }

  /*  @RequestMapping(value = "/gestion/{email}", consumes = "application/json", method = RequestMethod.PUT)
    public ResponseEntity update(@Valid @RequestBody UsuarioGestionCommand command, @PathVariable("email") String email) {
        return usuarioService.actualizarCuenta(command, email);
    }

    @RequestMapping(value = "/search/{name}", method = RequestMethod.GET)
    public ResponseEntity getUsersByName(@PathVariable("name") String name) {
        return userService.getUsersByName(name);
    }


    @RequestMapping(value = "/get/{id}", method = RequestMethod.GET)
    public ResponseEntity getUser(@PathVariable("id") String id) {

        return userService.getUserById(id);
    }*/
}