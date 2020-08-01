package sample;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;

class MyNumber{
    private DoubleProperty  number = new SimpleDoubleProperty();

    public double getNumber() {
        return number.get();
    }


    public DoubleProperty numberProperty() {
        return number;
    }

    public void setNumber(double number) {
        this.number.set(number);
    }
}

public class Main6Property  {
    public static void main(String[] args) {
        MyNumber myNumberExample = new MyNumber();
        myNumberExample.numberProperty().addListener((observable, oldValue, newValue) -> {
            System.out.println("observable = " + observable);
            System.out.println("oldValue = " + oldValue);
            System.out.println("newValue = " + newValue);
        });
        myNumberExample.setNumber(10);
        myNumberExample.setNumber(20);

    }

}
