public class Revista extends ItemBiblioteca {
    private static final int PRAZO_EMPRESTIMO_DIAS = 7;
    private static final double MULTA_POR_DIA = 1.00;

    public Revista(String codigoRevista, String tituloRevista) {
        super(codigoRevista, tituloRevista);
    }

    @Override
    public int calcularPrazoDias() {
        return PRAZO_EMPRESTIMO_DIAS;
    }

    @Override
    public double calcularMulta(int diasAtraso) {
        if (diasAtraso <= 0) {
            return 0.0;
        }
        return diasAtraso * MULTA_POR_DIA;
    }
}
