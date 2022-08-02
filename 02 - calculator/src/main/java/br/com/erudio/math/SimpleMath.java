package br.com.erudio.math;

import br.com.erudio.exception.UnSuportedMathOperationException;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import static br.com.erudio.request.converters.NumberConverter.convertToDouble;
import static br.com.erudio.request.converters.NumberConverter.isNumeric;

public class SimpleMath {

    public Double sum( Double numberOne,  Double numberTwo)  {
        return numberOne + numberTwo;
    }

    public Double subtraction(Double numberOne, Double numberTwo) {
        return numberOne - numberTwo;
    }

    public Double multiplication(Double numberOne,  Double numberTwo)  {
        return numberOne * numberTwo;
    }

    public Double division( Double numberOne, Double numberTwo){

        return numberOne / numberTwo;
    }

    public Double mean(Double numberOne,Double numberTwo) {
         return (Double) (numberOne + numberTwo)/2;
    }

    public Double squareRoot(Double numberOne){
       return Math.sqrt(numberOne);
    }
}
