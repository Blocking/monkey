package com.look.nio;

import org.junit.Test;

import java.nio.CharBuffer;
import java.util.Arrays;

/**
 * Created by 12232 on 2017/9/9.
 */
public class Day03 {


    @Test
    public void t(){
        CharBuffer buffer = CharBuffer.allocate(10);
        buffer.put("abcdefghioppp",0,5);
        buffer.flip();
       char[] bigchar = new char[1000];
       int length = buffer.remaining();
       buffer.get(bigchar,0,length);
        Arrays.stream(new char[][]{bigchar}).forEach(chars -> System.out.print(chars));
    }
}
