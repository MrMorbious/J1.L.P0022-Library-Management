package model.book;


import model.Manageable;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class Books implements Manageable<BooksData> {
    private Map<Integer, BooksData> mapBooks = new HashMap<>();
    private int autoIncrementID() {
        if (mapBooks != null && !mapBooks.isEmpty()) {
            return mapBooks.keySet().stream().max(Integer::compare).orElse(0) + 1;
        }
        return 1;
    }
    public int getIndexById(int idBook) {
        return mapBooks.containsKey(idBook) ? idBook : -1;
    }
    public BooksData getBookById(int idBook) {
        return mapBooks.get(idBook);
    }
    public Map<Integer , BooksData> getMapBooks () {
        return new HashMap<>(mapBooks);
    }
    @Override
    public void add(BooksData item) {
        int id = autoIncrementID();
        item.setBookId(id);
        mapBooks.put(id, item);
    }
    @Override
    public void update(int id, BooksData item) {
        mapBooks.put(id,item);
    }
    @Override
    public void delete(int id , BooksData item) {
        mapBooks.put(id , item);
    }

    @SuppressWarnings("unchecked")
    public void loadDataOfBooksFromFile(){
        String fileNameOfBook = "Books.dat";
        try{
            File f = new File(fileNameOfBook);
            if (!f.exists()) return;
            FileInputStream fi = new FileInputStream(f);
            ObjectInputStream fo = new ObjectInputStream(fi);
            mapBooks = (Map<Integer, BooksData>) fo.readObject();
            fo.close();
            fi.close();
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
    public void storeDataOfBookToFile() {
        String fileNameOfBook = "Books.dat";
        try {
            FileOutputStream f = new FileOutputStream(fileNameOfBook);
            ObjectOutputStream fo = new ObjectOutputStream(f);
            fo.writeObject(mapBooks);
            fo.close();
            f.close();
        } catch (Exception ignored) {
        }
    }


}
