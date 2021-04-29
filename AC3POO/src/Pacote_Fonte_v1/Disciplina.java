package Pacote_Fonte_v1;

import java.util.ArrayList;

public class Disciplina {

    private String codigo;
    private int creditos;
    private ArrayList<Matricula> matriculas = new ArrayList<>();

    public Disciplina(String codigo, int creditos) {
        this.codigo = codigo;
        this.creditos = creditos;
    }
    
    public void addMatricula(Matricula matricula) {
        matriculas.add(matricula);
    }
    
    public ArrayList getEstudantesMatriculados() {
       ArrayList<Estudante> estudantesMatriculados = new ArrayList<Estudante>();
        for (Matricula matricula : matriculas) {
            Estudante estudante = matricula.getEstudante();
            estudantesMatriculados.add(estudante);
        }
        return estudantesMatriculados;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public int getCreditos() {
        return creditos;
    }

    public void setCreditos(int creditos) {
        this.creditos = creditos;
    }

    public ArrayList<Matricula> getMatriculas() {
        return matriculas;
    }

    public void setMatriculas(ArrayList<Matricula> matriculas) {
        this.matriculas = matriculas;
    }

}
