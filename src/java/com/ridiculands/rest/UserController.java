package com.ridiculands.rest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    private final static Logger LOGGER = LoggerFactory.getLogger(UserController.class);

    @GetMapping(value="/userinfo/name")
    @ResponseBody
    public String userFullName(@AuthenticationPrincipal OidcUser oidcUser) {
        LOGGER.info("Calling /userinfo/name, oidcUser {}", oidcUser);
        return "Welcome, " + oidcUser.getFullName();
    }

    @GetMapping(value="/userinfo/attributes")
    @ResponseBody
    public String userAttribute(@AuthenticationPrincipal OidcUser oidcUser) {
        LOGGER.info("Calling /userinfo/name, oidcUser {}", oidcUser);
        return oidcUser.getAttributes().toString();
    }

    @GetMapping(value="/userinfo/authorities")
    @ResponseBody
    public String userAuthorities(@AuthenticationPrincipal OidcUser oidcUser) {
        LOGGER.info("Calling /userinfo/name, oidcUser {}", oidcUser);
        return "Welcome, " + oidcUser.getAuthorities().toString();
    }

}
