package com.example.personal.zjbj.network;

import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Target;

/**
 * Created by aersas on 2016/10/8.
 */

@Inherited
@Target(ElementType.METHOD)
public @interface POST {
    public enum FontColor{ BlUE,RED,GREEN}
    String name();
    FontColor fontColor() default FontColor.GREEN;
}
