package com.topics.bitmanipulation;

/**
 * Consider two positive 32-bit integers, q and p, and two bit positions, i and j.
 * Write a snippet of code that replaces the bits from q between positions i and j with the bits
 * of p. You can assume that, between i and j, there is enough space to fit all bits of p.
 */
public class ReplacingBit {
    public static int replace(int q, int p, int i, int j){
        int ones = ~0;

        int leftShiftJ = ones << (j + 1);
        int leftShiftI = ((1 << i) - 1);

        int mask = leftShiftJ | leftShiftI;

        int applyMaskToQ = q & mask;
        int bringPInPlace = p << i;

        return applyMaskToQ | bringPInPlace;
    }
}
