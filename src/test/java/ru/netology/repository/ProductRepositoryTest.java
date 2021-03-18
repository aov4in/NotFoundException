package ru.netology.repository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.exeptions.NotFoundException;

import static org.junit.jupiter.api.Assertions.*;

class ProductRepositoryTest {
    private ProductRepository repository = new ProductRepository();
    private Book coreJava = new Book(1,"The Road Ahead - Bill Gates", 467, "Bill Gates", 56, 2008);
    private Book coreJava1 = new Book(2,"Technical English", 482, "David Bonamy", 128, 2008);

    @BeforeEach
    public void setUp() {
        repository.save(coreJava);
        repository.save(coreJava1);
    }
    @Test
    public void shouldCheckException(){
        int id = 3;
        assertThrows(NotFoundException.class, () -> repository.removeById(id));
    }

    @Test
    public void shouldNotCheckException(){
        int id = 1;
        repository.removeById(id);
        Product[] expected = new Product[]{coreJava1};
        Product[] actual = repository.findAll();
        assertArrayEquals(expected, actual);
    }
}