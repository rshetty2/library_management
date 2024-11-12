package com.org.lms.view;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CommandParser {
    public void parse(String input) {
        String[] command = input.split(" ");


        switch(command[0]) {
            case "register" -> {
                Pattern fieldPattern = Pattern.compile("^([A-Za-z]+)\\s([A-Za-z]+)\\s([A-Za-z]+)\\s([A-Za-z]+)$");
                Matcher matcher  = fieldPattern.matcher(input);
            }
        }
    }
}
