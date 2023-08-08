package com.example.pruebarestapi.service;

import com.example.pruebarestapi.dto.AuthRestDTO;
import com.example.pruebarestapi.dto.AuthRestRegisterDTO;
import com.example.pruebarestapi.dto.ResponseJsonDto;

import java.util.Map;

public interface AuthService {
    Map<String, Object> register(AuthRestRegisterDTO authDto);

    Map<String, Object> login(AuthRestDTO authDto);
}
