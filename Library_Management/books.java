import java.util.Scanner;
public class books{
	book[] theBooks=new book[50];
	public static int count;
	Scanner sc=new Scanner(System.in);
	//switch case 0
	public void displayMenu(){
		System.out.println("----------------------------------------------------------------------------------------------------------");
		System.out.println("Press 0 to Exit Application.");
		System.out.println("Press 1 to Add new Book.");
		System.out.println("Press 2 to Upgrade Quantity of a Book.");
		System.out.println("Press 3 to Search a Book.");
		System.out.println("Press 4 to Show All Books.");
		System.out.println("Press 5 to Register Stdent.");
		System.out.println("Press 6 to Show All Registered Students.");
		System.out.println("Press 7 to Check Out Book.");
		System.out.println("Press 8 to Check In Book.");
		System.out.println("----------------------------------------------------------------------------------------------------------");
	}
	//switch case 1
	public void addBook(book b){
		for(int i=0;i<count;i++){
			if(this.compareBookObjects(b,this.theBooks[i])==0)	return;
		}
		if(count<50){
			theBooks[count]=b;
			count++;
		}
		else{
			System.out.println("No Space to Add More Books.");
		}
	}
	//to compare books
	public int compareBookObjects(book b1,book b2){
		if(b1.bookName.equalsIgnoreCase(b2.bookName)){
			System.out.println("Book of this Name Already Exists.");
			return 0;
		}
		if(b1.sNo==b2.sNo){
			System.out.println("Book of this Serial No Already Exists.");
			return 0;
		}
		return 1;
	}
	//switch case 2
	public void upgradeBookQty(){
		System.out.println("\t\t\t\tUPGRADE QUANTITY OF A BOOK\n");
		System.out.println("Enter Serial No of Book");
		int sNo=sc.nextInt();
		for(int i=0;i<count;i++){
			if(sNo==theBooks[i].sNo){
				System.out.println("Enter No of Books to be Added:");
				int addingQty=sc.nextInt();
				theBooks[i].bookQty+=addingQty;
				theBooks[i].bookQtyCopy+=addingQty;
				return;
			}
		}
	}
	//switch case 3 - 1
	public void searchBySno(){
		System.out.println("\t\t\t\tSEARCH BY SERIAL NUMBER\n");
		int sNo;
		System.out.println("Enter Serial No of Book:");
		sNo=sc.nextInt();
		int flag=0;
		System.out.println("S.No\t\tName\t\tAuthor\t\tAvailable Qty\t\tTotal Qty");
		for(int i=0;i<count;i++){
			if(sNo==theBooks[i].sNo){
				System.out.println(
				theBooks[i].sNo+"\t\t"+
				theBooks[i].bookName+"\t\t"+
				theBooks[i].authorName+"\t\t"+
				theBooks[i].bookQtyCopy+"\t\t"+
				theBooks[i].bookQty);
				flag++;
				return;
			}
		}
		if(flag==0){
			System.out.println("No Book for Serial No "
                               + sNo + " Found.");
	}
	//switch case 3 - 2
	public void searchByAuthorName(){
		System.out.println("\t\t\t\tSEARCH BY AUTHOR'S NAME");
		sc.nextLine();
		System.out.println("Enter Author Name:");
		String authorName=sc.nextLine();
		int flag=0;
		System.out.println("S.No\t\tName\t\tAuthor\t\tAvailable Qty\t\tTotal Qty");
		for(int i=0;i<count;i++){
			if(authorName.equalsIgnoreCase(theBooks[i].authorName)){
				System.out.println(theBooks[i].sNo + "\t\t"
                    + theBooks[i].bookName + "\t\t"
                    + theBooks[i].authorName + "\t\t"
                    + theBooks[i].bookQtyCopy + "\t\t"
                    + theBooks[i].bookQty);
				flag++;
			}
		}
		if(flag==0){
			System.out.println("No Books of "+authorName+" Found.");
		}
	}
	//switch case-4
	public void showAllBooks(){
		System.out.println("\t\t\t\tSHOWING ALL BOOKS\n");
		System.out.println("S.No\t\tName\t\tAuthor\t\tAvailable Qty\t\tTotal Qty");
		for(int i=0;i<count;i++){
			System.out.println(theBooks[i].sNo + "\t\t"
                + theBooks[i].bookName + "\t\t"
                + theBooks[i].authorName + "\t\t"
                + theBooks[i].bookQtyCopy + "\t\t"
                + theBooks[i].bookQty);
		}
	}
	//search in library
	public int isAvailable(int sNo){
		for(int i=0;i<count;i++){
			if(sNo==theBooks[i].sNo){
				if(theBooks[i].bookQtyCopy>0){
					System.out.println("Book is Available.");
					return i;
				}
				System.out.println("Book is Unavailable");
				return -1;
			}
		}
		System.out.println("No Book of Serial Number "+sNo+ " Available in Library.");
		return -1;
	}
	//remove book from library
	public book checkOutBook(){
		System.out.println("Enter Serial No of Book to be Checked Out.");
        int sNo = sc.nextInt();
        int bookIndex = isAvailable(sNo);
        if (bookIndex != -1) {
            theBooks[bookIndex].bookQtyCopy--;
            return theBooks[bookIndex];
        }
        return null;
	}
	//add book to library
	public book checkInBook(){
		for (int i = 0; i < count; i++) {
            if (b.equals(theBooks[i])) {
                theBooks[i].bookQtyCopy++;
                return;
            }
        }
	}
}