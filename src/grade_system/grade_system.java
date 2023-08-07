package grade_system;
import java.util.*;
import java.io.*;
public class grade_system {

	static Scanner sc=new Scanner(System.in);
	static String sno[]= {"002", "001", "003", "004", "005"};
	static String name[]={"Bob", "Ann", "Ken", "Ray", "Emy"};
	static String command[]= {"bubble sort", "selection sort", "linear search", 
			"binary search", "help", "update", "list all", "write file", "exit"};
	static String name_order[]=new String[name.length];
	static float c_avg=0;
	static float m_avg=0;
	static int chin[]= {90, 80, 60, 70, 60};
	static int math[]= {80, 60, 70, 75, 50};
	static double avg[]=new double[name.length];
	static String RN[]=new String[name.length];
	static int cn[]=new int[6];
	static int c_cn[]=new int[6];
	static int m_cn[]=new int[6];
	public static void average()
	{
		c_avg=0;
		m_avg=0;
		for(int i=0;i<name.length;i++)
		{
			avg[i]=(chin[i]+math[i])*0.5;
		}
		for(int i=0;i<name.length;i++)
		{
			c_avg=c_avg+chin[i];
		}
		for(int i=0;i<name.length;i++)
		{
			m_avg=m_avg+math[i];
		}
		c_avg=c_avg/name.length;
		m_avg=m_avg/name.length;
	}
	public static void average_tab()
	{
		for(int i=0;i<name.length;i++)
		{	
			if(avg[i]==100)
				RN[i]="優";
			else if(avg[i]>=90)
				RN[i]="優";
			else if(avg[i]>=80)
				RN[i]="甲";
			else if(avg[i]>=70)
				RN[i]="乙";
			else if(avg[i]>=60)
				RN[i]="丙";
			else
				RN[i]="丁";
		}
	}
	public static double standard_deviation(int array[])
	{
		int sum = 0;      
		for(int i=0;i<array.length;i++){
		    sum += array[i];      //求出數組的總和
		}
		//System.out.println(sum);  //939
		double average = sum/array.length;  //求出數組的平均數
		//System.out.println(average);   //52.0
		int total=0;
		for(int i=0;i<array.length;i++){
		    total += (array[i]-average)*(array[i]-average);   //求出方差，如果要計算方差的話這一步就可以了
		}
		double standardDeviation = Math.sqrt(total/array.length);   //求出標準差
	
		return standardDeviation;
	}
	public static void freQ()
	{
		for(int i=0;i<name.length;i++)
		{
			cn[i]=c_cn[i]=m_cn[i]=0;
		}
		for(int i=0;i<name.length;i++)
		{
			if(avg[i]>50)
				cn[(int)(avg[i]-50)/10]++;
			else
				cn[0]++;
		}	
		for(int i=0;i<name.length;i++)
		{
			if(avg[i]>50)
				c_cn[(int)(chin[i]-50)/10]++;
			else
				c_cn[0]++;
		}
			
		for(int i=0;i<name.length;i++)
		{
			if(avg[i]>50)
				m_cn[(int)(math[i]-50)/10]++;
			else
				m_cn[0]++;
		}
	}
	public static void listall()
	{
		average();
		average_tab();
		freQ();
		System.out.println("-----------------------------");
		System.out.println("name  chin  math   平均    等第");
		for(int i=0;i<name.length;i++)
			System.out.println(name[i]+"    "+chin[i]+"    "+math[i]+"    "+avg[i]+"    "+RN[i]);
		System.out.println("-----------------------------");
		System.out.println("chin平均="+c_avg+", math平均="+m_avg);
		System.out.println("中文標準差:"+standard_deviation(chin));
		System.out.println("數學標準差:"+standard_deviation(math));
		System.out.println("--------------------------------------------------------------\n分數範圍分布人數");
		System.out.println("    100    99.x-90.0 89.x-80.0 79.x-70.0 69.x-60.0 59.x-0.0 ");
		System.out.printf("平均");
		for(int i=cn.length-1;i>=0;i--)
		{
			System.out.print("  "+cn[i]+"       ");
		}
		System.out.printf("\n中文");
		for(int i=c_cn.length-1;i>=0;i--)
		{
			System.out.print("  "+c_cn[i]+"       ");
		} 
		System.out.printf("\n數學");
		for(int i=m_cn.length-1;i>=0;i--)
		{
			System.out.print("  "+m_cn[i]+"       ");
		}
		System.out.printf("\n");
		System.out.println("--------------------------------------------------------------");
		
	}
	public static void bubble_sort()
	{
		for (int i = 0; i < name.length; i++) 
		{
			for (int j = name.length-1; j > i; j--) 
			{
				String temp;
				int int_temp;
				double d_temp; 
				if (name[j].compareTo(name[j - 1]) < 0) 
				{
					temp = name[j];
					name[j] = name[j - 1];
					name[j - 1] = temp;
					temp = sno[j];
					sno[j] = sno[j - 1];
					sno[j - 1] = temp;
					int_temp=chin[j];
					chin[j] = chin[j - 1];
					chin[j - 1] = int_temp;
					int_temp=math[j];
					math[j] = math[j - 1];
					math[j - 1] = int_temp;
					d_temp=avg[j];
					avg[j] = avg[j - 1];
					avg[j - 1] = d_temp;
					temp = RN[j];
					RN[j] = RN[j - 1];
					RN[j - 1] = temp;
				}
			}
		}
	}
	public static void selection_sort()
	{
		String temp, min;
		int s, int_temp;
		double d_temp;

		for (int i = 0; i < name.length; i++) 
		{
			min = name[i];
			s = i;
			for (int j = i; j < 5; j++) 
			{
				if (name[j].compareTo(min) < 0) 
				{
					min = name[j];
					s = j;
				}
			}
			temp = name[s];
			name[s] = name[i];
			name[i] = temp;
			temp = sno[s];
			sno[s] = sno[i];
			sno[i] = temp;
			int_temp=chin[s];
			chin[s] = chin[i];
			chin[i] = int_temp;
			int_temp=math[s];
			math[s] = math[i];
			math[i] = int_temp;
			d_temp=avg[s];
			avg[s] = avg[i];
			avg[i] = d_temp;
			temp = RN[s];
			RN[s] = RN[i];
			RN[i] = temp;
		}
	}
	public static int LinearSearch(String input)
	{
		int flag = 1;
		for (int i = 0; i < input.length(); i++)
		{
			if (48 <= input.charAt(i) && input.charAt(i) <= 57)
				continue;
			else
			{
				flag = 0;
				break;
			}
		}

		if (flag == 0)
		{
			for(int i=0;i<name.length;i++)
			{
				if(input.equalsIgnoreCase(name[i]))
					return i;
			}
		}
		if (flag == 1)
		{
			for(int i=0;i<sno.length;i++)
			{
				if(input.equals(sno[i]))
					return i;
			}
		}
		return -1;
	}
	public static int BinarySearch(String input)
	{
		//判斷二元搜尋之資料為學號或是姓名(學號:1, 姓名:0)
		int flag = 1;
		for (int i = 0; i < input.length(); i++)
		{
			if (48 <= input.charAt(i) && input.charAt(i) <= 57)
				continue;
			else
			{
				flag = 0;
				break;
			}
		}
		
		int low = 0, high = name.length-1;
		int mid = (low + high) / 2;

		if (flag == 0)
		{
			bubble_sort(); //首先依照姓名排序

			//二元搜尋
			while (low <= high)
			{
				if (input.compareTo(name[mid]) < 0)
				{
					high = mid - 1;
					mid = (low + high) / 2;
				}
				else if (input.compareTo(name[mid]) > 0)
				{
					low = mid + 1;
					mid = (low + high) / 2;
				}
				else
				{
					return mid;
				}
				}
				System.out.printf("查無此人!\n");
			}

			if (flag == 1)
			{
				//二元搜尋
				while (low <= high)
				{
					if (input.compareTo(sno[mid]) < 0)
					{
						high = mid - 1;
						mid = (low + high) / 2;
					}
					else if (input.compareTo(sno[mid]) > 0)
					{
						low = mid + 1;
						mid = (low + high) / 2;
					}
					else
					{
						return mid;
					}
				}
				System.out.printf("查無此人!\n");
			}
			return -1;
	}
	public static void update()
	{
		System.out.printf("輸入姓名或學號:");
		String in=sc.next();
		int index=BinarySearch(in);
		System.out.printf("輸入中文分數:");
		chin[index]=sc.nextInt();
		System.out.printf("輸入數學分數:");
		math[index]=sc.nextInt();
		sc.nextLine();
		
		average();
		average_tab();
		freQ();
	}
	public static void help()
	{
		System.out.println("commands list:");
		for(int i=0;i<command.length;i++)
			System.out.println(command[i]);
	}
	public static void writefile() throws FileNotFoundException
	{
		//Scanner sc1 = new Scanner(System.in);
		System.out.print("file name:");
		String response=sc.nextLine(); 
		File file1 = new File(response);
		if (file1.exists())
		{
			System.out.println(response+" already exists");
			return;
		}
		PrintWriter output1 = new PrintWriter(file1);
		output1.println("name  chin  math   平均    等第");
		for(int i=0;i<name.length;i++)
			output1.println(name[i]+"    "+chin[i]+"    "+math[i]+"    "+avg[i]+"    "+RN[i]);
		output1.print("-----------------------------");	
		output1.close();
	}
	
