package com.example.test;

import org.testng.annotations.Test;

public class ArticleTest extends TestBase {
    @Test
    public void testAddArticleToFavoritsAndRemove() {
        app.article().search();
        app.article().addToFavorits();
        app.article().createReadingList();
        app.article().close();
        app.navigateTo().favorits();
        app.article().removeFromFavorits();
    }
}
