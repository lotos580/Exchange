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

        int priceArray[] = {100, 113, 110, 85, 105, 102, 86, 63, 81, 101, 94, 106, 101, 79, 94}; // ?????? ??????
        //int Price[] = {10, 11, 7, 10, 6}; // ?????? ??????

        System.out.print("Массив цены акций: ");
        for (Integer iPrice = 0; iPrice < priceArray.length; iPrice++) {
            String s = Integer.toString(priceArray[iPrice]);
            System.out.print(s + "," + " ");
        }
        System.out.print("\n");

        Integer priceDelta[] = new Integer[priceArray.length - 1];
        for (int i = 0; i < priceDelta.length; i++) {
            priceDelta[i] = priceArray[i + 1] - priceArray[i];
            String s = Integer.toString(priceDelta[i]);
        }
        
        System.out.print("\n");

        int firstDay = 0, endDay = 0, earnings = 0;
        int counterFirstDay = 0, counterEndDay = 0, counterEarnings = 0;

        for (int i = 0; i < priceDelta.length; ++i) {
            int newDelta = priceDelta[i];
            if (counterFirstDay == 0) {
                counterFirstDay = i;
                counterEndDay = i + 1;
                counterEarnings = newDelta;
            } else {
                counterEarnings = counterEarnings + newDelta;
                ++counterEndDay;
            }
            if (counterEarnings <= 0) {
                counterFirstDay = 0;
                counterEndDay = 0;
                counterEarnings = 0;
            } else if (counterEarnings > earnings) {
                firstDay = counterFirstDay;
                endDay = counterEndDay;
                earnings = counterEarnings;
            }
        }

        System.out.print("???????????? ????????? ??????: ");
        for (int i = firstDay; i < endDay; ++i) {
            String s = Integer.toString(priceDelta[i]);
            System.out.print(s + "," + " ");
        }
        System.out.print("\n");

        System.out.print("??????? " + Integer.toString(firstDay + 1) + " " +
                "- ???? " + Integer.toString(priceArray[firstDay]) +
                ", ??????? " + Integer.toString(endDay + 1) + " " +
                "- ???? " + Integer.toString(priceArray[endDay]) + ", ");
        System.out.print("?????? ???????: " + Integer.toString(earnings));
    }
}
