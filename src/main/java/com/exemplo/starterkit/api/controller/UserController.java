package com.exemplo.starterkit.api.controller;

import com.exemplo.starterkit.api.dto.UserDTO;
import com.exemplo.starterkit.domain.model.User;
import com.exemplo.starterkit.domain.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/users", produces = {"application/json"})
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private ModelMapper modelMapper;

    public UserController(UserService userService) {
        this.userService = userService;
    }


    @Operation(summary = "Lista o todos os usuários cadastrados", method = "GET")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Lista de usuários exibida com sucesso")
    })
    @GetMapping
    public ResponseEntity<List<UserDTO>> list (){
        return ResponseEntity.ok().body(userService.list()
                .stream().map(x -> modelMapper.map(x, UserDTO.class)).collect(Collectors.toList()));
    }

    @Operation(summary = "Realiza cadastro de um novo usuário", method = "POST")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Usuário cadastrado com sucesso"),
            @ApiResponse(responseCode = "400", description = "E-mail já cadastrado")
    })
    @PostMapping
    public ResponseEntity<User> createUser (@RequestBody @Valid UserDTO userDTO){
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(userService.createUser(userDTO));
    }

    @Operation(summary = "Realiza busca por usuário através do ID", method = "GET")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Usuário encontrado com sucesso"),
            @ApiResponse(responseCode = "404", description = "Usuário não encontrado")
    })
    @GetMapping("/{id}")
    public ResponseEntity<UserDTO> searchUserId (@PathVariable Long id){
        return ResponseEntity.ok().
                body(modelMapper.map(userService.searchUserId(id), UserDTO.class));
    }


    @Operation(summary = "Exclui usuário através do ID", method = "DELETE")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Usuário excluído com sucesso"),
            @ApiResponse(responseCode = "404", description = "Usuário não encontrado")
    })
    @DeleteMapping("/{id}")
    public ResponseEntity<UserDTO> deleteUser(@PathVariable Long id){
        userService.deleteUser(id);
        return ResponseEntity.noContent().build();
    }


    @Operation(summary = "Atualiza dados de usuário cadastrado", method = "PUT")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "400", description = "E-mail já cadastrado"),
            @ApiResponse(responseCode = "200", description = "Usuário atualizado com sucesso")
    })
    @PutMapping("/{id}")
    public ResponseEntity<UserDTO> update (@RequestBody @Valid UserDTO userDTO, @PathVariable Long id){
        return ResponseEntity.ok().body(modelMapper.map(userService.update(userDTO), UserDTO.class));
    }

}
