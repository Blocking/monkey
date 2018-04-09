package com.look.nio;

import java.nio.ByteBuffer;
import java.util.Arrays;

import org.junit.Test;

/**
 * Created by 12232 on 2017/8/29.
 * nio buffer学习
 */
public class Day01 {


    @Test
    public void name() throws Exception {
        buffer();
    }

    public void buffer(){
        ByteBuffer buffer = ByteBuffer.allocate(10);
        buffer.put((byte)'H').put((byte)'e').put((byte)'l').put((byte) 'l').put((byte) 'o');
        buffer.put(0,(byte)'M').put(1,(byte) 'w');
        System.out.println(buffer);
        byte[] myByteArray = new byte[10];
        for (int i = 0; buffer.hasRemaining(); i++) {
            byte b = buffer.get();
            System.out.println(b);
            myByteArray[i] = b;
        }
        System.out.println(Arrays.toString(myByteArray));
    }

}
