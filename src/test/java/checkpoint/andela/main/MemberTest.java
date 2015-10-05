package checkpoint.andela.main;


import checkpoint.andela.members.Student;
import org.junit.Test;
import org.junit.Assert.*;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;

/**
 * Created by Daniel James on 10/4/2015.
 */
public class MemberTest {
    @Test
    public void shouldReturnTrueForTwoMembersWithEqualProperties() {
        Member member = new Student("ID-15-006", "Nadaya Engesi", 'M');
        Member member1 = new Student("ID-15-006", "Nadaya Engesi", 'M');

        assertTrue(member.equals( member1));

    }

    @Test
    public void shouldReturnFalseForTwoMembersWithEqualProperties() {
        Member member = new Student("ID-15-006", "Nadaya Engesi", 'M');
        Member member1 = new Student("ID-15-006", "Nadaya Engesi", 'M');

        assertFalse(member.equals(member1));
    }

    @Test
    public void borrowBookShouldAddanewBookToMemberListOfBooks(){
        Member member1 = new Student("ID-15-018", "Jeremy Johnson", 'M');
        Book book = new Book("1005-ISBN-34", "The Theory of #TIA", "E");
        member1.borrowBook(book);
        assertTrue(member1.ownBook(book));
    }

    @Test
    public void returnBookShouldremoveaBookToMemberListOfBooks(){
        Member member1 = new Student("ID-15-018", "Jeremy Johnson", 'M');
        Book book = new Book("1005-ISBN-34", "The Theory of #TIA", "E");
        member1.borrowBook(book);
        member1.returnBook(book);
        assertFalse(member1.ownBook(book));
    }

}
