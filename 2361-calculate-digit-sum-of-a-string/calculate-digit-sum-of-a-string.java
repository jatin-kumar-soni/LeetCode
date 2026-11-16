class Solution {


    public String digitSum(String s, int k) {
        if(s.length() <=k)
        {
            return s;
        }
        String str=filterString(s,k);
        int n=str.length();
        String temp="";
        while(n > k)
        {
         str=filterString(str,k);
         n=str.length();
        }
        return str;
       

    }

    String filterString(String s, int k) {
        int len = s.length();
        String str="";
        StringBuilder store = new StringBuilder(s);
        StringBuilder store1 = new StringBuilder(str);

        while (store.length() > 0) {
            int p = k;
            int calc = 0;
            while (p-- > 0 && store.length() > 0) {
               if(store.length() > 0)
               {
                 char sr = store.charAt(0);
                  calc = calc + Character.getNumericValue(sr);
                store.deleteCharAt(0);
               }
               

            }
            store1.append(Integer.toString(calc));

        }
        return store1.toString();
    }
}