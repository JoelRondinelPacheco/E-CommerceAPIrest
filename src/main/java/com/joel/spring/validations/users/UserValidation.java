package com.joel.spring.validations.users;

import com.joel.spring.dtos.users.InvalidFieldDTO;
import com.joel.spring.dtos.users.LoginDTO;
import com.joel.spring.dtos.users.UserPostReqDTO;

import java.util.ArrayList;
import java.util.List;

public class UserValidation {

    public List<InvalidFieldDTO> registerValidation(UserPostReqDTO user) {
        List<InvalidFieldDTO> response = new ArrayList<>();


        if (user.getFirstName() == null || user.getFirstName().length() < 3 || user.getFirstName().length() > 15) {
            response.add(new InvalidFieldDTO("firstName", "El campo firstName no puede ser nulo, y tiene que tener entre 3 y 15 caracteres"));
        }

        if (user.getLastName() == null || user.getLastName().length() < 3 || user.getLastName().length() > 30) {
            response.add(new InvalidFieldDTO("lastName", "El campo lastName no puede ser nulo, y tiene que tener entre 3 y 30 caracteres"));
        }

        if (user.getEmail() == null || !user.getEmail().matches("^(?=.{1,64}@)[A-Za-z0-9_-]+(\\.[A-Za-z0-9_-]+)*@[^-][A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$")) {
            response.add(new InvalidFieldDTO("email", "El email no es valido"));
        }

        if (user.getPassword() == null || !user.getPassword().matches("^(?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[a-zA-Z]).{8,16}$")) {
            response.add(new InvalidFieldDTO("password", "La contraseña debe tener entre 8 y 6 caracteress, al menos un numero, una minuscula y una mayuscula"));
        }
        return response;
    }

    public List<InvalidFieldDTO> loginValidation(LoginDTO login) {
        List<InvalidFieldDTO> response = new ArrayList<>();
        if (login.getEmail().isBlank() || !login.getEmail().matches("^(?=.{1,64}@)[A-Za-z0-9_-]+(\\.[A-Za-z0-9_-]+)*@[^-][A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$")) {
            response.add(new InvalidFieldDTO("email", "Ingrese un email valido"));
        }

        if (login.getPassword().isBlank()) {
            response.add(new InvalidFieldDTO("password", "Contraseña invalida"));
        }

        return response;
    }


}
