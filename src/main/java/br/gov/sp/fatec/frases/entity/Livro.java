package br.gov.sp.fatec.frases.entity;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import com.fasterxml.jackson.annotation.JsonView;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.JoinColumn;
import br.gov.sp.fatec.frases.controller.View;

@Entity
@Table(name = "liv_livro")
public class Livro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="liv_id")
    @JsonView(View.LivroCompleto.class)
    private long id;

    @Column(name="liv_titulo")
    @JsonView(View.LivroComum.class)
    private String titulo;

    @Column(name="liv_isbn")
    @JsonView(View.LivroComum.class)
    private long isbn;

    @Column(name="liv_editora")
    @JsonView(View.LivroCompleto.class)
    private String editora;
    
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "lau_livro_autor",
        joinColumns = { @JoinColumn(name = "liv_id") },
        inverseJoinColumns = { @JoinColumn(name = "aur_id") }) 
    @JsonView(View.LivroComum.class)
    private Set<Autor> autores;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "livro")
    private Set<Volume> volumes;

    public Set<Volume> getVolumes() {
        return volumes;
    }


    public void setVolumes(Set<Volume> volumes) {
        this.volumes = volumes;
    }


    public long getId() {
        return id;
    }


    public void setId(long id) {
        this.id = id;
    }


    public String getTitulo() {
        return titulo;
    }


    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }


    public long getIsbn() {
        return isbn;
    }


    public void setIsbn(long isbn) {
        this.isbn = isbn;
    }


    public String getEditora() {
        return editora;
    }


    public void setEditora(String editora) {
        this.editora = editora;
    }


    public Set<Autor> getAutor() {
        return autores;
    }


    public void setAutor(Set<Autor> autores) {
        this.autores = autores;
    }
}
