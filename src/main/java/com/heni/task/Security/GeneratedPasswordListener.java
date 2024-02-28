package com.heni.task.Security;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationContext;
import org.springframework.context.event.EventListener;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.stereotype.Component;
@RequiredArgsConstructor
@Component
public class GeneratedPasswordListener {

    private final ApplicationContext context;

    @EventListener(ApplicationReadyEvent.class)
    public void getGeneratedPassword() {
        InMemoryUserDetailsManager userDetailsManager = context.getBean(InMemoryUserDetailsManager.class);
        User user = (User) userDetailsManager.loadUserByUsername("user");
        System.out.println("Generated security password: " + user.getPassword());
    }
}
