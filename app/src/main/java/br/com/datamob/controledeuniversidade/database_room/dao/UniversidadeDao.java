package br.com.datamob.controledeuniversidade.database_room.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import java.util.List;

import br.com.datamob.controledeuniversidade.database_room.entity.UniversidadeEntity;
import br.com.datamob.controledeuniversidade.database_room.view_entity.UniversidadeCidadeEntity;

@Dao
public interface UniversidadeDao
{
    @Insert
    public long[] insert(UniversidadeEntity... entities);

    @Query("select * from universidade order by upper(nome), upper(cidade)")
    public List<UniversidadeEntity> selectAll();

    @Query("select * from universidade where codigo = :codigo")
    public UniversidadeEntity selectByCodigo(Long codigo);

    @Delete
    public int delete(UniversidadeEntity... entities);

    @Update
    public int update(UniversidadeEntity... entities);

    @Query("select ifnull(max(codigo), 0) + 1 from universidade")
    public Long getProximoCodigo();

    @Query(" select u.codigo, u.nome as nome_universidade, u.cidade, c.nome as nome_cidade, c.estado as estado_descricao" +
            " from universidade u inner join cidade c on u.cidade = c.codigo" +
            " order by upper(u.nome), upper(c.nome), upper(c.estado)")
    public List<UniversidadeCidadeEntity> selectAllDiferente();
}
