package guru.springframework.domain;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;

public class CategoryTest {

    Category category;

    @BeforeAll
    public void setUp() {
        category = new Category();
    }

    @Test
    public void getId() throws Exception {
        Long idValue = 4L;

        category.setId(idValue);

        assertEquals(idValue, category.getId());
    }

    @Test
    public void getDescription() throws Exception {
    }

    @Test
    public void getRecipes() throws Exception {
    }

}