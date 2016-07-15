package com.twu.biblioteca;

/**
 * Created by DEVASHISH on 7/16/2016.
 */
public class BookList {
    private int index;
    private String title;
    private String author;
    private int yearPublished;

    BookList(int index,String title,String author,int yearPublished){
        this.index=index;
        this.title=title;
        this.author=author;
        this.yearPublished=yearPublished;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getYearPublished() {
        return yearPublished;
    }

    public void setYearPublished(int yearPublished) {
        this.yearPublished = yearPublished;
    }

    @Override
    public String toString(){
        return ""+index+"."+title+" "+author+" "+yearPublished;
    }

}
