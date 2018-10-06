package br.com.datamob.controledeuniversidade.database_room.entity;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Ignore;
import android.arch.persistence.room.PrimaryKey;

import java.util.Date;

@Entity(tableName = "cidade")
public class CidadeEntity
{
    @PrimaryKey(autoGenerate = true)
    private Long codigo;

    @ColumnInfo
    private String nome;

    @ColumnInfo
    private String estado;

    @Ignore
    private String colunaAuxiliar;

    public CidadeEntity()
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

    public String getEstado()
    {
        return estado;
    }

    public void setEstado(String estado)
    {
        this.estado = estado;
    }

    @Override
    public String toString()
    {
        return (nome != null ? nome.toString() : "Cidade") + " - " + (estado != null ? estado.toString() : "Estado");
    }
}
