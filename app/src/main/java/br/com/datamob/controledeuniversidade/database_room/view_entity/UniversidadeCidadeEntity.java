package br.com.datamob.controledeuniversidade.database_room.view_entity;

import android.arch.persistence.room.ColumnInfo;

public class UniversidadeCidadeEntity
{
    @ColumnInfo
    private Long codigo;
    @ColumnInfo
    private String nome_universidade;
    @ColumnInfo
    private Long cidade;
    @ColumnInfo
    private String nome_cidade;
    @ColumnInfo(name = "estado_descricao")
    private String estado;

    public UniversidadeCidadeEntity()
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

    public String getNome_universidade()
    {
        return nome_universidade;
    }

    public void setNome_universidade(String nome_universidade)
    {
        this.nome_universidade = nome_universidade;
    }

    public Long getCidade()
    {
        return cidade;
    }

    public void setCidade(Long cidade)
    {
        this.cidade = cidade;
    }

    public String getNome_cidade()
    {
        return nome_cidade;
    }

    public void setNome_cidade(String nome_cidade)
    {
        this.nome_cidade = nome_cidade;
    }

    public String getEstado()
    {
        return estado;
    }

    public void setEstado(String estado)
    {
        this.estado = estado;
    }
}
