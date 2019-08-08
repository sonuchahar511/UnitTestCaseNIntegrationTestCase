package com.chahar.mockito.exception;

import org.testng.annotations.Test;

import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.testng.Assert.assertThrows;

class TestNGMockitoStubExceptions {

    @SuppressWarnings("unchecked")
    @Test
    void test() {
        List<String> list = mock(List.class);
        when(list.size()).thenThrow(new RuntimeException("size() method not supported"));

        assertThrows(RuntimeException.class, () -> list.size());
    }

    @SuppressWarnings("unchecked")
    @Test(expectedExceptions = RuntimeException.class, expectedExceptionsMessageRegExp = "size method not supported")
    void test1() {
        List<String> list = mock(List.class);
        when(list.size()).thenThrow(new RuntimeException("size method not supported"));
        list.size();
    }

}
