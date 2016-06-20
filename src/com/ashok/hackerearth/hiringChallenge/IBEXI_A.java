package com.ashok.hackerearth.hiringChallenge;


import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;

/**
 * Problem: Navi and his company
 * Challenge: IBEXI (A Sapiens Company) Java Hiring Challenge
 * Date: 12|03|2016
 *
 * @author: Ashok Rajpurohit ashok1113@gmail.com
 */

public class IBEXI_A {

    private static PrintWriter out;
    private static InputStream in;

    public static void main(String[] args) throws IOException {
        OutputStream outputStream = System.out;
        in = System.in;
        out = new PrintWriter(outputStream);
        IBEXI_A a = new IBEXI_A();
        a.solve();
        out.close();
    }

    public void solve() throws IOException {
        InputReader in = new InputReader();
        int t = in.readInt();
        int NEW_PROJECT = 3601;
        while (t > 0) {
            t--;
            int n = in.readInt();
            int unassigned = 0, resource = 0;
            while (n > 0) {
                n--;
                int p = in.readInt();
                if (p == NEW_PROJECT) {
                    if (resource == 0)
                        unassigned++;
                    else
                        resource--;

                    p = in.readInt();
                } else {
                    resource += p;
                }
            }
            out.println(unassigned);
        }
    }

    final static class InputReader {
        byte[] buffer = new byte[8192];
        int offset = 0;
        int bufferSize = 0;

        public int readInt() throws IOException {
            int number = 0;
            int s = 1;
            if (offset == bufferSize) {
                offset = 0;
                bufferSize = in.read(buffer);
            }
            if (bufferSize == -1)
                throw new IOException("No new bytes");
            for (; buffer[offset] < 0x30 || buffer[offset] == '-'; ++offset) {
                if (buffer[offset] == '-')
                    s = -1;
                if (offset == bufferSize - 1) {
                    offset = -1;
                    bufferSize = in.read(buffer);
                }
            }
            for (; offset < bufferSize && buffer[offset] > 0x2f; ++offset) {
                number = (number << 3) + (number << 1) + buffer[offset] - 0x30;
                if (offset == bufferSize - 1) {
                    offset = -1;
                    bufferSize = in.read(buffer);
                }
            }
            ++offset;
            return number * s;
        }
    }
}
