package com.magch.randevu.domain.business.controller;

import com.magch.randevu.domain.business.dto.UserDto;
import com.magch.randevu.domain.business.services.UserService;
import com.magch.randevu.domain.models.BaseResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;


}