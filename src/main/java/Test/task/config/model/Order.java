package Test.task.config.model;

public class Order {

    private String Article;
    private String Name;
    private int Shelf;
    private String Box;

    public String getArticle() {
        return Article;
    }

    public String getName() {
        return Name;
    }

    public int getShelf() {
        return Shelf;
    }

    public String getBox() {
        return Box;
    }

    public Order(String article, String name, int shelf, String box) {
        Article = article;
        Name = name;
        Shelf = shelf;
        Box = box;
    }

    @Override
    public String toString() {
        return getArticle() + " " + getName() + " " + getShelf() + " " + getBox();
    }
}

