public abstract class Usuario {
    private String nome;
    private int quantidadeEmprestada;

    public Usuario(String nomeCompleto) {
        this.nome = nomeCompleto;
        this.quantidadeEmprestada = 0;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String novoNome) {
        this.nome = novoNome;
    }

    public int getQuantidadeEmprestada() {
        return quantidadeEmprestada;
    }

    protected void incrementarEmprestimos() {
        this.quantidadeEmprestada++;
    }

    protected void decrementarEmprestimos() {
        if (this.quantidadeEmprestada > 0) {
            this.quantidadeEmprestada--;
        }
    }

    public boolean possuiLimiteDisponivel() {
        return this.quantidadeEmprestada < calcularLimiteItens();
    }

    public abstract int calcularLimiteItens();

    @Override
    public String toString() {
        return String.format("%s (Itens emprestados: %d/%d)",
                nome, quantidadeEmprestada, calcularLimiteItens());
    }
}
