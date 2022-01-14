package com.testsite.core;

import java.util.Arrays;

public class Test {
    /* public static int[] plusOne(int[] digits) {
            
        int n = digits.length;
        for(int i=n-1; i>=0; i--) {
            if(digits[i] < 9) {
                digits[i]++; return digits;
            }
            digits[i] = 0;
        }
        
        int[] newNumber = new int [n+1];
        newNumber[0] = 1;
        return newNumber;
    } */

    /**
     * Given an input array with each value as a digit between 0-9, out put an array as if the value of array was added 1 to it.
     * Instead of simply joining the objects and adding one will not be good for higher length of array.
     * Hence we can try below approach of starting from the last array item.
     * If the value is less than 9 add 1 to it and return.
     * if not set it to 0 as is must be 9. the loop will go to the second last number and so on to do a +1.
     */
   static boolean solution(int[] sequence) {
        boolean isPossibleSequence = false;
        int counter = 0;
        for (int i=0; i<sequence.length-1;i++) {
            if (sequence[i]> sequence[i+1] ) {
                counter++;
                if (i>0 && sequence[i-1]> sequence[i+1] && i!=sequence.length-2 ) {
                    counter++;
                }
            }else {
                isPossibleSequence = true;
            }
        }
        if (counter>1) {
            System.out.println("counter first:" + counter);
            isPossibleSequence = false;
        }
        Arrays.sort(sequence);
        int count = 0;
        for (int i=0; i<sequence.length-1;i++) {
            if (sequence[i] == sequence[i+1]) {
                count ++;
            }
        }
        if (count>1) {
            System.out.println("counter second:" + counter);
            isPossibleSequence = false;
        }

        if (count ==1 && counter ==1) {
            isPossibleSequence = false;
        }
        
        return isPossibleSequence;
        
        }
        
        
        
      public static void main(String[] args) {
            int [] arr = {1, 2, 18, 4, 4}; 
            boolean possible =solution(arr); 
            System.out.println(possible);
      }
    }

    //Approach:
    /**
     * 
     */