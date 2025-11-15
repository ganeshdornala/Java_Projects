import java.util.Scanner;
public class Library{
	public static void main(String[] args){
		Scanner sc=new Scanner(System.in);
		System.out.println("********************Welcome to the CVRCoE Library!********************");
		System.out.println("Select From The Following Options:");
		System.out.println("**********************************************************************");
		books objBooks=new books();
		students objStudents=new students();
		int chowice;
		int searchChoice;
		do{
			objBooks.displayMenu();
			choice=sc.nextInt();
			switch(choice){
				case 1:
					book b=new book();
					objBooks.addBook(b);
					break;
				case 2:
					objBooks.upgradeBookQty();
					break;
				case 3:
					System.out.println("press 1 to Search with Book Serial No.");
					System.out.println("press 2 to Search with Book's Author Name.");
					searchChoice=sc.nextInt();
					switch(searchChoice){
						case 1:
							objBooks.searchBySno();
							break;
						case 2:
							objBooks.searchByAuthorName();
					}
					break;
				case 4:
					objBooks.showAllBooks();
					break;
				case 5:
					student s=new student();
					objStudents.addStudent(s);
					break;
				case 6:
					objStudents.showAllStudents();
					break;
				case 7:
					objStudents.checkOutBook(objBooks);
					break;
				case 8:
					objStudents.checkInBook(objBooks);
					break;
				default:
					System.out.println("ENTER BETWEEN 0 TO 8.");
			}
		}
		while(choice!=0);
	}	
}