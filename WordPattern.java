/* Word Pattern
Easy

949

134

Add to List

Share
Given a pattern and a string str, find if str follows the same pattern.

Here follow means a full match, such that there is a bijection between a letter in pattern and a non-empty word in str.

Example 1:

Input: pattern = "abba", str = "dog cat cat dog"
Output: true
Example 2:

Input:pattern = "abba", str = "dog cat cat fish"
Output: false
Example 3:

Input: pattern = "aaaa", str = "dog cat cat dog"
Output: false
Example 4:

Input: pattern = "abba", str = "dog dog dog dog"
Output: false
Notes:
You may assume pattern contains only lowercase letters, and str contains lowercase letters that may be separated by a single space. */

class Solution {
    public boolean wordPattern(String pattern, String str) {
        String[] strs = str.split(" ");
        if(pattern.length() != str.split(" ").length) return false;
        Map<Character,String> res = new HashMap<Character,String>();
        for(int i= 0;i<pattern.length();i++){
            if(!res.containsKey(pattern.charAt(i))){
                if(!res.containsValue(strs[i])){
                res.put(pattern.charAt(i),strs[i]);}
                else{
                    return false;
                }
            }
            if(res.containsKey(pattern.charAt(i))){
                if(!res.get(pattern.charAt(i)).equals(strs[i])){
                    return false;
                }
            }
        }
        return true;
    }
}