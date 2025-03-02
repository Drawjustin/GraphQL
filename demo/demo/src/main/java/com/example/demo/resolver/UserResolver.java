package com.example.demo.resolver;

import com.example.demo.entity.user.User;
import com.example.demo.input.AddUserInput;
import com.example.demo.service.UserService;
import org.apache.coyote.BadRequestException;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

@Controller
public class UserResolver {
    private final UserService userService;

    public UserResolver(UserService userService) {
        this.userService = userService;
    }

    @QueryMapping
    User getUser(@Argument String userId) throws BadRequestException {
        return userService.getUser(userId);
    }
    @MutationMapping
    public User addUser(@Argument AddUserInput addUserInput) {
        return userService.addUser(addUserInput);
    }
}
