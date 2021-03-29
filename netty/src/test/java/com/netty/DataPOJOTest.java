package com.netty;

import com.heller.netty.DataPOJO;
import org.junit.Test;

public class DataPOJOTest {
    @Test
    private void proto() {
        DataPOJO.Data data = DataPOJO.Data.newBuilder().setId(1).setName("a").build();

    }
}