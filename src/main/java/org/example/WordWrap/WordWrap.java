package org.example.WordWrap;

public class WordWrap {

    /*
    * Problem statement
You are given ‘N’ words of various lengths, now you have to arrange these words in such a way that each line contains at most ‘M’ characters and each word is separated by a space character. The cost of each line is equal to the cube of extra space characters required to complete ‘M’ characters in that particular line. Total cost is equal to the sum of costs of each line.

Your task is to form this arrangement with the minimum cost possible and return the minimum total cost.

Note:
The length of each word should be less than or equal to ‘M’.

You can’t break a word, i.e. the entire word should come in the same line and it must not be the case that a part of it comes in the first line and another part on the next line.
    *https://www.codingninjas.com/studio/problems/word-wrap_982931?topList=top-microsoft-coding-interview-questions&problemListRedirection=true&count=25&page=1&search=&sort_entity=order&sort_order=ASC&leftPanelTabValue=PROBLEM&customSource=studio_nav
    *
    *
    * */

    public static int wordWrap(String[] words, int m, int n) {

        // vector to store the length of every word.
        int len[] = new int[n];
        for (int i = 0; i < n; i++) {

            len[i] = words[i].length();
        }

        // Calculate the cost of line i having j-i words.
        int cost[][] = new int[n][n];
        for (int i = 0; i < n; i++) {

            cost[i][i] = m - len[i];

            for (int j = i + 1; j < n; j++) {

                cost[i][j] = cost[i][j - 1] - len[j] - 1;
            }
        }


        // Update the cost to MAX if it is not possible to add all the words in that
        // line.
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {

                if (cost[i][j] < 0)
                    cost[i][j] = 1000000000;
                else
                    cost[i][j] = cost[i][j] * cost[i][j] * cost[i][j];
            }
        }


        // Take a mincost vector to calculate the minimum cost of every line.
        int mincost[] = new int[n];
        for (int i = n - 1; i >= 0; i--) {
            mincost[i] = cost[i][n - 1];
            for (int j = n - 1; j > i; j--) {

                // If it is not possible to take that word in line i then continue.
                if (cost[i][j - 1] == 1000000000) {
                    continue;
                }

                if (mincost[i] > cost[i][j - 1] + mincost[j]) {
                    mincost[i] = cost[i][j - 1] + mincost[j];
                }
            }

        }


        return mincost[0];
    }
}
