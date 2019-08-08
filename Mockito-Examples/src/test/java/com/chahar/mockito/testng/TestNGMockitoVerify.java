package com.chahar.mockito.testng;

import org.mockito.Mockito;
import org.mockito.internal.verification.VerificationModeFactory;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.verify;

public class TestNGMockitoVerify {
    @Test
    public void test_mockito_verify() {


        @SuppressWarnings("unchecked")
//		List<String> mockedList = Mockito.mock(List.class);

                List<String> list = new ArrayList<>();
        List<String> mockedList = Mockito.mock(list.getClass());

        mockedList.add("first-element");
        mockedList.add("second-element");
        mockedList.add("third-element");
        mockedList.add("third-element");
        mockedList.clear();

        verify(mockedList).add("first-element");
        verify(mockedList).add("second-element");
        verify(mockedList, VerificationModeFactory.times(2)).add("third-element");

        verify(mockedList).clear();

    }
}
