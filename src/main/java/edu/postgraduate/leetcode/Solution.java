package edu.postgraduate.leetcode;

import java.util.*;

/**
 * @author QRX
 * @email QRXwzx@outlook.com
 * @Date 2020-01-20
 *
 */
public class Solution {

    /**
     * @name isMatch
     * @param s A string only contains 'publicStr'-'z'.
     * @param p Simple regular expression pattern, containing 'publicStr'-'z', '.' and '*'.
     * @return  The result of match.
     *
     *  This function's key point is (isMatch(s.substring(1), p)) || isMatch(s, p.substring(2))
     *  This boolean expression is the description of the functionality of '*'
     *  isMatch(s.substring(1), p) represent '*' repeat once and more than once, while
     *  isMatch(s, p.substring(2) represent the situation when the char before '*' don't repeat.
     */
    public boolean isMatch(String s, String p) {
        final char DOT = '.';
        final char STAR = '*';

        // Exit point.
        if(p.isEmpty()) {
            return s.isEmpty();
        }

        boolean isFirstMatch = ((!s.isEmpty()) && ((s.charAt(0) == p.charAt(0)) || (p.charAt(0) == DOT)));
        if((p.length() > 1) && (p.charAt(1) == STAR)) {
            return ((isFirstMatch && isMatch(s.substring(1), p)) || isMatch(s, p.substring(2)));
        }

        return (isFirstMatch && isMatch(s.substring(1), p.substring(1)));
    }

    /**
     *  Functional components of Method intToRoman().
     */
    private static Map<Integer, String> numMap = new HashMap<>();
    private static ArrayList<Integer> nums = new ArrayList<>();
    static {
        numMap.put(1, "I");
        numMap.put(4, "IV");
        numMap.put(5, "V");
        numMap.put(9, "IX");
        numMap.put(10, "X");
        numMap.put(40, "XL");
        numMap.put(50, "L");
        numMap.put(90, "XC");
        numMap.put(100, "C");
        numMap.put(400, "CD");
        numMap.put(500, "D");
        numMap.put(900, "CM");
        numMap.put(1000, "M");

        nums.add(1000);
        nums.add(900);
        nums.add(500);
        nums.add(400);
        nums.add(100);
        nums.add(90);
        nums.add(50);
        nums.add(40);
        nums.add(10);
        nums.add(9);
        nums.add(5);
        nums.add(4);
        nums.add(1);
    }

    private boolean isSpecial(int num) {
        if(num == 4 || num == 9 || num == 40 || num == 90 || num == 400 || num == 900) {
            return true;
        }
        return false;
    }

    /**
     * @name intToRoman
     * @param num Integer number
     * @return A string represent publicStr roman number.
     *
     *  Convert publicStr integer number to roman string.
     */
    public String intToRoman(int num) {

        StringBuilder resultBuilder = new StringBuilder();
        int remainder = 0;

        for(Integer integer : nums) {
            if(num >= integer) {
                if(isSpecial(integer)) { // Deal with special numbers: 4, 9 ,40, 90, 400 & 900.
                    resultBuilder.append(numMap.get(integer));
                    remainder = num - integer;
                    break;
                } else { // Deal with normal numbers(Numbers except 4...900).
                    int highestPos = integer;
                    int coeff = num / highestPos;
                    remainder = num - coeff * highestPos;
                    for(int i = 0 ; i < coeff ; i++) {
                        resultBuilder.append(numMap.get(highestPos));
                    }
                    break;
                }
            }
        }
        if(remainder > 0) {
            resultBuilder.append(intToRoman(remainder));
        }
        return resultBuilder.toString();
    }


    /**
     *  Functional components of Method romanToInt().
     */
    private static Map<String, Integer> romanMap = new HashMap<>();
    static {
        romanMap.put("I", 1);
        romanMap.put("IV", 4);
        romanMap.put("V", 5);
        romanMap.put("IX", 9);
        romanMap.put("X", 10);
        romanMap.put("XL", 40);
        romanMap.put("L", 50);
        romanMap.put("XC", 90);
        romanMap.put("C", 100);
        romanMap.put("CD", 400);
        romanMap.put("D", 500);
        romanMap.put("CM", 900);
        romanMap.put("M", 1000);
    }

