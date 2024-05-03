package com.api.crud.services;

import com.api.crud.models.UserModel;
import com.api.crud.repositories.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.Optional;

/**
 * Servicio que proporciona métodos para la gestión de usuarios.
 */
@Service
public class UserService {

    @Autowired
    private IUserRepository userRepository;

    /**
     * Obtiene todos los usuarios.
     *
     * @return ArrayList de UserModel con todos los usuarios.
     */
    public ArrayList<UserModel> getUsers() {
        return (ArrayList<UserModel>) userRepository.findAll();
    }

    /**
     * Guarda un nuevo usuario.
     *
     * @param user El UserModel del usuario a guardar.
     * @return El UserModel guardado.
     */
    public UserModel saveUser(UserModel user) {
        return userRepository.save(user);
    }

    /**
     * Obtiene un usuario por su ID.
     *
     * @param id El ID del usuario a buscar.
     * @return Optional de UserModel con el usuario encontrado (si existe).
     */
    public Optional<UserModel> getUser(Long id) {
        return userRepository.findById(id);
    }

    /**
     * Actualiza un usuario existente por su ID.
     *
     * @param request El UserModel actualizado.
     * @param id      El ID del usuario a actualizar.
     * @return El UserModel actualizado, o null si el usuario no existe.
     */
    public UserModel updateUser(UserModel request, Long id) {
        Optional<UserModel> userOptional = userRepository.findById(id);

        if (userOptional.isPresent()) {
            UserModel user = userOptional.get();
            updateUserData(user, request);
            return userRepository.save(user);
        }

        return null; // Usuario no encontrado
    }

    /**
     * Elimina un usuario por su ID.
     *
     * @param id El ID del usuario a eliminar.
     * @return true si se eliminó correctamente, false si ocurrió un error.
     */
    public boolean deleteUser(Long id) {
        try {
            userRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    // Actualiza los datos del usuario con la información proporcionada en la solicitud
    private void updateUserData(UserModel user, UserModel request) {
        user.setDireccion(request.getDireccion());
        user.setFechaRecogida(request.getFechaRecogida());
        user.setNombreEntrega(request.getNombreEntrega());
        user.setApellidoEntrega(request.getApellidoEntrega());
        user.setCelularEntrega(request.getCelularEntrega());
        user.setEmailUsuario(request.getEmailUsuario());
        user.setDescripcionTipoVia(request.getDescripcionTipoVia());
        user.setAplicativo(request.getAplicativo());
    }
}