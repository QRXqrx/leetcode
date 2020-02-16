package edu.postgraduate.programExercise.annotation;

public @interface MyAnnotation {
    int value();
    String name();
    Numbers num();
    MyAnno anno(); // 不能加@

}
