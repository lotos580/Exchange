/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exchange;

/**
 *
 * @author lotos
 */


public class Exchange {

    public static void main(String[] args) {

        int priceArray[] = {100, 113, 110, 85, 105, 102, 86, 63, 81, 101, 94, 106, 101, 79, 94};

        System.out.print("?????? ???? ?????: ");
        for (Integer iPrice = 0; iPrice < priceArray.length; iPrice++) {
            String s = Integer.toString(priceArray[iPrice]);
            System.out.print(s + "," + " ");
        }


        Integer priceDelta[] = new Integer[priceArray.length - 1];
        System.out.println("\n");
        for (int i = 0; i < priceDelta.length; i++) {
            priceDelta[i] = priceArray[i + 1] - priceArray[i];
            String s = Integer.toString(priceDelta[i]);
        }

        
        int firstDayNumbers = 0, lastDayNumbers = 0, earningNumbers = 0;
        int firstDay = 0, lastDay = 0, earnings = 0;
        
        for (int i = 0; i < priceDelta.length; ++i) {
            int newDelta = priceDelta[i];
            if (firstDayNumbers == 0) {
                firstDayNumbers = i;
                lastDayNumbers = i + 1;
                earningNumbers = newDelta;
            } else {
                earningNumbers = earningNumbers + newDelta;
                ++lastDayNumbers;
            }
            if (earningNumbers <= 0) {
                firstDayNumbers = 0;
                lastDayNumbers = 0;
                earningNumbers = 0;
            } else if (earningNumbers > earnings) {
                firstDay = firstDayNumbers;
                lastDay = lastDayNumbers;
                earnings = earningNumbers;
            }
        }

        System.out.print("???????????? ????????? ?????? ");
        for (int i = firstDay; i < lastDay; ++i) {
            String s = Integer.toString(priceDelta[i]);
            System.out.print(s + "," + " ");
        }
        System.out.print("\n");

        System.out.print("??????? " + Integer.toString(firstDay + 1) + " " +
                "- ???? " + Integer.toString(priceArray[firstDay]) +
                ", ??????? " + Integer.toString(lastDay + 1) + " " +
                "- ???? " + Integer.toString(priceArray[lastDay]) + "\n");
        System.out.print(", ?????? ???????: " + Integer.toString(earnings));
    }
}