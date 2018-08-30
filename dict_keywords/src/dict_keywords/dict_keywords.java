package dict_keywords;
import java.io.*;
public class dict_keywords {

	public static void main(String[] args) {
		BufferedReader br1=null,br2=null;
		try
		{
		br1=new BufferedReader(new FileReader("G:\\java lab home work\\HW2-master\\HW2-dictionary.txt"));
		br2=new BufferedReader(new FileReader("G:\\java lab home work\\HW2-master\\HW2-keywords.txt"));
		BufferedWriter wr= null;
        File file = new File("G:\\java lab home work\\HW2-master\\words_not_found.txt");
        wr = new BufferedWriter(new FileWriter(file));
		String line=br1.readLine(),output="";
		String dict[],keywords[];
		while(line!=null)
		{
			output+=line;
			output+=' ';
			line=br1.readLine();
		}
		dict=output.trim().split("\\s+");
		sort(dict);
		line=br2.readLine();
		output="";
		while(line!=null)
		{
			output+=line;
			output+=' ';
			line=br2.readLine();
		}
		keywords=output.trim().split("\\s+");
		sort(keywords);
		int size=keywords.length,count=0;
		
		for(int i=0;i<size;i++)
		{
			if(search_in_dict(keywords[i],dict)==0)
			{
				output="keyword not found: ";
				output+=keywords[i];
				output+='\n';
				wr.write(output);
				//System.out.println(keywords[i]);
				count++;
			}
		}
		output="number of keywords not found:=";
		output+=count;
		System.out.println(output);
		output="";
		wr.close();
//		byte b=(byte)0xf1;
//		System.out.println(b);
		
		}
		catch (IOException ioe) 
	       {
		   ioe.printStackTrace();
	       } 
		finally
		{
			try
			{
				if(br1!=null)
				{
					br1.close();
				}
				if(br2!=null)
				{
					br2.close();
				}
				
					
				
			}
			
			   catch (IOException ioe) 
		           {
				   System.out.println("Error in closing the BufferedReader");
			   }
		}
	}
	static void sort(String str[])
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
	static int search_in_dict(String word,String dict[])
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
