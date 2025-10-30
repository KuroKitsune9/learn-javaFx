// Kelas abstrak sebagai blueprint
abstract class Bangunan {
    public abstract double hitungLuas();

    public abstract double hitungVolume();
}

// Class Balok (inherit dari Bangunan)
class Balok extends Bangunan {
    private double panjang, lebar, tinggi;

    public Balok(double p, double l, double t) {
        this.panjang = p;
        this.lebar = l;
        this.tinggi = t;
    }

    @Override
    public double hitungLuas() {
        return 2 * (panjang * lebar + panjang * tinggi + lebar * tinggi);
    }

    @Override
    public double hitungVolume() {
        return panjang * lebar * tinggi;
    }
}

// Class Kubus (inherit dari Bangunan)
class Kubus extends Bangunan {
    private double sisi;

    public Kubus(double s) {
        this.sisi = s;
    }

    @Override
    public double hitungLuas() {
        return 6 * sisi * sisi;
    }

    @Override
    public double hitungVolume() {
        return sisi * sisi * sisi;
    }
}

// Main class untuk uji coba
public class BangunanOOP {
    public static void main(String[] args) {
        Balok balok = new Balok(5, 3, 4);
        Kubus kubus = new Kubus(6);

        System.out.println("=== Program PBO (OOP) ===");
        System.out.println("Luas Balok: " + balok.hitungLuas());
        System.out.println("Volume Balok: " + balok.hitungVolume());
        System.out.println("Luas Kubus: " + kubus.hitungLuas());
        System.out.println("Volume Kubus: " + kubus.hitungVolume());
    }
}
