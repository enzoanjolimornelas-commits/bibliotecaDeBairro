public class DVD extends ItemBiblioteca {
    private static final int PRAZO_EMPRESTIMO_DIAS = 3;
    private static final double MULTA_POR_DIA = 2.00;

    public DVD(String codigoMidia, String tituloMidia) {
        super(codigoMidia, tituloMidia);
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
