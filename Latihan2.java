public class Latihan2 {
    public static void main(String[] args) {
        // membuat objek MataKuliah
        MataKuliah mk1 = new MataKuliah("PBO", "Pemrograman Berorientasi Objek", 4);
        MataKuliah mk2 = new MataKuliah("BDI", "Basis Data I", 3);

        // menampilkan informasi mata kuliah
        System.out.println("=== Program Latihan 2 ===");
        System.out.println("Mata Kuliah 1:");
        System.out.println("Kode: " + mk1.getKode());
        System.out.println("Mata Kuliah: " + mk1.getMataKuliah());
        System.out.println("SKS: " + mk1.getSks());

        System.out.println("\nMata Kuliah 2:");
        System.out.println("Kode: " + mk2.getKode());
        System.out.println("Mata Kuliah: " + mk2.getMataKuliah());
        System.out.println("SKS: " + mk2.getSks());
    }
}

class MataKuliah {
    // Attribute
    private String kode;
    private String mataKuliah;
    private Integer sks;

    // Constructor
    public MataKuliah(String kode, String mataKuliah, Integer sks) {
        this.kode = kode;
        this.mataKuliah = mataKuliah;
        this.sks = sks;
    }

    // getter & setter
    public String getKode() {
        return kode;
    }

    public void setKode(String kode) {
        this.kode = kode;
    }

    public String getMataKuliah() {
        return mataKuliah;
    }

    public void setMataKuliah(String mataKuliah) {
        this.mataKuliah = mataKuliah;
    }

    public Integer getSks() {
        return sks;
    }

    public void setSks(Integer sks) {
        this.sks = sks;
    }
}
