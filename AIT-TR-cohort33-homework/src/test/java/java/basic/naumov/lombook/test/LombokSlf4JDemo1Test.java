package java.basic.naumov.lombook.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Test;

import lombok.extern.slf4j.Slf4j;
import basic.naumov.lombook.LombokSlf4jDemo1;

@Slf4j
public class LombokSlf4JDemo1Test {

    @Test
    public void testGetSurchargeWithValidTransaction() {
        LombokSlf4jDemo1 demo1 = new LombokSlf4jDemo1();
        double transaction = 100.0;
        double surcharge = demo1.getSurcharge(transaction);

        assertEquals(Math.PI, surcharge, 0.001);
    }

    @Test
    public void testGetSurchargeWithInvalidTransaction() {
        LombokSlf4jDemo1 demo1 = new LombokSlf4jDemo1();
        double transaction = Double.NaN;

        try {
            demo1.getSurcharge(transaction);
            fail("Expected RuntimeException");
        } catch (RuntimeException e) {
            // Проверяем, что исключение успешно брошено
            assertNotNull(e);
            // Проверяем, что сообщение об ошибке было залогировано
            log.error("Invalid Transaction");
        }
    }
}
