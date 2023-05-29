package com.ridiculands.solid.srp;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.mockito.Mockito.*;

@ExtendWith(SpringExtension.class)
public class OrderProcessorTest {

    @Mock
    OrderProcessor.OrderValidator validator;

    @Test
    public void testValidate() {
        when(validator.validate()).thenReturn(Boolean.FALSE);
    }

}
