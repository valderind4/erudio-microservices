package br.com.erudio.controller;

import br.com.erudio.exception.UnSuportedMathOperationException;
import br.com.erudio.math.SimpleMath;
import br.com.erudio.request.converters.NumberConverter;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MathController {

    private SimpleMath math = new SimpleMath();

    @RequestMapping(value = "/sum/{numberOne}/{numberTwo}", method = RequestMethod.GET)
    public Double sum(@PathVariable("numberOne") String numberOne, @PathVariable("numberTwo") String numberTwo) throws Exception {
        if(!NumberConverter.isNumeric(numberOne) || !NumberConverter.isNumeric(numberTwo)){
            throw new UnSuportedMathOperationException("Please set a numeric value!");
        }
        Double sum = math.sum(NumberConverter.convertToDouble(numberOne), NumberConverter.convertToDouble(numberTwo));
        return sum;
    }

    @RequestMapping(value = "/subtraction/{numberOne}/{numberTwo}", method = RequestMethod.GET)
    public Double subtraction(@PathVariable("numberOne") String numberOne, @PathVariable("numberTwo") String numberTwo) throws Exception {
        if(!NumberConverter.isNumeric(numberOne) || !NumberConverter.isNumeric(numberTwo)){
            throw new UnSuportedMathOperationException("Please set a numeric value!");
        }
        Double sub = NumberConverter.convertToDouble(numberOne) - NumberConverter.convertToDouble(numberTwo);
        return sub;
    }

    @RequestMapping(value = "/multiplication/{numberOne}/{numberTwo}", method = RequestMethod.GET)
    public Double multiplication(@PathVariable("numberOne") String numberOne, @PathVariable("numberTwo") String numberTwo) throws Exception {
        if(!NumberConverter.isNumeric(numberOne) || !NumberConverter.isNumeric(numberTwo)){
            throw new UnSuportedMathOperationException("Please set a numeric value!");
        }
        Double mult = NumberConverter.convertToDouble(numberOne) * NumberConverter.convertToDouble(numberTwo);
        return mult;
    }

    @RequestMapping(value = "/division/{numberOne}/{numberTwo}", method = RequestMethod.GET)
    public Double division(@PathVariable("numberOne") String numberOne, @PathVariable("numberTwo") String numberTwo) throws Exception {
        if(!NumberConverter.isNumeric(numberOne) || !NumberConverter.isNumeric(numberTwo)){
            throw new UnSuportedMathOperationException("Please set a numeric value!");
        }
        Double div = NumberConverter.convertToDouble(numberOne) / NumberConverter.convertToDouble(numberTwo);
        return div;
    }

    @RequestMapping(value = "/mean/{numberOne}/{numberTwo}", method = RequestMethod.GET)
    public Double mean(@PathVariable("numberOne") String numberOne, @PathVariable("numberTwo") String numberTwo) throws Exception {
        if(!NumberConverter.isNumeric(numberOne) || !NumberConverter.isNumeric(numberTwo)){
            throw new UnSuportedMathOperationException("Please set   a numeric value!");
        }
        Double mean = (NumberConverter.convertToDouble(numberOne) + NumberConverter.convertToDouble(numberTwo))/2;
        return mean;
    }

    @RequestMapping(value = "/squareRoot/{numberOne}", method = RequestMethod.GET)
    public Double squareRoot(@PathVariable("numberOne") String numberOne) throws Exception {
        if(!NumberConverter.isNumeric(numberOne)){
            throw new UnSuportedMathOperationException("Please set a numeric value!");
        }
        Double sqr = math.squareRoot(NumberConverter.convertToDouble(numberOne));
        return sqr;
    }

}
