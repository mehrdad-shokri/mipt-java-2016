package ru.mipt.java2016.homework.g595.popovkin.task2;

import java.io.*;

/**
 * Created by Howl on 30.10.2016.
 */
public class LongParser implements ItemParser<Long> {

    @Override
    public void serialize(Long argTmp, OutputStream out) throws IOException {
        long arg = argTmp;
        for (int i = 0; i < 8; ++i) {
            out.write((int) ((arg >> ((7 - i) * 8)) & 0xFFL));
        }
    }

    @Override
    public Long deserialize(InputStream in) throws IOException {
        long ans = 0;
        for (int i = 0; i < 8; ++i) {
            Integer tmp = (int) in.read();
            ans = (ans << 8) + tmp;
        }
        return ans;
    }
}
