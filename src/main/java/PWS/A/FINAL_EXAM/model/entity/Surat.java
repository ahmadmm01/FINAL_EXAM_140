/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package PWS.A.FINAL_EXAM.model.entity;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author MADD
 */
public class Surat
{
    String ID;
    int No_Surat;
    String Judul;
    String Tembusan;
    String File;
    String TS;

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public int getNo_Surat() {
        return No_Surat;
    }

    public void setNo_Surat(int No_Surat) {
        this.No_Surat = No_Surat;
    }

    public String getJudul() {
        return Judul;
    }

    public void setJudul(String Judul) {
        this.Judul = Judul;
    }

    public String getTembusan() {
        return Tembusan;
    }

    public void setTembusan(String Tembusan) {
        this.Tembusan = Tembusan;
    }

    public String getFile() {
        return File;
    }

    public void setFile(String File) {
        this.File = File;
    }

    public String getTS() {
//        LocalDateTime now = LocalDateTime.now();
//        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
//        TS = now.format(formatter);
        return TS;
    }

    public void setTS(String TSset) {
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        TSset = now.format(formatter);
        this.TS = TSset;
    }
}
