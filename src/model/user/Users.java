package model.user;

import model.Manageable;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class Users implements Manageable<UsersData> {

    private Map<Integer, UsersData> mapUser = new HashMap<>();

    private int autoIncreaseID() {
        if (mapUser != null && !mapUser.isEmpty()) {
            return mapUser.keySet().stream().max(Integer::compare).orElse(0) + 1;
        }
        return 1;
    }
    public int getIndexUserById(int idUser) {
        return mapUser.containsKey(idUser) ? idUser : -1;
    }
    public UsersData getUserById(int idUser) {
        return mapUser.get(idUser);
    }
    public Map<Integer , UsersData> getMapUsers () {
        return new HashMap<>(mapUser);
    }

    @Override
    public void add(UsersData item) {
        int id = autoIncreaseID();
        item.setUserId(id);
        mapUser.put(id, item);
    }
    @Override
    public void update(int id, UsersData item) {
        mapUser.put(id, item);
    }

    @Override
    public void delete(int id , UsersData item) {
        mapUser.put(id, item);
    }
    @SuppressWarnings("unchecked")
    public void loadDataOfUserFromFile(){
        String fileNameOfUser = "Users.dat";
        try{
            File f = new File(fileNameOfUser);
            if (!f.exists()) return;
            FileInputStream fi = new FileInputStream(f);
            ObjectInputStream fo = new ObjectInputStream(fi);
            mapUser = (Map <Integer , UsersData> ) fo.readObject();
            fo.close();
            fi.close();
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
    public void storeDataOfUserToFile() {
        String fileNameOfUser = "Users.dat";
        try {
            FileOutputStream f = new FileOutputStream(fileNameOfUser);
            ObjectOutputStream fo = new ObjectOutputStream(f);
            fo.writeObject(mapUser);
            fo.close();
            f.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
