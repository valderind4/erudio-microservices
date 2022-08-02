package br.com.erudio.controller;

import br.com.erudio.exception.UnSuportedMathOperationException;
import br.com.erudio.service.NumberConverter;
import br.com.erudio.service.SimpleMath;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MathController {

    @Autowired
    private SimpleMath math;
    @Autowired
    private NumberConverter numberConverter;

    @RequestMapping(value = "/sum/{numberOne}/{numberTwo}", method = RequestMethod.GET)
    public Double sum(@PathVariable("numberOne") String numberOne, @PathVariable("numberTwo") String numberTwo) throws Exception {
        if(!numberConverter.isNumeric(numberOne) || !numberConverter.isNumeric(numberTwo)){
            throw new UnSuportedMathOperationException("Please set a numeric value!");
        }
        Double sum = math.sum(numberConverter.convertToDouble(numberOne), numberConverter.convertToDouble(numberTwo));
        return sum;
    }

    @RequestMapping(value = "/subtraction/{numberOne}/{numberTwo}", method = RequestMethod.GET)
    public Double subtraction(@PathVariable("numberOne") String numberOne, @PathVariable("numberTwo") String numberTwo) throws Exception {
        if(!numberConverter.isNumeric(numberOne) || !numberConverter.isNumeric(numberTwo)){
            throw new UnSuportedMathOperationException("Please set a numeric value!");
        }
        Double sub = numberConverter.convertToDouble(numberOne) - numberConverter.convertToDouble(numberTwo);
        return sub;
    }

    @RequestMapping(value = "/multiplication/{numberOne}/{numberTwo}", method = RequestMethod.GET)
    public Double multiplication(@PathVariable("numberOne") String numberOne, @PathVariable("numberTwo") String numberTwo) throws Exception {
        if(!numberConverter.isNumeric(numberOne) || !numberConverter.isNumeric(numberTwo)){
            throw new UnSuportedMathOperationException("Please set a numeric value!");
        }
        Double mult = numberConverter.convertToDouble(numberOne) * numberConverter.convertToDouble(numberTwo);
        return mult;
    }

    @RequestMapping(value = "/division/{numberOne}/{numberTwo}", method = RequestMethod.GET)
    public Double division(@PathVariable("numberOne") String numberOne, @PathVariable("numberTwo") String numberTwo) throws Exception {
        if(!numberConverter.isNumeric(numberOne) || !numberConverter.isNumeric(numberTwo)){
            throw new UnSuportedMathOperationException("Please set a numeric value!");
        }
        Double div = numberConverter.convertToDouble(numberOne) / numberConverter.convertToDouble(numberTwo);
        return div;
    }

    @RequestMapping(value = "/mean/{numberOne}/{numberTwo}", method = RequestMethod.GET)
    public Double mean(@PathVariable("numberOne") String numberOne, @PathVariable("numberTwo") String numberTwo) throws Exception {
        if(!numberConverter.isNumeric(numberOne) || !numberConverter.isNumeric(numberTwo)){
            throw new UnSuportedMathOperationException("Please set   a numeric value!");
        }
        Double mean = (numberConverter.convertToDouble(numberOne) + numberConverter.convertToDouble(numberTwo))/2;
        return mean;
    }

    @RequestMapping(value = "/squareRoot/{numberOne}", method = RequestMethod.GET)
    public Double squareRoot(@PathVariable("numberOne") String numberOne) throws Exception {
        if(!numberConverter.isNumeric(numberOne)){
            throw new UnSuportedMathOperationException("Please set a numeric value!");
        }
        Double sqr = math.squareRoot(numberConverter.convertToDouble(numberOne));
        return sqr;
    }

}
