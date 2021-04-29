package Pacote_Fonte_v1;

import java.util.ArrayList;
import java.util.Scanner;

public class GestaoAcademicaApp1 {
    public static void main(String[] args) {
        
        Faculdade faculdade = new Faculdade("Faculdade Faculdade Impacta de Tecnologia");

        faculdade.carregarDadosArquivo("disciplinas-abcde.txt",
                                       "estudantes-abcde.txt",
                                       "matriculas-abcde.txt");
        
        while (true) {        
            System.out.println("========= Menu =========");
            Scanner input = new Scanner(System.in);
            System.out.println("0-) Sair do Sistema");
            System.out.println("1-) Listar nome e id de todos estudantes");
            System.out.println("2-) Listar o código das disciplinas");
            System.out.println("3-) Selecionar estudantes matriculados na disciplina X");
            System.out.println("4-) Selecionar disciplinas cadastradas no aluno X");
            System.out.println("Digite a opção desejada:");
            int opc = input.nextInt();
            
            switch (opc){
                case 0:                 
                    System.out.println("====== Fim do Programa ======");
                    System.exit(-1);
                    break;
                case 1:
                    listDeEstudantes(faculdade.getEstudantes());
                    break;
                case 2:
                    codDaDisciplina(faculdade.getDisciplinas());
                    break;
                case 3:
                    listarEstDisc(faculdade.getDisciplinas());
                    break;
                case 4:
                    listarDiscEst(faculdade.getEstudantes());
                    break;
                default:
                    System.out.println("Opção que você digitou não existe");
            }
            System.out.println("");
        }
    }

    private static void listDeEstudantes(ArrayList<Estudante> estudantes) {
        System.out.println("\n==== Lista de estudantes ====");
        for (Estudante estudante : estudantes)
            System.out.println("Id: " + estudante.getId() + " | Nome: "+ estudante.getNome());
    }

    private static void codDaDisciplina(ArrayList<Disciplina> disciplinas) {
        // Iterar lista de disciplinas
        System.out.println("\n==== Lista de Disciplinas ====");
        for (Disciplina disciplina : disciplinas)
            System.out.println("Código: " + disciplina.getCodigo());
    }

    private static void listarEstDisc(ArrayList<Disciplina> disciplinas) {
        Scanner input = new Scanner(System.in);
        Disciplina disciplina = null;
        while (disciplina == null) {
            System.out.println("\nDigite o credito da Disciplina: ");
            String opc = input.nextLine();
            disciplina = findDisciplinaByCodigo(opc, disciplinas);
            if (disciplina == null){
                System.out.println("Disciplina inválida");
                System.out.println("Digite Novamente!");
            }
        }
        
        ArrayList<Estudante> estudantes = disciplina.getEstudantesMatriculados();
        System.out.println("\n==== Lista de alunos da disciplina: " + disciplina.getCodigo() + " ====");
        
        for (Estudante estudante : estudantes)
            System.out.println("Id: " + estudante.getId() + " | Nome: "+ estudante.getNome() + " | Email: " + estudante.getEmail());
        
        System.out.println("\nTotal de alunos: " + estudantes.size());
    }

    private static void listarDiscEst(ArrayList<Estudante> estudantes) {
        Scanner input = new Scanner(System.in);
        Estudante estudante = null;
        while (estudante == null){
            System.out.println("\nDigite o id do estudante: ");
            int opc = input.nextInt();
            estudante = findEstudanteById(opc, estudantes);
            if (estudante == null)
                System.out.println("Estudante não encontrado");
        }
        
        ArrayList<Disciplina> disciplinas = estudante.getDisciplinasMatriculadas();
        System.out.println("\n=== Lista de Disciplinas do aluno: " + estudante.getNome() + " ===");
        
        for (Disciplina disciplina : disciplinas)
            System.out.println("Disciplina: " + disciplina.getCodigo() + " | Codigo: " + disciplina.getCreditos());
    }
    
    private static Estudante findEstudanteById(int id, ArrayList<Estudante> estudantes) {
        for (Estudante estudante : estudantes) {
            if (id == estudante.getId()) {
                return estudante;
            }
        }
        return null;
    }

    private static Disciplina findDisciplinaByCodigo(String codigo, ArrayList<Disciplina> disciplinas) {
        for (Disciplina disciplina : disciplinas) {
            if (codigo.equals(disciplina.getCodigo())) {
                return disciplina;
            }
        }
        return null;
    }
}
