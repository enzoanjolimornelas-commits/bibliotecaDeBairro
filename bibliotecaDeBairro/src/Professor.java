public class Professor extends Usuario {
    private static final int LIMITE_SIMULTANEO_PROFESSOR = 5;

    public Professor(String nomeProfessor) {
        super(nomeProfessor);
    }

    @Override
    public int calcularLimiteItens() {
        return LIMITE_SIMULTANEO_PROFESSOR;
    }
}
