package College;
import java.util.Scanner;
public class book{
	public int sNo;
	public String bookName;
	public String authorName;
	public int bookQty;
	public int bookQtyCopy;
	Scanner sc=new Scanner(System.in);
	public book(){
		System.out.println("Enter serial No of Book:");
		this.sNo=sc.nextInt();
		sc.nextLine();
		System.out.println("Enter Book Name:");
		this.bookName=sc.nextLine();
		System.out.println("Enter Author Name:");
		this.authorName=sc.nextLine();
		System.out.println("Enter Quantity of Books:");
		this.bookQty=sc.nextInt();
		bookQtyCopy=this.bookQty;
	}
}	