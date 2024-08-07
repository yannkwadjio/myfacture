package com.myfacture.controller.api;

import com.myfacture.services.interfaces.UtilisateurInterfaces;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/users/")
@RequiredArgsConstructor
public class UtilisateurApi {
    private final UtilisateurInterfaces utilisateurInterfaces;

}
