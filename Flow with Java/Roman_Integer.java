/**
Q. Roman numbers to Integer conversion
*/
import java.util.*;
class Roman_Integer
{
	/**
	 * L = 50, C = 100, D = 500, M = 1000;
	 */
	static int Rvalue(char ch)
	{
		int val = 0;
		switch(ch)
		{
			case 'I':
				val = 1;
				break;
			case 'V':
				val = 5;
				break;
			case 'X':
				val = 10;
				break;
			case 'L':
				val = 50;
				break;
			case 'C':
				val = 100;
				break;
			case 'D':
				val = 500;
				break;
			case 'M':
				val = 1000;
				break;
			default:
			val = -1;
		}
		return val;
	}

	static int RtoInt(String r, char c, int i)
	{
		if(!r.equals(""))
		{
			char ch = r.charAt(0);
			int ch1 = Rvalue(c);
			int ch2 = Rvalue(ch);
			if(ch2 == -1)
				return -1;
			if( ch1 > ch2 || ch1 == ch2 )
			{
				i += ch2;
				return RtoInt(r.substring(1), ch, i);
			}
			else // ch1 < ch2
			{
				i += ch2 - 2*ch1;
				return RtoInt(r.substring(1), ch, i);
			}
		}
		else
			return i;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("\nEnter a Roman number between I to M (1 to 1000): ");
		String Rnum = sc.next();
		int res = RtoInt(Rnum, Rnum.charAt(0), 0);
		if( res == -1)
		{
			System.out.print("\nInvalid Input\nEnter again: ");
			main(args);
		}
		else
		{
			System.out.println(Rnum + " = " + res);
		}
		sc.close();
	}
}