    /**
     *
     * @param s A string represents publicStr number in roman style.
     * @return An integer coresponding to the roman number.
     *
     *  Convert publicStr roman string to integer number.
     */
    public int romanToInt(String s) {
        if(s == null) {
            return 0;
        }

        int result = 0;
        String oneRoman = s.substring(0, 1);;
        String twoRomans = null;
        boolean resultHasPlus = false;
        if(s.length() > 1) {
            twoRomans = s.substring(0, 2);
        }
        if(twoRomans != null) {
            boolean isSpecial = (romanMap.get(twoRomans) != null);
            if(isSpecial) {
                result = romanMap.get(twoRomans);
                if(s.length() > 2) {
                    result += romanToInt(s.substring(2));
                }
                resultHasPlus = true;
            }
        }

        if(!resultHasPlus) {
            result = romanMap.get(oneRoman);
            if(s.length() > 1) {
                result += romanToInt(s.substring(1));
            }
        }
        return result;
    }


    /**
     *
     * @param num   Number of pairs of parentheses contained in each result string.
     * @param depth The max depth of DFS.
     * @param leftCnt   The number of left parentheses.
     * @param rightCnt  The number of right parentheses.
     * @param parentheses   A string that represents one parentheses sequence.
     * @param result    The result list containing parentheses sequences, which is constructed through this method.
     *
     *  Key functional component method of method generateParenthesis(). Implemented by DFS algorithm.
     */
    private void buildParenDFS(
            int num,
            int depth,
            int leftCnt,
            int rightCnt,
            String parentheses,
            List<String> result) {
        if(leftCnt > num) {
            return;
        }
        if(rightCnt > leftCnt) {
            return;
        }
        if(depth == 0) {
            result.add(parentheses);
            return;
        }

        buildParenDFS(num, depth - 1, leftCnt + 1, rightCnt, parentheses + "(", result);
        buildParenDFS(num, depth - 1, leftCnt, rightCnt + 1, parentheses + ")", result );
    }

