package prototype;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Recommendation originalRecommendation = new Recommendation("Young Adults");
        originalRecommendation.addBook(new Book("J. R. R. Tolkien", "The Lord of the Rings", "High fantasy", 1954));
        originalRecommendation.addBook(new Book("Suzanne Collins", "The Hunger Games", "Dystopian", 2008));

        System.out.println("Original Recommendation: " + originalRecommendation);

        System.out.println("Cloning the original recommendation...");
        Recommendation clonedRecommendation = originalRecommendation.clone();
        clonedRecommendation.setTargetAudience("Adults");
        clonedRecommendation.addBook(new Book("George Orwell", "1984", "Dystopian", 1949));

        System.out.println("Cloned Recommendation: " + clonedRecommendation);

        System.out.println("Original Recommendation after cloning: " + originalRecommendation);
    }
}