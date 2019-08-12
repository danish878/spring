package com.danny.service;

import java.util.ArrayList;
import java.util.List;

import com.danny.model.Product;

public class ProductServiceImpl implements ProductService {

    private List<String> booksList = new ArrayList<>();
    private List<String> musicList = new ArrayList<>();
    private List<String> movieList = new ArrayList<>();

    public ProductServiceImpl() {
        booksList.add("book1");
        booksList.add("book2");
        booksList.add("book3");

        musicList.add("music1");
        musicList.add("music2");
        musicList.add("music3");

        movieList.add("movies1");
        movieList.add("movies2");
        movieList.add("movies3");
    }

    @Override
    public List<String> getProductCategories() {
        List<String> categories = new ArrayList<>();
        categories.add("Books");
        categories.add("Music");
        categories.add("Movies");
        return categories;
    }

    @Override
    public List<String> getProducts(String category) {
        switch (category.toLowerCase()) {
            case "books":
                return booksList;
            case "music":
                return booksList;
            case "movies":
                return booksList;
            default:
                return null;
        }
    }

    @Override
    public boolean addProduct(String category, String product) {
        switch (category.toLowerCase()) {
            case "books":
                booksList.add(product);
                break;
            case "music":
                musicList.add(product);
                break;
            case "movies":
                movieList.add(product);
                break;
            default:
                return false;
        }

        return true;
    }

    @Override
    public List<Product> getProductsV2(String category) {
        List<Product> productList = new ArrayList<>();
        productList.add(new Product("Java Brains Book", "1234", 999.99));
        productList.add(new Product("Yet Another Book", "ABCA", 34.2));
        return productList;
    }

}