    /**
     *
     * @param n Number of pairs of parentheses contained in each result string.
     * @return The result list containing sequences of expected numbers pairs of parentheses.
     *
     *  Generate publicStr list containing sequences of expected numbers pairs of parentheses.
     */
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        buildParenDFS(n, 2*n, 0, 0, "", result);
        return result;
    }




    private List<Integer> arrayToList(int[] nums) {
        List<Integer> list = new ArrayList<>();
        for (int num : nums) {
            list.add(num);
        }
        return list;
    }

    private List<Integer> makeTriple(int min, int mid, int max) {
        List<Integer> triple = new ArrayList<>();
        triple.add(min);
        triple.add(mid);
        triple.add(max);
        return triple;
    }

    private void updateTripleList(List<List<Integer>> tripleList, List<Integer> numList, int head, int tail) {
        if(tail - head <= 1) {
            return ;
        }
        while(tail - head > 1) {
            int mid = (head + tail) / 2;
            //
            System.out.println("Origin: (" + head + ", " + mid + ", " + tail + ")");
            System.out.println("*****************");
            //
            int sum = numList.get(head) + numList.get(mid) + numList.get(tail);
            if(sum == 0) {
                List<Integer> triple = makeTriple(numList.get(head), numList.get(mid), numList.get(tail));
                if(!tripleList.contains(triple)) {
                    tripleList.add(triple);
                }
                return;
            }
            if(sum < 0) { // sum < 0, mid need to be larger.
                while((sum < 0) && (mid < tail - 1)) {
                    mid++;
                    //
                    System.out.println("(" + head + ", " + mid + ", " + tail + ")");
                    System.out.println("*****************");
                    //
                    sum = numList.get(head) + numList.get(mid) + numList.get(tail);
                }
                if(sum == 0) { // update result.
                    List<Integer> triple = makeTriple(numList.get(head), numList.get(mid), numList.get(tail));
                    if(!tripleList.contains(triple)) {
                        tripleList.add(triple);
                    }
                    return;
                }else if(sum < 0) {
                    head++;
                }else{
                    tail--;
                }
            }
            if(sum > 0){ // sum > 0, mid need to be smaller
                while((sum > 0) && (mid > head + 1)) {
                    mid--;
                    //
                    System.out.println("(" + head + ", " + mid + ", " + tail + ")");
                    System.out.println("*****************");
                    //
                    sum = numList.get(head) + numList.get(mid) + numList.get(tail);
                }
                if(sum == 0) { // update result.
                    List<Integer> triple = makeTriple(numList.get(head), numList.get(mid), numList.get(tail));
                    if(!tripleList.contains(triple)) {
                        tripleList.add(triple);
                    }
                    return;
                }else if(sum < 0) {
                    head++;
                }else{
                    tail--;
                }
            }
        }
    }

    public List<List<Integer>> threeSum(int[] nums) {
        if((nums == null) || nums.length < 3) {
            return new ArrayList<>();
        }
        List<List<Integer>> tripleList = new ArrayList<>();
        // sort
        List<Integer> numList = arrayToList(nums);
        Collections.sort(numList);
        System.out.println("After sort: " + numList);

        int head = 0;
        int tail = numList.size() - 1;

        while(tail - head > 1) {
            updateTripleList(tripleList, numList, head, tail);
            updateTripleList(tripleList, numList, head + 1, tail);
            updateTripleList(tripleList, numList, head, tail - 1);
            head++;
            tail--;
        }

        return tripleList;
    }
//    public List<List<Integer>> threeSum(int[] nums) {
//        if((nums == null) || (nums.length < 3)) {
//            return new ArrayList<>();
//        }
//
//        List<List<Integer>> resultList = new ArrayList<>();
//        // Sort
//        List<Integer> numList = arrayToList(nums);
//        Collections.sort(numList);
//
//        int head = 0;
//        int tail = numList.size() - 1;
//
//        while(tail - head > 1) {
//            int mid = (head + tail) / 2;
//            //
//            System.out.println("head = " + head);
//            System.out.println("mid = " + mid);
//            System.out.println("tail = " + tail);
//            System.out.println("*****************");
//            //
//            int sum = numList.get(head) + numList.get(mid) + numList.get(tail);
//            if(sum == 0) {
//                // Add triple to result list;
//                List<Integer> triple = makeTriple(numList.get(head), numList.get(mid), numList.get(tail));
//                if(!resultList.contains(triple)) {
//                    resultList.add(triple);
//                }
//                // Move one pointer( head and tail are ok), make sure this loop won't execute forever.
//                head++;
//            } else if(sum < 0) {
//                while((sum < 0) && (mid < tail - 1)) {
//                    mid++;
//                    sum = numList.get(head) + numList.get(mid) + numList.get(tail);
//                }
//                if(sum == 0) {
//                    List<Integer> triple = makeTriple(numList.get(head), numList.get(mid), numList.get(tail));
//                    if(!resultList.contains(triple)) {
//                        resultList.add(triple);
//                    }
//                    head++;
//                } else if(sum < 0) {
//                    head++;
//                } else {
//                    tail--;
//                }
//            } else {
//                while((sum > 0) && (mid > head + 1)) {
//                    mid--;
//                    sum = numList.get(head) + numList.get(mid) + numList.get(tail);
//                }
//                if(sum == 0) {
//                    List<Integer> triple = makeTriple(numList.get(head), numList.get(mid), numList.get(tail));
//                    if(!resultList.contains(triple)) {
//                        resultList.add(triple);
//                    }
//                    tail--;
//                } else if(sum < 0) {
//                    head++;
//                } else {
//                    tail--;
//                }
//            }
//        }
//        return resultList;
//    }
}
