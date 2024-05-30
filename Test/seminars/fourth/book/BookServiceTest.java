package seminars.fourth.book;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class BookServiceTest {

    @Test
    public void testFindById() {
        //Создание мок-объекта для класса BookRepository
        BookRepository mockBookRepository = mock(BookRepository.class);

        //Создание объекта класса BookService, передача ему мок-объекта
        BookService bookService = new BookService(mockBookRepository);
        bookService.findBookById("20");
        verify(mockBookRepository, times(1)).findById("20");
    }
    @Test
    public void testFindAllBooks() {
        BookRepository mockBookRepository = mock(BookRepository.class);
        BookService bookService = new BookService(mockBookRepository);
        List<Book> books = bookService.findAllBooks();
        when(mockBookRepository.findAll()).thenReturn(books);
        verify(mockBookRepository, times(1)).findAll();
    }
}