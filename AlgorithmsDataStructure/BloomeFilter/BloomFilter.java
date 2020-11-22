package BloomeFilter;

public class BloomFilter
{
      public int filter_len;
      public byte[] slots;
      
      public BloomFilter(int f_len)
      {
        filter_len = f_len;
        makeArray(f_len);
      }
      
      public void makeArray(int len) {
    	  slots = new byte[len];
    	  for(int i = 0; i < len;i++)
    		  slots[i] = 0;
      }

    
      public int hash1(String str1)
      {
        int res = 0;
        for(int i=0; i<str1.length(); i++)
        {
            int code = (int)str1.charAt(i);
            if(i == 0)res = 0;
            res *= 17;
            res += code;
            res%=filter_len;
        }
        return res;
      }
      public int hash2(String str1)
      {
    	  int res = 0;
          for(int i=0; i<str1.length(); i++)
          {
              int code = (int)str1.charAt(i);
              if(i == 0)res = 0;
              res *= 223;
              res += code;
              res %= filter_len;
          }
          return res;

      }

      public void add(String str1)
      {
        int f = hash1(str1);
        int s = hash2(str1);
        slots[f] = 1;
        slots[s] = 1;
      }

      public boolean isValue(String str1)
      {
    	  int f = hash1(str1);
          int s = hash2(str1);
          if(slots[f] == 0 || slots[s] == 0)
          		return false;
        return true;
      }
}