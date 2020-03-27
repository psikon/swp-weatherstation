package com.swp.weatherstation.utils;

import java.util.Scanner;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Component
public class ConsoleView {

    public void welcome() {
        System.out.println(
                "##############################\n" +
                "#   Open Weather Station   ###\n" +
                "##############################\n\n");
    }

    public String getLocation() {
        System.out.println("Type in our location:");
        return getInput();
    }

    private String getInput() {
        return new Scanner(System.in).nextLine().trim();
    }

    public void setOutput(String output) {
        System.out.println(output);
    }
}
