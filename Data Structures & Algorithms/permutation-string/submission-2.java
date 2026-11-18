class Solution {
    public boolean checkInclusion(String s1, String s2) {

        if(s2.length() < s1.length()) return false;
        HashMap<Character,Integer> target = new HashMap<>();

        for(char c : s1.toCharArray() ){
            target.put(c, target.getOrDefault(c,0) + 1);
        }


        HashMap<Character, Integer> window = new HashMap();
        int len = s1.length();
        for(int i = 0; i < len; i++ ){
            char c = s2.charAt(i);
            window.put(c, window.getOrDefault(c,0) + 1);
        }
        for(int i = 0; i + len < s2.length(); i++){
            if(window.equals(target)) return true;
            System.out.println(window.toString());
            char l = s2.charAt(i);
            window.put(l,window.get(l)-1);
            if(window.get(l) == 0) window.remove(l);
            char r = s2.charAt(i + len);
            window.put(r,window.getOrDefault(r,0)+1);
        }

        return window.equals(target);

        
        
    }
}
