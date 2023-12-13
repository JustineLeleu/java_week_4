package com.example.challenge1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Value;

@Service
@PropertySource("classpath:application.properties")
public class GreetingsService
{
    @Autowired
    Environment environment;

    private final String request;

    GreetingsService(@Value("${configured_language}") String language)
    {
        this.request = language + "_hello_world";
    }

    public String getMessage()
    {
        return environment.getProperty(this.request);
    }
}