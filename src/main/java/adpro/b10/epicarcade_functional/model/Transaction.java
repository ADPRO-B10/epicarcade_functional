package adpro.b10.epicarcade_functional.model;

import adpro.b10.epicarcade_functional.enums.TransactionStatus;

import lombok.Getter;
import lombok.Setter;
import lombok.Builder;

import java.util.List;
import java.time.LocalDate;

@Builder
@Getter

public class Transaction {
    private String id;
    private String pembeli;
    private String penjual;
    private String statusPembayaran;
    private List<Game> listGame;
    private LocalDate waktuTransaksi;
    private Long totalHarga;

    public Transaction(String id, String pembeli, String penjual, List<Game> listGame, LocalDate waktuTransaksi, Long totalHarga) {
        this.id = id;
        this.pembeli = pembeli;
        this.penjual = penjual;
        this.waktuTransaksi = waktuTransaksi;
        this.totalHarga = totalHarga;
        this.statusPembayaran = TransactionStatus.WAITING_PAYMENT.getValue();

        if (listGame.isEmpty()) {
            throw new IllegalArgumentException();
        } else {
            this.listGame = listGame;
        }
    }

    public Transaction(String id, String pembeli, String penjual, List<Game> listGame, LocalDate waktuTransaksi,
                       Long totalHarga, String statusPembayaran) {
        this(id, pembeli, penjual,  listGame, waktuTransaksi, totalHarga);

        this.setStatus(statusPembayaran);
    }


    public void setStatus(String statusPembayaran) {
        if (TransactionStatus.contains(statusPembayaran)) {
            this.statusPembayaran = statusPembayaran;
        } else {
            throw new IllegalArgumentException();
        }
    }
    public void tambahProduk(Game game) {
        this.listGame.add(game);
    }
}