public class Livro extends ItemBiblioteca {
    private static final int PRAZO_EMPRESTIMO_DIAS = 14;
    private static final double MULTA_POR_DIA = 0.50;

    public Livro(String codigoLivro, String tituloLivro) {
        super(codigoLivro, tituloLivro);
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
