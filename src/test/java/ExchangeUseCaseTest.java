import core.usecases.ExchangeUseCase;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import static org.junit.Assert.*;

@RunWith(JUnit4.class)
public class ExchangeUseCaseTest {

    private ExchangeUseCase exchangeUseCase;
    private Double testCurrFromRate = 2.0;
    private Double testCurrToRate = 4.0;
    private Double testAmount = 100.0;

    @Before
    public void setUp() {
        exchangeUseCase = new ExchangeUseCase(testCurrFromRate, testCurrToRate, testAmount);
    }

    @Test
    public void testExchange() {
        double result = exchangeUseCase.invokeAndReturn();
        System.out.println(result);
        assertTrue(result == 50.0);
    }
}
