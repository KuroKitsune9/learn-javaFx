public class BangunanProsedural {

    // Fungsi menghitung luas permukaan balok
    public static double hitungLuasBalok(double p, double l, double t) {
        return 2 * (p * l + p * t + l * t);
    }

    // Fungsi menghitung volume balok
    public static double hitungVolumeBalok(double p, double l, double t) {
        return p * l * t;
    }

    // Fungsi menghitung luas permukaan kubus
    public static double hitungLuasKubus(double s) {
        return 6 * s * s;
    }

    // Fungsi menghitung volume kubus
    public static double hitungVolumeKubus(double s) {
        return s * s * s;
    }

    public static void main(String[] args) {
        double p = 5, l = 3, t = 4;
        double s = 6;

        System.out.println("=== Program Prosedural ===");
        System.out.println("Luas Balok: " + hitungLuasBalok(p, l, t));
        System.out.println("Volume Balok: " + hitungVolumeBalok(p, l, t));
        System.out.println("Luas Kubus: " + hitungLuasKubus(s));
        System.out.println("Volume Kubus: " + hitungVolumeKubus(s));
    }
}
