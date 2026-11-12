public class Aluno extends Usuario {
    private static final int LIMITE_SIMULTANEO_ALUNO = 3;

    public Aluno(String nomeAluno) {
        super(nomeAluno);
    }

    @Override
    public int calcularLimiteItens() {
        return LIMITE_SIMULTANEO_ALUNO;
    }
}
