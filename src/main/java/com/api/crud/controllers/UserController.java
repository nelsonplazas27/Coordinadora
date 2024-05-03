package com.api.crud.controllers;

import com.api.crud.models.UserModel;
import com.api.crud.services.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Controlador para la gestión de usuarios en la API.
 */
@RestController
@RequestMapping("/user")
@Validated
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * Método para obtener todos los usuarios.
     *
     * @return ArrayList de UserModel con todos los usuarios.
     */
    @GetMapping
    public ArrayList<UserModel> getAllUsers() {
        return userService.getUsers();
    }

    /**
     * Método para guardar un nuevo usuario.
     *
     * @param user   El UserModel del usuario a guardar.
     * @param result El resultado de la validación del objeto UserModel.
     * @return ResponseEntity con el usuario guardado o mensajes de error en caso de validación fallida.
     */
    @PostMapping
    public ResponseEntity<?> saveUser(@Valid @RequestBody UserModel user, BindingResult result) {
        // Verificar si hay errores de validación
        if (result.hasErrors()) {
            // Obtener los errores de validación
            List<FieldError> errors = result.getFieldErrors();
            // Crear una lista para almacenar los mensajes de error
            List<String> errorMessages = new ArrayList<>();
            // Iterar sobre los errores y obtener los mensajes
            for (FieldError error : errors) {
                errorMessages.add(error.getDefaultMessage());
            }
            // Devolver una respuesta con los mensajes de error
            return ResponseEntity.badRequest().body(errorMessages);
        }

        // Si no hay errores de validación, guardar el usuario y devolver una respuesta exitosa
        UserModel savedUser = userService.saveUser(user);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedUser);
    }

    /**
     * Método para obtener un usuario por su ID.
     *
     * @param id El ID del usuario a buscar.
     * @return Optional de UserModel con el usuario encontrado (si existe).
     */
    @GetMapping(path = "/{id}")
    public Optional<UserModel> getUserById(@PathVariable long id) {
        return userService.getUser(id);
    }

    /**
     * Método para actualizar un usuario existente por su ID.
     *
     * @param request El UserModel actualizado.
     * @param id      El ID del usuario a actualizar.
     * @return El UserModel actualizado.
     */
    @PutMapping(path = "/{id}")
    public UserModel updateUserById(@RequestBody UserModel request, @PathVariable Long id) {
        return userService.updateUser(request, id);
    }

    /**
     * Método para eliminar un usuario por su ID.
     *
     * @param id El ID del usuario a eliminar.
     * @return ResponseEntity con un mensaje indicando si se eliminó correctamente o no.
     */
    @DeleteMapping(path = "/{id}")
    public ResponseEntity<String> deleteUserById(@PathVariable long id) {
        boolean ok = userService.deleteUser(id);

        if (ok) {
            return ResponseEntity.ok("User with ID " + id + " deleted");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User with ID " + id + " not found");
        }
    }
}
