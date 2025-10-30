
// src/Mahasiswa.java
import java.util.Arrays;
import java.util.Date;

public class Mahasiswa {
    private String nama;
    private String nim;
    private String jurusan;
    private int umur;
    private Date tglLahir;
    private String[] skills;

    // Konstruktor
    public Mahasiswa(String nama, String nim, String jurusan) {
        setNama(nama);
        setNim(nim);
        setJurusan(jurusan);
    }

    // Nama: tidak boleh kosong, tidak boleh mengandung angka
    public void setNama(String nama) {
        if (nama == null || nama.trim().isEmpty()) {
            throw new IllegalArgumentException("Nama tidak boleh kosong");
        }
        if (!nama.matches("[a-zA-Z\\s]+")) {
            throw new IllegalArgumentException("Nama hanya boleh berisi huruf dan spasi");
        }
        this.nama = nama.trim();
    }

    public String getNama() {
        return nama;
    }

    // NIM: minimal tidak kosong (bisa tambahkan format)
    public void setNim(String nim) {
        if (nim == null || nim.trim().isEmpty()) {
            throw new IllegalArgumentException("NIM tidak boleh kosong");
        }
        this.nim = nim.trim();
    }

    public String getNim() {
        return nim;
    }

    // Jurusan: minimal 3 karakter dan tidak boleh kosong
    public void setJurusan(String jurusan) {
        if (jurusan == null || jurusan.trim().length() < 3) {
            throw new IllegalArgumentException("Jurusan harus minimal 3 karakter");
        }
        this.jurusan = jurusan.trim();
    }

    public String getJurusan() {
        return jurusan;
    }

    // Umur: harus > 0
    public void setUmur(int umur) {
        if (umur <= 0) {
            throw new IllegalArgumentException("Umur harus lebih dari 0");
        }
        this.umur = umur;
    }

    public int getUmur() {
        return umur;
    }

    // Tanggal lahir: defensive copy
    public void setTglLahir(Date tglLahir) {
        if (tglLahir == null) {
            this.tglLahir = null;
            return;
        }
        this.tglLahir = new Date(tglLahir.getTime());
    }

    public Date getTglLahir() {
        return tglLahir == null ? null : new Date(tglLahir.getTime());
    }

    // Skills: defensive copy
    public void setSkills(String[] skills) {
        if (skills == null) {
            this.skills = null;
            return;
        }
        this.skills = Arrays.copyOf(skills, skills.length);
    }

    public String[] getSkills() {
        return skills == null ? null : Arrays.copyOf(skills, skills.length);
    }

    // Tampilkan info
    public void tampilkanInfo() {
        System.out.println("=== Data Mahasiswa ===");
        System.out.println("Nama    : " + getNama());
        System.out.println("NIM     : " + getNim());
        System.out.println("Jurusan : " + getJurusan());
        System.out.println("Umur    : " + getUmur());
        System.out.println("Tgl Lahir: " + (getTglLahir() == null ? "-" : getTglLahir()));
        System.out.println("Skills  : " + (getSkills() == null ? "-" : String.join(", ", getSkills())));
    }
}
