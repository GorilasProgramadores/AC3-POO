package Pacote_Fonte_v1;

import java.util.ArrayList;

public class Estudante {

    private long id;
    private String nome;
    private String email;
    private ArrayList<Matricula> matriculas = new ArrayList<>();

    public Estudante(long id, String nome, String email) {
        this.id = id;
        this.nome = nome;
        this.email = email;
    }

    public void addMatricula(Matricula matricula) {
        matriculas.add(matricula);
    }

    public ArrayList getDisciplinasMatriculadas() {
        ArrayList<Disciplina> disciplinasMatriculadas = new ArrayList<>();
        for (Matricula matricula : matriculas) {
            Disciplina disciplina = matricula.getDisciplina();
            disciplinasMatriculadas.add(disciplina);
        }
        return disciplinasMatriculadas;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public ArrayList<Matricula> getMatriculas() {
        return matriculas;
    }

    public void setMatriculas(ArrayList<Matricula> matriculas) {
        this.matriculas = matriculas;
    }
}
