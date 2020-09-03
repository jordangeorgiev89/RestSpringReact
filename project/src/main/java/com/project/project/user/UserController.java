package com.project.project.user;

import com.project.project.shared.GenericResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("/api/1.0/users")
    GenericResponse createUser(@Valid @RequestBody User user, BindingResult bindingResult) {
        if      (user.getUsername() == null ||
                user.getDisplayName() == null ||
                user.getPassword() == null ||
                user.getUsername().length() <= 3 ||
                user.getDisplayName().length() <= 3 ||
                user.getPassword().length() <= 8)
        {
            throw new UserNotValidException();
        }

        if (bindingResult.hasErrors()) {
            throw new UserNotValidException();
        }
        userService.save(user);

        return new GenericResponse("User Saved");
    }
}
