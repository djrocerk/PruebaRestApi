package com.example.pruebarestapi.service.impl;

import com.example.pruebarestapi.dto.AuthRestDTO;
import com.example.pruebarestapi.dto.AuthRestRegisterDTO;
import com.example.pruebarestapi.model.AuthModel;
import com.example.pruebarestapi.repository.AuthRepository;
import com.example.pruebarestapi.security.JwtUtil;
import com.example.pruebarestapi.service.AuthService;
import com.example.pruebarestapi.service.PersonService;
import com.example.pruebarestapi.swagger.schema.MessageResponseSchema;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Slf4j
@Service
public class AuthServiceImpl implements AuthService {
    private final AuthRepository authRepository;
    private final JwtUtil jwtUtil;
    private final PersonService personService;

    public AuthServiceImpl(AuthRepository authRepository, JwtUtil jwtUtil, PersonService personService) {
        this.authRepository = authRepository;
        this.jwtUtil = jwtUtil;
        this.personService = personService;
    }

    @Override
    public Map<String, Object> register(AuthRestRegisterDTO authDto) {
        Map<String, Object> response = new HashMap<>();
        try {
            AuthModel authModel = new AuthModel();
            authModel.setUser(authDto.getAuth().getUser());
            authModel.setPass(authDto.getAuth().getPass());
            authModel = authRepository.save(authModel);
            AuthRestRegisterDTO authRestRegisterDTO = personService.created(authDto.getPerson(), authModel);
            response.put("status", HttpStatus.OK);
            response.put("data", authRestRegisterDTO);
        } catch (Exception e) {
            log.info("Error Exception");
            log.info(e.getMessage());
            MessageResponseSchema message = new MessageResponseSchema("Error en el proceso");
            response.put("status", HttpStatus.INTERNAL_SERVER_ERROR);
            response.put("data", message);
        }
        return response;
    }

    @Override
    public Map<String, Object> login(AuthRestDTO authDto) {
        Map<String, Object> response = new HashMap<>();
        MessageResponseSchema message = new MessageResponseSchema();
        try {
            AuthModel authModel = authRepository.findByUserAndPass(authDto.getUser(), authDto.getPass());
            String token = jwtUtil.createToken(authModel);
            response.put("status", HttpStatus.OK);
            message.setMessage("Token: " + token);
        } catch (BadCredentialsException e) {
            log.info("Error BadCredentialsException");
            log.info(e.getMessage());
            response.put("status", HttpStatus.BAD_REQUEST);
            message.setMessage("Token: " + "Credenciales invalidas");
        } catch (Exception e) {
            log.info("Error Exception");
            log.info(e.getMessage());
            response.put("status", HttpStatus.INTERNAL_SERVER_ERROR);
            message.setMessage("Error en el proceso");
        }
        log.info(message.getMessage());
        response.put("data", message);
        return response;
    }
}
