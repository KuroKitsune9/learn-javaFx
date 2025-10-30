
// src/Main.java
import java.util.Date;

public class Main {
    public static void main(String[] args) {
        try {
            Mahasiswa mhs = new Mahasiswa("", "231011", "Informatika");
            mhs.setUmur(20);
            mhs.setTglLahir(new Date());
            mhs.setSkills(new String[] { "Java", "HTML" });
            mhs.tampilkanInfo();

            System.out.println("\n-- Uji validasi nama kosong --");
            Mahasiswa m2 = new Mahasiswa("", "202310123", "TI"); // ini akan melempar exception
            m2.tampilkanInfo();
        } catch (IllegalArgumentException ex) {
            System.err.println("Validasi gagal: " + ex.getMessage());
        }
    }
}