	public static void main(String[] args) throws FileNotFoundException 
	{
		String com=" ";
		String com2=" ";
		int in_com=-1;
		int temp;
		average();
		average_tab();
		freQ();
		while(in_com!=7) 
		{
			System.out.printf("輸入命令:");
			com=sc.nextLine();
			for(int i=0;i<command.length;i++)
			{
				if(com.equalsIgnoreCase(command[i]))
					in_com=i;
			}
			switch(in_com)
			{
			case 0:
				bubble_sort();
				listall();
				break;
			case 1:
				selection_sort();
				listall();
				break;
			case 2:
				System.out.printf("輸入姓名或學號:");
				com2=sc.nextLine();
				temp=LinearSearch(com2);
				if(temp==-1)
					System.out.println("查無此人");
				else
				{
					System.out.println("name  chin  math   平均    等第");
					System.out.println(name[temp]+"    "+chin[temp]+"    "+math[temp]+
							"    "+avg[temp]+"    "+RN[temp]);
				}
				break;
			case 3:
				System.out.printf("輸入姓名或學號:");
				com2=sc.nextLine();
				temp=BinarySearch(com2);
				if(temp==-1)
					System.out.println("查無此人");
				else
				{
					System.out.println("name  chin  math   平均    等第");
					System.out.println(name[temp]+"    "+chin[temp]+"    "+math[temp]+
							"    "+avg[temp]+"    "+RN[temp]);
				}
				break;
			case 4:
				help();
				break;
			case 5:
				update();
				break;
			case 6:
				listall();
				break;
			case 7:
				writefile();
				break;
			case 8:
				System.exit(0);
				break;
			default:
				System.out.println("輸入錯誤, 請輸入help");	
			}
			in_com=-1;
		}
		

	}

}
