package UTS_Semester_3;

public class Main {
    public static void main(String[] args) {
        // Contoh pembuatan objek MataKuliah (valid)
        MataKuliah mk1 = new MataKuliah("MK001", "Pemrograman Berorientasi Objek", 3);
        mk1.tampilkanInfo();
        System.out.println();

        // Contoh pembuatan Mahasiswa (valid)
        Mahasiswa mhs = new Mahasiswa(
                "Andi",
                "andi@example.com",
                "Jl. Merdeka No.1",
                "081234567890",
                "M2023001",
                "Teknik Informatika",
                3.45);
        mhs.tampilkanInfo();
        System.out.println();

        // Contoh pembuatan Dosen (valid)
        Dosen dosen = new Dosen(
                "Dr. Siti",
                "siti@univ.ac.id",
                "Bandung",
                "081298765432",
                "D12345",
                "Pemrograman Berorientasi Objek");
        dosen.tampilkanInfo();
        System.out.println();

        // Interaksi: Mahasiswa mengambil mata kuliah
        mhs.ambilMataKuliah(mk1);

        // Interaksi: Dosen mengajar
        dosen.mengajar();

        System.out.println("\n--- Contoh Validasi Gagal ---");
        mhs.setNim("x123"); // salah
        mhs.setIpk(4.8); // salah
        dosen.setNidn("123"); // salah

        System.out.println("\n--- Setelah Percobaan Validasi ---");
        mhs.tampilkanInfo();
        dosen.tampilkanInfo();
    }
}

/*
 * ===========================
 * CLASS USER
 * ===========================
 */
class User {
    private String nama;
    private String email;
    private String alamat;
    private String noHP;

    public User(String nama, String email, String alamat, String noHP) {
        setNama(nama);
        setEmail(email);
        setAlamat(alamat);
        setNoHP(noHP);
    }

    public void tampilkanInfo() {
        System.out.println("----- Informasi User -----");
        System.out.println("Nama   : " + nama);
        System.out.println("Email  : " + email);
        System.out.println("Alamat : " + alamat);
        System.out.println("No HP  : " + noHP);
    }

    // Getter & Setter dengan Validasi
    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        if (nama == null || nama.trim().isEmpty()) {
            System.out.println("Error: nama tidak boleh kosong.");
            return;
        }
        this.nama = nama.trim();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        if (email == null || !email.contains("@")) {
            System.out.println("Error: email harus mengandung karakter '@'.");
            return;
        }
        this.email = email;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        if (alamat == null || alamat.trim().isEmpty()) {
            System.out.println("Error: alamat tidak boleh kosong.");
            return;
        }
        this.alamat = alamat.trim();
    }

    public String getNoHP() {
        return noHP;
    }

    public void setNoHP(String noHP) {
        if (noHP == null) {
            System.out.println("Error: noHP tidak boleh null.");
            return;
        }
        String digits = noHP.replaceAll("\\D", "");
        if (digits.length() < 10) {
            System.out.println("Error: noHP minimal 10 digit angka.");
            return;
        }
        this.noHP = digits;
    }
}

/*
 * ===========================
 * CLASS MAHASISWA (extends User)
 * ===========================
 */
class Mahasiswa extends User {
    private String nim;
    private String jurusan;
    private double ipk;

    public Mahasiswa(String nama, String email, String alamat, String noHP,
            String nim, String jurusan, double ipk) {
        super(nama, email, alamat, noHP);
        setNim(nim);
        setJurusan(jurusan);
        setIpk(ipk);
    }

    @Override
    public void tampilkanInfo() {
        System.out.println("===== Informasi Mahasiswa =====");
        super.tampilkanInfo();
        System.out.println("NIM      : " + nim);
        System.out.println("Jurusan  : " + jurusan);
        System.out.println("IPK      : " + ipk);
    }

    public String getNim() {
        return nim;
    }

