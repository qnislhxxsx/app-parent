package org.app.dao;

import org.app.entity.Sample;
import org.app.entity.SampleExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SampleMapper {
    long countByExample(SampleExample example);

    int deleteByExample(SampleExample example);

    int deleteByPrimaryKey(String id);

    int insert(Sample record);

    int insertSelective(Sample record);

    List<Sample> selectByExample(SampleExample example);

    Sample selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") Sample record, @Param("example") SampleExample example);

    int updateByExample(@Param("record") Sample record, @Param("example") SampleExample example);

    int updateByPrimaryKeySelective(Sample record);

    int updateByPrimaryKey(Sample record);
}
