package com.fastinjava.service.demo2.demo;

import org.springframework.http.server.PathContainer;
import org.springframework.web.util.pattern.PathPattern;
import org.springframework.web.util.pattern.PathPatternParser;

public class Main7 {
    public static void main(String[] args) {
        PathPatternParser pathPatternParser = new PathPatternParser();
        PathPattern pathPattern = pathPatternParser.parse("/abc*");
        PathContainer pathContainer = PathContainer.parsePath("/abc2k");
        boolean matches = pathPattern.matches(pathContainer);
        System.out.println(matches);
    }
}
