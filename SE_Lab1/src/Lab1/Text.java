package Lab1;

import java.util.Scanner;

//import java。util。*;
//import test.type;


public class Text {
	
	
	public Graph g;
	Text(Graph n)
	{
		this.g=n;
	}
	public void showDirectedGraph(Graph g, int n)//展示有向图
	{
		for(int i=0;i<=n;i++)
		{
			for(int j=0;j<=n;j++)
			{
				if(g.Getedge(i, j) >= 1)
				{
					System.out.println(i+"，"+j+"："+g.Getstr(i)+"->"+g.Getstr(j));
				}
			}
			
		}
		
	}
	public String queryBridgeWords(String word1,String word2)//查询桥连接
	{
		int x=g.Getpos(word1);
		int y=g.Getpos(word2);
		int n=g.Getn();
		StringBuilder result = new StringBuilder();
		if((x!= -1)&&(y!=-1))
		{
			for(int i=0;i<=n;i++)
			{
				if((g.Getedge(x, i) >= 1)&&(g.Getedge(i, y)>=1))
				{
					result.append(g.Getstr(i));
					result.append(' ');
				}
			}
			return result.toString();
		}
		else
			return result.toString();
		
	}
	public String generateNewText(String inputText)//根据brigde生成新文本
	{
		String str_array[] = inputText.split(" ");
		StringBuilder builder = new StringBuilder();
		String temp;
		for(int i=0;i<str_array.length-1;i++)
		{
			builder.append(str_array[i]);
			builder.append(' ');
			temp = queryBridgeWords(str_array[i],str_array[i+1]);
			if(temp.length() != 0)
				builder.append(temp);			
		}
		builder.append(str_array[str_array.length-1]);
		return builder.toString();
	}
//	public String calcShortestPath(String word1,String word2)//计算两个单词之间的最短路径
//	{
//		
//	}
//	public String randomwalk()//随机游走
//	{
//		
//	}
	public static void main(String args[])
	{
		//展示有向图
		Graph g = new Graph();
		Text t = new Text(g);
		System.out.print('\n');
		t.showDirectedGraph(g, g.Getn());
		
		//查询桥连接
		String word1,word2,re;
		Scanner sc = new Scanner(System.in);
		System.out.println("请输入两个桥接词");
		System.out.println("输入第一个桥接词：");
		word1 = sc.nextLine();
		System.out.println("输入第二个桥接词：");
		word2 = sc.nextLine();
		if((g.Getpos(word1)== -1)||(g.Getpos(word2)==-1))
		{
			System.out.println("No bridge words from  “"+ word1+"” to “" +word2+"”!");
		}
		else
		{
			
			if((g.Isingraph(word1) == 0)&&(g.Isingraph(word2)==0))
			{
				System.out.println("No “"+word1+"” and “"+word2+"” in the graph!");
			}
			else if(g.Isingraph(word1) == 0)
			{
				System.out.println("No “"+word1+"” in the graph!");
			}
			else if(g.Isingraph(word2) == 0)
			{
				System.out.println("No “"+word2+"” in the graph!");
			}
			else
			{
				re= t.queryBridgeWords(word1, word2);
				if(re.length() == 0)
					System.out.println("No bridge words from “"+word1+"” to “"+word2+"!");
				else
				System.out.println("The bridge words from  “"+word1+"” to “"+word2+"” is:"+re);
			}
				
			  
		}
		
		//根据bridge生成新文本
		System.out.println("输入新文本");
		String inputText;
		String outputText;
		inputText = sc.nextLine();
		System.out.println("输出插入桥连接词文本");
        outputText = t.generateNewText(inputText);
		System.out.println(outputText);
		
		
	}

}