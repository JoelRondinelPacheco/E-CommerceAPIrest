package com.joel.spring.validations.users;

import com.joel.spring.user.dto.AuthResDTO;
import com.joel.spring.user.dto.UserCredentialsDTO;
import com.joel.spring.user.dto.UserPostReqDTO;

import java.util.ArrayList;
import java.util.List;

public class UserValidation {

    public List<AuthResDTO> registerValidation(UserPostReqDTO user) {
        List<AuthResDTO> response = new ArrayList<>();


        if (user.getFirstName() == null || user.getFirstName().length() < 3 || user.getFirstName().length() > 15) {
            response.add(new AuthResDTO("firstName", "El campo firstName no puede ser nulo, y tiene que tener entre 3 y 15 caracteres"));
        }

        if (user.getLastName() == null || user.getLastName().length() < 3 || user.getLastName().length() > 30) {
            response.add(new AuthResDTO("lastName", "El campo lastName no puede ser nulo, y tiene que tener entre 3 y 30 caracteres"));
        }

        if (user.getEmail() == null || user.getEmail().isBlank() || !user.getEmail().matches("^(?=.{1,64}@)[A-Za-z0-9_-]+(\\.[A-Za-z0-9_-]+)*@[^-][A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$")) {
            response.add(new AuthResDTO("email", "El email no es valido"));
        }

        if (user.getPassword() == null || user.getPassword().isEmpty() || !user.getPassword().matches("^(?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[a-zA-Z]).{8,16}$")) {
            response.add(new AuthResDTO("password", "La contraseña debe tener entre 8 y 6 caracteress, al menos un numero, una minuscula y una mayuscula"));
        }
        return response;
    }

    public List<AuthResDTO> loginValidation(UserCredentialsDTO login) {
        List<AuthResDTO> response = new ArrayList<>();
        if (login.getEmail() == null || login.getEmail().isBlank() || !login.getEmail().matches("^(?=.{1,64}@)[A-Za-z0-9_-]+(\\.[A-Za-z0-9_-]+)*@[^-][A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$")) {
            response.add(new AuthResDTO("email", "Ingrese un email valido"));
        }

        if (login.getEmail() == null || login.getPassword().isBlank()) {
            response.add(new AuthResDTO("password", "Contraseña invalida"));
        }

        return response;
    }


}
