package simcorp.stock.profit.calculator.utils;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class InputValidatorTest {
    @Test
    void test_isValidStockName_ReturnsTrue() {
        String stockName = "TSLA";
        boolean isValid = InputValidator.isValidStockName(stockName);
        assertTrue(isValid);
    }

    @Test
    void test_withEmptyStockName_ReturnsFalse() {
        String stockName = "";
        boolean isValid = InputValidator.isValidStockName(stockName);
        assertTrue(!isValid);
    }

    @Test
    void test_withNullStockName_ReturnsFalse() {
        String stockName = null;
        boolean isValid = InputValidator.isValidStockName(stockName);
        assertTrue(!isValid);
    }

    @Test
    void test_isValidYear_ReturnsTrue() {
        String yearStr = "2020";
        boolean isValid = InputValidator.isValidYear(yearStr);
        assertTrue(isValid);
    }

    @Test
    void test_withEmptyYear_ReturnsFalse() {
        String yearStr = "";
        boolean isValid = InputValidator.isValidYear(yearStr);
        assertTrue(!isValid);
    }
}