    public void setNim(String nim) {
        if (nim == null || !nim.matches("M\\d+")) {
            System.out.println("Error: NIM harus diawali 'M' diikuti angka.");
            return;
        }
        this.nim = nim;
    }

    public String getJurusan() {
        return jurusan;
    }

    public void setJurusan(String jurusan) {
        if (jurusan == null || jurusan.trim().isEmpty()) {
            System.out.println("Error: jurusan tidak boleh kosong.");
            return;
        }
        this.jurusan = jurusan.trim();
    }

    public double getIpk() {
        return ipk;
    }

    public void setIpk(double ipk) {
        if (ipk < 0.0 || ipk > 4.0) {
            System.out.println("Error: IPK harus antara 0.00–4.00.");
            return;
        }
        this.ipk = ipk;
    }

    public void ambilMataKuliah(MataKuliah mk) {
        System.out.println("Mahasiswa " + getNama() + " mengambil mata kuliah " + mk.getNamaMatkul());
    }
}

/*
 * ===========================
 * CLASS DOSEN (extends User)
 * ===========================
 */
class Dosen extends User {
    private String nidn;
    private String mataKuliahAjar;

    public Dosen(String nama, String email, String alamat, String noHP,
            String nidn, String mataKuliahAjar) {
        super(nama, email, alamat, noHP);
        setNidn(nidn);
        setMataKuliahAjar(mataKuliahAjar);
    }

    @Override
    public void tampilkanInfo() {
        System.out.println("===== Informasi Dosen =====");
        super.tampilkanInfo();
        System.out.println("NIDN            : " + nidn);
        System.out.println("Mata Kuliah Ajr : " + mataKuliahAjar);
    }

    public String getNidn() {
        return nidn;
    }

    public void setNidn(String nidn) {
        if (nidn == null || !nidn.matches("D\\d+")) {
            System.out.println("Error: NIDN harus diawali 'D' diikuti angka.");
            return;
        }
        this.nidn = nidn;
    }

    public String getMataKuliahAjar() {
        return mataKuliahAjar;
    }

    public void setMataKuliahAjar(String mataKuliahAjar) {
        if (mataKuliahAjar == null || mataKuliahAjar.trim().isEmpty()) {
            System.out.println("Error: mataKuliahAjar tidak boleh kosong.");
            return;
        }
        this.mataKuliahAjar = mataKuliahAjar.trim();
    }

    public void mengajar() {
        System.out.println("Dosen " + getNama() + " sedang mengajar mata kuliah " + mataKuliahAjar);
    }
}

/*
 * ===========================
 * CLASS MATAKULIAH
 * ===========================
 */
class MataKuliah {
    private String kode;
    private String namaMatkul;
    private int sks;

    public MataKuliah(String kode, String namaMatkul, int sks) {
        setKode(kode);
        setNamaMatkul(namaMatkul);
        setSks(sks);
    }

    public String getKode() {
        return kode;
    }

    public void setKode(String kode) {
        if (!kode.startsWith("MK")) {
            System.out.println("Error: kode harus diawali 'MK'.");
            return;
        }
        this.kode = kode;
    }

    public String getNamaMatkul() {
        return namaMatkul;
    }

    public void setNamaMatkul(String namaMatkul) {
        if (namaMatkul == null || namaMatkul.trim().isEmpty()) {
            System.out.println("Error: namaMatkul tidak boleh kosong.");
            return;
        }
        this.namaMatkul = namaMatkul.trim();
    }

    public int getSks() {
        return sks;
    }

    public void setSks(int sks) {
        if (sks < 1 || sks > 4) {
            System.out.println("Error: SKS harus 1–4.");
            return;
        }
        this.sks = sks;
    }

    public void tampilkanInfo() {
        System.out.println("----- Informasi Mata Kuliah -----");
        System.out.println("Kode      : " + kode);
        System.out.println("Nama      : " + namaMatkul);
        System.out.println("SKS       : " + sks);
    }
}
