package Lab1;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.*;
public class Graph {

	public int edge[][];
	public String strr[];//原始字符串
	public int n;
	public HashMap<String,Integer> map;
	public int Getedge(int x,int y)//返回边x->y
	{
		return edge[x][y];
	}
	public int Getn()
	{
		return n;
	}
	public int Isingraph(String str)
	{
		if(map.containsKey(str) == true)
			return 1;
		else 
			return 0;
	}
	public String Getstr(int n)//返回第n个原始字符串
	{
		String key = null;
		Integer integ = null;
		Iterator iter = map.entrySet().iterator();
		while(iter.hasNext())
		{
			Map.Entry entry = (Map.Entry)iter.next();
			key =(String)entry.getKey();
			integ = (Integer)entry.getValue();
			if(integ.intValue() == n)
				return key;
		}
		return null;
	}
	public int Getpos(String str)
	{
		if(map.containsKey(str) == true)
		return (Integer)map.get(str);
		else
		return -1;
	}
	public Graph()
	{
		File file = new File("text.txt");
        Reader reader = null;
        try {
            System.out.println("以字符为单位读取文件内容，一次读一个字节：");
            // 一次读一个字符
            reader = new InputStreamReader(new FileInputStream(file));
            int tempchar;
            char temp;
            String[] str = new String[500];//存储原始字符串段
            strr = new String[500];//存储除去字符的单词
            char[] chararr = new char[30];
            int m = -1;
            int n = -1;
            int k = -1;
            while ((tempchar = reader.read()) != -1)
            {
            	temp = (char)tempchar;
            	if(((tempchar>=65)&&(tempchar <= 90))||((tempchar >= 97)&&(tempchar <= 122)))
            {
            		n++;
            		chararr[n]=temp;
        		}
            	else if(!(((tempchar>=65)&&(tempchar <= 90))||((tempchar >= 97)&&(tempchar <= 122))))
            	{
            	    
            		StringBuilder builder = new StringBuilder();
            		for(int i=0;i<=n;i++)
            		{
            			builder.append(chararr[i]);
            			chararr[i]='\u0000';
            		}
            		m++;
            		str[m]=builder.toString();
            		System.out.println(m+":"+str[m]);
            		n=-1;
            	    
            	}
            }
            
            for(int i=0;i<=m;i++)
            {
            	
            	if(str[i].length() != 0)
        		{ 
            		k++;
            		str[i]=str[i].toLowerCase();//修改为小写单词
            		strr[k] = str[i];
            		System.out.print(strr[k]);
                	System.out.print(" ");
        		}
            	
            }
            reader.close();
            this.n=k;
            
            map = new HashMap<String,Integer>();//map建立字符串和边的映射
            for(int i=0;i<=k;i++)
            {
            		map.put(strr[i], 0);
            }
            for(int i=0;i<=k;i++)
            {
	            	if(map.get(strr[i]) == 0)
	            	{
	            		map.put(strr[i], i+1);//单词和结点序号之间建立映射，且保证单词不重复。
	            		System.out.println("----"+map.get(strr[i])+" "+strr[i]);
	            	}
            }
            edge = new int[k+2][k+2];
            for(int i=0;i<=k;i++)
            {
	            	for(int j=0;j<=k;j++)
	            	{
	            		edge[i][j]=0;
	            		//System.out.println();
	            	}
            }
            for(int s=0;s<=k;s++)
            {
            		edge[map.get(strr[s])][map.get(strr[s+1])]++;
            }
        }catch (Exception e){
            e.printStackTrace();
        }
		
		
		
	
	}
		
	

}
