package algorithm;
//判断两个字符串是否互为变形词

/**题目：
 * 给定两个字符串str1和str2,如果str1和str2中出现的字符种类一样且每种字符出现的次数也一样，
 * 那么str1和str2互为变形词。请实现函数判断这两个字符串是否互为变形词。
 */

//举例：
//str1="123" str2="321" 返回true
//str1="123" str2="1223"  返回false

import java.util.HashMap;
import java.util.Map;

public class bianxingci {
    public static void main(String[] args) {
        String str1="123";
        String str2="321";
        System.out.println(isDeformation(str1,str2));
        String str3="abc";
        String str4="acbb";
        System.out.println(isDeformation2(str3,str4));
    }

    /** 方法一：数组。
     * 遍历str1，统计str1中每个字符出现的次数，array[a]=b,a是字符，b为该字符出现的次数。
     * 遍历str2,每遍历一个字符，就将该字符出现的次数减一。
     * 如果将该字符减一之后，该字符出现的次数小于0，直接返回false;
     * 如果遍历完str2之后也没有出现负数，则返回true.
     */
    public static boolean isDeformation(String str1,String str2){
        if(str1==null||str2==null||str1.length()!=str2.length()){
            return false;
        }
         int[] array=new int[256] ;
        int i=0;
        for(;i<str1.length();i++){
            array[str1.charAt(i)]++;
        }
        for(;i<str2.length();i++){
            if((array[str2.charAt(i)]--)<0){
                return false;
            }
        }
        return true;
    }

    //方法二：Map
    public static boolean isDeformation2(String str1,String str2) {
        if (str1 == null || str2 == null || str1.length() != str2.length()) {
            return false;
        }
        Map<Character, Integer> map = new HashMap();
        char[] a = str1.toCharArray();
        char[] b = str2.toCharArray();
        for (int i = 0; i < a.length; i++) {
            Integer value = map.getOrDefault(a[i], 0);
            map.put(a[i], value + 1);
        }
        for (int i = 0; i < b.length; i++) {
            if (!map.containsKey(b[i])) {
                return false;
            }
            Integer value = map.get(b[i]);
            map.put(b[i], value - 1);
            if(map.get(b[i])<0){
                return false;
            }
        }
        return true;
    }
}
