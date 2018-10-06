package br.com.datamob.controledeuniversidade.database_room.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import java.util.List;

import br.com.datamob.controledeuniversidade.database_room.entity.CidadeEntity;

@Dao
public interface CidadeDao
{
    @Insert
    public long[] insert(CidadeEntity... entities);

    @Query("select * from cidade order by upper(nome), upper(estado)")
    public List<CidadeEntity> selectAll();

    @Query("select * from cidade order by upper(nome), upper(estado)")
    public CidadeEntity[] selectAllArray();
}
