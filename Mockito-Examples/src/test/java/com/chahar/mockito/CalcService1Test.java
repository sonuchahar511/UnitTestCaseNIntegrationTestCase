package com.chahar.mockito;

import com.chahar.AddService;
import com.chahar.CalcService;
//import org.apache.commons.logging.Log;
//import org.apache.commons.logging.LogFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

public class CalcService1Test {
    private static Logger logger = LogManager.getLogger(CalcService1Test.class);

    @Test
    void testCalc() {
        logger.info("**--- Test testCalc executed ---**");

        AddService addService;
        CalcService calcService;

        addService = Mockito.mock(AddService.class);
        calcService = new CalcService(addService);

        int num1 = 11;
        int num2 = 12;
        int expected = 23;

        when(addService.add(num1, num2)).thenReturn(expected);

        int actual = calcService.calc(num1, num2);

        assertEquals(expected, actual);

    }
}
