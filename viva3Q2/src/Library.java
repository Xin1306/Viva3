import java.util.*;
public class Library {
    private List<Book>books;
    public Library(){
        this.books = new ArrayList<>();
    }
    public void findBooksByAuthor(String author){
        System.out.println(("Books by author '"+author+"':"));
        for(Book book: books){
            if(book.getAuthor().equals(author)){
                displayBook(book);
            }
        }
    }
    public void findBooksByTitle(String title){
        System.out.println(("Books with title '"+title+"':"));
        for(Book book: books){
            if(book.getTitle().equals(title)){
                displayBook(book);
            }
        }
    }
    public void addBook(Book book){
        books.add(book);
    }
    public void removeBook(String ISBN){
        books.removeIf(book -> book.getISBN().equals(ISBN));
    }
    public boolean borrowBook(String ISBN){
        Iterator<Book>iterator = books.iterator();
        while(iterator.hasNext()){
            Book book= iterator.next();
            if(book.getISBN().equals(ISBN)&& !endsWithPrimeDigits(ISBN)){
                iterator.remove();;
                return true;
            }
        }
        return false;
    }
    public boolean endsWithPrimeDigits(String ISBN){
        String lastTwoDigits = ISBN.substring(ISBN.length()-2);
        return isPrime(Integer.parseInt(lastTwoDigits));
    }
    private boolean isPrime(int num){
        if(num<2){
            return false;
        }
        for(int i=2;i<=Math.sqrt(num);i++){
            if(num%i==0){
                return false;
            }
        }
        return true;
    }
    public void sortBooks() {
        Collections.sort(books, Comparator.comparing(Book::getTitle));
    }
    public void displayLibrary(){
        System.out.println("Books in the library, sorted by title: ");
        if(books.isEmpty()){
            System.out.println("No books is in the library");
        }else{
            for(Book book:books){
                displayBook(book);
            }
        }
    }
    public void displayBook(Book book){
        System.out.println("- Title: "+ book.getTitle()+ "\n  Author: "+ book.getAuthor()+ "\n  ISBN: "+ book.getISBN());
        System.out.println();
    }
}
