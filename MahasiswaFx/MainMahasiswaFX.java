import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class MainMahasiswaFX extends Application {

    @Override
    public void start(Stage primaryStage) {
        Label lblNama = new Label("Nama:");
        TextField tfNama = new TextField();

        Label lblNim = new Label("NIM:");
        TextField tfNim = new TextField();

        Label lblJurusan = new Label("Jurusan:");
        TextField tfJurusan = new TextField();

        Label lblUmur = new Label("Umur:");
        TextField tfUmur = new TextField();

        Button btnSimpan = new Button("Simpan");

        // Aksi tombol
        btnSimpan.setOnAction(e -> {
            try {
                Mahasiswa m = new Mahasiswa(
                        tfNama.getText(),
                        tfNim.getText(),
                        tfJurusan.getText());

                int umur = Integer.parseInt(tfUmur.getText());
                m.setUmur(umur);

                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Data Mahasiswa");
                alert.setHeaderText("Berhasil Disimpan!");
                alert.setContentText(
                        "Nama: " + m.getNama() + "\n" +
                                "NIM: " + m.getNim() + "\n" +
                                "Jurusan: " + m.getJurusan() + "\n" +
                                "Umur: " + m.getUmur());
                alert.showAndWait();

            } catch (NumberFormatException ex) {
                new Alert(Alert.AlertType.ERROR, "Umur harus berupa angka!").showAndWait();
            } catch (IllegalArgumentException ex) {
                new Alert(Alert.AlertType.ERROR, ex.getMessage()).showAndWait();
            } catch (Exception ex) {
                new Alert(Alert.AlertType.ERROR, "Terjadi error: " + ex.getMessage()).showAndWait();
            }
        });

        // Layout form
        GridPane grid = new GridPane();
        grid.setHgap(8);
        grid.setVgap(8);
        grid.setStyle("-fx-padding: 15;");

        grid.add(lblNama, 0, 0);
        grid.add(tfNama, 1, 0);
        grid.add(lblNim, 0, 1);
        grid.add(tfNim, 1, 1);
        grid.add(lblJurusan, 0, 2);
        grid.add(tfJurusan, 1, 2);
        grid.add(lblUmur, 0, 3);
        grid.add(tfUmur, 1, 3);
        grid.add(btnSimpan, 1, 4);

        Scene scene = new Scene(grid, 400, 250);
        primaryStage.setTitle("Form Data Mahasiswa");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
