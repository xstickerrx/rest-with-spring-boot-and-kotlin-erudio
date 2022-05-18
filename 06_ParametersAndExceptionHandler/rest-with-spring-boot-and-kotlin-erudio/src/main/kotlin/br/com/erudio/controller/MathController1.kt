package br.com.erudio.controller

import br.com.erudio.exceptions.UnsupportedMathOperationException
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.util.concurrent.atomic.AtomicLong
import kotlin.math.sqrt

@RestController
class MathController1 {

    val counter: AtomicLong = AtomicLong()

    @RequestMapping(value = ["/sum/{numberOne}/{numberTwo}"])
    fun sum(@PathVariable(value = "numberOne")numberOne : String?,
            @PathVariable(value = "numberTwo")numberTwo : String?
    ): Double{

        if(!isNumeric(numberOne) || !isNumeric(numberTwo)) throw UnsupportedMathOperationException("Please set a numeric Value !")
        return convertToDouble(numberOne) + convertToDouble(numberTwo)


    }

    @RequestMapping(value = ["/subtraction/{numberOne}/{numberTwo}"])
    fun subtraction(@PathVariable(value = "numberOne")numberOne : String?,
                    @PathVariable(value = "numberTwo")numberTwo : String?
    ): Double{

        if(!isNumeric(numberOne) || !isNumeric(numberTwo)) throw UnsupportedMathOperationException("Please set a numeric Value !")
        return convertToDouble(numberOne) - convertToDouble(numberTwo)


    }

    @RequestMapping(value = ["/multiplier/{numberOne}/{numberTwo}"])
    fun multiplier(@PathVariable(value = "numberOne")numberOne : String?,
                   @PathVariable(value = "numberTwo")numberTwo : String?
    ): Double{

        if(!isNumeric(numberOne) || !isNumeric(numberTwo)) throw UnsupportedMathOperationException("Please set a numeric Value !")
        return convertToDouble(numberOne) * convertToDouble(numberTwo)


    }

    @RequestMapping(value = ["/division/{numberOne}/{numberTwo}"])
    fun division(@PathVariable(value = "numberOne")numberOne : String?,
                 @PathVariable(value = "numberTwo")numberTwo : String?
    ): Double{

        if(!isNumeric(numberOne) || !isNumeric(numberTwo)) throw UnsupportedMathOperationException("Please set a numeric Value !")
        return convertToDouble(numberOne) / convertToDouble(numberTwo)


    }

    @RequestMapping(value = ["/average/{numberOne}/{numberTwo}"])
    fun average(@PathVariable(value = "numberOne")numberOne : String?,
                @PathVariable(value = "numberTwo")numberTwo : String?
    ): Double{

        if(!isNumeric(numberOne) || !isNumeric(numberTwo)) throw UnsupportedMathOperationException("Please set a numeric Value !")
        return ((convertToDouble(numberOne) + convertToDouble(numberTwo))/2)


    }

    @RequestMapping(value = ["/source/{numberOne}"])
    fun source(@PathVariable(value = "numberOne")numberOne : String?
    ): Double{

        if(!isNumeric(numberOne)) throw UnsupportedMathOperationException("Please set a numeric Value !")
        return sqrt(convertToDouble(numberOne))


    }

    private fun isNumeric(strNumber: String?): Boolean {
        if (strNumber.isNullOrBlank()) return false
        val number = strNumber.replace(",".toRegex(), ".")
        return number.matches("""[-+]?[0-9]*\.?[0-9]+""".toRegex())
    }

    private fun convertToDouble(strNumber: String?): Double {
        if (strNumber.isNullOrBlank()) return 0.0
        val number = strNumber.replace(",".toRegex(), ".")
        return if (isNumeric(number)) number.toDouble() else 0.0
    }


}