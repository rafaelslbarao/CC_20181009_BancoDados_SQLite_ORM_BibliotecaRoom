package br.com.datamob.controledeuniversidade.database_room.entity;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.arch.persistence.room.Index;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

@Entity(tableName = "universidade"
        , primaryKeys = { "codigo", "cidade" }
        , foreignKeys ={@ForeignKey(entity = CidadeEntity.class, childColumns = "cidade", parentColumns = "codigo")}
        , indices = {@Index("nome")}
        )
public class UniversidadeEntity
{
    @NonNull
    private Long codigo;

    @NonNull
    private Long cidade;

    @ColumnInfo
    private String nome;

    public UniversidadeEntity()
    {
    }

    public Long getCodigo()
    {
        return codigo;
    }

    public void setCodigo(Long codigo)
    {
        this.codigo = codigo;
    }

    public String getNome()
    {
        return nome;
    }

    public void setNome(String nome)
    {
        this.nome = nome;
    }

    public Long getCidade()
    {
        return cidade;
    }

    public void setCidade(Long cidade)
    {
        this.cidade = cidade;
    }
}
