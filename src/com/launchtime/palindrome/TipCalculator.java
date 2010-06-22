package com.launchtime.palindrome;

import java.math.BigDecimal;

public class TipCalculator
{
    private BigDecimal pct;

    public TipCalculator(String pct)
    {
        BigDecimal p = new BigDecimal(pct);
        p = p.add(new BigDecimal("100"));
        p = p.divide(new BigDecimal("100"), 6, BigDecimal.ROUND_HALF_EVEN);
        this.pct = p;
    }

    public String compute(String val)
    {
        BigDecimal amt = new BigDecimal(val);
        BigDecimal minAmt = amt.multiply(this.pct);
        minAmt = minAmt.setScale(2, BigDecimal.ROUND_HALF_EVEN);

        while (!isPalindrome(minAmt.toString()))
            minAmt = minAmt.add(new BigDecimal("0.01"));

        BigDecimal tip = minAmt.subtract(amt);
        return tip.toString();
    }

    private boolean isPalindrome(String val)
    {
        String str = val.replace(".", "");
        int l = str.length();
        int x = l / 2;
        for (int i = 0; i <= x; i++) {
            if (str.charAt(i) != str.charAt(l - 1 - i))
                return false;
        }
        return true;
    }
}
