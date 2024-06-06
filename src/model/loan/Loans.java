package model.loan;

import model.Manageable;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class Loans implements Manageable<LoansData> {

    Map<Integer , LoansData> mapLoan = new HashMap<>();

    private int autoIncrementID() {
        if (mapLoan != null && !mapLoan.isEmpty()) {
            return mapLoan.keySet().stream().max(Integer::compare).orElse(0) + 1;
        }
        return 1;
    }
    public int getIndexById(int idTransaction) {
        return mapLoan.containsKey(idTransaction) ? idTransaction : -1;
    }
    public LoansData getLoanById(int idTransaction) {
        return mapLoan.get(idTransaction);
    }
    public Map<Integer , LoansData> getMapLoans () {
        return new HashMap<>(mapLoan);
    }
    @Override
    public void add(LoansData item) {
        int id = autoIncrementID();
        item.setTransactionId(id);
        mapLoan.put(id, item);
    }
    @Override
    public void update(int id, LoansData item) {
        mapLoan.put(id,item);
    }
    @Override
    public void delete(int id, LoansData item) {
        mapLoan.put(id , item);
    }

    @SuppressWarnings("unchecked")
    public void loadDataOfLoanFromFile(){
        String fileNameOfLoan = "Loans.dat";
        try{
            File f = new File(fileNameOfLoan);
            if (!f.exists()) return;
            FileInputStream fi = new FileInputStream(f);
            ObjectInputStream fo = new ObjectInputStream(fi);
            mapLoan = (Map <Integer , LoansData> ) fo.readObject();
            fo.close();
            fi.close();
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
    public void storeDataOfLoanToFile() {
        String fileNameOfLoan = "Loans.dat";
        try {
            FileOutputStream f = new FileOutputStream(fileNameOfLoan);
            ObjectOutputStream fo = new ObjectOutputStream(f);
            fo.writeObject(mapLoan);
            fo.close();
            f.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
