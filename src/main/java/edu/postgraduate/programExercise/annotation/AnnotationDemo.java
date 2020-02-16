package edu.postgraduate.programExercise.annotation;

@SuppressWarnings("all")
public class AnnotationDemo {
    @Override
    public String toString() {
        return super.toString();
    }

    @Deprecated
    public void show1() {

    }

    @MyAnnotation(value = 12, name = "QRX", num = Numbers.NUM1, anno = @MyAnno)
    public void show2() {

    }


}
