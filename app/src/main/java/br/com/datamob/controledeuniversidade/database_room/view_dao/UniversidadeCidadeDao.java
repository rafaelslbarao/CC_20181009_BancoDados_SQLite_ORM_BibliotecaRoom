package br.com.datamob.controledeuniversidade.database_room.view_dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Query;

import java.util.List;

import br.com.datamob.controledeuniversidade.database_room.view_entity.UniversidadeCidadeEntity;

@Dao
public interface UniversidadeCidadeDao
{

    @Query(" select u.codigo, u.nome as nome_universidade, u.cidade, c.nome as nome_cidade, c.estado as estado_descricao" +
            " from universidade u inner join cidade c on u.cidade = c.codigo" +
            " order by upper(u.nome), upper(c.nome), upper(c.estado)")
    public List<UniversidadeCidadeEntity> selectAll();


}
