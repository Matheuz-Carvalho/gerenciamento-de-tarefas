package src;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Task {
    private String titulo;
    private String descricao;
    private LocalDate prazo;
    private boolean isConcluida;
    private String prioridade;

    public Task(String titulo, String descricao, LocalDate prazo, String prioridade) {
        this.titulo = titulo;
        this.descricao = descricao;
        this.prazo = prazo;
        this.isConcluida = false;
        this.prioridade = prioridade;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public LocalDate getPrazo() {
        return prazo;
    }

    public void setPrazo(LocalDate prazo) {
        this.prazo = prazo;
    }

    public boolean isConcluida() {
        return isConcluida;
    }

    public void setCompleted(boolean completed) {
        isConcluida = completed;
    }

    public String getPrioridade() {
        return prioridade;
    }

    public void setPrioridade(String prioridade) {
        this.prioridade = prioridade;
    }

    @Override
    public String toString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return "Título: " + titulo +
                ", Descrição: " + descricao +
                ", Data de Vencimento: " + prazo.format(formatter) +
                ", Prioridade: " + prioridade +
                ", Concluída: " + (isConcluida ? "Sim" : "Não");
    }
}
