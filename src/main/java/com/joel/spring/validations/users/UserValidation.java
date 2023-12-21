package com.joel.spring.validations.users;

import com.joel.spring.dtos.users.LoginResDTO;
import com.joel.spring.entities.UserEntity;

public class UserValidation {

    public LoginResDTO validate(UserEntity user) {
        LoginResDTO response = new LoginResDTO();

        response.setNumOfErrors(0);

        if (user.getFirstName() == null || user.getFirstName().length() < 3 || user.getFirstName().length() > 15) {
            response.setNumOfErrors(response.getNumOfErrors() + 1);
            response.setMessage("El campo firstName no puede ser nulo, y tiene que tener entre 3 y 15 caracteres");
        }

        if (user.getLastName() == null || user.getLastName().length() < 3 || user.getLastName().length() > 30) {
            response.setNumOfErrors(response.getNumOfErrors() + 1);
            response.setMessage("El campo lastName no puede ser nulo, y tiene que tener entre 3 y 30 caracteres");
        }

        if (user.getEmail() == null || !user.getEmail().matches("^(?=.{1,64}@)[A-Za-z0-9_-]+(\\.[A-Za-z0-9_-]+)*@[^-][A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$")) {
            response.setNumOfErrors(response.getNumOfErrors() + 1);
            response.setMessage("El email no es valido");
        }

        if (user.getPassword() == null || !user.getPassword().matches("^(?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[a-zA-Z]).{8,16}$")) {
            response.setNumOfErrors(response.getNumOfErrors() + 1);
            response.setMessage("La contraseña debe tener entre 8 y 6 caracteress, al menos un numero, una minuscula y una mayuscula");
        }

        return response;
    }


}
