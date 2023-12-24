package com.joel.spring.controllers;

import com.joel.spring.dtos.users.UserEditReqDTO;
import com.joel.spring.dtos.users.UserPersonalInfoDTO;
import com.joel.spring.entities.UserEntity;
import com.joel.spring.exceptions.NotFoundException;
import com.joel.spring.services.IUserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clients")
public class ClientController {
    @Autowired
    private IUserService userService;

    @GetMapping
    public List<UserEntity> getAll () { return this.userService.getAll(); }

    @Operation(summary = "Get user By Id", description = "Retrive personal information from the user id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "OK. Usuario encontrado", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = UserPersonalInfoDTO.class))
            }),
            @ApiResponse(responseCode = "404", description = "Not found. No existe un usuario con ese id", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = String.class), examples = {
                            @ExampleObject(value = "User not found")
                    })}),
            @ApiResponse(responseCode = "400", description = "Bad Request. No se porporciono un body valido", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = String.class)) }
            )}
    )
    @Parameter(in = ParameterIn.PATH, name = "userId", required = true, description = "Id of the user to be searched", example = "dfsfds")
    @Parameter(in = ParameterIn.HEADER, required = true, name = "Authorization", description = "Authorization token")
    @GetMapping("/{userId}")
    public ResponseEntity<UserPersonalInfoDTO> getById (@PathVariable String userId) throws NotFoundException {
        return new ResponseEntity<>(this.userService.getUserPersonalInfo(userId), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{clientId}")
    public ResponseEntity<String> delete(@PathVariable String clientId) {
        this.userService.delete(clientId);
        return new ResponseEntity<>("Deleted", HttpStatus.OK);
    }

    @PutMapping("/edit")
    public ResponseEntity<UserEntity> edit(@RequestBody UserEditReqDTO body) throws NotFoundException {
        UserEntity userEntity = this.userService.update(body);
        return new ResponseEntity<UserEntity>(userEntity, HttpStatus.OK);
    }


}
