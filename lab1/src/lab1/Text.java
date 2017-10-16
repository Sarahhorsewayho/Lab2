package lab1;

import java.util.Scanner;
import java.util.Random;
import java.util.Vector;

//import java.util.*;
//import test.type;


public class Text {
	
	
	public Graph g;
	private int t=0;
	StringBuilder mp=new StringBuilder();
	Text(Graph n)
	{
		this.g=n;
	}
	public void showDirectedGraph(Graph g, int n)//展示有向图
	{
		//System.out.println(n);
		//System.out.println(g.Getedge(44, 39));
		for(int i=0;i<=n+1;i++)
		{
			for(int j=0;j<=n+1;j++)
			{
				if(g.Getedge(i, j) != 100000)
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
				if((g.Getedge(x, i)!=100000)&&(g.Getedge(i, y)!=100000))
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
	public String generateNewText(String inputText)//根据bridge生成新文本
	{
		String str_array[] = inputText.split(" ");
		StringBuilder builder = new StringBuilder();
		String temp;
		for(int i=0;i<str_array.length-1;i++)
		{
			builder.append(str_array[i]);
			builder.append(' ');
			temp = queryBridgeWords(str_array[i],str_array[i+1]);
			if(temp.length()!=0)
				builder.append(temp);			
		}
		builder.append(str_array[str_array.length-1]);
		return builder.toString();
	}
	public String calcShortestPath(String word1,String word2)//计算两个单词之间的最短路径
	{
		int n=g.Getn();
		//int pathRep[][][]=new int[n+1][n+1][n+1];
		
		if(g.Isingraph(word1)==0)
			return "我们的图里不存在这样的单词";
		if((!word2.equals(""))&&g.Isingraph(word2)==0)
			return "我们的图里不存在这样的单词";
		int x=g.Getpos(word1);
		int y = 0,muti=0;
		if(!word2.equals(""))
			y=g.Getpos(word2);
		
		int[][] leastDis = new int[n+2][n+2];
		int[][] minPath =new int[n+2][n+2];
		StringBuilder builder = new StringBuilder();
		for(int i=0;i<=n+1;i++)
		{
			for(int j=0;j<=n+1;j++)
			{
				leastDis[i][j]=g.Getedge(i,j);
				minPath[i][j]=0;
			}
		}
		for(int k=0;k<=n+1;k++)
		{
			for(int i=0;i<=n+1;i++)
			{
				for(int j=0;j<=n+1;j++)
				{
					if(leastDis[i][k]+leastDis[k][j]<leastDis[i][j])
					{
						leastDis[i][j]=leastDis[i][k]+leastDis[k][j];
						minPath[i][j]=k;
					}
				}
			}
		}
		if(!word2.equals(""))
		{
			String res=null;
			res=printminPath(x,y,minPath);
			if(t == 1 && g.Getedge(x,y)==100000)
			{
					return "不存在两个单词之间的路径";
			}
			else
			{
				builder.append(g.Getstr(x));
				builder.append(res);
			}
			String str1=builder.toString();
			int s0=minPath[x][y];
			for(int q=1;q<=n+1;q++)
			{
				if(q!=s0)
				{
					if(leastDis[x][q]+leastDis[q][y]==leastDis[x][y])
					{	
						StringBuilder sb=new StringBuilder();
						mp.setLength(0);
						sb.append(g.Getstr(x));
						String res1=printminPath(x,q,minPath);
						mp.setLength(0);
						String res2=printminPath(q,y,minPath);
						sb.append(res1);
						sb.append(res2);
						String str2=sb.toString();
						if(!(str2.equals(str1)))
						{
							builder.append('\n');
							builder.append(str2);
						}
					}
				}
			}
			
		}
		else
		{
			String mutipath = null;
			//System.out.println("-.-"+minPath[52][53]);
			for(int j=1;j<=g.n+1;j++)
			{
				if(g.isRepeat(j)!=1)
				{
					mutipath=printminPath(x,j,minPath);
					if(!(t==1 && g.Getedge(x,j)==100000))
					{
						builder.append(g.Getstr(x));
						builder.append(mutipath);
						builder.append('\n');
						muti++;
					}
					mp.setLength(0);
					t=0;
				}
			}
			if(muti==0)
				return "从该点出发没有路";
		}
		return builder.toString();
	}
	String printminPath(int i,int j,int minPath[][])
	{
		//System.out.println(g.Getstr(i)+"->"+g.Getstr(j));
		if(minPath[i][j]==0)
		{
			mp.append("->");
			mp.append(g.Getstr(j));
			//System.out.println(g.Getstr(j));
			t=t+1;
		}
		else
		{
			int k=minPath[i][j];
			printminPath(i,k,minPath);
			printminPath(k,j,minPath);
		}
		return mp.toString();
	}
	public String randomwalk()//随机游走
	{
		StringBuilder randomPath=new StringBuilder();
		int min=1;
		int max=g.n+1;
		int s,p;
		int[][] putPath=new int[g.n+2][g.n+2];
		for(int i=0;i<=g.n+1;i++)
		{
			for(int j=0;j<g.n+1;j++)
				putPath[i][j]=0;
		}
		Random random=new Random();
		Random rep=new Random();
		do {
			s = random.nextInt(max-min)+ min;
		}while(g.isRepeat(s)==1);
		randomPath.append(g.Getstr(s));
		do {
			p= rep.nextInt(max-min)+min;
		}while(g.Getedge(s, p)==100000||p==s);
		do{
			putPath[s][p]=1;
			s=p;
			randomPath.append("->");
			randomPath.append(g.Getstr(p));
			do {
				p= rep.nextInt(max-min)+min;
			}while(g.Getedge(s, p)==100000||p==s);
		}while(putPath[s][p]==0);
		randomPath.append("->");
		randomPath.append(g.Getstr(p));
		return randomPath.toString();		
	}
	public static void main(String args[])
	{
		int time=0;
		do {
			Graph g = new Graph();
			Text t = new Text(g);
			String commandLine;
			Scanner cmd=new Scanner(System.in);
			commandLine=cmd.nextLine();
			String[] cmd_array = new String[3] ;
			cmd_array=commandLine.split(" ");
			String word1,word2 = null,re;
			Scanner sc = new Scanner(System.in);
		//	System.out.print('\n');
			//展示有向图
			if(cmd_array[0].equals("show"))
			{
			//	System.out.print('\n');
				t.showDirectedGraph(g, g.Getn());
			}
			
			//查询桥连接
			else if(cmd_array[0].equals("br"))
			{
				int a=0;
				for(int k = 0; k < cmd_array.length; k++)
				{
					if(null != cmd_array[k]) a++;
				}
				if(a!=3)
					System.out.println("非法输入！");
				else
				{
					word1=cmd_array[1];
					word2=cmd_array[2];
					//System.out.println("请输入两个桥接词");
					//System.out.println("输入第一个桥接词：");
					//word1 = sc.nextLine();
					//System.out.println("输入第二个桥接词：");
					//word2 = sc.nextLine();
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
				}
			}
			//根据bridge生成新文本
			else if(cmd_array[0].equals("getnew"))
			{
				int a=0;
				for(int k = 0; k < cmd_array.length; k++)
				{
					if(null != cmd_array[k]) a++;
				}
				if(a!=1)
					System.out.println("非法输入！");
				else
				{
					System.out.println("输入新文本");
					String inputText;
					String outputText;
					inputText = sc.nextLine();
					System.out.println("输出插入桥连接词文本");
			        outputText = t.generateNewText(inputText);
					System.out.println(outputText);
				}
			}
			
			//计算最短路径
			else if(cmd_array[0].equals("shortest"))
			{
				//System.out.println("输入两个单词");
				//System.out.println("输入第一个词：");
				//word1 = sc.nextLine();
				//System.out.println("输入第二个词：");
				//word2 = sc.nextLine();
				int a=0;
				String min;
				for(int k = 0; k < cmd_array.length; k++)
				{
					if(null != cmd_array[k]) a++;
				}
				if(a==1)
				{
					word1="";
					System.out.println("非法输入！");
				}
				else
					word1=cmd_array[1];
				if(a==2)
				{
					word2="";
					min=t.calcShortestPath(word1,word2);
					System.out.println(min);
				}
				else if(a==3)
				{
					word2=cmd_array[2];
					min=t.calcShortestPath(word1,word2);
					System.out.println(min);
				}
				else
					System.out.println("非法输入！");
				//System.out.println("两个词之间的最短路径为：");
			}
			
			//随机游走
			else if(cmd_array[0].equals("random"))
			{
				//System.out.println("随机游走：");
				int a=0;
				for(int k = 0; k < cmd_array.length; k++)
				{
					if(null != cmd_array[k]) a++;
				}
				if(a!=1)
				{
					System.out.println("非法输入！");
				}
				else 
				{
					String randompath;
					randompath=t.randomwalk();
					System.out.println(randompath);
				}
			}
			else if(cmd_array[0].equals("quit"))
				System.exit(0);
			else
				System.out.println("非法输入！");
			time++;
	}while(time!=50);
	}
}

