package assignment_3;
import java.io.*;
public class Dynamic_allocation {

	public static void main(String args[])throws IOException
	{
		BufferedReader br=null;
		try
		{
			br=new BufferedReader(new FileReader("G:\\java lab home work\\csx-351-hw3-inderjeet777-master\\HW3-unsorted-keywords.txt"));
		    String line="";
		    line=br.readLine();
		    int count=0,i=0,line_no=1;
		    while(line!=null)
		    {
		    	count++;
		    	line=br.readLine();
		    }
		    line="";
		    System.out.println(count);
		    String keywords[]=new String[count];
			br=new BufferedReader(new FileReader("G:\\java lab home work\\csx-351-hw3-inderjeet777-master\\HW3-unsorted-keywords.txt"));
		    line=br.readLine();
		    while(line!=null)
		    {
		    	keywords[i]=line;
		    	i++;
		    	line=br.readLine();
		    }
		    line="";
			sort(keywords);
			br=new BufferedReader(new FileReader("G:\\java lab home work\\csx-351-hw3-inderjeet777-master\\HW3-input-code.cpp"));
		    line=br.readLine();
		    String regex = "((?<=[a-zA-Z])(?=[0-9]))|((?<=[0-9])(?=[a-zA-Z])|[#<>();=]+)";
		    while(line!=null)
		    {
		    	String words[]=line.trim().split(regex);
		    	//System.out.println(line);
		    	String output="";
		    	for(int j=0;j<words.length;j++)
		    	{
		    		System.out.println(words[j]);
		    		if(search(words[j],keywords)==1)
		    		{
		    			output="";
		    			output+=Integer.toString(line_no);
		    			output+=words[j];
		    			int index=line.indexOf(words[j]);
		    			output+=Integer.toString(index);
		    			System.out.println(output);
		    			
		    			
		    		}
		    	}
		    	line=br.readLine();
		    	line_no++;
		    	
		    }
		    
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
		
	}
	static void sort(String str[])//insertion sort
	{
		int size=str.length;
		for(int i=1;i<size;i++)
		{
			int j=i-1;
			String s=str[i];
			while(j>-1&&(s.compareTo(str[j]))<0)
			{
				str[j+1]=str[j];
				j--;
			}
			str[j+1]=s;
		}
		
		
	}
	static int search(String word,String dict[])//binary search
	{
		int low=0,high=dict.length-1,mid;
		
		while(low<=high)
		{
			mid=(low+(high-low)/2);
			int comp=word.compareTo(dict[mid]);
			if(comp==0)
				return 1;
			if(comp<0)
			{
				high=mid-1;
			}
			else
				low=mid+1;
		}
		return 0;
	}
}
