package zadanie_3_2;

public class TestAuthor {

    public static void main(String[] args) {

        Author author = new Author("Maria", "Wzornicka", 22);

        System.out.println(author);

        System.out.println(author.getName() + " " + author.getSurname() + " " + author.getAge());

        author.setSurname("Kowalska");

        System.out.println(author);

    }
}