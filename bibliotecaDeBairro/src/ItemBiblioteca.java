public abstract class ItemBiblioteca {
    private String codigo;
    private String titulo;
    private boolean disponivel;

    public ItemBiblioteca(String codigoItem, String tituloObra) {
        this.codigo = codigoItem;
        this.titulo = tituloObra;
        this.disponivel = true;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String novoCodigo) {
        this.codigo = novoCodigo;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String novoTitulo) {
        this.titulo = novoTitulo;
    }

    public boolean isDisponivel() {
        return disponivel;
    }

    // Disponibilidade controlada apenas internamente pelo pacote (emprestar/devolver)
    protected void atualizarDisponibilidade(boolean statusDisponivel) {
        this.disponivel = statusDisponivel;
    }

    public abstract int calcularPrazoDias();

    public abstract double calcularMulta(int diasAtraso);

    @Override
    public String toString() {
        String statusTexto = disponivel ? "Disponivel" : "Emprestado";
        return String.format("[%s] %s | Prazo: %d dias | Status: %s",
                codigo, titulo, calcularPrazoDias(), statusTexto);
    }
}
